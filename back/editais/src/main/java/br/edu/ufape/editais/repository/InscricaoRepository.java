package br.edu.ufape.editais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ufape.editais.model.Inscricao;

public interface InscricaoRepository extends JpaRepository <Inscricao, Long> {

}
