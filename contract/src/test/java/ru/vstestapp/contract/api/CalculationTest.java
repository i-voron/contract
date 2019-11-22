package ru.vstestapp.contract.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.vstestapp.contract.api.calculation.InsuranceCalculator;
import ru.vstestapp.contract.entity.Insurance;
import ru.vstestapp.contract.entity.ReferenceRealtyType;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class CalculationTest {
    @Autowired
    InsuranceCalculator calculator;

    @Test
    public void calculatorTest() {
        String res = calculator.calculate(
                new Insurance(100, new Date(), new Date(), new Date(),
                        "2016", "20.5", new ReferenceRealtyType("Квартира", 1.7f),
                        "1000.55"));
        assertNotNull(res);
    }
}