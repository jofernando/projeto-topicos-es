package br.edu.ufape.vinculos.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.vinculos.business.models.Projeto;

@Repository
public interface ProjetosRepository extends JpaRepository<Projeto, Long>{
    
}
