package entity;

public class Feedback {
    private final String mensagem;

    public Feedback(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}