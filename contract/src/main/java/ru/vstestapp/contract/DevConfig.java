package ru.vstestapp.contract;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.vstestapp.contract.entity.*;
import ru.vstestapp.contract.service.*;

import java.util.Calendar;
import java.util.Date;

@Configuration
public class DevConfig {
    @Bean
    public CommandLineRunner dataLoader(ReferenceAreaService rar, ReferenceRtService rrr, ReferenceYocService ryr,
                                        InsurantService ir, ContractService cs) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                ReferenceArea area=new ReferenceArea("Менее 50 кв.м.",1.2f,null,49.9f);
                ReferenceArea area2=new ReferenceArea("50-100 кв.м.",1.5f,50f,100f);
                ReferenceArea area3=new ReferenceArea("Более 100 кв.м.",2f,100.1f,null);

                ReferenceRealtyType type=new ReferenceRealtyType("Квартира",Float.valueOf(1.7f));
                ReferenceRealtyType type2=new ReferenceRealtyType("Дом",Float.valueOf(1.5f));
                ReferenceRealtyType type3=new ReferenceRealtyType("Комната",Float.valueOf(1.3f));

                ReferenceYearOfConstruction year=new ReferenceYearOfConstruction("Меньше 2000",1.3f,null,1999f);
                ReferenceYearOfConstruction year2=new ReferenceYearOfConstruction("2000-2014",1.6f,2000f,2014f);
                ReferenceYearOfConstruction year3=new ReferenceYearOfConstruction("2019",2f,2015f,null);

                rar.save(area);
                rar.save(area2);
                rar.save(area3);
                rrr.save(type);
                rrr.save(type2);
                rrr.save(type3);
                ryr.save(year);
                ryr.save(year2);
                ryr.save(year3);

                Insurant ins=new Insurant("Иванов","Иван","Иванович",new Date(),new Passport(1111,222222));
                Insurant ins2=new Insurant("Петров","Петр","Петрович",new Date(),new Passport(1234,333333));
                Insurant ins3=new Insurant("Сидоров","Василий",null,new Date(),new Passport(9999,444444));
//                ir.save(new Insurant("Петров","Петр","Петрович",new Date(),new Passport(1234,333333)));
                ir.save(ins);
                ir.save(ins2);
                ir.save(ins3);

                Calendar c=Calendar.getInstance();
                c.roll(Calendar.DAY_OF_YEAR, 10);
                Contract contract = new Contract();
                contract.setAddress(new Address("Россия", "555555", "регион", null, "Москва", "Тверская", 1, null, null, 1));
                contract.setInsurance(new Insurance(100, new Date(), c.getTime(), new Date(), "2016", "20.5", type,"1000.55"));
                contract.setInsurant(ins);
                contract.setContractNumber(1111);
                contract.setComments("dsfsdfsdfsdfs");
                cs.save(contract);

                contract = new Contract();
                contract.setAddress(new Address("Россия", "555555", "регион", null, "Москва", "Тверская", 3, null, null, 1));
                contract.setInsurance(new Insurance(100, new Date(), c.getTime(), new Date(), "2016", "20.5", type2,"3000.55"));
                contract.setInsurant(ins2);
                contract.setContractNumber(1112);
                contract.setComments("dsfsdfsdfsdfs");
                cs.save(contract);

                contract = new Contract();
                contract.setAddress(new Address("Россия", "555555", "регион", null, "Москва", "Тверская", 2, null, null, 1));
                contract.setInsurance(new Insurance(100, new Date(), c.getTime(), new Date(), "2016", "20.5", type3,"10020.55"));
                contract.setInsurant(ins3);
                contract.setContractNumber(1113);
                contract.setComments("dsfsdfsdfsdfs");

                cs.save(contract);


            }
        };
    }
}
