package br.edu.ufape.editais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import br.edu.ufape.editais.model.Inscricao;
import br.edu.ufape.editais.model.dto.DadosAtualizarInscricao;
import br.edu.ufape.editais.model.dto.DadosDetalhamentoInscricao;
import br.edu.ufape.editais.model.dto.DadosListagemInscricao;
import br.edu.ufape.editais.model.dto.InscricaoDTO;
import br.edu.ufape.editais.repository.InscricaoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoRepository repository;
    
    @PostMapping
    public ResponseEntity<DadosDetalhamentoInscricao> cadastrarInscricao(@RequestBody InscricaoDTO dados, UriComponentsBuilder uriBuilder) {
    	var inscricao = new Inscricao(dados);
    	repository.save(new Inscricao(dados));
    	
    	var uri = uriBuilder.path("/inscricoes/{id}").buildAndExpand(inscricao.getId()).toUri();
    	
    	return ResponseEntity.created(uri).body(new DadosDetalhamentoInscricao(inscricao));
    }
    
    @GetMapping
    public ResponseEntity<List<DadosListagemInscricao>> listarInscricao(){
    	var lista = repository.findAll().stream().map(DadosListagemInscricao :: new).toList();
    	
    	return ResponseEntity.ok(lista);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoInscricao> buscarInscricaoPorId(@PathVariable Long id) {
    	var inscricao = repository.getReferenceById(id);
    	
    	return ResponseEntity.ok(new DadosDetalhamentoInscricao(inscricao));
    }
    
    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoInscricao> atualizarEdital(@RequestBody @Valid DadosAtualizarInscricao dados) {
    	var inscricao = repository.getReferenceById(dados.id());
        inscricao.atualizarInformacoes(dados);
        
        return ResponseEntity.ok(new DadosDetalhamentoInscricao(inscricao));
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirEdital(@PathVariable Long id) {
    	repository.deleteById(id);
    	
    	return ResponseEntity.noContent().build();
    }

}