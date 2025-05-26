# 3.1.- GoFs Criacionais

## Factory Method 

O padrão de projeto Factory Method é um padrão criacional que define uma interface para a criação de objetos, permitindo que as subclasses escolham qual tipo de objeto será instanciado. Essa abordagem promove flexibilidade e reduz o acoplamento entre o código que usa os objetos e suas classes concretas, facilitando a extensão do sistema sem modificar seu núcleo.

### Esquema ilustrativo do Factory Method 

<div align="center">

<p><strong>Figura 1 – Fluxograma ilustrativo do padrão Factory Method aplicado</strong></p>

![esquema ilustrativo]()

<p><em>Autor: <a href="https://github.com/julia-fortunato" target="_blank">Júlia Fortunato</a>, <a href="https://github.com/luanasoares0901" target="_blank">Luana</a> e <a href="https://github.com/ailujana" target="_blank">Ana Julia</a>, 2025</em></p>

</div>

### Modelagem do Factory Method 

#### Imagem

Na Figura 2, encontra-se a modelagem para o Factory Method 

<div align="center">

<p><strong>Figura 2 – Modelagem do Factory Method  </strong></p>

![Diagrama do Factory Method](../assets/factoryMethod.png)

<p><em>Autor: <a href="https://github.com/julia-fortunato" target="_blank">Júlia Fortunato</a>, <a href="https://github.com/luanasoares0901" target="_blank">Luana</a> e <a href="https://github.com/ailujana" target="_blank">Ana Julia</a>, 2025</em></p>

</div>


#### Frame interativo da modelagem do Factory Method

<div style="width: 640px; height: 480px; margin: 10px; position: relative;"><iframe allowfullscreen frameborder="0" style="width:640px; height:480px" src="https://lucid.app/documents/embedded/3d29c102-1433-45c0-8e62-4555223031e1" id="9e2iZ.B9riZr"></iframe></div>

### Implementação do Factory Method

```
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

// Classe Principal todo main

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
```


## Referências Bibliográficas

> 

## Bibliografia 

> [1] REFRACTORING.GURU. Factory Metho. [S. l.], [s. d.]. Disponível em: https://refactoring.guru/design-patterns/factory-method. Acesso em: 25 maio. 2025.


## Histórico de Versões
| Versão | Data | Descrição | Autor(es) | Revisor(es) | Descrição da Revisão | Commits |
| ------ | ---- | --------- | --------- | ----------- | -------------------- | ------- |
| 1.0 | 25/05/2025 | Estruturação e Inclusão da implementação | [Ana Catarina](https://github.com/an4catarina) e [Victor Hugo](http://github.com/ViictorHugoo) | | | |
