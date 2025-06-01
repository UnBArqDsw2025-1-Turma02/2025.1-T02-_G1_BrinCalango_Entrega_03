import entity.QuestaoEscolhaMultipla;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        QuestaoEscolhaMultipla qem = new QuestaoEscolhaMultipla();
        Map<String,Boolean> resQuestao = new HashMap<>();
        Map<String,Boolean> resAluno = new HashMap<>();

        qem.setIdQuestao(1);
        qem.setNivel(0);
        qem.setPontuacao(10);
        qem.setEnunciado("Qual função escreve no console?");
        qem.setResposta(null);
        resQuestao.put("escreva",true);
        resQuestao.put("escreval",true);
        resQuestao.put("leia",false);
        resQuestao.put("leiaCaracter",false);
        qem.setAlternativasEM(resQuestao);

        resAluno.put("leiaCaracter",false);
        resAluno.put("escreva",true);
        resAluno.put("leia",false);
        resAluno.put("escreval",false);

        QuestaoEscolhaMultipla qemClone = (QuestaoEscolhaMultipla) qem.clone();

        if(qemClone.acertouME(resAluno)){
            System.out.println("Acertou!");
        }else{
            System.out.println("Errou!");
        }

    }
}