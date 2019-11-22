package ru.vstestapp.contract.validation;

import ru.vstestapp.contract.entity.ReferenceRealtyType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RealtyTypeIsSelectedValidator implements ConstraintValidator<RealtyTypeIsSelected, ReferenceRealtyType> {
    private int missingIdValue;

    @Override
    public void initialize(RealtyTypeIsSelected constraintAnnotation) {
        missingIdValue = constraintAnnotation.missingIdValue();
    }

    @Override
    public boolean isValid(ReferenceRealtyType rt, ConstraintValidatorContext context) {
        if (rt != null && rt.getId()!=null && rt.getId()==missingIdValue) {
            return false;
        }

        return true;
    }
}
