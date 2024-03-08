package br.edu.ufape.vinculos.business.services;

import java.util.Optional;

import java.util.List;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import br.edu.ufape.vinculos.business.models.Projeto;
import br.edu.ufape.vinculos.business.services.interfaces.ProjetoServiceInterface;
import br.edu.ufape.vinculos.data.repositories.ProjetosRepository;

@Service
@RequiredArgsConstructor
public class ProjetoService implements ProjetoServiceInterface {
    private final ProjetosRepository repository;

    @Override
    public Projeto registerProjeto(Projeto entity) {
        return repository.save(entity);
    }

    @Override
    public String deleteProjeto(Long id) {
        Optional<Projeto> entity = repository.findById(id);
        if(entity.isPresent()){ 
        repository.delete(entity.get());
        return "Projeto deletado com sucesso";}
        else throw new RuntimeException("Projeto não encontrado");
    }

     @Override
    public Projeto findProjeto(Long id) {
        Optional<Projeto> entity = repository.findById(id);
        if(entity.isPresent()) return entity.get();
        else throw new RuntimeException("Projeto não encontrado");
    }


    @Override
    public List<Projeto> findAllProjetos() {
        return repository.findAll();
    }

}
