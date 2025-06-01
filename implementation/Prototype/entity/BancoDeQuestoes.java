package entity;

import java.util.HashMap;
import java.util.Map;

class BancoDeQuestoes {
    private Map<Integer, Questao> modelos = new HashMap<>();

    public void adicionarModelo(Questao questao) {
        modelos.put(questao.idQuestao, questao);
    }

    public Questao clone(int idQuestao) {
        Questao questao = modelos.get(idQuestao);
        if (questao != null) {
            return questao.clone();
        }
        return null;
    }
}