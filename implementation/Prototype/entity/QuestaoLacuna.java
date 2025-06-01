package entity;

public class QuestaoLacuna extends Questao {

    private String respostaLacuna;

    public QuestaoLacuna(){
    }

    public QuestaoLacuna(QuestaoLacuna instancia) {
        super(instancia);
        if(instancia != null){
            this.respostaLacuna = instancia.respostaLacuna;
        }else{
            throw new RuntimeException("Instancia Vazia!!");
        }
    }

    public String getRespostaLacuna() {
        return respostaLacuna;
    }

    public void setRespostaLacuna(String respostaLacuna) {
        this.respostaLacuna = respostaLacuna;
    }

    public boolean acertouLacuna(String resposta){
        return resposta.equals(respostaLacuna);
    }

    @Override
    public Questao clone() {
        return new QuestaoLacuna(this);
    }
}

