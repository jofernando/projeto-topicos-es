import java.util.Date;
import java.util.List;
import java.util.Map;

public class Edital {
    private String descricao;
    private String editalArquivo;
    private Date inicioInscricao;
    private Date fimInscricao;
    private Map<String, List<String>> classificacaoFinal;

    public Edital() {
    }

    public Edital(String descricao, String editalArquivo, Date inicioInscricao, Date fimInscricao, Map<String, List<String>> classificacaoFinal) {
        this.descricao = descricao;
        this.editalArquivo = editalArquivo;
        this.inicioInscricao = inicioInscricao;
        this.fimInscricao = fimInscricao;
        this.classificacaoFinal = classificacaoFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEditalArquivo() {
        return editalArquivo;
    }

    public void setEditalArquivo(String editalArquivo) {
        this.editalArquivo = editalArquivo;
    }

    public Date getInicioInscricao() {
        return inicioInscricao;
    }

    public void setInicioInscricao(Date inicioInscricao) {
        this.inicioInscricao = inicioInscricao;
    }

    public Date getFimInscricao() {
        return fimInscricao;
    }

    public void setFimInscricao(Date fimInscricao) {
        this.fimInscricao = fimInscricao;
    }

    public Map<String, List<String>> getClassificacaoFinal() {
        return classificacaoFinal;
    }

    public void setClassificacaoFinal(Map<String, List<String>> classificacaoFinal) {
        this.classificacaoFinal = classificacaoFinal;
    }
}
