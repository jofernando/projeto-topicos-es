package br.edu.ufape.editais.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ufape.editais.model.Vaga;
//import br.edu.ufape.editais.model.dto.DadosListagemVaga;

public interface VagaRepository extends JpaRepository <Vaga, Long> {

	List<Vaga> findAllByAtivaTrue();

}
