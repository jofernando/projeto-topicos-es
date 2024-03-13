package br.edu.ufape.editais.controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import br.edu.ufape.editais.model.Vaga;

@RestController
@RequestMapping("/vagas")
public class VagaController {
    private List<Vaga> vagas = new ArrayList<>();

    @PostMapping
    public void criarVaga(@RequestBody Vaga vaga) {
        vagas.add(vaga);
    }

    @GetMapping("/{id}")
    public Vaga buscarVagas(@PathVariable int id) {
        for (Vaga vaga : vagas) {
            if (vaga.getId() == id) {
                return vaga;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public void atualizarVaga(@PathVariable int id, @RequestBody Vaga vaga) {
        for (int i = 0; i < vagas.size(); i++) {
            if (vagas.get(i).getId() == id) {
                vagas.set(i, vaga);
                return;
            }
        }
    }

    @DeleteMapping("/{id}")
    public void deletarVaga(@PathVariable int id) {
        vagas.removeIf(vaga -> vaga.getId() == id);
    }
}