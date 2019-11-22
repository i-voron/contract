package ru.vstestapp.contract.repository;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.vstestapp.contract.entity.*;
import ru.vstestapp.contract.service.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration
@ComponentScan(basePackages = {"ru.vstestapp.contract.service","ru.vstestapp.contract.api"})
public class ContractRepositoriesTest {
    @Autowired
    private InsurantService insurantRepository;
    @Autowired
    private ReferenceAreaService rar;
    @Autowired
    private ReferenceRtService rrr;
    @Autowired
    private ReferenceYocService ryr;
    private ReferenceArea area;
    private ReferenceArea area2;
    private ReferenceArea area3;
    private ReferenceRealtyType type;
    private ReferenceRealtyType type2;
    private ReferenceRealtyType type3;
    private ReferenceYearOfConstruction year;
    private ReferenceYearOfConstruction year2;
    private ReferenceYearOfConstruction year3;
    private Insurant ins;
    private Insurant ins2;
    private Insurant ins3;
    @Autowired
    private ContractService contractService;

    @Before
    public void setUp() {
        area = new ReferenceArea("Менее 50 кв.м.", 1.2f, null, 49.9f);
        area2 = new ReferenceArea("50-100 кв.м.", 1.5f, 50f, 100f);
        area3 = new ReferenceArea("Более 100 кв.м.", 2f, 100.1f, null);

        type = new ReferenceRealtyType("Квартира", 1.7f);
        type2 = new ReferenceRealtyType("Дом", 1.5f);
        type3 = new ReferenceRealtyType("Комната", 1.3f);

        year = new ReferenceYearOfConstruction("Меньше 2000", 1.3f, null, 1999f);
        year2 = new ReferenceYearOfConstruction("2000-2014", 1.6f, 2000f, 2014f);
        year3 = new ReferenceYearOfConstruction("2019", 2f, 2015f, null);

        ins=new Insurant("Иванов","Иван","Иванович",new Date(),new Passport(1111,222222));
        ins2 = new Insurant("Петров", "Петр", "Петрович", new Date(), new Passport(1234, 333333));
        ins3 = new Insurant("Аматеру", "Синдзи", null, new Date(), new Passport(9999, 444444));
    }

    @Test
    public void testAReferencesRepositorySave() {
        rar.save(area);
        rar.save(area2);
        rar.save(area3);
        rrr.save(type);
        rrr.save(type2);
        rrr.save(type3);
        ryr.save(year);
        ryr.save(year2);
        ryr.save(year3);

        Iterable<ReferenceArea> findAllReferenceArea = rar.findAll();
        Iterable<ReferenceRealtyType> findAllReferenceRealtyType = rrr.findAll();
        Iterable<ReferenceYearOfConstruction> findAllReferenceYearOfConstruction = ryr.findAll();

        assertThat(findAllReferenceArea, contains(area, area2, area3));
        assertThat(findAllReferenceRealtyType, contains(type, type2, type3));
        assertThat(findAllReferenceYearOfConstruction, contains(year, year2, year3));

        assertEquals(rar.findByRangeCoefficient(49.9f),area.getValue());
        assertEquals(rar.findByRangeCoefficient(50f),area2.getValue());
        assertEquals(rar.findByRangeCoefficient(100.1f),area3.getValue());

        assertEquals(ryr.findByRangeCoefficient(1999f),year.getValue());
        assertEquals(ryr.findByRangeCoefficient(2000f),year2.getValue());
        assertEquals(ryr.findByRangeCoefficient(2015f),year3.getValue());
    }

    @Test
    public void testBInsurantRepositoryfindFio() {
        insurantRepository.save(ins);
        insurantRepository.save(ins2);
        insurantRepository.save(ins3);

        List<Insurant> insurants = insurantRepository.findFio("Иванов", "Иван", "Иванович");
        List<Insurant> insurants2 = insurantRepository.findFio("Петров", "Петр", "Петрович");
        List<Insurant> insurants3 = insurantRepository.findFio("Аматеру", "Синдзи", null);

        assertThat(insurants, contains(ins));
        assertThat(insurants2, contains(ins2));
        assertThat(insurants3, contains(ins3));
    }

    @Test
    public void testContractRepositorySave() {
        rrr.save(type);
        insurantRepository.save(ins);

        Calendar c=Calendar.getInstance();
        c.roll(Calendar.DAY_OF_YEAR, 10);

        Contract contract = new Contract();
        contract.setAddress(new Address("Россия", "555555", "регион", null, "Москва", "Тверская", 1, null, null, 1));
        contract.setInsurance(new Insurance(100, new Date(), c.getTime(), new Date(), "2016", "20.5", type,"1000.55"));
        contract.setInsurant(ins);
        contract.setContractNumber(1111);
        contract.setComments("dsfsdfsdfsdfs");

        contractService.save(contract);
//        assertThat(contractService.findAll(), contains(contract));
//
//        assertTrue(contractService.findByContractNumber(contract.getId(), contract.getContractNumber()).isPresent());
//        assertFalse(contractService.findByContractNumber(contract.getId(), 123).isPresent());
    }


}