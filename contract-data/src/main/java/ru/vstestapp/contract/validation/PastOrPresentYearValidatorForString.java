package ru.vstestapp.contract.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigInteger;
import java.util.Calendar;

public class PastOrPresentYearValidatorForString implements ConstraintValidator<PastOrPresentYear, CharSequence> {
//public class PastOrPresentYearValidatorForString {

    @Override
    public void initialize(PastOrPresentYear constraintAnnotation) {
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext context) {
        if (charSequence == null) {
            return false;
        }
        BigInteger bigNum = getBigIntegerValue(charSequence);
        if (bigNum == null) {
            return false;
        }
        int integerPartLength = bigNum.toString().length();
        if (integerPartLength > 4 || integerPartLength < 4) {
            return false;
        }
        final Calendar now = Calendar.getInstance();

        return (bigNum.intValue() <= now.get(Calendar.YEAR));
    }

    private BigInteger getBigIntegerValue(CharSequence charSequence) {
        BigInteger bd;
        try {
            bd = new BigInteger(charSequence.toString());
        } catch (NumberFormatException nfe) {
            return null;
        }
        return bd;
    }
}
