package br.edu.ufape.vinculos.application.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import br.edu.ufape.vinculos.application.validations.ValidDateRangeValidator;

import java.lang.annotation.RetentionPolicy;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidDateRangeValidator.class)
@Documented
public @interface ValidDateRange {
    String message() default "Data de início deve ser anterior à data de término";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
