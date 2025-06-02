# Memento

O padrão Memento foi escolhido por sua capacidade de capturar e restaurar o estado interno de um objeto sem violar o encapsulamento. Isso se alinha perfeitamente com a necessidade de salvar e restaurar o progresso do usuário (nível, XP, acertos, erros etc.) de forma transparente.

## Estrutura do Memento na Modelagem

A modelagem foi dividida em três classes principais:

### 1. **Progresso (Originador)**
- Guarda o estado atual do progresso do usuário.
- Responsável por criar e restaurar objetos `ProgressoMemento`.
- Métodos principais:
  - `salvarEstado(): ProgressoMemento`
  - `restaurarEstado(ProgressoMemento)`

### 2. **ProgressoMemento (Memento)**
- Armazena o estado do progresso (níveis, XP, acertos etc.).
- Não permite alterações diretas no estado original.
- É imutável e usado apenas para restauração.

### 3. **Usuario (Cuidador)**
- Mantém os mementos em `progressoSalvo`.
- Aciona os métodos de salvar/restaurar do progresso.
- Métodos principais:
  - `salvarProgresso()`
  - `restaurarProgresso()`

---

## Benefícios Observados

- **Segurança e simplicidade**: ideal para crianças — o progresso é salvo automaticamente sem exigir ações complexas.
- **Recuperação fácil**: evita frustração em caso de erro ou queda de sistema.
- **Extensibilidade**: permite futuras implementações como "voltar para checkpoint" ou "repetir nível".

---

## Exemplo de Fluxo

1. A criança completa um conjunto de questões.
2. O método `salvarProgresso()` é chamado, e o estado é armazenado como `ProgressoMemento`.
3. Se necessário, o método `restaurarProgresso()` recupera o progresso anterior sem expor os detalhes internos da lógica de XP e níveis.


## Modelagem do Memento

Na Figura 2, encontra-se a modelagem para o Memento 

<div align="center">

<p><strong>Figura 2 – Modelagem do Factory Method  </strong></p>

![Diagrama do Memento](../assets/memento.png)

<p><em>Autor: <a href="https://github.com/andre-maia51" target="_blank">André Maia</a>, <a href="https://github.com/luanasoares0901" target="_blank">Luana</a> e <a href="https://github.com/ailujana" target="_blank">Ana Julia</a>, 2025</em></p>

</div>


## Frame interativo da modelagem do Memento

<div style="width: 1000px; height: 480px; margin: 10px; position: relative;"><iframe allowfullscreen frameborder="0" style="width:640px; height:480px" src="https://lucid.app/documents/embedded/ab4b32b3-4349-4cbd-90ad-b51ce4c55466" id="Ys8kvwa65fiR"></iframe></div>

## Implementação do Memento

### Classe `Usuário`

```Java
 package entity;

 import java.time.LocalDate;
 import java.time.Period;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.regex.Pattern;
 import entity.ProgressoMemento;
 import java.util.ArrayList;
 import java.util.List;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private Progresso progresso;
    private List<ProgressoMemento> progressoSalvo;

    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.progresso = new Progresso();
        this.progressoSalvo = new ArrayList<>();
    }

    public Progresso getProgresso() {
        return progresso;
    }

    public void salvarProgresso() {
        progressoSalvo.add(progresso.salvarEstado());
        System.out.println("Progresso salvo com sucesso.");
    }

    public void restaurarProgresso(int index) {
        if (index >= 0 && index < progressoSalvo.size()) {
            progresso.restaurarEstado(progressoSalvo.get(index));
            System.out.println("Progresso restaurado para o estado " + index);
        } else {
            System.out.println("Índice inválido para restauração.");
        }
    }

    public boolean salvarDados() {
        System.out.println("Dados salvos com sucesso!");
        return true;
    }

    public boolean validarEmail() {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(regex, this.email);
    }

    public static class ConfigAcessibilidade {
         private boolean altoContraste;
         private boolean textoGrande;

        public ConfigAcessibilidade(boolean altoContraste, boolean textoGrande) {
             this.altoContraste = altoContraste;
            this.textoGrande = textoGrande;
         }

        public boolean isAltoContraste() {
             return altoContraste;
         }

         public boolean isTextoGrande() {
            return textoGrande;
        }

        public void setAltoContraste(boolean altoContraste) {
            this.altoContraste = altoContraste;
         }

        public void setTextoGrande(boolean textoGrande) {
            this.textoGrande = textoGrande;
        }
    }

     public class Feedback {
         private int idQuestao;
        private boolean acertou;

        public Feedback(int idQuestao, boolean acertou) {
             this.idQuestao = idQuestao;
             this.acertou = acertou;
         }

        public int getIdQuestao() {
             return idQuestao;
        }

         public boolean isAcertou() {
             return acertou;
         }
     }

     public class Teoria {
        private int capitulo;
        private String conteudo;

        public Teoria(int capitulo, String conteudo) {
            this.capitulo = capitulo;
            this.conteudo = conteudo;
        }

        public int getCapitulo() {
            return capitulo;
        }

        public String getConteudo() {
            return conteudo;
        }
    }

    public Teoria lerTeoria(int capitulo) {
        return new Teoria(capitulo, "Conteúdo do capítulo " + capitulo);
    }

    public int calcularIdade() {
        System.out.println("Calculando idade");
        return 30;
    }
}
```

### Classe `Progresso`

```JAVA
package entity;

public class Progresso {
    private int nivelAtual = 1;
    private int nivelProx = 2;
    private int qtdXP = 0;
    private int XPMaxNivel = 100;
    private int totalQuestoesAcerto = 0;
    private int totalQuestoesErro = 0;
    private float porcentagemConcluida = 0;

    public void atualizarProgresso(int qtdXP) {
        this.qtdXP += qtdXP;
        System.out.println("XP adicionado: " + qtdXP + " | Total de XP: " + this.qtdXP);
        atualizarNivel();
    }

    public boolean atualizarNivel() {
        if (qtdXP >= XPMaxNivel) { // pra subir de nivel precisa chegar ao max de xp
            nivelAtual++;
            nivelProx++;
            qtdXP -= XPMaxNivel;
            XPMaxNivel += 40;
            System.out.println("Parabéns! Você subiu para o nível " + nivelAtual);
            return true;
        }
        return false;
    }

    public void incrementarErros() {
    totalQuestoesErro++;
}


    public ProgressoMemento salvarEstado() {
        System.out.println("Salvando progresso...");
        return new ProgressoMemento(nivelAtual, nivelProx, qtdXP, XPMaxNivel, totalQuestoesAcerto, totalQuestoesErro, porcentagemConcluida);
    }

    public void restaurarEstado (ProgressoMemento memento) {
        System.out.println("Restaurando progresso salvo...");
        this.nivelAtual = memento.getNivelAtual();
        this.nivelProx = memento.getNivelProx();
        this.qtdXP = memento.getQtdXP();
        this.XPMaxNivel = memento.getXPMaxNivel();
        this.totalQuestoesAcerto = memento.getTotalQuestoesAcerto();
        this.totalQuestoesErro = memento.getTotalQuestoesErro();
        this.porcentagemConcluida = memento.getPorcentagemConcluida();
    }

    public void mostrarProgresso() {
        System.out.println("=== Progresso ===");
        System.out.println("Nível atual: " + nivelAtual);
        System.out.println("XP: " + qtdXP + "/" + XPMaxNivel);
        System.out.println("=================");
    }
}
```

### Classe `ProgressoMemento`

```JAVA
package entity;

public class ProgressoMemento{
    private int nivelAtual;
    private int nivelProx;
    private int qtdXP;
    private int XPMaxNivel;
    private int totalQuestoesAcerto;
    private int totalQuestoesErro;
    private float porcentagemConcluida;

    public ProgressoMemento(int nivelAtual, int nivelProx, int qtdXP, int XPMaxNivel, int totalQuestoesAcerto, int totalQuestoesErro, float porcentagemConcluida) {
        this.nivelAtual = nivelAtual;
        this.nivelProx = nivelProx;
        this.qtdXP = qtdXP;
        this.XPMaxNivel = XPMaxNivel;
        this.totalQuestoesAcerto = totalQuestoesAcerto;
        this.totalQuestoesErro = totalQuestoesErro;
        this.porcentagemConcluida = porcentagemConcluida;
    }
    
    public int getNivelAtual() { return nivelAtual; } 
    public int getNivelProx() { return nivelProx; }
    public int getQtdXP() { return qtdXP; }
    public int getXPMaxNivel() { return XPMaxNivel; }
    public int getTotalQuestoesAcerto() { return totalQuestoesAcerto; }
    public int getTotalQuestoesErro() { return totalQuestoesErro; }
    public float getPorcentagemConcluida() { return porcentagemConcluida; }

}
```

### Classe `Main`

```Java
import entity.Usuario;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(1, "João", "joao@email.com", "senha123");

        usuario.getProgresso().atualizarProgresso(50);
        usuario.getProgresso().mostrarProgresso();

        usuario.salvarProgresso();

        usuario.getProgresso().atualizarProgresso(70);
        usuario.getProgresso().mostrarProgresso();

        usuario.salvarProgresso();

        usuario.getProgresso().atualizarProgresso(200);
        usuario.getProgresso().mostrarProgresso();

        usuario.restaurarProgresso(0);
        usuario.getProgresso().mostrarProgresso();
    }
}
```






## (i) Autores:
- Ana Júlia Mendes Santos  
- André Maia
- Luana Ribeiro Soares

**Observação**: rastro dos commits está no histórico de versões no fim da página.

##  (ii) Justificativas & senso crítico

- **Isolamento do estado**: permite capturar o estado do objeto `Progresso` em um ponto específico no tempo.
- **Reversibilidade**: possibilita restaurar estados anteriores — útil em casos de erro, redefinição de progresso ou simulação.
- **Encapsulamento preservado**: o `Usuario` interage com snapshots (`ProgressoMemento`) sem acessar diretamente os dados internos de `Progresso`.
- **Histórico de progresso**: o atributo `progressoSalvo: List<ProgressoMemento>` permite manter múltiplos estados salvos.

Embora o padrão Memento seja poderoso, ele também pode aumentar o consumo de memória se muitos estados forem armazenados indiscriminadamente. No contexto infantil, isso é mitigado pela simplicidade dos dados e pela limitação dos checkpoints de salvamento.


##  (iii) Comentários sobre o trabalho em equipe

- O trabalho foi dividido de forma colaborativa entre a equipe;
- As decisões sobre uso do padrão foram debatidas em reuniões curtas, promovendo aprendizado mútuo e engajamento;
- A modelagem foi relaizada em conjunto durante reunião.


## Bibiografia

> [1] Refactoring.Guru. Padrão de Projeto Memento. Disponível em: https://refactoring.guru/pt-br/design-patterns/memento. Acesso em: 30 maio 2025.

> [2] GAMMA, Erich et al. Padrões de projeto: soluções reutilizáveis de software orientado a objetos. Porto Alegre: Bookman, 2009. Acesso em: 30 maio 2025.

> [3] ALMEIDA, Alexandre. Padrões de Projeto em Java: Soluções reutilizáveis com Design Patterns. São Paulo: Novatec, 2014.Acesso em: 30 maio 2025.

> [4] LARMAN, Craig. Utilizando UML e Padrões: uma introdução à análise e ao projeto orientados a objetos e ao processo unificado. 3. ed. Porto Alegre: Bookman, 2007.Acesso em: 30 maio 2025.

 
## Histórico de Versões
| Versão | Data | Descrição | Autor(es) | Revisor(es) | Descrição da Revisão | Commits |
| ------ | ---- | --------- | --------- | ----------- | -------------------- | ------- |
| 1.1 | 30/05/2025 | Documentação da modelagem| [Ana Julia](https://github.com/ailujana), [André Maia](http://github.com/andre-maia51) e [Luana Ribeiro](https://github.com/luanasoares0901) | | | |
| 1.2 | 01/06/2025 | Implementação do Memento| [Diogo Barboza](https://github.com/Diogo-Barboza), [Cristiano Moraes](http://github.com/CristianoMoraiss) | | | |
