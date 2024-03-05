public class Inscricao {
    private Bolsa bolsa;
    private String historicoEscolar;
    private String curriculo;
    private String funcao;
    private String comprovanteMatricula;
    private long userId;

    public Inscricao() {
    }

    public Inscricao(Bolsa bolsa, String historicoEscolar, String curriculo, String funcao, String comprovanteMatricula, long userId) {
        this.bolsa = bolsa;
        this.historicoEscolar = historicoEscolar;
        this.curriculo = curriculo;
        this.funcao = funcao;
        this.comprovanteMatricula = comprovanteMatricula;
        this.userId = userId;
    }

    public Bolsa getBolsa() {
        return bolsa;
    }

    public void setBolsa(Bolsa bolsa) {
        this.bolsa = bolsa;
    }

    public String getHistoricoEscolar() {
        return historicoEscolar;
    }

    public void setHistoricoEscolar(String historicoEscolar) {
        this.historicoEscolar = historicoEscolar;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getComprovanteMatricula() {
        return comprovanteMatricula;
    }

    public void setComprovanteMatricula(String comprovanteMatricula) {
        this.comprovanteMatricula = comprovanteMatricula;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
