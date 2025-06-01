package entity;

import java.util.ArrayList;
import java.util.List;

public class QuestaoMultiplaEscolha extends Questao {

    private ArrayList<String> alternativasME;
    private ArrayList<String> alternativasCorretasME;

    public QuestaoMultiplaEscolha(){
    }

    public QuestaoMultiplaEscolha(QuestaoMultiplaEscolha instancia){
        super(instancia);
        if(instancia != null){
            this.alternativasME = instancia.alternativasME;
            this.alternativasCorretasME = instancia.alternativasCorretasME;
        }else{
            throw new RuntimeException("Instancia Vazia!!");
        }
    }

    public ArrayList<String> getAlternativasME() {
        return alternativasME;
    }

    public void setAlternativasME(ArrayList<String> alternativasME) {
        this.alternativasME = alternativasME;
    }

    public List<String> getAlternativasCorretasME() {
        return alternativasCorretasME;
    }

    public void setAlternativasCorretasME(ArrayList<String> alternativasCorretasME) {
        this.alternativasCorretasME = alternativasCorretasME;
    }

    public boolean acertouME(List<String> respostas){
        int cont = 0;
        for(String res : respostas){
            if(this.alternativasCorretasME.contains(res)){
                cont++;
            }
        }
        return (cont == this.alternativasCorretasME.size());
    }

    @Override
    public Questao clone() {
        return new QuestaoMultiplaEscolha(this);
    }
}