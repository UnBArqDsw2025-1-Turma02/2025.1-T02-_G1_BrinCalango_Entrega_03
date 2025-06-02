# GoFs de Padrões Comportamentais

## Introdução aos Padrões GoF

Os padrões de projeto (Design Patterns) são soluções recorrentes e comprovadas para problemas comuns enfrentados durante o desenvolvimento de software orientado a objetos. Esse conceito foi amplamente consolidado pela obra seminal “Design Patterns: Elements of Reusable Object-Oriented Software” de Erich Gamma, Richard Helm, Ralph Johnson e John Vlissides, conhecidos como a Gang of Four (GoF) (Gamma et al., 1995).

Os padrões GoF são tradicionalmente categorizados em três grupos:

1. **Criacionais**: focados na criação de objetos.
2. **Estruturais**: organizam classes e objetos.
3. **Comportamentais**: concentram-se na comunicação entre objetos.


# Padrões GoF Criacionais

Os padrões criacionais são responsáveis por abstrair o processo de instanciação de objetos, promovendo a flexibilidade e a reutilização no design de software. Segundo Gamma et al. (1995), esses padrões “abstratizam o processo de instanciação. Eles ajudam a tornar um sistema independente de como seus objetos são criados, compostos e representados”.

## Importância dos padrões criacionais:

- Isolam a lógica de criação dos objetos.
- Promovem a reutilização de código.
- Aumentam a flexibilidade e desacoplamento.
- Facilitam a manutenção e extensão.

## Exemplos clássicos de padrões criacionais:

- Factory Method
- Abstract Factory
- Builder
- Prototype
- Singleton
- Multiton
- Object Pool

Este tópico irá explorar três padrões essenciais: **Builder**, **Factory Method** e **Prototype**.


## Padrão Builder

### Definição

O padrão **Builder** separa a construção de um objeto complexo de sua representação, permitindo que o mesmo processo de construção possa criar diferentes representações (Gamma et al., 1995).

Em outras palavras, o Builder permite criar objetos passo a passo, facilitando a construção de objetos complexos ou com múltiplos atributos opcionais.

### Estrutura

- **Builder**: especifica uma interface para criar partes do objeto.
- **ConcreteBuilder**: implementa a interface e monta a representação.
- **Director**: constrói o objeto utilizando a interface do Builder.
- **Product**: representa o objeto complexo que está sendo construído.

### Aplicabilidade

Ideal quando a criação de um objeto envolve múltiplas etapas ou diferentes representações.  
Exemplo: construção de refeições (hambúrguer, refrigerante, sobremesa) ou montagem de relatórios complexos.

### Benefícios

- Separa a lógica de construção da representação.
- Facilita a criação de objetos complexos.
- Promove a reutilização de código.

### Desvantagens

- Pode aumentar o número de classes.
- Complexidade adicional na implementação.


## Padrão Factory Method

### Definição

O padrão **Factory Method** define uma interface para criar um objeto, mas permite que as subclasses decidam qual classe concreta instanciar (Gamma et al., 1995).

Em suma, o Factory Method delega a responsabilidade de instanciar objetos para as subclasses, promovendo o princípio de **abertura/fechamento** (Open/Closed Principle).

### Estrutura

- **Product**: interface ou classe abstrata para os objetos criados.
- **ConcreteProduct**: implementações concretas do Product.
- **Creator**: declara o Factory Method, que retorna um objeto Product.
- **ConcreteCreator**: sobrescreve o Factory Method para retornar uma instância específica de ConcreteProduct.

### Aplicabilidade

Ideal quando:

- O código precisa ser independente das classes concretas que serão instanciadas.
- Quer-se delegar a criação para subclasses.

Exemplo clássico: criação de documentos (PDF, DOC, etc.), onde cada tipo de documento possui formas distintas de abertura e manipulação.

### Benefícios

- Desacopla a criação do uso do objeto.
- Facilita a introdução de novos tipos de objetos sem modificar o código existente.
- Favorece a reutilização e manutenibilidade.

### Desvantagens

- Pode aumentar o número de classes.
- Subclasses obrigatórias para cada tipo de produto.


## Padrão Prototype

### Definição

O padrão **Prototype** permite criar novos objetos a partir da cópia de objetos existentes, ou seja, através de **clonagem** (Gamma et al., 1995).

Em vez de criar novos objetos com `new`, o Prototype cria cópias, o que é útil quando a criação direta é custosa ou complexa.

### Estrutura

- **Prototype**: interface que declara um método de clonagem (geralmente `clone()`).
- **ConcretePrototype**: implementa o método de clonagem.
- **Client**: cria novos objetos solicitando cópias dos protótipos.

### Aplicabilidade

Ideal quando:

- A criação de um objeto é custosa.
- Muitos objetos compartilham configurações iniciais.
- A instânciação não pode depender de subclasses.

Exemplo clássico: cópia de figuras em um editor gráfico, onde o usuário cria múltiplas instâncias com pequenas variações.

### Benefícios

- Reduz o custo de criação de objetos.
- Evita a necessidade de subclasses para cada configuração.
- Preserva o encapsulamento.

### Desvantagens

- Exige cuidado com cópias profundas (deep copy) ou rasas (shallow copy).
- Pode ser difícil implementar clonagem correta em objetos complexos.


## Comparativo entre os padrões

| Padrão         | Principal uso                                 | Estrutura Chave                              |
| -------------- | --------------------------------------------- | -------------------------------------------- |
| Builder        | Construção complexa e passo a passo de objetos| Builder, ConcreteBuilder, Director, Product  |
| Factory Method | Delegar a instanciação para subclasses        | Creator, ConcreteCreator, Product            |
| Prototype      | Criar objetos por clonagem                    | Prototype, ConcretePrototype, Client         |


## Conclusão

Os padrões GoF criacionais são fundamentais para definir como e quando os objetos devem ser criados. Eles promovem a flexibilidade no design e evitam dependências rígidas entre classes.

- **Builder** é ideal para construir objetos complexos e configuráveis.
- **Factory Method** permite que subclasses decidam qual objeto será criado, promovendo extensibilidade.
- **Prototype** possibilita criar objetos através de clonagem, economizando recursos e tempo.

Compreender e aplicar corretamente esses padrões melhora a qualidade, manutenção e escalabilidade dos sistemas de software.


# Padrões GoF Estruturais

Os padrões estruturais são responsáveis por definir como as classes e objetos se compõem para formar estruturas maiores. Segundo Gamma et al. (1995), esses padrões “descrevem maneiras de compor classes e objetos para formar estruturas maiores e mais complexas, mantendo a flexibilidade e eficiência”.

## Importância dos padrões estruturais:

- Reduzem o acoplamento entre classes.
- Facilitam a reutilização e manutenção.
- Organizam melhor a arquitetura interna de sistemas orientados a objetos.

## Exemplos clássicos de padrões estruturais:

- Adapter
- Bridge
- Composite
- Decorator
- Facade
- Flyweight
- Proxy

Este tópico irá explorar dois padrões essenciais: **Facade** e **Proxy**.


## Padrão Facade

### Definição

O padrão **Facade** fornece uma interface unificada e simplificada para um conjunto de interfaces em um subsistema, tornando esse subsistema mais fácil de usar (Gamma et al., 1995).

Em outras palavras, ele cria uma "fachada" que centraliza e oculta a complexidade de diversas classes, expondo apenas uma interface de alto nível.

### Estrutura

- **Facade**: fornece uma interface simples para o cliente e delega as chamadas para os objetos do subsistema.
- **Subsystem Classes**: classes que realizam o trabalho efetivo, mas são acessadas de forma indireta pelo cliente através da fachada.
- **Client**: interage com a Facade em vez de lidar diretamente com várias classes do subsistema.

### Aplicabilidade

Ideal quando:

- Deseja-se fornecer uma interface única para um conjunto complexo de subsistemas.
- Há necessidade de reduzir o acoplamento entre o cliente e o subsistema.

Exemplo clássico: bibliotecas de sistemas complexos (como gráficos, bancos de dados, redes) podem expor uma única interface para os desenvolvedores, escondendo a complexidade interna.

### Benefícios

- Reduz a complexidade do sistema.
- Desacopla o cliente das classes do subsistema.
- Facilita a manutenção e evolução.

### Desvantagens

- Pode se tornar um "Deus Objeto" se não bem projetado.
- Pode ocultar funcionalidades importantes do subsistema.

## Padrão Proxy

### Definição

O padrão **Proxy** fornece um substituto ou representante de outro objeto para controlar o acesso a ele (Gamma et al., 1995).

Em outras palavras, o Proxy atua como um "intermediário" entre o cliente e o objeto real, adicionando funcionalidades como controle de acesso, cache, logging ou adiamento da inicialização (lazy loading).

### Estrutura

- **Subject**: interface comum para o RealSubject e o Proxy.
- **RealSubject**: objeto real que executa a lógica principal.
- **Proxy**: mantém uma referência ao RealSubject e controla o acesso a ele.

### Tipos comuns de Proxy:

- **Virtual Proxy**: adia a criação do objeto real até ser necessário.
- **Protection Proxy**: controla o acesso ao objeto com base em permissões.
- **Remote Proxy**: representa um objeto localizado em outro espaço de endereço ou rede.
- **Cache Proxy**: armazena resultados para evitar repetição de operações custosas.

### Aplicabilidade

Ideal quando:

- Deseja-se adicionar controles adicionais ao acesso de um objeto.
- É necessário adiar a criação ou carregar um objeto sob demanda.
- Sistemas distribuídos exigem a representação de objetos remotos.

Exemplo clássico: proxy de imagens em editores gráficos que só carrega a imagem real quando necessária.

### Benefícios

- Adiciona controle sobre o objeto real sem alterar sua estrutura.
- Melhora a eficiência através de cache ou carregamento sob demanda.
- Aumenta a segurança por meio de restrições de acesso.

### Desvantagens

- Pode introduzir complexidade adicional.
- Pode afetar o desempenho se não for bem implementado.


## Comparativo entre os padrões

| Padrão | Principal uso | Estrutura Chave                         |
| ------ | ------------- | -------------------------------------- |
| Facade | Fornecer uma interface simplificada para um subsistema | Facade, Subsystem Classes, Client |
| Proxy  | Controlar o acesso a um objeto real                    | Proxy, RealSubject, Subject       |


## Conclusão

Os padrões GoF estruturais são fundamentais para organizar e otimizar a estrutura interna de sistemas, promovendo maior clareza e eficiência.

- **Facade** é ideal para reduzir a complexidade e promover uma interface de alto nível.
- **Proxy** é recomendado quando é necessário controlar o acesso ou adicionar funcionalidades a um objeto.

Dominar esses padrões é essencial para construir sistemas mais robustos, modulares e de fácil manutenção.


# Padrões GoF Comportamentais

Os **padrões comportamentais** são responsáveis por definir maneiras eficientes de comunicação entre objetos e algoritmos, focando na interação e atribuições de responsabilidades. Segundo Gamma et al. (1995), esses padrões "caracterizam a maneira como classes e objetos interagem e distribuem responsabilidades".

**Importância dos padrões comportamentais**:

- Reduzem o acoplamento entre objetos.
- Facilitam a variação de algoritmos e fluxos.
- Promovem reutilização e manutenção.

### Exemplos clássicos de padrões comportamentais:

- Strategy
- Observer
- Memento
- Template Method
- Command
- Chain of Responsibility
- State
- Iterator
- Visitor
- Mediator

Este tópico irá explorar três padrões essenciais: **Memento**, **Observer** e **Template Method**.

## Padrão Memento

### Definição

O padrão **Memento** permite capturar e externalizar o estado interno de um objeto, de forma que ele possa ser restaurado posteriormente, sem violar o encapsulamento (Gamma et al., 1995). 

Em outras palavras, ele implementa uma forma de "snapshot" (captura instantânea) de um objeto, que pode ser restaurado a qualquer momento.

### Estrutura

- **Originator**: objeto que cria um memento e pode restaurar seu estado a partir dele.
- **Memento**: objeto que armazena o estado interno do Originator.
- **Caretaker**: responsável por armazenar o memento, mas não pode alterá-lo.

### Aplicabilidade

Este padrão é útil para implementar funcionalidades de "desfazer" (undo), como em editores de texto (Sourcemaking, 2024). Ele também é usado em jogos para salvar estados ou em sistemas que exigem recuperação após falhas (Tutorialspoint, 2024).

### Benefícios

- Mantém o encapsulamento (Gamma et al., 1995).
- Fácil de implementar histórico de estados.

### Desvantagens

- Pode causar sobrecarga de memória se muitos estados forem armazenados (Sourcemaking, 2024).

## Padrão Observer

### Definição

O padrão **Observer** define uma dependência um-para-muitos entre objetos, de modo que quando um objeto (sujeito) muda de estado, todos os seus dependentes (observadores) são notificados automaticamente (Gamma et al., 1995).

Este padrão é também conhecido como "Publisher-Subscriber" ou "Listener" (Sourcemaking, 2024).

### Estrutura

- **Subject**: mantém a lista de observadores e notifica-os sobre alterações.
- **Observer**: define uma interface para receber atualizações.

### Aplicabilidade

O padrão Observer é frequentemente usado em sistemas com dependência reativa entre objetos, como interfaces gráficas ou notificações de eventos (Tutorialspoint, 2024).

### Benefícios

- Favorece o princípio da inversão de dependências (Gamma et al., 1995).
- Facilita a extensibilidade e reutilização.

### Desvantagens

- Pode gerar cascatas indesejadas de atualizações (Sourcemaking, 2024).
- Dificuldade no controle da ordem de notificação.

## Padrão Template Method

### Definição

O padrão **Template Method** define o esqueleto de um algoritmo em uma operação, deixando alguns passos para as subclasses. As subclasses podem redefinir certos passos do algoritmo sem alterar sua estrutura geral (Gamma et al., 1995).

Em suma, consiste em uma **classe abstrata** com um método principal que define a ordem das operações, e **subclasses concretas** que implementam detalhes específicos.

### Estrutura

- **AbstractClass**: define o Template Method e métodos abstratos.
- **ConcreteClass**: implementa os métodos específicos.

### Aplicabilidade

Quando várias classes compartilham a mesma estrutura de algoritmo, mas com variações específicas, o Template Method é apropriado. Um exemplo é o processamento de dados com diferentes fontes: arquivos, banco de dados ou APIs (Larman, 2007; Silva, 2007).

### Benefícios

- Reduz duplicação de código (Gamma et al., 1995).
- Centraliza o controle do fluxo.

### Desvantagens

- Forte acoplamento entre classes abstratas e concretas (Larman, 2007).
- Menor flexibilidade em tempo de execução.

## Comparativo entre os padrões

| Padrão            | Principal uso                                        | Estrutura Chave                  |
| ----------------- | ---------------------------------------------------- | -------------------------------- |
| Memento           | Salvar/restaurar estado de objetos                   | Originator, Memento, Caretaker   |
| Observer          | Notificar automaticamente múltiplos objetos          | Subject, Observer                |
| Template Method   | Definir fluxo fixo com passos variáveis               | AbstractClass, ConcreteClass     |

## Conclusão

Os padrões GoF comportamentais são fundamentais para o desenvolvimento de sistemas orientados a objetos robustos e flexíveis. Eles promovem a separação de responsabilidades, favorecem o baixo acoplamento e facilitam a manutenção e extensão de sistemas.

O Memento é ideal para histórico e restauração; o Observer para notificações automáticas; e o Template Method para estruturar fluxos de maneira genérica e reaproveitável. Compreender e aplicar corretamente esses padrões é essencial para profissionais de software que desejam construir sistemas elegantes e escaláveis.

## Referências Bibliográficas

> [1] GAMMA, E.; HELM, R.; JOHNSON, R.; VLISSIDES, J. **Design Patterns: Elements of Reusable Object-Oriented Software**. Addison-Wesley, 1995.

> [2] LARMAN, C. **Utilizando UML e Padrões: Uma Introdução à Análise e ao Projeto Orientado a Objetos**. 3ª ed., Bookman, 2007.

> [3] SILVA, R. P. **UML 2 em Modelagem Orientada a Objetos**. Visual Books, 2007.

> [4] SOURCEMAKING. **Design Patterns**. Disponível em: <https://sourcemaking.com/design_patterns>. Acesso em: maio 2025.

> [5] TUTORIALSPOINT. **Design Pattern Tutorial**. Disponível em: <https://www.tutorialspoint.com/design_pattern/index.htm>. Acesso em: maio 2025.

> [6] SERRANO, M. Arquitetura e Desenho de Software – Aula GoFs Comportamentais. Universidade de Brasília, 2025


##  Histórico de Versões

| Versão | Data       | Descrição                                    | Autor(es)                                                                                              | Revisor(es)                                      | Descrição da Revisão                                                                                  | Commits |
| :----: | ---------- | -------------------------------------------- | ------------------------------------------------------------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | ------- |
| 1.0    | 01/06/2025 | Documentação dos GoFs Comportamentais        | [Maria Clara](https://github.com/Oleari19)                        | -                                              | -                                                                                            | [Commit 1.0](https://github.com/UnBArqDsw2025-1-Turma02/2025.1-T02-_G1_BrinCalango_Entrega_03/commit/c812fc12f8663d373cbc3099de28a5eec68182b4) |
| 1.1    | 02/06/2025 | Documentação dos GoFs Criacionais e Estruturais        | [Maria Clara](https://github.com/Oleari19)                        | -                                              | -                                                                                            | [Commit 1.1](https://github.com/UnBArqDsw2025-1-Turma02/2025.1-T02-_G1_BrinCalango_Entrega_03/commit/70fc3aa8235322a652a5422a80c7127cfe17214c) |