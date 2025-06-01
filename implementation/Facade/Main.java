import application.Facade;
import application.FacadeImpl;
import entity.Modulo;
import service.ModuloService;
import service.QuestaoService;
import service.UsuarioService;

public class Main {
    public static void main(String[] args){

        FacadeImpl intf = new FacadeImpl(new ModuloService(),new QuestaoService(),new UsuarioService());
        Modulo mo = intf.iniciarModulo(0);
        intf.executarAtividade(0,mo,"Resposta questao 0");
        intf.responderQuestao(mo,0,"Resposta questao 0");
        intf.mostrarProgresso(1);
        intf.mostrarResultadoUltimaResposta(1);

    }
}








































