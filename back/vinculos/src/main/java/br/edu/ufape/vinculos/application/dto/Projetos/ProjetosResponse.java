package br.edu.ufape.vinculos.application.dto.Projetos;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.edu.ufape.vinculos.business.models.Projeto;
import br.edu.ufape.vinculos.config.SpringApplicationContext;

@Getter @Setter @NoArgsConstructor
public class ProjetosResponse {
    private Long id;
    private String nome;
    private String descricao;
    private List<String> palavrasChave;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCriacao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCertificacao;
    private String linguagemDeDesenvolvimento;
    private String campoDeAplicacao;
    private String tipoDeSistema;

    public ProjetosResponse(Projeto obj){
        if(obj == null) throw new IllegalArgumentException("Objeto não pode ser nulo");
        else{
            ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
            modelMapper.map(obj, this);
        }
    }
}
