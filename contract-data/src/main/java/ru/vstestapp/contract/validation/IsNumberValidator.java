package ru.vstestapp.contract.validation;

import org.springframework.util.NumberUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsNumberValidator implements ConstraintValidator<IsNumber, Object> {

    @Override
    public void initialize(IsNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {                                         
            NumberUtils.parseNumber(value.toString(), Double.class);
        } catch (NullPointerException | NumberFormatException ex) {
            return false;
        }
        return true;
    }
    
}
