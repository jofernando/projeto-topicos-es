package br.edu.ufape.vinculos.application.dto.Projetos;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.edu.ufape.vinculos.application.annotations.NotFutureDate;
import br.edu.ufape.vinculos.application.annotations.ValidDateRange;
import br.edu.ufape.vinculos.application.validations.DateRange;
import br.edu.ufape.vinculos.business.models.Projeto;
import br.edu.ufape.vinculos.config.SpringApplicationContext;

@Getter @Setter @NoArgsConstructor @ValidDateRange(message = "A data de criação deve ser anterior à data de certificação")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProjetosRequest implements DateRange {
    
    @Override
    public Date getStartDate() {
        return dataCriacao;
    }

    @Override
    public Date getEndDate() {
        return dataCertificacao;
    }
    
    @NotBlank(message = "O nome não pode ser vazio")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    private String descricao;

    @NotEmpty(message = "A lista de palavras-chave não pode ser vazia")
    private List<String> palavrasChave;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCriacao;

    @NotFutureDate(message = "A data de certificação não pode ser futura")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCertificacao;

    private String linguagemDeDesenvolvimento;

    private String campoDeAplicacao;

    private String tipoDeSistema;

    public Projeto convertToEntity() {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
    
		Projeto obj = modelMapper.map(this, Projeto.class);
		return obj;
    }


}
