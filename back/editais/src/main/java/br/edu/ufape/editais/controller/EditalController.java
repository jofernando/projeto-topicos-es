package br.edu.ufape.editais.controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufape.editais.model.Edital;

@RestController
@RequestMapping("/editais")
public class EditalController {
    private List<Edital> editais = new ArrayList<>();

    @PostMapping
    public void criarEdital(@RequestBody Edital edital) {
        editais.add(edital);
    }
    
    @GetMapping
    public List<Edital> buscarTodosEditais(){
    	return editais;
    }
    
    @GetMapping("/{id}")
    public Edital buscarEditalPorDescricao(@PathVariable long id) {
        for (Edital edital : editais) {
            if (edital.getId() == id) {
                return edital;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public void atualizarEdital(@PathVariable long id, @RequestBody Edital edital) {
        for (int i = 0; i < editais.size(); i++) {
            if (editais.get(i).getId() == id) {
                editais.set(i, edital);
                return;
            }
        }
    }

    @DeleteMapping("/{id}")
    public void deletarEdital(@PathVariable long id) {
        editais.removeIf(edital -> edital.getId() == id);
    }
    
}