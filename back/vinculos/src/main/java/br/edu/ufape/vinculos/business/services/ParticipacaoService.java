package br.edu.ufape.vinculos.business.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import br.edu.ufape.vinculos.business.models.Participacao;
import br.edu.ufape.vinculos.business.models.Projeto;
import br.edu.ufape.vinculos.business.services.interfaces.ParticipacaoServiceInterface;
import br.edu.ufape.vinculos.data.repositories.ParticipacaoRepository;


@Service @RequiredArgsConstructor
public class ParticipacaoService implements ParticipacaoServiceInterface {
    private final ParticipacaoRepository repository;

    @Override
    public Participacao registerParticipacao(Participacao entity) {
        return repository.save(entity);
    }

    @Override
    public String deleteParticipacao(Long id) {
        Participacao entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Participacao não encontrado"));
        repository.delete(entity);
        return "Participacao deletado com sucesso";
    }

    @Override
    public Participacao findParticipacao(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Participacao não encontrada"));
    }

    @Override
    public List<Participacao> findAllParticipacoes() {
        return repository.findAll();
    }

    @Override
    public List<Participacao> findParticipacaoByProjeto(Projeto projeto) {
        return repository.findByProjeto(projeto);
    }

    
}
