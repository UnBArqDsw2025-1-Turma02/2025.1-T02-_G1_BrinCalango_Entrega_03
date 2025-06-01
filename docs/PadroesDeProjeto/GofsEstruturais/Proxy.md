# 3.2.- GoFs Estruturais

## Proxy 

O Proxy é um padrão de projeto estrutural que tem como principal objetivo controlar o acesso a um objeto, atuando como um intermediário entre o cliente e o objeto real. Esse padrão permite adicionar uma camada extra de controle sobre o objeto original sem alterar seu código, possibilitando a implementação de verificações, validações ou funcionalidades adicionais antes ou depois do acesso ao objeto real.

Dessa forma, o Proxy funciona como um substituto ou representante de outro objeto, controlando o acesso a ele e permitindo realizar algo antes ou depois que a solicitação chega ao objeto original [1]. Esse padrão é especialmente útil quando precisamos adicionar funcionalidades que não estão diretamente relacionadas à responsabilidade principal do objeto.

Esse padrão pode ser observado em diversos contextos do mundo real, como em sistemas de controle de acesso a documentos confidenciais, onde um funcionário precisa ter autorização específica para acessar determinados arquivos. O sistema de segurança (Proxy) verifica as credenciais do funcionário antes de permitir ou negar o acesso ao documento solicitado (objeto real).

Seguindo essa ideia, pensou-se na aplicação de um Proxy no sistema BrinCalango para controlar o acesso ao conteúdo educacional. Essa ideia partiu do princípio de que o BrinCalango precisa garantir que os usuários acessem apenas conteúdos adequados ao seu nível de progresso e faixa etária. O padrão Proxy permite implementar essa verificação de forma transparente, sem modificar as classes de conteúdo existentes.

A implementação do Proxy no BrinCalango foi dividida em duas partes principais: o controle de acesso às teorias e o controle de acesso às questões. Em ambos os casos, o Proxy verifica se o usuário atende aos requisitos necessários para acessar o conteúdo solicitado, como ter completado capítulos anteriores ou estar em um nível adequado para responder determinadas questões.

Dessa forma, a adoção do padrão Proxy no BrinCalango mostrou-se útil por permitir a implementação de um sistema de controle de acesso robusto e flexível, garantindo que os usuários interajam apenas com conteúdos apropriados ao seu progresso, sem a necessidade de modificar as classes de conteúdo existentes. Isso simplifica a manutenção do sistema e proporciona uma experiência de aprendizado mais adequada e personalizada para cada usuário.

### Esquema ilustrativo do Proxy de Controle de Acesso

Com o objetivo de facilitar a compreensão do padrão de projeto Proxy na aplicação BrinCalango, foi desenvolvido um esquema ilustrativo, presente na Figura 1, que representa a interação entre os componentes principais: o **Usuário**, o **Progresso**, o **Conteúdo** e as classes de Proxy.

O processo se inicia com o Usuário tentando acessar um conteúdo educacional, seja uma teoria ou uma questão. Antes que esse acesso seja concedido, o sistema verifica o progresso atual do usuário através da classe Progresso, que mantém informações sobre o capítulo atual e a última questão respondida.

Quando o usuário tenta acessar uma teoria, a solicitação é interceptada pelo TeoriaProxy, que verifica se o capítulo solicitado está disponível para o nível atual do usuário. O TeoriaProxy compara o capítulo atual do usuário com o capítulo da teoria solicitada, permitindo o acesso apenas se o usuário já tiver progredido o suficiente (capítulo atual >= capítulo solicitado - 0.1). Caso contrário, o acesso é bloqueado.

De forma semelhante, quando o usuário tenta acessar uma questão, a solicitação passa pelo QuestaoProxy, que verifica se o número da questão é adequado ao progresso atual do usuário. O QuestaoProxy compara o progresso do usuário com o número da questão, permitindo o acesso apenas se o usuário estiver pronto para responder aquela questão (questão atual >= número da questão - 0.1). Se o usuário atender aos requisitos, a solicitação é delegada para a questão real; caso contrário, o acesso é negado.

Esse esquema ilustra como o padrão Proxy atua como uma camada de proteção entre o usuário e o conteúdo, garantindo que o acesso seja concedido apenas quando apropriado, sem modificar as classes originais de Teoria e Questao. Isso permite um controle granular sobre o acesso ao conteúdo educacional, adaptando-se ao progresso individual de cada usuário no sistema BrinCalango.

<p align="center"><strong>Figura 1 – Modelagem do Proxy</strong></p>

<div align="center">

![Modelagem do Proxy](../assets/Proxy.png)

</div>

<p align="center"><em>Autor: <a href="https://github.com/juliatakaki" target="_blank">Júlia Takaki</a> e <a href="https://github.com/Oleari19" target="_blank">Maria Clara</a>, 2025</em></p>

### Implementação do Proxy
```
```

## Referências Bibliográficas

> [1] REFRACTORING.GURU. Proxy. [S. l.], [s. d.]. Disponível em: https://refactoring.guru/design-patterns/proxy. Acesso em: 01 jun. 2025.

## Bibliografia 

> SOURCEMAKING. Proxy. [S. l.], [s. d.]. Disponível em: https://sourcemaking.com/design_patterns/proxy. Acesso em: 01 jun. 2025.

## Histórico de Versões
| Versão | Data       | Descrição                                    | Autor(es)                                                                                              | Revisor(es)                                      | Descrição da Revisão                                                                                  | Commits |
| :----: | ---------- | -------------------------------------------- | -------------------------------------------------------------------------------------------------------- | ------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | -------- |
| 1.0    | 01/06/2025 | Criação e Documentação do Proxy | [Júlia Takaki](https://github.com/juliatakaki) e [Maria Clara](https://github.com/Oleari19)| - | - | [Commit1-0](https://github.com/UnBArqDsw2025-1-Turma02/2025.1-T02-_G1_BrinCalango_Entrega_03/commit/c35b578d8c92e70d3772f47c6c39798c28ddfb90) |
