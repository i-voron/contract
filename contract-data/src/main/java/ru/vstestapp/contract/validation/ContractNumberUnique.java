package ru.vstestapp.contract.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Проверка уникальности номера договора
 */
@Target(TYPE)
//@Target(FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ContractNumberUniqueValidator.class)
public @interface ContractNumberUnique {
    String message() default "{ContractNumberUnique.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
