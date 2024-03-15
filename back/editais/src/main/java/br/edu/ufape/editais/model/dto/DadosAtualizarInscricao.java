package br.edu.ufape.editais.model.dto;

import br.edu.ufape.editais.model.enums.Bolsa;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarInscricao(
		
		@NotNull
		Long id,
		Bolsa bolsa,
	    String curriculo,
	    String funcao) {

}
