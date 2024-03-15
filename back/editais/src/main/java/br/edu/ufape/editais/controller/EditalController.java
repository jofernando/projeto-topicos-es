package br.edu.ufape.editais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import br.edu.ufape.editais.model.Edital;
import br.edu.ufape.editais.model.dto.DadosAtualizarEdital;
import br.edu.ufape.editais.model.dto.DadosDetalhamentoEdital;
import br.edu.ufape.editais.model.dto.DadosListagemEdital;
import br.edu.ufape.editais.model.dto.EditalDTO;
import br.edu.ufape.editais.repository.EditalRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/editais")
public class EditalController {

    @Autowired
    private EditalRepository repository;
    
    @PostMapping
    public ResponseEntity<DadosDetalhamentoEdital> cadastrarEdital(@RequestBody @Valid EditalDTO dados, UriComponentsBuilder uriBuilder) {
    	var edital = new Edital(dados);
    	repository.save(new Edital(dados));
    	
    	var uri = uriBuilder.path("/editais/{id}").buildAndExpand(edital.getId()).toUri();
    	
    	return ResponseEntity.created(uri).body(new DadosDetalhamentoEdital(edital));
    }
    
    @GetMapping
    public ResponseEntity<List<DadosListagemEdital>> listarEditais(){
    	var lista = repository.findAll().stream().map(DadosListagemEdital :: new).toList();
    	
    	return ResponseEntity.ok(lista);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoEdital> buscarEditalPorId(@PathVariable Long id) {
    	var edital = repository.getReferenceById(id);
    	
    	return ResponseEntity.ok(new DadosDetalhamentoEdital(edital));
    }
    
    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoEdital> atualizarEdital(@RequestBody @Valid DadosAtualizarEdital dados) {
    	var edital = repository.getReferenceById(dados.id());
        edital.atualizarInformacoes(dados);
        
        return ResponseEntity.ok(new DadosDetalhamentoEdital(edital));
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirEdital(@PathVariable Long id) {
    	repository.deleteById(id);
    	
    	return ResponseEntity.noContent().build();
    }

}