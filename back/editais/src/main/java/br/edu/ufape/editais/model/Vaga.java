package br.edu.ufape.editais.model;

import java.util.Date;
import java.util.List;
import java.util.Map;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Edital {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String descricao;
    private String editalArquivo;
    private Date inicioInscricao;
    private Date fimInscricao;
    private Map<String, List<String>> classificacaoFinal;
}