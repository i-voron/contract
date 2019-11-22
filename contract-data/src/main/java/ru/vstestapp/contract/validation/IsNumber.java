package ru.vstestapp.contract.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * проверка на число
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = IsNumberValidator.class)
public @interface IsNumber {
    String message() default "{IsNumber.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
