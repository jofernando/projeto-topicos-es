package br.edu.ufape.editais.model;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;
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
    
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}