package entity;

import java.time.LocalDate;

public class ControleOfensiva {

    private int diasSeguidos;
    private LocalDate ultimoDia;

    public ControleOfensiva(){
    }

    public ControleOfensiva(int diasSeguidos, LocalDate ultimoDia) {
        this.diasSeguidos = diasSeguidos;
        this.ultimoDia = ultimoDia;
    }

    public int getDiasSeguidos() {
        return diasSeguidos;
    }

    public void setDiasSeguidos(int diasSeguidos) {
        this.diasSeguidos = diasSeguidos;
    }

    public LocalDate getUltimoDia() {
        return ultimoDia;
    }

    public void setUltimoDia(LocalDate ultimoDia) {
        this.ultimoDia = ultimoDia;
    }

    public void atualizar(int questaoId, LocalDate dataHoje){
        this.diasSeguidos += 1;
        this.ultimoDia = dataHoje;
    }
}
