package br.edu.ufape.vinculos.business.services.interfaces;

import java.util.List;

import br.edu.ufape.vinculos.business.models.Projeto;
import br.edu.ufape.vinculos.business.models.Vinculo;

public interface VinculoServiceInterface {

    Vinculo registerVinculo(Vinculo entity);

    String deleteVinculo(Long id);

    Vinculo findVinculo(Long id);

    List<Vinculo> findAllVinculos();

    List<Vinculo> findByProjeto(Projeto projeto);

}