package ru.vstestapp.contract.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * проверка количества цифр
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = DigitsCountValidator.class)
public @interface DigitsCount {
    String message() default "{DigitsCount.message}";
    int count() default 4;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
