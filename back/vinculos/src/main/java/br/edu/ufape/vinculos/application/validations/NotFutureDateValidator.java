package br.edu.ufape.vinculos.application.validations;

import java.util.Date;

import br.edu.ufape.vinculos.application.annotations.NotFutureDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class NotFutureDateValidator implements ConstraintValidator<NotFutureDate, Date>{
     @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        Date now = new Date();
        return value.before(now) || value.equals(now);
    }
}
