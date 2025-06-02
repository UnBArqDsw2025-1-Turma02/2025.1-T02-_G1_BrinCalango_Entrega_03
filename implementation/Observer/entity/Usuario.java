package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Usuario {

    private int id;
    private Date dataNascimento;
    private String nome;
    private String email;
    private String senha;
    private ConfigAcessibilidade preferenciasAcessibilidade;
    private ControleOfensiva observer =  new ControleOfensiva;

    public Usuario(){
    }

    public Usuario(int id, Date dataNascimento, String nome, String email, String senha) {
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ConfigAcessibilidade getPreferenciasAcessibilidade() {
        return preferenciasAcessibilidade;
    }

    public void setPreferenciasAcessibilidade(ConfigAcessibilidade preferenciasAcessibilidade) {
        this.preferenciasAcessibilidade = preferenciasAcessibilidade;
    }

    public void realizarAtividade(Questao questao){
        System.out.println("Realizando a atividade "+questao.getId()+"!");
        notificarObservadores(questao);
    }

    // Observer
    private void notificarObservadores(Questao questao){
        System.out.println("Notificando Observadores!");
        for(ControleOfensiva obs: this.observer) {
            obs.atualizar(questao.getId(), LocalDate.now());
        }
    }

    public void adicionarObservador(ControleOfensiva obs){
        System.out.println("Adicionando Observador!");
        this.observer.add(obs);
    }

    public void removerObservador(ControleOfensiva obs){
        System.out.println("Removendo Observador!");
        this.observer.remove(obs);
    }


}









