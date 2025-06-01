package entity;

public abstract class TrilhaTeoria {

    // Template Method
    public final void carregarTeoria(String capitulo) {
        System.out.println("Carregando teoria: " + capitulo);
        exibirTitulo();
        exibirConteudo();
        exibirMidias();
        aplicarAcessibilidade();
        exibirResumoInterativo();
    }

    protected abstract void exibirTitulo();
    protected abstract void exibirConteudo();
    protected abstract void exibirMidias();
    protected abstract void aplicarAcessibilidade();
    protected abstract void exibirResumoInterativo();
}