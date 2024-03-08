package br.edu.ufape.vinculos.application.validations;

import br.edu.ufape.vinculos.application.annotations.ProjetoExists;
import br.edu.ufape.vinculos.data.repositories.ProjetosRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ProjetoExistsValidator implements ConstraintValidator<ProjetoExists, Long>{
    private final ProjetosRepository projetosRepository;

    @SuppressWarnings("null")
    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return projetosRepository.existsById(id);
    }
}
