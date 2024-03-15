package br.edu.ufape.editais.model;

import java.util.Date;
import java.util.List;

import br.edu.ufape.editais.model.dto.DadosAtualizarEdital;
import br.edu.ufape.editais.model.dto.EditalDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Edital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String descricao;
    private String editalArquivo;
    private Date inicioInscricao;
    private Date fimInscricao;
    @OneToMany(mappedBy = "edital", cascade = CascadeType.ALL)
    private List<ClassificacaoFinal> classificacoesFinais;
    
    public Edital (EditalDTO dados) {
    	this.descricao = dados.descricao();
    	this.editalArquivo = dados.editalArquivo();
    	this.inicioInscricao = dados.inicioInscricao();
    	this.fimInscricao = dados.fimInscricao();
    }

	public void atualizarInformacoes (@Valid DadosAtualizarEdital dados) {
		if (dados.descricao() != null) {
			this.descricao = dados.descricao();
		}
		if (dados.editalArquivo() != null) {
			this.editalArquivo = dados.editalArquivo();
		}
		if (dados.inicioInscricao() != null) {
			this.inicioInscricao = dados.inicioInscricao();
		}
		if (dados.fimInscricao() != null) {
			this.fimInscricao = dados.fimInscricao();
		}
	}
    
}