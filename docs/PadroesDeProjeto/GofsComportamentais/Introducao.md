
# GoFs de Padrões Comportamentais

## Introdução aos Padrões GoF

Os padrões de projeto (Design Patterns) são soluções recorrentes e comprovadas para problemas comuns enfrentados durante o desenvolvimento de software orientado a objetos. Esse conceito foi amplamente consolidado pela obra seminal “Design Patterns: Elements of Reusable Object-Oriented Software” de Erich Gamma, Richard Helm, Ralph Johnson e John Vlissides, conhecidos como a Gang of Four (GoF) (Gamma et al., 1995).

Os padrões GoF são tradicionalmente categorizados em três grupos:

1. **Criacionais**: focados na criação de objetos.
2. **Estruturais**: organizam classes e objetos.
3. **Comportamentais**: concentram-se na comunicação entre objetos.

## Padrões GoF Comportamentais

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
| :----: | ---------- | -------------------------------------------- | -------------------------------------------------------------------------------------------------------- | ------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | -------- |
| 1.0    | 01/06/2025 | Documentação dos GoFs Comportamentais | [Maria Clara](https://github.com/Oleari19) | - | - | [Commit 1]() |