package br.edu.ufape.editais.model.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarEdital(
		
		@NotNull
		Long id,
		String descricao,
	    String editalArquivo,
	    Date inicioInscricao,
	    Date fimInscricao) {

}
