package ru.vstestapp.contract.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Проверяет, выбран ли тип недвижимости (по умолчанию -1 в id)
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = RealtyTypeIsSelectedValidator.class)
public @interface RealtyTypeIsSelected {
    String message() default "{RealtyTypeIsSelected.message}";
    int missingIdValue() default -1;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
