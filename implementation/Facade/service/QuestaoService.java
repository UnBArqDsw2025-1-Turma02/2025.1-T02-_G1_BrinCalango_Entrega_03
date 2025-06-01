package service;

import entity.Feedback;
import entity.Modulo;

public class QuestaoService {

    public boolean responderQuestao(Modulo modulo, int idQuestao, String resposta){
        String res = modulo.getQuestoes().get(idQuestao).getResposta();
        return res.equals(resposta);
    }

    public Feedback gerarFeedback(int idUsuario){
        return new Feedback("Usuario "+idUsuario+" mandou feedback!!");
    }

}
