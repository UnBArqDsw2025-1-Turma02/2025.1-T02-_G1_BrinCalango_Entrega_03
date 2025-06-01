# Template Method no BrinCalango


## Definição

Template Method é um padrão comportamental que define o esqueleto de um algoritmo em uma superclasse, permitindo que as subclasses sobrescrevam etapas específicas do algoritmo sem modificar sua estrutura geral.


## Aplicação no Projeto BrinCalango

### Contexto

O BrinCalango é uma aplicação voltada para o ensino de programação por meio de trilhas teóricas e práticas. Cada trilha teórica possui uma sequência de ações para exibição do conteúdo, mas o formato dessas trilhas pode variar conforme o público-alvo (por exemplo, uma versão inclusiva com recursos de acessibilidade).


### Problema

As trilhas de aprendizado compartilhavam a mesma sequência lógica: carregar conteúdo, exibir título, corpo, mídias, configurações específicas e eventualmente um resumo interativo. Contudo, a implementação dessas etapas variava entre diferentes tipos de trilhas (padrão e inclusiva), gerando duplicação de código e dificuldade de manutenção.


### Solução com Template Method

Foi implementado o padrão Template Method para encapsular o fluxo geral em uma classe abstrata ``TrilhaTeoria``, delegando às subclasses (``TrilhaTeoriaPadrao`` e ``TrilhaTeoriaInclusiva``) a responsabilidade de fornecer implementações específicas das etapas. Dessa forma, o algoritmo principal se manteve estável, e as variações foram isoladas nas subclasses.


## Estrutura da Implementação

- A classe abstrata TrilhaTeoria define os métodos protegidos que representam os passos do algoritmo (carregarTeoria, exibirTitulo, exibirConteudo, etc.).
- A sequência dessas etapas é definida em um método template (não mostrado na imagem, mas subentendido).
- As subclasses (TrilhaTeoriaPadrao e TrilhaTeoriaInclusiva) sobrescrevem esses métodos para customizar o comportamento conforme necessário.

## Modelagem

<div align="center">

![Diagrama do Template Method](../assets/TemplateMethod.png)

</div>

<p align="center"><em></em></p>

### Diagrama no Lucidchart

[Acesse o diagrama interativo no Lucidchart](link)

#### Frame interativo da modelagem do Prototype

<div style="width: 1000px; height: 500px; margin: 10px; position: relative;"><iframe allowfullscreen frameborder="0" style="width:1000px; height:500px" src="link" id="YEkiwTVEnZWG"></iframe></div>

## Implementação do Template Method

## Vantagens obtidas

1. Redução de duplicação de código entre tipos de trilha.
2. Facilidade de manutenção e extensão.
3. Separação clara entre a estrutura do algoritmo e as variações específicas.
4. Melhoria na legibilidade do código e adesão a boas práticas de design orientado a objetos.

## (i) Autores:
Modelagem: 
- Ana Júlia
- André

Implementação:
- Ana Catarina dos Santos
- Victor Hugo Rodrigues Guimarães
- Julia Takaki


## (ii) Justificativas & senso crítico

- O Template Method foi escolhido pois havia um fluxo comum entre diferentes trilhas teóricas, mas com detalhes de implementação distintos. Assim, foi possível isolar essas diferenças mantendo a lógica central unificada.
- A implementação respeita o princípio do Open/Closed, permitindo extensões sem alterações na superclasse. O uso de herança foi pontual e focado em variações comportamentais, o que se alinha ao design orientado a objetos.

## (iii) Comentários sobre o trabalho em equipe

- O desenvolvimento foi colaborativo e bem dividido. A equipe de modelagem definiu claramente as abstrações, facilitando a implementação. O trabalho foi realizado de forma incremental, com revisões cruzadas que garantiram a consistência do artefato.


## Referências

> [1] Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*.

> [2] Refactoring.Guru. [Template Method](https://refactoring.guru/design-patterns/template-method).

> [3] Arquitetura de Software – Profa. Milene – UnB (2025).

## Histórico de Versões

| Versão | Data | Descrição | Autor(es) | Revisor(es) | Descrição da Revisão | Commits |
| ------ | ---- | --------- | --------- | ----------- | -------------------- | ------- |
| 1.0 | 01/06/2025 | Estruturação e Inclusão da implementação | [Ana Catarina](https://github.com/an4catarina) e [Victor Hugo](http://github.com/ViictorHugoo) | [Julia Takaki](http://github.com/juliatakaki)| | |