package br.edu.ufape.editais.model.dto;

import java.util.Date;
import java.util.List;

import br.edu.ufape.editais.model.ClassificacaoFinal;
import br.edu.ufape.editais.model.Edital;

public record DadosDetalhamentoEdital(
		
		Long id,
		String descricao,
	    String editalArquivo,
	    Date inicioInscricao,
	    Date fimInscricao,
	    List<ClassificacaoFinal> classificacoesFinais) {

	public DadosDetalhamentoEdital(Edital edital) {
		this(
				edital.getId(),
				edital.getDescricao(),
				edital.getEditalArquivo(),
				edital.getInicioInscricao(),
				edital.getFimInscricao(),
				edital.getClassificacoesFinais());
	}
}
