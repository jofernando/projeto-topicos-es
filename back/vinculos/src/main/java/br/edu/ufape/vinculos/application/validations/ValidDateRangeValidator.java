package br.edu.ufape.vinculos.application.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import br.edu.ufape.vinculos.application.annotations.ValidDateRange;


public class ValidDateRangeValidator implements ConstraintValidator<ValidDateRange, DateRange> {

    @Override
    public void initialize(ValidDateRange constraintAnnotation) {
    }

    @Override
    public boolean isValid(DateRange dateRange, ConstraintValidatorContext context) {
        if (dateRange.getStartDate() == null || dateRange.getEndDate() == null) {
            return true;
        }
        return dateRange.getStartDate().before(dateRange.getEndDate());
    }
}
