# 3.2.- GoFs Estruturais

## Proxy 

### Introdução

O padrão de projeto Proxy pertence ao grupo dos padrões estruturais e tem como principal propósito fornecer um substituto ou representante para outro objeto. Ele atua como um intermediário, controlando o acesso ao objeto real, o que permite executar funcionalidades adicionais — como validações, cache ou controle de acesso — sem modificar diretamente o objeto original [1].

O Proxy é particularmente útil em situações onde o objeto real é custoso para ser instanciado (por exemplo, quando exige acesso a recursos externos, como banco de dados ou arquivos), ou quando queremos garantir que certas condições sejam verificadas antes da interação com esse objeto.

De modo prático, o Proxy implementa a mesma interface do objeto real, sendo capaz de ser utilizado no lugar dele de forma transparente. O cliente interage com o Proxy como se estivesse interagindo com o objeto original, sem saber que há uma camada adicional de controle intermediando essa comunicação.

Esse padrão é amplamente utilizado em contextos como:
- Controle de acesso (Protection Proxy);
- Inicialização sob demanda (Virtual Proxy);
- Registro de chamadas (Logging Proxy);
- Cache de resultados (Caching Proxy);
- Representação local de objetos remotos (Remote Proxy).

## Metodologia

Durante uma **discussão interna entre alguns membros do grupo no WhatsApp**, surgiu a ideia de aplicar o padrão **Proxy** na arquitetura da aplicação BrinCalango.

A proposta foi debatida com foco em cenários nos quais seria necessário **restringir ou controlar o acesso** a determinados conteúdos educacionais, como teorias e questões. A escolha foi motivada pela necessidade de garantir que os usuários **interajam apenas com conteúdos apropriados** ao seu progresso no sistema, sem que fosse necessário modificar diretamente as classes originais.

Após análise dos benefícios do padrão, decidiu-se que o Proxy seria uma **solução eficiente e elegante**, promovendo o **princípio da responsabilidade única**, mantendo as classes originais focadas na lógica de negócio e delegando o controle de acesso a uma camada intermediária.


### Exemplo de aplicação no BrinCalango

No sistema BrinCalango, o padrão Proxy foi utilizado para controlar o acesso a conteúdos educacionais, como teorias e questões. A proposta surgiu da necessidade de garantir que os usuários interajam apenas com conteúdos apropriados ao seu progresso e faixa etária, sem que seja necessário modificar diretamente as classes originais de conteúdo.

A aplicação do padrão foi dividida em dois Proxys principais:

- TeoriaProxy: verifica se o usuário já alcançou o capítulo correspondente à teoria desejada;
- QuestaoProxy: garante que o usuário já está apto a resolver uma questão específica, com base no seu progresso anterior.

Ambos os Proxys consultam uma instância da classe Progresso, que mantém informações sobre o estágio atual do usuário. Essa abordagem reforça a ideia de separação de responsabilidades e facilita a manutenção e evolução do sistema.

Ilustração da arquitetura Proxy no BrinCalango
A Figura 1 apresenta um esquema visual da interação entre os componentes do padrão Proxy no BrinCalango. A sequência de interação começa com o usuário tentando acessar um conteúdo. A solicitação é interceptada por um Proxy, que valida o progresso do usuário antes de delegar a solicitação ao objeto real (Teoria ou Questão).

<p align="center"><strong>Figura 1 – Modelagem do Proxy</strong></p> <div align="center">

![modelagem proxy](../assets/Proxy.png)

</div> <p align="center"><em>Autor: <a href="https://github.com/juliatakaki" target="_blank">Júlia Takaki</a> e <a href="https://github.com/Oleari19" target="_blank">Maria Clara</a>, 2025</em></p>


### Implementação
```
interface Conteudo {
    void acessar(Usuario usuario);
}

class Teoria implements Conteudo {
    private float capitulo;
    private String conteudo;

    public Teoria(float capitulo, String conteudo) {
        this.capitulo = capitulo;
        this.conteudo = conteudo;
        System.out.println("-> Criando Teoria do capítulo " + capitulo);
    }

    @Override
    public void acessar(Usuario usuario) {
        System.out.println("Usuário " + usuario.getId() + " acessou Teoria do capítulo " + capitulo);
        System.out.println("Conteúdo: " + conteudo);
    }
}

class TeoriaProxy implements Conteudo {
    private float capitulo;
    private String conteudo;
    private Teoria teoria;

    public TeoriaProxy(float capitulo, String conteudo) {
        this.capitulo = capitulo;
        this.conteudo = conteudo;
        System.out.println("-> Criando TeoriaProxy para capítulo " + capitulo);
    }

    @Override
    public void acessar(Usuario usuario) {
        System.out.println("\nVerificando acesso à Teoria do capítulo " + capitulo);

        if (usuario.getProgresso().getCapituloAtual() >= (capitulo - 0.1)) {
            if (teoria == null) {
                teoria = new Teoria(capitulo, conteudo);
            }
            teoria.acessar(usuario);
        } else {
            System.out.println("Acesso negado. Usuário está no capítulo " + usuario.getProgresso().getCapituloAtual());
        }
    }
}

class Questao implements Conteudo {
    private int id;
    private float capitulo;
    private String corpo;

    public Questao(int id, float capitulo, String corpo) {
        this.id = id;
        this.capitulo = capitulo;
        this.corpo = corpo;
        System.out.println("-> Criando Questão " + id + " para capítulo " + capitulo);
    }

    @Override
    public void acessar(Usuario usuario) {
        System.out.println("Usuário " + usuario.getId() + " acessou Questão " + id + " do capítulo " + capitulo);
        System.out.println("Questão: " + corpo);
    }
}

class QuestaoProxy implements Conteudo {
    private int id;
    private float capitulo;
    private String corpo;
    private String numeroQuestao;
    private Questao questao;

    public QuestaoProxy(int id, float capitulo, String corpo, String numeroQuestao) {
        this.id = id;
        this.capitulo = capitulo;
        this.corpo = corpo;
        this.numeroQuestao = numeroQuestao;
        System.out.println("-> Criando QuestaoProxy para Questão " + id);
    }

    @Override
    public void acessar(Usuario usuario) {
        System.out.println("\nVerificando acesso à Questão " + id);

        float numeroQuestaoFloat = Float.parseFloat(numeroQuestao);
        if (usuario.getProgresso().getQuestaoAtual(capitulo) >= (numeroQuestaoFloat - 0.1)) {
            if (questao == null) {
                questao = new Questao(id, capitulo, corpo);
            }
            questao.acessar(usuario);
        } else {
            System.out.println("Acesso negado. Usuário está na questão " + usuario.getProgresso().getQuestaoAtual(capitulo));
        }
    }
}

class Progresso {
    private float capituloAtual;
    private float ultimaQuestaoRespondida;

    public Progresso(float capituloAtual, float ultimaQuestaoRespondida) {
        this.capituloAtual = capituloAtual;
        this.ultimaQuestaoRespondida = ultimaQuestaoRespondida;
    }

    public float getCapituloAtual() {
        return capituloAtual;
    }

    public float getQuestaoAtual(float capitulo) {
        if (capitulo == capituloAtual) {
            return ultimaQuestaoRespondida;
        } else if (capitulo < capituloAtual) {
            return 999;
        } else {
            return 0;
        }
    }
}

class Usuario {
    private int id;
    private Progresso progresso;

    public Usuario(int id, Progresso progresso) {
        this.id = id;
        this.progresso = progresso;
        System.out.println("-> Criado Usuário " + id);
    }

    public int getId() {
        return id;
    }

    public Progresso getProgresso() {
        return progresso;
    }
}

public class Cliente {
    public static void main(String[] args) {
        System.out.println("Início do Proxy Educacional");

        Usuario iniciante = new Usuario(1, new Progresso(1.0f, 1.0f));
        Usuario intermediario = new Usuario(2, new Progresso(2.0f, 2.0f));

        Conteudo teoria1 = new TeoriaProxy(1.0f, "Variáveis e Tipos de Dados");
        Conteudo teoria2 = new TeoriaProxy(2.0f, "Árvores e Grafos");

        Conteudo questao1 = new QuestaoProxy(1, 1.0f, "O que é uma variável?", "1.0");
        Conteudo questao2 = new QuestaoProxy(2, 2.0f, "Implemente busca em árvore binária.", "2.0");

        System.out.println("\n--- Cenário 1 ---");
        teoria1.acessar(iniciante);
        questao1.acessar(iniciante);

        System.out.println("\n--- Cenário 2 ---");
        teoria2.acessar(iniciante);
        questao2.acessar(iniciante);

        System.out.println("\n--- Cenário 3 ---");
        teoria2.acessar(intermediario);
        questao2.acessar(intermediario);
    }
}
```

## (i)Autores:
- Maria Clara Oleari  
- Júlia Takaki

**Observação**: rastro dos commits está no histórico de versões no fim da página.

## (ii) Justificativas & senso crítico

- O padrão Proxy foi escolhido por permitir o **controle de acesso a funcionalidades sensíveis** da aplicação, como a visualização de teorias ou questões, sem alterar diretamente as classes originais. Isso favorece o princípio da responsabilidade única e baixo acoplamento.

- A aplicação do Proxy tornou possível a criação de uma camada intermediária que **verifica condições de acesso** antes de permitir que o usuário visualize certos conteúdos. Essa separação promove maior **organização, reutilização e segurança lógica** dentro do sistema.

- O padrão também se mostrou útil para **fins pedagógicos**, ao permitir que funcionalidades sejam protegidas ou simuladas sem afetar a implementação original das classes-alvo.

Crítica construtiva:

- Embora o Proxy traga maior controle e organização, ele também pode **aumentar a complexidade** da arquitetura se aplicado de forma exagerada em componentes que não requerem esse tipo de proteção.

- No início, houve dificuldade para distinguir o Proxy de outros padrões similares, exigindo leituras e discussões para entender o seu papel exato dentro do sistema e como mantê-lo coeso com os objetivos da aplicação.

##  (iii) Comentários sobre o trabalho em equipe

- O trabalho foi dividido de forma colaborativa;
- As decisões sobre uso do padrão foram debatidas em reuniões curtas, promovendo aprendizado mútuo e engajamento;
- A equipe se reuniu para elaborar a modelagem durante reuniões no Discord.

## Referências Bibliográficas

> [1] REFRACTORING.GURU. Proxy. [S. l.], [s. d.]. Disponível em: https://refactoring.guru/design-patterns/proxy. Acesso em: 01 jun. 2025.

## Bibliografia 

> [1] SOURCEMAKING. Proxy. [S. l.], [s. d.]. Disponível em: https://sourcemaking.com/design_patterns/proxy. Acesso em: 01 jun. 2025.

## Histórico de Versões
| Versão | Data       | Descrição                                    | Autor(es)                                                                                              | Revisor(es)                                      | Descrição da Revisão                                                                                  | Commits |
| :----: | ---------- | -------------------------------------------- | -------------------------------------------------------------------------------------------------------- | ------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | -------- |
| 1.0    | 01/06/2025 | Criação e Documentação do Proxy | [Júlia Takaki](https://github.com/juliatakaki) e [Maria Clara](https://github.com/Oleari19)| [Victor Hugo](https://github.com/ViictorHugoo) | Reestruturação e mudança de textos | [Commit1-0](https://github.com/UnBArqDsw2025-1-Turma02/2025.1-T02-_G1_BrinCalango_Entrega_03/commit/c35b578d8c92e70d3772f47c6c39798c28ddfb90) |
| 1.1    | 01/06/2025 | Implementação do Proxy | [Júlia Takaki](https://github.com/juliatakaki), [Victor Hugo](https://github.com/ViictorHugoo) e [Ana Catarina](https://github.com/an4catarina) | - | - | [Commit1-1](https://github.com/UnBArqDsw2025-1-Turma02/2025.1-T02-_G1_BrinCalango_Entrega_03/commit/e0cc8c8fd9a965b41706dc45948dffded7690a0a) |
| 1.2 | 02/06/2025 | Ajustes na padronização da documentação | [Ana Júlia](https://github.com/ailujana), [Júlia Fortunato](http://github.com/julia-fortunato) | | | |
