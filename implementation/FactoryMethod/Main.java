import java.util.List;
import java.util.ArrayList;

// Produto Abstrato
abstract class Questao {
    int idQuestao;
    String tema, nivelDificuldade, tipo, enunciado, explicacao;
    int pontuacao;

    abstract void executar();

    boolean validarResposta(String respostaUsuario) { return true; }

    Questao proximaQuestao() { return null; }

    String mostrarEnunciado() { return enunciado; }

    String exibirExplicacao() { return explicacao; }
}

// Produto Concreto 1
class MultiplaEscolha extends Questao {
    String alternativaCorreta;
    List<String> alternativas;

    void executar() { System.out.println("Criando questão do tipo: Multipla Escolha"); }
}

// Produto Concreto 2
class MultiplasAlternativas extends Questao {
    List<String> alternativasCorretas;
    List<String> alternativas;

    void executar() { System.out.println("Criando questão do tipo: Multiplas Alternativas"); }
}

// Produto Concreto 3
class VerdadeiroOuFalso extends Questao {
    boolean resposta;

    void executar() { System.out.println("Criando questão do tipo: Verdadeiro ou Falso"); }
}

// Produto Concreto 4
class Lacuna extends Questao {
    String alternativaCorreta;
    List<String> opcoesLacunas;

    void executar() { System.out.println("Criando questão do tipo: Lacuna"); }
}

// Criador Abstrato
abstract class QuestaoCreator {
    abstract Questao criarQuestao(String tipo);
}

// Criadores Concretos
class CriadorQuestaoMultiplaEscolha extends QuestaoCreator {
    Questao criarQuestao(String tipo) { return new MultiplaEscolha(); }
}

class CriadorQuestaoMultiplasAlternativas extends QuestaoCreator {
    Questao criarQuestao(String tipo) { return new MultiplasAlternativas(); }
}

class CriadorQuestaoVouF extends QuestaoCreator {
    Questao criarQuestao(String tipo) { return new VerdadeiroOuFalso(); }
}

class CriadorQuestaoLacuna extends QuestaoCreator {
    Questao criarQuestao(String tipo) { return new Lacuna(); }
}

// Classe Principal
class Principal {
    public static void main(String[] args) {
        QuestaoCreator criadorVF = new CriadorQuestaoVouF();
        QuestaoCreator criadorME = new CriadorQuestaoMultiplaEscolha();
        QuestaoCreator criadorMA = new CriadorQuestaoMultiplasAlternativas();
        QuestaoCreator criadorLacuna = new CriadorQuestaoLacuna();


        Questao vf = criadorVF.criarQuestao("VF");
        Questao me = criadorME.criarQuestao("Multipla Escolha");
        Questao ma = criadorMA.criarQuestao("Multipla Alternativa");
        Questao lacuna = criadorLacuna.criarQuestao("Lacuna");


        vf.executar(); 
        me.executar();
        ma.executar();
        lacuna.executar();
    }
}