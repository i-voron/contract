package ru.vstestapp.contract.validation;

import ru.vstestapp.contract.entity.Insurance;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;

public class ContractDurationValidator implements ConstraintValidator<ContractDuration, Insurance> {
    private int duration;

    @Override
    public void initialize(ContractDuration constraintAnnotation) {
        duration = constraintAnnotation.duration();
    }

    @Override
    public boolean isValid(Insurance insurance, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("{ContractDuration.message}")
                .addPropertyNode("dateTo").addConstraintViolation();

        if (insurance == null || insurance.getDateTo()==null || insurance.getDateFrom()==null) {
            return false;
        }
        if (duration < 0) {
            return false;
        }

        int result = insurance.getDateTo().toInstant().compareTo(insurance.getDateFrom().toInstant());

        if (result >= 0) {
            Calendar valueCalendar = Calendar.getInstance();
            valueCalendar.setTime(insurance.getDateFrom());
            valueCalendar.roll(Calendar.YEAR, 1);

//            insurance.getDateTo().toInstant().until(valueCalendar.toInstant(), DAYS);
            if (insurance.getDateTo().toInstant().isBefore(valueCalendar.toInstant())) {
                return true;
            }
        }

        return false;
    }
}
