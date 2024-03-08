package br.edu.ufape.vinculos.application.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import br.edu.ufape.vinculos.application.validations.ProjetoExistsValidator;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProjetoExistsValidator.class)
public @interface ProjetoExists {
    String message() default "ID inválido, Projeto não encontrado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
