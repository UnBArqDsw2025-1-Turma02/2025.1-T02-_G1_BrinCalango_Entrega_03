package entity;

public abstract class Questao {

    protected int idQuestao;
    protected int nivel;
    protected int pontuacao;
    protected String enunciado;
    protected String resposta;

    public Questao(){
    }

    public Questao(Questao instancia) {
        if(instancia != null){
            this.idQuestao = instancia.idQuestao;
            this.nivel = instancia.nivel;
            this.pontuacao = instancia.pontuacao;
            this.enunciado = instancia.enunciado;
            this.resposta = instancia.resposta;
        }
    }

    public int getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(int idQuestao) {
        this.idQuestao = idQuestao;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public abstract Questao clone();

}