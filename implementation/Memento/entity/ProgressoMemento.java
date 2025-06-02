package entity;

public class ProgressoMemento{
    private int nivelAtual;
    private int nivelProx;
    private int qtdXP;
    private int XPMaxNivel;
    private int totalQuestoesAcerto;
    private int totalQuestoesErro;
    private float porcentagemConcluida;

    public ProgressoMemento(int nivelAtual, int nivelProx, int qtdXP, int XPMaxNivel, int totalQuestoesAcerto, int totalQuestoesErro, float porcentagemConcluida) {
        this.nivelAtual = nivelAtual;
        this.nivelProx = nivelProx;
        this.qtdXP = qtdXP;
        this.XPMaxNivel = XPMaxNivel;
        this.totalQuestoesAcerto = totalQuestoesAcerto;
        this.totalQuestoesErro = totalQuestoesErro;
        this.porcentagemConcluida = porcentagemConcluida;
    }
    
    public int getNivelAtual() { return nivelAtual; } 
    public int getNivelProx() { return nivelProx; }
    public int getQtdXP() { return qtdXP; }
    public int getXPMaxNivel() { return XPMaxNivel; }
    public int getTotalQuestoesAcerto() { return totalQuestoesAcerto; }
    public int getTotalQuestoesErro() { return totalQuestoesErro; }
    public float getPorcentagemConcluida() { return porcentagemConcluida; }

}


