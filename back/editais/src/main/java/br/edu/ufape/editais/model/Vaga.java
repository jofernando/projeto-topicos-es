package br.edu.ufape.editais.model;

public class Vaga {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantidade;

    public Vaga() {
    }

    public Vaga(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public <T> T method(Class<T> type) {
        // Implementação do método que ta no diagr mas...?
        return null;
    }
}
