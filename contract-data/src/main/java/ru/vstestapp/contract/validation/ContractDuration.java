package ru.vstestapp.contract.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Срок действия договора не может быть больше года.
 */
@Target(TYPE)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ContractDurationValidator.class)
public @interface ContractDuration {
    String message() default "{ContractDuration.message}";
    int duration() default 1;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
