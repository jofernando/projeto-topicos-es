package br.edu.ufape.editais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ufape.editais.model.Edital;

public interface EditalRepository extends JpaRepository <Edital, Long>{
	
}
