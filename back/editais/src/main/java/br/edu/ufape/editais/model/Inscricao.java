package br.edu.ufape.editais.model;

import jakarta.persistence.*;
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
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}