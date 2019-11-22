package ru.vstestapp.contract.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigInteger;

public class DigitsCountValidator implements ConstraintValidator<DigitsCount, Object> {
    private int count;

    @Override
    public void initialize(DigitsCount constraintAnnotation) {
        this.count=constraintAnnotation.count();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        BigInteger bigNum = getBigIntegerValue(value);
        if (bigNum == null) {
            return false;
        }
        int integerPartLength = bigNum.toString().length();
        if (integerPartLength == count) {
            return true;
        }

        return false;
    }

    private BigInteger getBigIntegerValue(Object value) {
        BigInteger bd;
        try {
            bd = new BigInteger(value.toString());
        } catch (NumberFormatException nfe) {
            return null;
        }
        return bd;
    }
}
