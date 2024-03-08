package br.edu.ufape.vinculos.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import br.edu.ufape.vinculos.business.models.Projeto;
import br.edu.ufape.vinculos.business.models.Vinculo;
import br.edu.ufape.vinculos.business.services.interfaces.VinculoServiceInterface;
import br.edu.ufape.vinculos.data.repositories.VinculosRepository;


@Service
@RequiredArgsConstructor
public class VinculoService implements VinculoServiceInterface {
    private final VinculosRepository repository;

   
    
    @Override
    public Vinculo registerVinculo(Vinculo entity) {
       return repository.save(entity);
    }

    @Override
    public String deleteVinculo(Long id) {
        Optional<Vinculo> entity = repository.findById(id);
        if(entity.isPresent()){ 
        repository.delete(entity.get());
        return "Vinculo deletado com sucesso";}
        else throw new RuntimeException("Vinculo não encontrado");
    }

    @Override
    public Vinculo findVinculo(Long id) {
        Optional<Vinculo> entity = repository.findById(id);
        if(entity.isPresent()) return entity.get();
        else throw new RuntimeException("Vinculo não encontrado");
    }

    @Override
    public List<Vinculo> findAllVinculos() {
        return repository.findAll();
    }

    @Override
    public List<Vinculo> findByProjeto(Projeto projeto) {
        return repository.findByProjeto(projeto);
    }

    
}
