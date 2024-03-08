package br.edu.ufape.vinculos.application.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import br.edu.ufape.vinculos.application.validations.NotFutureDateValidator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotFutureDateValidator.class)
public @interface NotFutureDate {
    String message() default "A data não pode ser futura";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}