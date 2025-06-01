package entity;

import java.util.ArrayList;

public class Modulo {
    private int idModulo;
    private ArrayList<Questao> questoes = new ArrayList<Questao>();

    public Modulo(){
    }

    public Modulo(int idModulo, ArrayList<Questao> questoes) {
        this.idModulo = idModulo;
        this.questoes = questoes;
    }

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public ArrayList<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(ArrayList<Questao> questoes) {
        this.questoes = questoes;
    }
}
