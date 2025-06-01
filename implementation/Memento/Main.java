import java.time.LocalDate;
import entity.Progresso;
import entity.ProgressoMemento;

public class Main {
    public static void main(String[] args) {
        // Criar configurações de acessibilidade fictícias
        Usuario.ConfigAcessibilidade config = new Usuario.ConfigAcessibilidade(true, true);

        // Criar progresso inicial
        Progresso progresso = new Progresso(1, 100);

        // Criar usuário
        Usuario usuario = new Usuario(
            1,
            "João Silva",
            "joao@email.com",
            "senha123",
            LocalDate.of(2000, 5, 15),
            config,
            progresso
        );

        // Validar email
        System.out.println("Email válido? " + usuario.validarEmail());

        // Calcular idade
        System.out.println("Idade: " + usuario.calcularIdade());

        // Ler teoria
        Usuario.Teoria teoria = usuario.lerTeoria(3);
        System.out.println("Teoria capítulo " + teoria.getCapitulo() + ": " + teoria.getConteudo());

        // Realizar 5 atividades
        for (int i = 1; i <= 5; i++) {
            Usuario.Feedback feedback = usuario.realizarAtividade(i);
            System.out.println("Questão " + feedback.getIdQuestao() + ": " +
                (feedback.isAcertou() ? "Acertou!" : "Errou!"));
        }

        // Consultar progresso atual
        Progresso progressoAtual = usuario.consultarProgresso();
        System.out.println("XP Atual: " + progressoAtual.getQtdXP());
        System.out.println("Nível Atual: " + progressoAtual.getNivelAtual());

        // Salvar progresso
        usuario.salvarProgresso();
        System.out.println("Progresso salvo.");

        // Simular mais atividades e progresso
        for (int i = 6; i <= 10; i++) {
            usuario.realizarAtividade(i);
        }

        System.out.println("XP após mais questões: " + progressoAtual.getQtdXP());
        System.out.println("Nível Atual: " + progressoAtual.getNivelAtual());

        // Restaurar progresso anterior
        usuario.restaurarProgresso();
        System.out.println("Progresso restaurado.");

        // Consultar novamente
        System.out.println("XP restaurado: " + progressoAtual.getQtdXP());
        System.out.println("Nível restaurado: " + progressoAtual.getNivelAtual());
    }
}
