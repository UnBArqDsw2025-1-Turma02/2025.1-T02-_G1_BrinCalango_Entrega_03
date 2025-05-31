import entity.ControleOfensiva;
import entity.Questao;
import entity.Usuario;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Usuario user = new Usuario(1,new Date(103,7,10),
                "Mauricio","mauricio@mauricio.com",
                "$2a$10$LUYjuqEM/l/dt51ZuJm0d.polPlGo0vdrdZzlyBUL.zvvR3k0WNHa");

        ControleOfensiva co = new ControleOfensiva(300, LocalDate.now());

        // Testando adicionar observador e notifica-lo
        user.adicionarObservador(co);
        user.realizarAtividade(new Questao(1));

        // Testando remover observador

        user.removerObservador(co);

    }
}
