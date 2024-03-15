package br.edu.ufape.editais.model.dto;

import br.edu.ufape.editais.model.Inscricao;
import br.edu.ufape.editais.model.enums.Bolsa;

public record DadosDetalhamentoInscricao(
		
		Long id,
		Bolsa bolsa,
	    String historicoEscolar,
	    String curriculo,
	    String funcao,
	    String comprovanteMatricula,
	    Long userId) {

	public DadosDetalhamentoInscricao(Inscricao inscricao) {
		this(
				inscricao.getId(),
				inscricao.getBolsa(),
				inscricao.getHistoricoEscolar(),
				inscricao.getCurriculo(),
				inscricao.getFuncao(),
				inscricao.getComprovanteMatricula(),
				inscricao.getUserId());
	}

}
