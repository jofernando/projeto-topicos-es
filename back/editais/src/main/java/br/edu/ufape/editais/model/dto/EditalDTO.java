package br.edu.ufape.editais.model.dto;

import java.util.Date;
import java.util.List;

import br.edu.ufape.editais.model.ClassificacaoFinal;

public record EditalDTO(
		
		String descricao,
	    String editalArquivo,
	    Date inicioInscricao,
	    Date fimInscricao,
	    List<ClassificacaoFinal> classificacoesFinais) {

}
