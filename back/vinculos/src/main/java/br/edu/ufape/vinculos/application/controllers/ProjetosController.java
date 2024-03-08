package br.edu.ufape.vinculos.application.controllers;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import br.edu.ufape.vinculos.application.dto.Participacoes.ParticipacoesResponse;
import br.edu.ufape.vinculos.application.dto.Projetos.ProjetosRequest;
import br.edu.ufape.vinculos.application.dto.Projetos.ProjetosResponse;
import br.edu.ufape.vinculos.application.dto.Vinculos.VinculosResponse;
import br.edu.ufape.vinculos.business.facade.Facade;
import br.edu.ufape.vinculos.business.models.Projeto;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetosController {

    private final ModelMapper modelMapper;
    private final Facade projetos;

    @PostMapping
    public ResponseEntity<ProjetosResponse> registerProjeto(@Valid @RequestBody ProjetosRequest entity) {
        ProjetosResponse response = new ProjetosResponse(projetos.registerProjeto(entity.convertToEntity()));
        return new ResponseEntity<ProjetosResponse>(response, HttpStatus.CREATED);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjetosResponse> updateProjeto(@PathVariable Long id,@Valid @RequestBody ProjetosRequest entity) {
        try{
            Projeto projeto = projetos.findProjeto(id);
            modelMapper.map(entity, projeto);
            ProjetosResponse response = new ProjetosResponse(projetos.registerProjeto(projeto));
            return new ResponseEntity<ProjetosResponse>(response, HttpStatus.OK);
        }catch(RuntimeException e){
            System.err.println(e.getMessage());
            return new ResponseEntity<ProjetosResponse>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetosResponse> findProjeto(@PathVariable Long id) {
        try{
            ProjetosResponse response = new ProjetosResponse(projetos.findProjeto(id));
            return new ResponseEntity<ProjetosResponse>(response, HttpStatus.OK);
        }catch(RuntimeException e){
            System.err.println(e.getMessage());
            return new ResponseEntity<ProjetosResponse>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<ProjetosResponse> listProjetos() {
        return projetos.findAllProjetos().stream().map(ProjetosResponse::new).toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProjeto(@PathVariable Long id) {
        try{
            String response = projetos.deleteProjeto(id);
            return ResponseEntity.ok().body(response);
        }catch(RuntimeException e){
            System.err.println(e.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/vinculos")
    public List<VinculosResponse> getVinculosByProjeto(@PathVariable Long id) {
        try{
            Projeto projeto = projetos.findProjeto(id);
            return projetos.findVinculoByProjeto(projeto).stream().map(VinculosResponse::new).toList();
        }catch(RuntimeException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/{id}/participacoes")
    public List<ParticipacoesResponse> getParticipacoesByProjeto(@PathVariable Long id) {
        try{
            Projeto projeto = projetos.findProjeto(id);
            return projetos.findParticipacaoByProjeto(projeto).stream().map(ParticipacoesResponse::new).toList();
        }catch(RuntimeException e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    
}
