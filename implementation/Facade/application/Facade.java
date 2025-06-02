package application;

import entity.Feedback;
import entity.Modulo;
import entity.Progresso;
import service.ModuloService;
import service.QuestaoService;
import service.UsuarioService;
import entity.Usuario;

public interface Facade {
    public Modulo iniciarModulo(int idModulo);
    public void executarAtividade(int idQuestao,Modulo modulo,String resposta);
    public Feedback responderQuestao(Modulo modulo, int idQuestao, String resposta);
    public Feedback mostrarResultadoUltimaResposta(int idUsuario);
    public Progresso mostrarProgresso(int idUsuario);
}
