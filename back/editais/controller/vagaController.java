import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {
    private List<Vaga> vagas = new ArrayList<>();

    @PostMapping
    public void criarVaga(@RequestBody Vaga vaga) {
        vagas.add(vaga);
    }

    @GetMapping("/{quantidade}")
    public Vaga buscarVagaPorQuantidade(@PathVariable int quantidade) {
        for (Vaga vaga : vagas) {
            if (vaga.getQuantidade() == quantidade) {
                return vaga;
            }
        }
        return null;
    }

    @PutMapping("/{quantidade}")
    public void atualizarVaga(@PathVariable int quantidade, @RequestBody Vaga vaga) {
        for (int i = 0; i < vagas.size(); i++) {
            if (vagas.get(i).getQuantidade() == quantidade) {
                vagas.set(i, vaga);
                return;
            }
        }
    }

    @DeleteMapping("/{quantidade}")
    public void deletarVaga(@PathVariable int quantidade) {
        vagas.removeIf(vaga -> vaga.getQuantidade() == quantidade);
    }
}
