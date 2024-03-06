import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {
    private List<Inscricao> inscricoes = new ArrayList<>();

    @PostMapping
    public void criarInscricao(@RequestBody Inscricao inscricao) {
        inscricoes.add(inscricao);
    }

    @GetMapping("/{userId}")
    public Inscricao buscarInscricaoPorUserId(@PathVariable long userId) {
        for (Inscricao inscricao : inscricoes) {
            if (inscricao.getUserId() == userId) {
                return inscricao;
            }
        }
        return null;
    }

    @PutMapping("/{userId}")
    public void atualizarInscricao(@PathVariable long userId, @RequestBody Inscricao inscricao) {
        for (int i = 0; i < inscricoes.size(); i++) {
            if (inscricoes.get(i).getUserId() == userId) {
                inscricoes.set(i, inscricao);
                return;
            }
        }
    }

    @DeleteMapping("/{userId}")
    public void deletarInscricao(@PathVariable long userId) {
        inscricoes.removeIf(inscricao -> inscricao.getUserId() == userId);
    }
}
