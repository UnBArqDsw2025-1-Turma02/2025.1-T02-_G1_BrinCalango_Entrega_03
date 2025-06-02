package entity;

public class Progresso {
    private int nivelAtual = 1;
    private int nivelProx = 2;
    private int qtdXP = 0;
    private int XPMaxNivel = 100;
    private int totalQuestoesAcerto = 0;
    private int totalQuestoesErro = 0;
    private float porcentagemConcluida = 0;

    public void atualizarProgresso(int qtdXP) {
        this.qtdXP += qtdXP;
        System.out.println("XP adicionado: " + qtdXP + " | Total de XP: " + this.qtdXP);
        atualizarNivel();
    }

    public boolean atualizarNivel() {
        if (qtdXP >= XPMaxNivel) { // pra subir de nivel precisa chegar ao max de xp
            nivelAtual++;
            nivelProx++;
            qtdXP -= XPMaxNivel;
            XPMaxNivel += 40;
            System.out.println("Parabéns! Você subiu para o nível " + nivelAtual);
            return true;
        }
        return false;
    }

    public void incrementarErros() {
    totalQuestoesErro++;
}


    public ProgressoMemento salvarEstado() {
        System.out.println("Salvando progresso...");
        return new ProgressoMemento(nivelAtual, nivelProx, qtdXP, XPMaxNivel, totalQuestoesAcerto, totalQuestoesErro, porcentagemConcluida);
    }

    public void restaurarEstado (ProgressoMemento memento) {
        System.out.println("Restaurando progresso salvo...");
        this.nivelAtual = memento.getNivelAtual();
        this.nivelProx = memento.getNivelProx();
        this.qtdXP = memento.getQtdXP();
        this.XPMaxNivel = memento.getXPMaxNivel();
        this.totalQuestoesAcerto = memento.getTotalQuestoesAcerto();
        this.totalQuestoesErro = memento.getTotalQuestoesErro();
        this.porcentagemConcluida = memento.getPorcentagemConcluida();
    }

    public void mostrarProgresso() {
        System.out.println("=== Progresso ===");
        System.out.println("Nível atual: " + nivelAtual);
        System.out.println("XP: " + qtdXP + "/" + XPMaxNivel);
        System.out.println("=================");
    }
}


