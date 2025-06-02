import entity.Usuario;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(1, "João", "joao@email.com", "senha123");

        usuario.getProgresso().atualizarProgresso(50);
        usuario.getProgresso().mostrarProgresso();

        usuario.salvarProgresso();

        usuario.getProgresso().atualizarProgresso(70);
        usuario.getProgresso().mostrarProgresso();

        usuario.salvarProgresso();

        usuario.getProgresso().atualizarProgresso(200);
        usuario.getProgresso().mostrarProgresso();

        usuario.restaurarProgresso(0);
        usuario.getProgresso().mostrarProgresso();
    }
}
