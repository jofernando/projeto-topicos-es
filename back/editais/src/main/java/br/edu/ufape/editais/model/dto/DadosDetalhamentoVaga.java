package br.edu.ufape.editais.model.dto;

import br.edu.ufape.editais.model.Vaga;

public record DadosDetalhamentoVaga(
		
		Long id,
		int quantidade,
		boolean ativa) {

	public DadosDetalhamentoVaga(Vaga vaga) {
		this(vaga.getId(), vaga.getQuantidade(), vaga.isAtiva());
	}
}
