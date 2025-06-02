# Builder 

O Builder é um padrão de projeto do qual o principal objetivo é **separar** a criação de um objeto complexo para que possamos criar diferentes representações dele. 

Dessa forma, o Builder cria objetos pela contrução *step-by-step*, de forma a construí-lo com a execução de vários passos [2].

Esse padrão pode ser observado em restaurantes de fast-food para a preparação de lanches infantis, por exemplo. Um lanche infantil é composto, geralmente, por um item principal, um acompanhamento, uma bebida e um brinde. Essa composição pode possuir diversas variações em cada um dos itens para a montagem de diferentes tipos de lanches diferentes.

Seguindo essa ideia, pensou-se na aplicação de um Builder na classe responsável pela configuração de acessibilidade do BrinCalango. Essa ideia partiu do princípio de que o BrinCalango tem como objetivo fornecer uma interface amigável para diversos grupos diferentes de crianças e, por isso, possui diferentes funções de acessibilidade para poder trazer maior inclusão. Sabemos também que diferentes grupos exigem diferentes perfis de acessibilidade, no qual uma função de acessibilidade não precisa estar ativada para um determinado grupo "A", enquanto é de suma importância para um grupo "B".

Dessa forma, a adoção do padrão Builder no BrinCalango mostrou-se útil por permitir a criação flexível de diferentes configurações de acessibilidade, atendendo às necessidades específicas de cada grupo de crianças sem a necessidade de criar inúmeras subclasses ou interfaces complexas. Isso simplifica o processo de configuração e manutenção, garantindo uma experiência mais inclusiva e personalizada para os usuários do sistema.

## Metodologia

Durante o desenvolvimento deste trabalho, a equipe realizou uma reunião para discutir onde o padrão Builder poderia ser aplicado de forma mais estratégica dentro da arquitetura da aplicação BrinCalango.

Inicialmente, considerou-se aplicar o padrão na construção da entidade `Usuario`, devido à quantidade de atributos e à necessidade de criar objetos com perfis variados.

No entanto, durante a modelagem prática, a equipe percebeu que a classe `Usuario` não apresentava tanta variação no processo de construção. Por outro lado, a classe `ConfigAcessibilidade` revelou-se como uma excelente candidata ao padrão, pois representa **objetos complexos e altamente configuráveis**, voltados à personalização da experiência de usuários com diferentes perfis de acessibilidade.

Com isso, a decisão final foi de **aplicar o padrão Builder na criação de objetos `ConfigAcessibilidade`**, permitindo configurar elementos como contraste, tamanho da fonte, leitor de telas e animações, de maneira flexível, escalável e organizada.

Essa escolha demonstrou aderência aos princípios do padrão e alinhamento com o propósito inclusivo da aplicação.

## Esquema ilustrativo do Builder de Configuração de Acessibilidade

Com o objetivo de facilitar a compreensão do padrão de projeto **Builder** na aplicação BrinCalango, foi desenvolvido um esquema ilustrativo, presente na Figura 1, que representa a interação entre três componentes principais: o **Cliente**, o **Director** e o **Builder**.

O processo se inicia com o Cliente solicitando a alteração das configurações de acessibilidade. Essa solicitação é repassada ao Director, que tem a função de orquestrar a construção do objeto final – neste caso, um conjunto de configurações personalizadas para acessibilidade. O Director conhece os passos necessários para montar esse objeto, mas não precisa conhecer os detalhes de implementação de cada etapa. Ele apenas coordena a execução dos métodos do Builder.

O Builder é o componente responsável por realizar as etapas de construção de fato. Cada "build" representado no esquema corresponde a uma configuração específica de acessibilidade que está sendo definida. Os ícones no lado direito ajudam a representar visualmente essas configurações:

- O primeiro ícone, com um círculo dividido entre branco e preto, representa a ativação do **modo de alto contraste**, ideal para usuários com baixa visão.
- O segundo ícone, com duas letras "A" de tamanhos diferentes, simboliza o **aumento do tamanho da fonte**, para facilitar a leitura do conteúdo textual.
- O terceiro ícone, com um alto-falante, indica a ativação de um **leitor de telas**, essencial para usuários com deficiência visual.
- O quarto ícone, com um botão de play/pause, está relacionado à **configuração de animações**, permitindo que o sistema desative ou pause elementos animados, o que é útil para pessoas com deficiências fotossensível ou com dificuldades cognitivas.

Ao final desse processo, o Cliente pode acessar ou recuperar a configuração personalizada construída. O esquema evidencia como o padrão Builder permite a criação de objetos complexos de forma estruturada, oferecendo flexibilidade na montagem e facilitando a adaptação às necessidades específicas de cada usuário.


<p align="center"><strong>Figura 1 – Fluxograma ilustrativo do padrão Builder aplicado à configuração de acessibilidade</strong></p>

<div align="center">

![Diagrama do Builder](../assets/builderr.jpg)

</div>

<p align="center"><em>Autor: <a href="https://github.com/julia-fortunato" target="_blank">Júlia Fortunato</a>, <a href="https://github.com/andre-maia51" target="_blank">André Cláudio</a>, 2025</em></p>



## Modelagem do Builder de Configuração de Acessibilidade

#### Imagem

Na Figura 2, encontra-se a modelagem para o Builder de Configuração de Acessibilidade.

<p align="center"><strong>Figura 2 – Modelagem do Builder de Configuração de Acessibilidade </strong></p>

![Diagrama do builder](../assets/Builder-BrinCalango.svg)

<p align="center"><em>Autor: <a href="https://github.com/julia-fortunato" target="_blank">Júlia Fortunato</a>, <a href="https://github.com/andre-maia51" target="_blank">André Cláudio</a>, 2025</em></p>

#### Frame interativo da modelagem do Builder
<div style="width: 1000px; height: 500px; margin: 10px; position: relative;"><iframe allowfullscreen frameborder="0" style="width:1000px; height:500px" src="https://lucid.app/documents/embedded/2d83e371-90ce-4f3d-af08-fe71bfb54e1b" id="YEkiwTVEnZWG"></iframe></div>

## Implementação do Builder

```JAVA
abstract class ConfiguracaoAcessibilidade {

    protected boolean contraste;
    protected int tamanhoFonte;
    protected int leitorDeTelas; // 0=desligado, 1=básico, 2=completo
    protected boolean animacoes;

    public ConfiguracaoAcessibilidade() {
        System.out.println("-> Criando uma nova configuração de acessibilidade (Produto Base).");
    }

    public boolean isContraste() { return contraste; }
    public int getTamanhoFonte() { return tamanhoFonte; }
    public int getLeitorDeTelas() { return leitorDeTelas; }
    public boolean hasAnimacoes() { return animacoes; }

    public abstract void displayConfig();
}

// Produto Concreto 1
class ConfiguracaoAcessibilidade1 extends ConfiguracaoAcessibilidade {
    public ConfiguracaoAcessibilidade1() {
        super();
        System.out.println("   -> Instanciando Produto Concreto: ConfiguracaoAcessibilidade1.");
    }

    @Override
    public void displayConfig() {
        System.out.println("\n--- Configuração de Acessibilidade Perfil 1 ---");
        System.out.println("   Contraste Ativado: " + contraste);
        System.out.println("   Tamanho da Fonte: " + tamanhoFonte);
        System.out.println("   Leitor de Telas: " + (leitorDeTelas == 0 ? "Desligado" : (leitorDeTelas == 1 ? "Básico" : "Completo")));
        System.out.println("   Animações Ativadas: " + animacoes);
        System.out.println("----------------------------------------------");
    }
}

// Produto Concreto 2
class ConfiguracaoAcessibilidade2 extends ConfiguracaoAcessibilidade {
    public ConfiguracaoAcessibilidade2() {
        super();
        System.out.println("   -> Instanciando Produto Concreto: ConfiguracaoAcessibilidade2.");
    }

    @Override
    public void displayConfig() {
        System.out.println("\n--- Configuração de Acessibilidade Perfil 2 ---");
        System.out.println("   Contraste Ativado: " + contraste);
        System.out.println("   Tamanho da Fonte: " + tamanhoFonte);
        System.out.println("   Leitor de Telas: " + (leitorDeTelas == 0 ? "Desligado" : (leitorDeTelas == 1 ? "Básico" : "Completo")));
        System.out.println("   Animações Ativadas: " + animacoes);
        System.out.println("----------------------------------------------");
    }
}

// Interface Builder
interface Builder {
    void reset();
    void buildContraste(boolean contraste); 
    void buildTamanhoFonte(int tamanhoFonte); 
    void buildLeitorDeTelas(int leitorDeTelas); 
    void buildAnimacoes(boolean animacoes);

    ConfiguracaoAcessibilidade getResult();
}

// Builder Concreto 1
class PerfilAcessibilidade1 implements Builder {

    private ConfiguracaoAcessibilidade1 produto;

    public PerfilAcessibilidade1() {
        this.reset(); 
    }

    @Override
    public void reset() {
        System.out.println("  -> PerfilAcessibilidade1: Reiniciando processo de construção para Perfil 1.");
        this.produto = new ConfiguracaoAcessibilidade1();
    }

    @Override
    public void buildContraste(boolean contraste) {
        System.out.println("  -> PerfilAcessibilidade1: Definindo contraste para " + contraste + ".");
        this.produto.contraste = contraste; 

    @Override
    public void buildTamanhoFonte(int tamanhoFonte) {
        System.out.println("  -> PerfilAcessibilidade1: Definindo tamanho da fonte para " + tamanhoFonte + ".");
        this.produto.tamanhoFonte = tamanhoFonte; 
    }

    @Override
    public void buildLeitorDeTelas(int leitorDeTelas) {
        System.out.println("  -> PerfilAcessibilidade1: Definindo leitor de telas para " + leitorDeTelas + ".");
        this.produto.leitorDeTelas = leitorDeTelas;
    }

    @Override
    public void buildAnimacoes(boolean animacoes) {
        System.out.println("  -> PerfilAcessibilidade1: Definindo animações para " + animacoes + ".");
        this.produto.animacoes = animacoes;
    }

    // Retorna o produto construído [cite: 1]
    @Override
    public ConfiguracaoAcessibilidade getResult() {
        System.out.println("  -> PerfilAcessibilidade1: Retornando o produto ConfiguracaoAcessibilidade1 finalizado.");
        ConfiguracaoAcessibilidade1 finalProduct = this.produto;
        return finalProduct;
    }
}

// Builder Concreto 2
class PerfilAcessibilidade2 implements Builder {

    private ConfiguracaoAcessibilidade2 produto;

    public PerfilAcessibilidade2() {
        this.reset();
    }

    @Override
    public void reset() {
        System.out.println("  -> PerfilAcessibilidade2: Reiniciando processo de construção para Perfil 2.");
        this.produto = new ConfiguracaoAcessibilidade2();
    }

    @Override
    public void buildContraste(boolean contraste) {
        System.out.println("  -> PerfilAcessibilidade2: Definindo contraste para " + contraste + ".");
        this.produto.contraste = contraste; 
    }

    @Override
    public void buildTamanhoFonte(int tamanhoFonte) {
        System.out.println("  -> PerfilAcessibilidade2: Definindo tamanho da fonte para " + tamanhoFonte + ".");
        this.produto.tamanhoFonte = tamanhoFonte; 
    }

    @Override
    public void buildLeitorDeTelas(int leitorDeTelas) {
        System.out.println("  -> PerfilAcessibilidade2: Definindo leitor de telas para " + leitorDeTelas + ".");
        this.produto.leitorDeTelas = leitorDeTelas; 
    }

    @Override
    public void buildAnimacoes(boolean animacoes) {
        System.out.println("  -> PerfilAcessibilidade2: Definindo animações para " + animacoes + ".");
        this.produto.animacoes = animacoes; 


    @Override
    public ConfiguracaoAcessibilidade getResult() {
        System.out.println("  -> PerfilAcessibilidade2: Retornando o produto ConfiguracaoAcessibilidade2 finalizado.");
        ConfiguracaoAcessibilidade2 finalProduct = this.produto;
        return finalProduct;
    }
}

// Diretor
class ConfigAcessibilidadeDirector {

    private Builder builder;

    public void setBuilder(Builder builder) {
        this.builder = builder;
        System.out.println("Director: Builder configurado.");
    }

    public void construirPerfilPadrao() {
        System.out.println("\nDirector: Iniciando construção do Perfil Padrão.");
        builder.reset();
        builder.buildContraste(true);
        builder.buildTamanhoFonte(18);
        builder.buildLeitorDeTelas(1); 
        builder.buildAnimacoes(false);
        System.out.println("Director: Perfil Padrão concluído.");
    }

    public void construirPerfilMinimalista() {
        System.out.println("\nDirector: Iniciando construção do Perfil Minimalista.");
        builder.reset(); 
        builder.buildContraste(false);
        builder.buildTamanhoFonte(12); 
        builder.buildLeitorDeTelas(0); 
        builder.buildAnimacoes(true); 
        System.out.println("Director: Perfil Minimalista concluído.");
    }
}

// Cliente
public class Cliente {
    public static void main(String[] args) {
        System.out.println("Cliente: Iniciando demonstração do padrão Builder para Acessibilidade.");

        System.out.println("\nCliente: Criando PerfilAcessibilidade1.");
        Builder builder1 = new PerfilAcessibilidade1(); 

        System.out.println("\nCliente: Criando PerfilAcessibilidade2.");
        Builder builder2 = new PerfilAcessibilidade2(); 

        System.out.println("\nCliente: Criando o Director.");
        ConfigAcessibilidadeDirector director = new ConfigAcessibilidadeDirector();

        // Primeiro cenario
        System.out.println("\n--- Cenário 1: Construindo Perfil Padrão com PerfilAcessibilidade1 ---");
        director.setBuilder(builder1); 
        director.construirPerfilPadrao();
        ConfiguracaoAcessibilidade perfilPadrao1 = builder1.getResult();
        perfilPadrao1.displayConfig();

        // Segundo cenario
        System.out.println("\n--- Cenário 2: Construindo Perfil Minimalista com PerfilAcessibilidade2 ---");
        director.setBuilder(builder2); 
        director.construirPerfilMinimalista(); 
        ConfiguracaoAcessibilidade perfilMinimalista2 = builder2.getResult(); 
        perfilMinimalista2.displayConfig();

        // Terceiro cenario
        System.out.println("\n--- Cenário 3: Construindo Perfil Padrão com PerfilAcessibilidade2 ---");
        director.setBuilder(builder2);
        director.construirPerfilPadrao();
        ConfiguracaoAcessibilidade perfilPadrao2 = builder2.getResult();
        perfilPadrao2.displayConfig();

    }
}
```

## (i)Autores:
- André Cláudio   
- Diogo Barboza
- Júlia Rocha Fortunato

**Observação**: rastro dos commits está no histórico de versões no fim da página.

##  (ii) Justificativas & senso crítico

- O padrão Builder foi escolhido por promover flexibilidade na construção de objetos complexos, permitindo que diferentes combinações de atributos sejam definidas passo a passo, sem a necessidade de múltiplos construtores sobrecarregados. 

- Isso é especialmente valioso no BrinCalango, que possui foco em acessibilidade, pois diferentes usuários podem ter necessidades específicas — por exemplo, alguns podem precisar de contraste elevado, outros de fontes ampliadas, e alguns podem desejar desabilitar animações.

- A adoção do Builder também contribui para a manutenibilidade do código, uma vez que facilita a criação de novos perfis de acessibilidade sem alterar a estrutura da classe ConfigAcessibilidade. Assim, é possível expandir ou modificar comportamentos sem comprometer as configurações existentes.


Crítica construtiva:

- Mas, é possível perceber, que o uso do Builder pode aumentar a complexidade do código. A criação de uma classe Builder separada adiciona mais arquivos e estruturas ao sistema, o que pode dificultar a leitura para desenvolvedores iniciantes ou em equipes com pouca familiaridade com padrões de projeto. Além disso, se as configurações forem muito simples ou raramente alteradas, o uso do Builder pode ser considerado um exagero — o que contraria o princípio da simplicidade.


##  (iii) Comentários sobre o trabalho em equipe

- O trabalho foi dividido de forma colaborativa;
- A modelagem foi feita de forma conjunta entre Júlia e André, no qual foi possível ter várias discussões que contribuíram para a melhoria da construção do Builder;
- Foi possível promover o engajamento entre a modelagem e a implementação, com comunicação feitas por mensagem e por ligações no Discord.

## Referências Bibliográficas

> [1] REFRACTORING.GURU. Builder. [S. l.], [s. d.]. Disponível em: https://refactoring.guru/design-patterns/builder. Acesso em: 23 maio. 2025.

## Bibliografia 

> [1] SOURCEMAKING. Builder. [S. l.], [s. d.]. Disponível em: https://sourcemaking.com/design_patterns/builder. Acesso em: 23 maio. 2025.

## Histórico de Versões
| Versão | Data       | Descrição                                    | Autor(es)                                                                                              | Revisor(es)                                      | Descrição da Revisão                                                                                  | Commits |
| :----: | ---------- | -------------------------------------------- | -------------------------------------------------------------------------------------------------------- | ------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | -------- |
| 1.0    | 23/05/2025 | Criação e Documentação do Builder | [Andre Cláudio](https://github.com/andre-maia51), [Júlia Fortunato](https://github.com/julia-fortunato) | - | - | [Commit1-0](https://github.com/UnBArqDsw2025-1-Turma02/2025.1-T02-_G1_BrinCalango_Entrega_03/commit/640be50b4d53000609c93e142ce41ec11d218840) |
| 1.1    | 29/05/2025 | Criação da implementação do Builder | [Diogo Barboza](https://github.com/Diogo-Barboza) | - | - | [Commit1-1](https://github.com/UnBArqDsw2025-1-Turma02/2025.1-T02-_G1_BrinCalango_Entrega_03/commit/91917dcaac6b3ce3989754812d91acb1b29f6321) |
| 1.2 | 02/06/2025 | Ajustes na padronização da documentação | [Ana Júlia](https://github.com/ailujana), [Júlia Fortunato](http://github.com/julia-fortunato) | | | [Commit1-2](https://github.com/UnBArqDsw2025-1-Turma02/2025.1-T02-_G1_BrinCalango_Entrega_03/commit/da8b635e375ee95c23e7c3cd72bab2736573c651) |

