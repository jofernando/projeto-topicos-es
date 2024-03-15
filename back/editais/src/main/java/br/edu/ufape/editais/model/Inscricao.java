package br.edu.ufape.editais.model;

import br.edu.ufape.editais.model.dto.DadosAtualizarInscricao;
import br.edu.ufape.editais.model.dto.InscricaoDTO;
import br.edu.ufape.editais.model.enums.Bolsa;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inscricao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Bolsa bolsa;
    private String historicoEscolar;
    private String curriculo;
    private String funcao;
    private String comprovanteMatricula;
    private long userId;
    
    public Inscricao (InscricaoDTO dados) {
    	this.bolsa = dados.bolsa();
    	this.historicoEscolar = dados.historicoEscolar();
    	this.curriculo = dados.curriculo();
    	this.funcao = dados.funcao();
    	this.comprovanteMatricula = dados.comprovanteMatricula();
    	this.userId = dados.userId();
    }

	public void atualizarInformacoes (@Valid DadosAtualizarInscricao dados) {
		if (dados.bolsa() != null) {
			this.bolsa = dados.bolsa();
		}
		if (dados.curriculo() != null) {
			this.curriculo = dados.curriculo();
		}
		if (dados.funcao() != null) {
			this.funcao = dados.funcao();
		}
	}
    
}