package br.edu.ufape.editais.model.dto;

import java.util.Date;

import br.edu.ufape.editais.model.Edital;

public record DadosListagemEdital(
		
		Long id,
		String descricao,
	    String editalArquivo,
	    Date inicioInscricao,
	    Date fimInscricao) {
	
	public DadosListagemEdital(Edital edital) {
		this(edital.getId(), edital.getDescricao(), edital.getEditalArquivo(), edital.getInicioInscricao(), edital.getFimInscricao());
	}
}
