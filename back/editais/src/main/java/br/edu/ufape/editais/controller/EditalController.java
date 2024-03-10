package br.edu.ufape.editais.controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/editais")
public class EditalController {
    private List<Edital> editais = new ArrayList<>();

    @PostMapping
    public void criarEdital(@RequestBody Edital edital) {
        editais.add(edital);
    }

    @GetMapping("/{descricao}")
    public Edital buscarEditalPorDescricao(@PathVariable String descricao) {
        for (Edital edital : editais) {
            if (edital.getDescricao().equals(descricao)) {
                return edital;
            }
        }
        return null;
    }

    @PutMapping("/{descricao}")
    public void atualizarEdital(@PathVariable String descricao, @RequestBody Edital edital) {
        for (int i = 0; i < editais.size(); i++) {
            if (editais.get(i).getDescricao().equals(descricao)) {
                editais.set(i, edital);
                return;
            }
        }
    }

    @DeleteMapping("/{descricao}")
    public void deletarEdital(@PathVariable String descricao) {
        editais.removeIf(edital -> edital.getDescricao().equals(descricao));
    }
}
