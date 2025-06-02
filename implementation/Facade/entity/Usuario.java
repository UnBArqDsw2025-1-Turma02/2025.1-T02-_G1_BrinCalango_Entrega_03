package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import application.FacadeImpl;

public class Usuario {

    private int id;
    private Date dataNascimento;
    private String nome;
    private String email;
    private String senha;
    private ConfigAcessibilidade preferenciasAcessibilidade;
    private FacadeImpl facade;

    public Usuario(){
    }

    public Usuario(int id, Date dataNascimento, String nome, String email, String senha, FacadeImpl facade) {
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.facade = facade;
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

    public void setFacade(FacadeImpl facade) {
        this.facade = facade;
    }

    public Feedback responderQuestao(Modulo modulo, int idQuestao, String resposta) {
      if (this.facade == null) {
          throw new IllegalStateException("Facade não foi configurada.");
      }
      return this.facade.responderQuestao(modulo, idQuestao, resposta);
    }


    public Progresso verProgresso() {
        if (this.facade == null) {
            throw new IllegalStateException("Facade não foi configurada.");
        }
        return this.facade.mostrarProgresso(this.id);
    }

}









