# Factory Method 

O padrão de projeto Factory Method é um padrão criacional que define uma interface para a criação de objetos, permitindo que as subclasses escolham qual tipo de objeto será instanciado. Essa abordagem promove flexibilidade e reduz o acoplamento entre o código que usa os objetos e suas classes concretas, facilitando a extensão do sistema sem modificar seu núcleo.

## Metodologia

Durante o desenvolvimento deste trabalho, os integrantes da equipe se reuniram presencialmente em sala de aula para discutir quais seriam os **padrões comportamentais mais adequados** à proposta da aplicação BrinCalango.

Na ocasião, foi realizada uma análise conjunta entre os sete integrantes do grupo, considerando os principais desafios de interação, reatividade e controle de estado da aplicação.

O debate foi guiado por critérios como:

- Preservação e restauração do estado do usuário;
- Reação automática a eventos do sistema;
- Estruturação de fluxos reutilizáveis para exibição de conteúdo teórico.

Esse processo colaborativo garantiu que a escolha dos padrões fosse fundamentada, crítica e aderente ao domínio do projeto.

## Problema

A aplicação BrinCalango envolvia múltiplos comportamentos associados à experiência de aprendizagem do usuário: progresso salvo, eventos reativos e variações na apresentação de conteúdo.

Diante disso, surgiram questionamentos como:

- Como salvar e restaurar o progresso do usuário sem comprometer o encapsulamento?
- Como notificar automaticamente componentes quando ações do usuário forem realizadas?
- Como garantir uma sequência lógica e padronizada para diferentes trilhas teóricas com variações específicas?

A equipe precisava de soluções comportamentais que fossem coesas, desacopladas e compatíveis com os princípios de reusabilidade e escalabilidade.

## Solução

Após debate e alinhamento conceitual, a equipe decidiu pela adoção de três padrões comportamentais do catálogo GoF, por atenderem diretamente aos requisitos da aplicação:

- **Memento**: Para capturar e restaurar o estado do progresso do usuário de forma segura e encapsulada;
- **Observer**: Para acionar atualizações automáticas (como a ofensiva) quando o usuário realiza ações;
- **Template Method**: Para definir um fluxo fixo de exibição de conteúdo nas trilhas teóricas, permitindo personalizações.

A adoção desses padrões se mostrou coerente com os objetivos pedagógicos e técnicos da aplicação, e foi validada com modelagem, implementação e testes práticos conduzidos pela equipe.

## Modelagem do Factory Method 

Na Figura 2, encontra-se a modelagem para o Factory Method 

<div align="center">

<p><strong>Figura 2 – Modelagem do Factory Method  </strong></p>

![Diagrama do Factory Method](../assets/factoryMethod.png)

<p><em>Autor: <a href="https://github.com/julia-fortunato" target="_blank">Júlia Fortunato</a>, <a href="https://github.com/luanasoares0901" target="_blank">Luana</a> e <a href="https://github.com/ailujana" target="_blank">Ana Julia</a>, 2025</em></p>

</div>

A seguir, descrevemos as classes envolvidas e sua função no padrão.

### Classe Abstrata `Questao`

Representa o **produto abstrato**.

```plaintext
Atributos:
- idQuestao: int
- tema: string
- nivelDificuldade: int
- tipo: string
- dica: string
- pontuacao: int

Métodos:
+ executarQuestao(): void
+ validarResposta(respostaUsuario): boolean
+ proxQuestao(): Questao
+ mostrarDica(): string
+ exibirExplicacao(): string
```

---

#### Subclasses de `Questao` (Produtos Concretos)

##### `MultiplaEscolha`
- alternativaCorreta: string
- alternativas: list<string>
-  + exibirQuestaoMultiplaEscolha(idQuestao): void

##### `EscolhaMultipla`
- alternativasCorretas: list<string>
- alternativas: list<string>
-  + exibirQuestaoEscolhaMultipla(idQuestao): void

##### `VerdadeiroOuFalso`
- resposta: boolean
-  + exibirQuestaoVouF(idQuestao): void

##### `Lacuna`
- alternativaCorreta: string
- opcoesLacunas: list<string>
-  + exibirQuestaoLacuna(idQuestao): void

---

#### Criador Abstrato `QuestaoCreator`

Define o método de fábrica:

```plaintext
+ criarQuestao(): Questao
```

---

#### Criadores Concretos

Implementam o método de fábrica instanciando as subclasses de `Questao`.

##### `CriadorQuestaoMultiplaEscolha`
```plaintext
+ criarQuestao(): MultiplaEscolha
```

##### `CriadorQuestaoEscolhaMultipla`
```plaintext
+ criarQuestao(): EscolhaMultipla
```

##### `CriadorQuestaoVouF`
```plaintext
+ criarQuestao(): VerdadeiroOuFalso
```

##### `CriadorQuestaoLacuna`
```plaintext
+ criarQuestao(): Lacuna
```

---

## Frame interativo da modelagem do Factory Method

<div style="width: 640px; height: 480px; margin: 10px; position: relative;"><iframe allowfullscreen frameborder="0" style="width:640px; height:480px" src="https://lucid.app/documents/embedded/3d29c102-1433-45c0-8e62-4555223031e1" id="9e2iZ.B9riZr"></iframe></div>

## Implementação do Factory Method

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

## (i)Autores:
- Ana Júlia Mendes Santos  
- Ana Catarina
- Julia Rocha Fortunato
- Luana Ribeiro Soares
- Victor Hugo

**Observação**: rastro dos commits está no histórico de versões no fim da página.

##  (ii) Justificativas & senso crítico

- O padrão Factory Method foi escolhido por promover flexibilidade na criação de diferentes tipos de questões sem exigir mudanças no código cliente. Isso segue o princípio Open/Closed (aberto para extensão, fechado para modificação).

- A separação entre a lógica de criação (Creator) e a utilização dos objetos (Questao) melhora a organização e manutenibilidade do sistema.

- Permite que novos tipos de questões sejam adicionados com baixo impacto no restante da aplicação — basta implementar uma nova subclasse de Questao e um novo Creator.

- Reduz o acoplamento com classes concretas, facilitando a testabilidade e reutilização dos componentes do sistema.

- A aplicação prática evidenciou que o padrão é especialmente útil em sistemas que precisam lidar com variações do mesmo tipo de objeto (como questões de diferentes formatos), tornando-o adequado ao escopo educacional proposto.

Crítica construtiva:

- Embora o padrão traga muitos benefícios, ele também aumenta a complexidade estrutural, o que pode ser desnecessário em sistemas pequenos ou com poucas variações.

- Foi necessário certo esforço para entender claramente a separação entre criadores e produtos no início da implementação, demandando pesquisa e discussão em grupo para alinhamento conceitual.


##  (iii) Comentários sobre o trabalho em equipe

- O trabalho foi dividido de forma colaborativa;
- As decisões sobre uso do padrão foram debatidas em reuniões curtas, promovendo aprendizado mútuo e engajamento;
- A equipe se reuniu para elaborar a modelagem durante reuniões.




## Bibliografia 

> [1] REFRACTORING.GURU. Factory Metho. [S. l.], [s. d.]. Disponível em: https://refactoring.guru/design-patterns/factory-method. Acesso em: 25 maio. 2025.

> [2] Gamma, Erich, et al. *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley, 1994. Acesso em: 20 de maio. 2025.

> [3] Larman, Craig. *Utilizando UML e Padrões*. Bookman, 3ª ed., 2007. Acesso em: 20 de maio. 2025.

> [4]https://www.geeksforgeeks.org/factory-method-design-pattern-in-java/ Acesso em: 20 de maio. 2025.

 

## Histórico de Versões
| Versão | Data | Descrição | Autor(es) | Revisor(es) | Descrição da Revisão | Commits |
| ------ | ---- | --------- | --------- | ----------- | -------------------- | ------- |
| 1.0 | 25/05/2025 | Estruturação e Inclusão da implementação | [Ana Catarina](https://github.com/an4catarina) e [Victor Hugo](http://github.com/ViictorHugoo) | | | |
| 1.1 | 30/05/2025 | Documentação da modelagem| [Ana Julia](https://github.com/ailujana), [Julia Fortunato](http://github.com/julia-fortunato) e [Luana Ribeiro](https://github.com/luanasoares0901) | | | |
| 1.2 | 31/05/2025 | Correções na documentação|[Luana Ribeiro](https://github.com/luanasoares0901) | | | |
| 1.3 | 02/06/2025 | Ajustes na padronização da documentação | [Ana Júlia](https://github.com/ailujana), [Júlia Fortunato](http://github.com/julia-fortunato) | | | [Commit1-3](https://github.com/UnBArqDsw2025-1-Turma02/2025.1-T02-_G1_BrinCalango_Entrega_03/commit/da8b635e375ee95c23e7c3cd72bab2736573c651) |
