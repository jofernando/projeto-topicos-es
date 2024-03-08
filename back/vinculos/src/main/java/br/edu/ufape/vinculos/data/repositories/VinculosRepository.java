package br.edu.ufape.vinculos.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.vinculos.business.models.Projeto;
import br.edu.ufape.vinculos.business.models.Vinculo;

@Repository
public interface VinculosRepository extends JpaRepository<Vinculo, Long>{
    List<Vinculo> findByProjeto(Projeto projeto);
    
}
