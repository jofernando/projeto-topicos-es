package br.edu.ufape.vinculos.business.services.interfaces;

import java.util.List;

import br.edu.ufape.vinculos.business.models.Projeto;

public interface ProjetoServiceInterface {

    Projeto registerProjeto(Projeto entity);

    String deleteProjeto(Long id);

    Projeto findProjeto(Long id);

    List<Projeto> findAllProjetos();

}