package br.edu.ufape.editais.model.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import br.edu.ufape.editais.model.ClassificacaoFinal;
import jakarta.validation.constraints.NotBlank;

public record EditalDTO(
		
		@NotBlank
		String descricao,
		
		@NotBlank
	    String editalArquivo,
	    
	    @DateTimeFormat
	    Date inicioInscricao,
	    
	    @DateTimeFormat
	    Date fimInscricao,
	    
	    List<ClassificacaoFinal> classificacoesFinais) {

}
