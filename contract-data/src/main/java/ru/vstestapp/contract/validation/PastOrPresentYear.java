package ru.vstestapp.contract.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Год должен быть четырехзначный и не больше текущего года.  NotNull
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = PastOrPresentYearValidatorForString.class)
public @interface PastOrPresentYear {
    String message() default "{PastOrPresentYear.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
