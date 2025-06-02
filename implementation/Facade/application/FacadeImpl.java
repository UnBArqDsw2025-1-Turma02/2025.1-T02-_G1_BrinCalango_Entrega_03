package application;

import entity.Feedback;
import entity.Modulo;
import entity.Progresso;
import entity.Usuario;
import service.ModuloService;
import service.QuestaoService;
import service.UsuarioService;

public class FacadeImpl implements Facade{

    private ModuloService moduloService;
    private QuestaoService questaoService;
    private UsuarioService usuarioService;

    public FacadeImpl(ModuloService moduloService, QuestaoService questaoService, UsuarioService usuarioService) {
        this.moduloService = moduloService;
        this.questaoService = questaoService;
        this.usuarioService = usuarioService;
    }

    @Override
    public Modulo iniciarModulo(int idModulo) {
        System.out.println("Iniciando Modulo");
        return moduloService.iniciarModulo(idModulo);
    }

    @Override
    public void executarAtividade(int idQuestao,Modulo modulo,String resposta) {
        System.out.println("Respondendo Questao "+ idQuestao);
        if(questaoService.responderQuestao(modulo,idQuestao,resposta)){
            System.out.println("Acertou!!");
        }else {
            System.out.println("Errou!!");
        }
        System.out.println("Gerando Feedback");
        Feedback fe = questaoService.gerarFeedback(1);
        System.out.println("Feedback da questao "+idQuestao+" com mensagem\n"+fe.getMensagem());

    }

    @Override
    public Feedback responderQuestao(Modulo modulo, int idQuestao, String resposta) {
        System.out.println("Respondendo Questao "+ idQuestao);
        if(questaoService.responderQuestao(modulo,idQuestao,resposta)){
            System.out.println("Acertou!!");
        }else {
            System.out.println("Errou!!");
        }
        return new Feedback("Feedback gerado com sucesso!");
    }
    

    @Override
    public Feedback mostrarResultadoUltimaResposta(int idUsuario) {
        System.out.println("Feedback da ultima questao!");
        return null;
    }

    @Override
    public Progresso mostrarProgresso(int idUsuario) {
        System.out.println("Progresso do usuario"+idUsuario);

        return new Progresso("Progresso do usuário: salvo!");
    }

    public ModuloService getModuloService() {
        return moduloService;
    }

    public void setModuloService(ModuloService moduloService) {
        this.moduloService = moduloService;
    }

    public QuestaoService getQuestaoService() {
        return questaoService;
    }

    public void setQuestaoService(QuestaoService questaoService) {
        this.questaoService = questaoService;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

}
