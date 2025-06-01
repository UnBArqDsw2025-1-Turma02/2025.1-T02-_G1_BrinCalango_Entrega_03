package service;

import entity.Modulo;
import entity.Questao;
import java.util.ArrayList;

public class ModuloService {

    public Modulo iniciarModulo(int idModulo){

        Modulo novoModulo = new Modulo();

        novoModulo.setIdModulo(1);

        ArrayList<Questao> ar = new ArrayList<Questao>();

        int i = 0;
        while (i < 10) {
            ar.add(new Questao(i,0,10,"Enunciado questao "+i,"Resposta questao "+i));
            i++;
        }

        novoModulo.setQuestoes(ar);

        return novoModulo;
    }

    public ArrayList<Questao> obterQuestoes(Modulo idModulo){
        return idModulo.getQuestoes();
    }

}
