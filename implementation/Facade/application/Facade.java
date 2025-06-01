package application;

import entity.Feedback;
import entity.Modulo;

public interface Facade {
    Modulo iniciarModulo(int idModulo);
    public void executarAtividade(int idQuestao,Modulo modulo,String resposta);
    public void responderQuestao(Modulo modulo, int idQuestao, String resposta);
    Feedback mostrarResultadoUltimaResposta(int idUsuario);
    void mostrarProgresso(int idUsuario);
}
