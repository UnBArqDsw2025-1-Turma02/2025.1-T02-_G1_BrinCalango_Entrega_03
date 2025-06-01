package entity;

public class Questao {

    private int idQuestao;
    private int nivel;
    private int pontuacao;
    private String enunciado;
    private String resposta;

    public Questao(){
    }

    public Questao(int idQuestao, int nivel, int pontuacao, String enunciado, String resposta) {
        this.idQuestao = idQuestao;
        this.nivel = nivel;
        this.pontuacao = pontuacao;
        this.enunciado = enunciado;
        this.resposta = resposta;
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
}
