package entity;

public class TrilhaTeoriaInclusiva extends TrilhaTeoria {

    @Override
    protected void exibirTitulo() {
        System.out.println("Exibindo título inclusivo com linguagem simples");
    }

    @Override
    protected void exibirConteudo() {
        System.out.println("Exibindo conteúdo com ajustes de acessibilidade");
    }

    @Override
    protected void exibirMidias() {
        System.out.println("Exibindo mídias com audiodescrição e legendas");
    }

    @Override
    protected void aplicarAcessibilidade() {
        System.out.println("Aplicando recursos como contraste e navegação por teclado");
    }

    @Override
    protected void exibirResumoInterativo() {
        System.out.println("Exibindo resumo com atividades inclusivas");
    }
}