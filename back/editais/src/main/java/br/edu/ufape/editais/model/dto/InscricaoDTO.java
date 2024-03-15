package br.edu.ufape.editais.model.dto;

import br.edu.ufape.editais.model.enums.Bolsa;

public record InscricaoDTO(
		
		Bolsa bolsa,
	    String historicoEscolar,
	    String curriculo,
	    String funcao,
	    String comprovanteMatricula,
	    long userId) {

}
