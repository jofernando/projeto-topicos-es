package br.edu.ufape.editais.model.dto;

import br.edu.ufape.editais.model.enums.Bolsa;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InscricaoDTO(
		
		@Enumerated
		Bolsa bolsa,
		
		@NotBlank
	    String historicoEscolar,
	    
	    @NotBlank
	    String curriculo,
	    
	    @NotBlank
	    String funcao,
	    
	    @NotBlank
	    String comprovanteMatricula,
	    
	    @NotNull
	    long userId) {

}
