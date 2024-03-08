package br.edu.ufape.vinculos.application.dto.Vinculos;


import java.util.Date;

import org.hibernate.validator.constraints.Range;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.edu.ufape.vinculos.application.annotations.NotFutureDate;
import br.edu.ufape.vinculos.application.annotations.ProjetoExists;
import br.edu.ufape.vinculos.application.annotations.ValidDateRange;
import br.edu.ufape.vinculos.application.validations.DateRange;
import br.edu.ufape.vinculos.business.models.Vinculo;
import br.edu.ufape.vinculos.business.models.enums.TipoVinculoEnum;
import br.edu.ufape.vinculos.config.SpringApplicationContext;

@Getter @Setter @NoArgsConstructor @ValidDateRange(message = "A data de início deve ser anterior à data de fim")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class VinculosRequest implements DateRange {


    @Override
    public Date getStartDate() {
        return dataInicio;
    }

    @Override
    public Date getEndDate() {
        return dataFim;
    }

    @NotNull(message = "O tipo de vínculo não pode ser vazio")
    private TipoVinculoEnum tipoVinculo;


    @Range(min = 1, max = 168, message = "A carga horária deve ser entre 1 e 168 horas semanais")
    @NotNull(message = "A carga horária não pode ser vazia")
    private int cargaHoraria;


    @NotFutureDate(message = "A data de início não pode ser futura")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataInicio;


    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataFim;

    @NotNull(message = "O status não pode ser vazio")
    private boolean bolsista;

    @NotNull(message = "O status não pode ser vazio")
    private boolean status;

    @NotNull(message = "O projeto não pode ser vazio")
    @ProjetoExists(message = "O projeto não existe")
    private Long projetoId;



    
    public Vinculo convertToEntity() {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		Vinculo obj = modelMapper.map(this, Vinculo.class);
		return obj;
    }
}
