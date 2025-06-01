#  Prototype no BrinCalango

##  Definição
O padrão **Prototype** é um dos padrões criacionais definidos pelos GoF (Gang of Four) que permite **clonar objetos existentes** sem acoplá-los ao código que os cria. Ele é especialmente útil quando a criação de novos objetos a partir do zero é custosa ou complexa [1, 2].

##  Aplicação no Projeto BrinCalango

### Contexto
No BrinCalango, temos o conceito de **questões padronizadas**, como *QuestaoVouF*, *QuestaoLacuna*, *QuestaoMultiplaEscolha* e *QuestaoEscolhaMultipla*, armazenadas em um repositório chamado `BancoDeQuestoes`. A lógica do jogo exige gerar novas instâncias dessas questões diversas vezes — por exemplo, ao criar provas, rodadas de treino ou simulações. Essa necessidade foi evidenciada durante os estudos da disciplina de Arquitetura de Software, conforme orientações da professora Milene (UnB, 2024) [2].

### Problema
Criar novas questões do zero exigiria uma lógica extra para configurar o nível, alternativas, pontuação, enunciado, etc., o que se tornaria repetitivo e propenso a erros.

### Solução com Prototype
Com o padrão **Prototype**, é possível:
- Criar uma **questão-modelo**;
- Armazená-la no `BancoDeQuestoes`;
- Cloná-la rapidamente com `.clone()` para gerar múltiplas instâncias similares, com as mesmas configurações.

Essa abordagem segue o modelo recomendado por Gamma et al. [1] e exemplificado em Refactoring.Guru (2025), onde o uso de `.clone()` encapsula a lógica de duplicação respeitando os princípios de responsabilidade única.

## Imagem

<div align="center">

![Diagrama do Protoype](../assets/prototype.png)

</div>

<p align="center"><em>Autor: <a href="https://github.com/ailujana" target="_blank">Ana Júlia</a>, <a href="https://github.com/Oleari19" target="_blank">Maria Clara</a>, 2025</em></p>


## Diagrama no Lucidchart

[Acesse o diagrama interativo no Lucidchart](https://lucid.app/lucidchart/5297f22b-c775-46c0-a384-1254419ea4e8/edit?invitationId=inv_5365ef39-e274-4853-aeba-90716661d7b4&page=0_0#)

#### Frame interativo da modelagem do Prototype
<div style="width: 1000px; height: 500px; margin: 10px; position: relative;"><iframe allowfullscreen frameborder="0" style="width:1000px; height:500px" src="https://lucid.app/documents/embedded/5297f22b-c775-46c0-a384-1254419ea4e8" id="YEkiwTVEnZWG"></iframe></div>

## Implementação do Prototype

```
import java.util.*;

// Produto Abstrato (Prototype)

public abstract class Questao {

    protected int idQuestao;
    protected int nivel;
    protected int pontuacao;
    protected String enunciado;
    protected String resposta;

    public Questao(){
    }

    public Questao(Questao instancia) {
        if(instancia != null){
            this.idQuestao = instancia.idQuestao;
            this.nivel = instancia.nivel;
            this.pontuacao = instancia.pontuacao;
            this.enunciado = instancia.enunciado;
            this.resposta = instancia.resposta;
        }
    }

    public int getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(int idQuestao) {
        this.idQuestao = idQuestao;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public abstract Questao clone();

}


public class QuestaoVouF extends Questao {

    private boolean respostaVouF;

    public QuestaoVouF(){
    }

    public QuestaoVouF(QuestaoVouF instancia){
        super(instancia);
        if(instancia != null){
            this.respostaVouF = instancia.respostaVouF;
        }else{
            throw new RuntimeException("Instancia Vazia!!");
        }
    }

    public boolean getRespostaVouF() {
        return respostaVouF;
    }

    public void setRespostaVouF(boolean respostaVouF) {
        this.respostaVouF = respostaVouF;
    }

    @Override
    public Questao clone() {
        return new QuestaoVouF(this);
    }

}



public class QuestaoLacuna extends Questao{

    private String respostaLacuna;

    public QuestaoLacuna(){
    }

    public QuestaoLacuna(QuestaoLacuna instancia) {
        super(instancia);
        if(instancia != null){
            this.respostaLacuna = instancia.respostaLacuna;
        }else{
            throw new RuntimeException("Instancia Vazia!!");
        }
    }

    public String getRespostaLacuna() {
        return respostaLacuna;
    }

    public void setRespostaLacuna(String respostaLacuna) {
        this.respostaLacuna = respostaLacuna;
    }

    public boolean acertouLacuna(String resposta){
        return resposta.equals(respostaLacuna);
    }

    @Override
    public Questao clone() {
        return new QuestaoLacuna(this);
    }
}


import java.util.ArrayList;

public class QuestaoMultiplaEscolha extends Questao{

    private ArrayList<String> alternativasME;
    private ArrayList<String> alternativasCorretasME;

    public QuestaoMultiplaEscolha(){
    }

    public QuestaoMultiplaEscolha(QuestaoMultiplaEscolha instancia){
        super(instancia);
        if(instancia != null){
            this.alternativasME = instancia.alternativasME;
            this.alternativasCorretasME = instancia.alternativasCorretasME;
        }else{
            throw new RuntimeException("Instancia Vazia!!");
        }
    }

    public ArrayList<String> getAlternativasME() {
        return alternativasME;
    }

    public void setAlternativasME(ArrayList<String> alternativasME) {
        this.alternativasME = alternativasME;
    }

    public List<String> getAlternativasCorretasME() {
        return alternativasCorretasME;
    }

    public void setAlternativasCorretasME(ArrayList<String> alternativasCorretasME) {
        this.alternativasCorretasME = alternativasCorretasME;
    }

    public boolean acertouME(List<String> respostas){
        int cont = 0;
        for(String res : respostas){
            if(this.alternativasCorretasME.contains(res)){
                cont++;
            }
        }
        return (cont == this.alternativasCorretasME.size());
    }

    @Override
    public Questao clone() {
        return new QuestaoMultiplaEscolha(this);
    }
}

import java.util.Map;

public class QuestaoEscolhaMultipla extends Questao{

    private Map<String,Boolean> alternativasEM;

    public QuestaoEscolhaMultipla(){
    }

    public QuestaoEscolhaMultipla(QuestaoEscolhaMultipla instancia){
        super(instancia);
        if(instancia != null){
            this.alternativasEM = instancia.alternativasEM;
        }else{
            throw new RuntimeException("Instancia Vazia!!");
        }
    }

    public Map<String, Boolean> getAlternativasEM() {
        return alternativasEM;
    }

    public void setAlternativasEM(Map<String, Boolean> alternativasEM) {
        this.alternativasEM = alternativasEM;
    }

    public boolean acertouME(Map<String,Boolean> resposta){
        return alternativasEM.equals(resposta);
    }

    @Override
    public Questao clone() {
        return new QuestaoEscolhaMultipla(this);
    }
}


class BancoDeQuestoes {
    private Map<Integer, Questao> modelos = new HashMap<>();

    public void adicionarModelo(Questao questao) {
        modelos.put(questao.idQuestao, questao);
    }

    public Questao clone(int idQuestao) {
        Questao questao = modelos.get(idQuestao);
        if (questao != null) {
            return questao.clone();
        }
        return null;
    }
}

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        QuestaoEscolhaMultipla qem = new QuestaoEscolhaMultipla();
        Map<String,Boolean> resQuestao = new HashMap<>();
        Map<String,Boolean> resAluno = new HashMap<>();

        qem.setIdQuestao(1);
        qem.setNivel(0);
        qem.setPontuacao(10);
        qem.setEnunciado("Qual função escreve no console?");
        qem.setResposta(null);
        resQuestao.put("escreva",true);
        resQuestao.put("escreval",true);
        resQuestao.put("leia",false);
        resQuestao.put("leiaCaracter",false);
        qem.setAlternativasEM(resQuestao);

        resAluno.put("leiaCaracter",false);
        resAluno.put("escreva",true);
        resAluno.put("leia",false);
        resAluno.put("escreval",false);

        QuestaoEscolhaMultipla qemClone = (QuestaoEscolhaMultipla) qem.clone();

        if(qemClone.acertouME(resAluno)){
            System.out.println("Acertou!");
        }else{
            System.out.println("Errou!");
        }

    }
}

```

## Vantagens obtidas

- **Eficiência**: Redução no custo de criação de objetos complexos.
- **Manutenção**: Permite alterar a questão-modelo e replicar a mudança automaticamente nos clones.
- **Flexibilidade**: Adiciona facilidade na criação de novos tipos de questões sem alterar a lógica do sistema.
- **Desacoplamento**: Separação clara entre criação e uso de objetos.

## (i) Autoras:
- Ana Júlia Mendes Santos  
- Maria Clara Oleari de Araujo
- Júlia Takaki Neves

**Observação**: rastro dos commits está no histórico de versões no fim da página.

##  (ii) Justificativas & senso crítico

- **Escolha do padrão**: O Prototype foi escolhido devido à necessidade de gerar **cópias rápidas e seguras** de objetos complexos (questões) sem depender da criação manual.
- **Alinhamento com boas práticas**: A aplicação do padrão respeita princípios como SRP (Single Responsibility Principle), pois o método `.clone()` está encapsulado na própria classe da questão.
- O embasamento teórico está alinhado com a bibliografia clássica (Gamma et al., 1994) e moderna (Refactoring.Guru, 2025).

##  (iii) Comentários sobre o trabalho em equipe

- O trabalho foi dividido de forma colaborativa;
- As decisões sobre uso do padrão foram debatidas em reuniões curtas, promovendo aprendizado mútuo e engajamento.

##  Referências

> [1] Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*.

> [2] Refactoring.Guru. [Prototype](https://refactoring.guru/design-patterns/prototype).
> [3] Arquitetura de Software – Profa. Milene – UnB (2024).
> [4] Documentação interna do projeto BrinCalango.

##  Histórico de Versões
| Versão | Data       | Descrição                                    | Autor(es)                                                                                              | Revisor(es)                                      | Descrição da Revisão                                                                                  | Commits |
| :----: | ---------- | -------------------------------------------- | -------------------------------------------------------------------------------------------------------- | ------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | -------- |
| 1.0    | 26/05/2025 | Criação e Documentação do Prototype | [Ana Júlia](https://github.com/ailujana), [Maria Clara](https://github.com/Oleari19) | - | - | [Commit1-0](https://github.com/UnBArqDsw2025-1-Turma02/2025.1-T02-_G1_BrinCalango_Entrega_03/commit/8c27e9e66a1404e0664b4cf0ea93b82e572b6d0e) |
| 1.1    | 28/05/2025 | Criação da implementação do Prototype | [Júlia Takaki](https://github.com/juliatakaki) | - | - | [Commit1-1](https://github.com/UnBArqDsw2025-1-Turma02/2025.1-T02-_G1_BrinCalango_Entrega_03/commit/9933b7cd86bf97b661f0ad2832aa4279ee5c7777) |
| 1.2    | 28/05/2025 | Escrita da implementação do Prototype | [Mauricio Ferreira](https://github.com/mauricio-araujoo), [Cristiano Morais](https://github.com/CristianoMoraiss) | - | - | - |