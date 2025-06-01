package entity;

public class QuestaoVouF extends Questao {

    private boolean respostaVouF;

    public QuestaoVouF(){
    }

    public QuestaoVouF(QuestaoVouF instancia){
        super(instancia);
        if(instancia != null){
            this.respostaVouF = instancia.respostaVouF;
        }else{
            throw new RuntimeException("Instancia Vazia!!");
        }
    }

    public boolean getRespostaVouF() {
        return respostaVouF;
    }

    public void setRespostaVouF(boolean respostaVouF) {
        this.respostaVouF = respostaVouF;
    }

    @Override
    public Questao clone() {
        return new QuestaoVouF(this);
    }

}