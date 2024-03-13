package br.edu.ufape.editais.controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufape.editais.model.Inscricao;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {
    private List<Inscricao> inscricoes = new ArrayList<>();

    @PostMapping
    public void criarInscricao(@RequestBody Inscricao inscricao) {
        inscricoes.add(inscricao);
    }
    
    @GetMapping
    public List<Inscricao> buscarTodasInscricoes(){
    	return inscricoes;
    }

    @GetMapping("/{id}")
    public Inscricao buscarInscricaoPorMatricula(@PathVariable long id) {
        for (Inscricao inscricao : inscricoes) {
            if (inscricao.getId() == id) {
                return inscricao;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public void atualizarInscricao(@PathVariable long id, @RequestBody Inscricao inscricao) {
        for (int i = 0; i < inscricoes.size(); i++) {
            if (inscricoes.get(i).getId() == id) {
                inscricoes.set(i, inscricao);
                return;
            }
        }
    }

    @DeleteMapping("/{id}")
    public void deletarInscricao(@PathVariable long id) {
        inscricoes.removeIf(inscricao -> inscricao.getId() == id);
    }
}