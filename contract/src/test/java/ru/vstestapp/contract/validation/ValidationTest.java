package ru.vstestapp.contract.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.vstestapp.contract.ValidationConfig;
import ru.vstestapp.contract.entity.Insurance;

import javax.validation.Validator;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { ValidationConfig.class })
public class ValidationTest {
//    @Qualifier("validator")
    @Autowired
    private Validator validator;

    @Test
    public void testBonusValidationSuccess() {
        Calendar c=Calendar.getInstance();
        assertFalse(validator.validateValue(Insurance.class, "insuranceAmount", null).isEmpty());
        assertFalse(validator.validateValue(Insurance.class, "insuranceAmount", -1).isEmpty());
        c.roll(Calendar.YEAR, 1);
        assertFalse(validator.validateValue(Insurance.class, "dateFrom", null).isEmpty());
        assertFalse(validator.validateValue(Insurance.class, "dateFrom", c.getTime()).isEmpty());
        c.roll(Calendar.YEAR, -2);
        assertFalse(validator.validateValue(Insurance.class, "dateTo", null).isEmpty());
        assertFalse(validator.validateValue(Insurance.class, "dateTo", c.getTime()).isEmpty());
        assertFalse(validator.validateValue(Insurance.class, "calculationDate", null).isEmpty());
        c.roll(Calendar.YEAR, 2);
        assertFalse(validator.validateValue(Insurance.class, "yearOfConstruction", null).isEmpty());
        assertFalse(validator.validateValue(Insurance.class, "yearOfConstruction", String.valueOf(c.get(Calendar.YEAR))).isEmpty());
        assertFalse(validator.validateValue(Insurance.class, "area", null).isEmpty());
        assertFalse(validator.validateValue(Insurance.class, "area", "1000.22").isEmpty());
        assertFalse(validator.validateValue(Insurance.class, "insurancePremium", null).isEmpty());
        assertFalse(validator.validateValue(Insurance.class, "insurancePremium", "555.214").isEmpty());


        Insurance insurance=new Insurance();
        insurance.setDateFrom(new Date());
        c.roll(Calendar.DAY_OF_YEAR,5);
        insurance.setDateTo(c.getTime());
        assertTrue(validator.validate(insurance).size()==7);
    }
}
