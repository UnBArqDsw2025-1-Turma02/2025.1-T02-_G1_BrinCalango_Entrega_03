// import application.Facade;
// import application.FacadeImpl;
// import entity.Modulo;
// import service.ModuloService;
// import service.QuestaoService;
// import service.UsuarioService;

// public class Main {
//     public static void main(String[] args){

//         FacadeImpl intf = new FacadeImpl(new ModuloService(),new QuestaoService(),new UsuarioService());
//         Modulo mo = intf.iniciarModulo(0);
//         intf.executarAtividade(0,mo,"Resposta questao 0");
//         intf.responderQuestao(mo,0,"Resposta questao 0");
//         intf.mostrarProgresso(1);
//         intf.mostrarResultadoUltimaResposta(1);

//     }
// }

import entity.Usuario;
import entity.ConfigAcessibilidade;
import entity.Feedback;
import application.FacadeImpl;
import service.UsuarioService;
import service.QuestaoService;
import service.ModuloService;
import application.Facade;
import application.FacadeImpl;
import java.util.Date;
import entity.Modulo;


public class Main {
    public static void main(String[] args) {

        FacadeImpl intf = new FacadeImpl(new ModuloService(),new QuestaoService(),new UsuarioService());

        Usuario user = new Usuario(1,new Date(103,7,10),
                "Mauricio","mauricio@mauricio.com",
                "$2a$10$LUYjuqEM/l/dt51ZuJm0d.polPlGo0vdrdZzlyBUL.zvvR3k0WNHa", intf);
         //Usuário requisita a Fachada 

        Modulo mo = intf.iniciarModulo(0);
        intf.executarAtividade(0,mo,"Resposta questao 0");
        intf.responderQuestao(mo,0,"Resposta questao 0");
        intf.mostrarProgresso(1);
        intf.mostrarResultadoUltimaResposta(1);
    }
}







































