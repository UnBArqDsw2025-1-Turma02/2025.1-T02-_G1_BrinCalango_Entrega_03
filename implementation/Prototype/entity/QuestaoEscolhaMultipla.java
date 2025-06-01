package entity;

import java.util.Map;

public class QuestaoEscolhaMultipla extends Questao {

    private Map<String,Boolean> alternativasEM;

    public QuestaoEscolhaMultipla(){
    }

    public QuestaoEscolhaMultipla(QuestaoEscolhaMultipla instancia){
        super(instancia);
        if(instancia != null){
            this.alternativasEM = instancia.alternativasEM;
        }else{
            throw new RuntimeException("Instancia Vazia!!");
        }
    }

    public Map<String, Boolean> getAlternativasEM() {
        return alternativasEM;
    }

    public void setAlternativasEM(Map<String, Boolean> alternativasEM) {
        this.alternativasEM = alternativasEM;
    }

    public boolean acertouME(Map<String,Boolean> resposta){
        return alternativasEM.equals(resposta);
    }

    @Override
    public Questao clone() {
        return new QuestaoEscolhaMultipla(this);
    }
}
