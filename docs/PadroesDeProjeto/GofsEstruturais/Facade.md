# 3.2.- GoFs Estruturais

## Facade 

###  Definição
O padrão **Facade** é um dos padrões estruturais do catálogo *GoF* em um subsistema. Ele define uma interface de mais alto nível que torna o subsistema mais fácil de usar.

> Segundo Refactoring.Guru:  
> “O Facade fornece uma interface simplificada para um subsistema complexo, facilitando o uso de bibliotecas ou códigos internos por parte do cliente.”  
> Fonte: [Refactoring Guru - Facade](https://refactoring.guru/pt-br/design-patterns/facade)

Esse padrão é especialmente útil quando lidamos com **sistemas compostos por múltiplos serviços ou módulos**, escondendo a complexidade e promovendo o desacoplamento entre os componentes.

---

### Imagem

<div align="center">

![Diagrama do Facade](../assets/Facade.png)

</div>

<p><em>Autor: <a href="https://github.com/julia-fortunato" target="_blank">Júlia Fortunato</a>, <a href="https://github.com/luanasoares0901" target="_blank">Luana</a>, <a href="https://github.com/ailujana" target="_blank">Ana Julia</a> e <a href="https://github.com/mauricio-araujoo" target="_blank">Maurício</a>, 2025</em></p>


### Diagrama no Lucidchart

[Acesse o diagrama interativo no Lucidchart](https://lucid.app/lucidchart/44e8d0b4-a9a0-47e3-8f2c-3b19c256692c/edit?invitationId=inv_9811db09-efb6-48fd-93e7-b9ed212e6ff3&page=0_0#)

#### Frame interativo da modelagem do Facade
<div style="width: 640px; height: 480px; margin: 10px; position: relative;"><iframe allowfullscreen frameborder="0" style="width:640px; height:480px" src="https://lucid.app/documents/embedded/44e8d0b4-a9a0-47e3-8f2c-3b19c256692c" id="Lq8kb~zelObz"></iframe></div>

### Implementação do Facade



## Vantagens obtidas

- **Simplicidade para o cliente**: A camada de fachada fornece uma única interface, reduzindo a complexidade para os usuários/clientes do sistema.
- **Desacoplamento**: Componentes como controladores ou interfaces de usuário não precisam conhecer a lógica interna dos serviços.
- **Facilidade de manutenção**: Mudanças internas nos serviços (ex: troca de implementação) não afetam quem consome o `Facade`.
- **Melhora a legibilidade e organização do código**.

## (i)Autores:
- Ana Júlia Mendes Santos  
- Julia Rocha Fortunato
- Luana Ribeiro Soares
- Maurício Araújo 

**Observação**: rastro dos commits está no histórico de versões no fim da página.

##  (ii) Justificativas & senso crítico

No contexto do projeto **BrinCalango**, o padrão Facade foi adotado para **centralizar a orquestração das funcionalidades principais**: início de módulos, execução de atividades, resposta de questões, geração de feedbacks e visualização do progresso do usuário.

A interface `Facade` e sua implementação `FacadeImpl` abstraem e simplificam a interação com três serviços distintos:

- `ModuloService`: Responsável por inicializar módulos e obter questões.
- `QuestaoService`: Gerencia a lógica de resposta das questões e feedbacks.
- `UsuarioService`: Coleta e apresenta o progresso do usuário.

- **Risco de tornar-se uma “Deus-classe”**: Se a fachada centraliza lógica demais, ela pode crescer descontroladamente.
- **Ocultamento excessivo da lógica**: Pode esconder detalhes importantes que seriam úteis em contextos mais flexíveis.
- **Dependência de implementação concreta**: Apesar de ter uma interface, o uso direto da `FacadeImpl` pode gerar acoplamento indesejado se não for bem controlado.


##  (iii) Comentários sobre o trabalho em equipe

- O trabalho foi dividido de forma colaborativa;
- As decisões sobre uso do padrão foram debatidas em reuniões curtas, promovendo aprendizado mútuo e engajamento;
- A modelagem foi realizada em grupo durante reunião de forma colaborativa.

##  Bibliografia

> [1] Refactoring.Guru - Padrão Facade: https://refactoring.guru/pt-br/design-patterns/facade. 

> [2] Slides da Prof.ª Milene – Aula GoFs Estruturais UnB (2024).

> [3] Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley.


##  Histórico de Versões
| Versão | Data       | Descrição                                    | Autor(es)                                                                                              | Revisor(es)                                      | Descrição da Revisão                                                                                  | Commits |
| :----: | ---------- | -------------------------------------------- | -------------------------------------------------------------------------------------------------------- | ------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | -------- |
| 1.0    | 31/05/2025 | Criação e Documentação do Facade | [Ana Julia](https://github.com/ailujana), [Julia Fortunato](http://github.com/julia-fortunato) , [Luana Ribeiro](https://github.com/luanasoares0901) e [Maurício Araújo](https://github.com/mauricio-araujoo) | - | - |  |