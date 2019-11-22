package ru.vstestapp.contract.api.calculation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vstestapp.contract.entity.Insurance;
import ru.vstestapp.contract.service.ReferenceAreaService;
import ru.vstestapp.contract.service.ReferenceYocService;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
public class InsuranceCalculatorImpl implements InsuranceCalculator {
    @Autowired
    private ReferenceAreaService ras;
    @Autowired
    private ReferenceYocService rys;
    @Autowired
    private InsuranceCalculationFactory calculationFactory;

    @Override
    public String calculate(Insurance insurance) {
        if (insurance.getInsuranceAmount() == null || insurance.getDateFrom() == null ||
                insurance.getDateTo() == null || insurance.getRealtyType() == null) {
            return null;
        }
        Integer insuranceAmount = insurance.getInsuranceAmount();
        Integer daysCount = Math.toIntExact(insurance.getDateFrom().toInstant().until(insurance.getDateTo().toInstant(), DAYS));
        if (daysCount == 0) daysCount++;
        Float coefficientRt = insurance.getRealtyType().getValue();
        Float coefficientArea = ras.findByRangeCoefficient(Float.valueOf(insurance.getArea()));
        Float coefficientYoc = rys.findByRangeCoefficient(Float.valueOf(insurance.getYearOfConstruction()));

        String res = calculationFactory.getStrategy("InsCalcA").
                calculate(insuranceAmount, daysCount, coefficientRt, coefficientYoc, coefficientArea);

        return res;
    }
}
