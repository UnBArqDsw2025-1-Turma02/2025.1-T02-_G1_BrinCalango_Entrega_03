package entity;

public class TrilhaTeoriaPadrao extends TrilhaTeoria {

    @Override
    protected void exibirTitulo() {
        System.out.println("Exibindo título padrão");
    }

    @Override
    protected void exibirConteudo() {
        System.out.println("Exibindo conteúdo padrão");
    }

    @Override
    protected void exibirMidias() {
        System.out.println("Exibindo mídias padrão");
    }

    @Override
    protected void aplicarAcessibilidade() {
        System.out.println("Aplicando acessibilidade padrão");
    }

    @Override
    protected void exibirResumoInterativo() {
        System.out.println("Exibindo resumo interativo padrão");
    }
}