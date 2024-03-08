package br.edu.ufape.vinculos.application.dto.Vinculos;

import lombok.Setter;
import br.edu.ufape.vinculos.business.models.Vinculo;
import br.edu.ufape.vinculos.business.models.enums.TipoVinculoEnum;
import br.edu.ufape.vinculos.config.SpringApplicationContext;
import lombok.NoArgsConstructor;

import java.util.Date;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter @Setter @NoArgsConstructor
public class VinculosResponse {
    private Long id;
    private TipoVinculoEnum tipoVinculo;
    private int cargaHoraria;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataInicio;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataFim;
    private boolean bolsista;
    private boolean status;
    private Long projetoId;

    public VinculosResponse(Vinculo obj) {
        if(obj == null) throw new IllegalArgumentException("Objeto não pode ser nulo");
        else{
        ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(obj, this);
        }
    }

  
    
}
