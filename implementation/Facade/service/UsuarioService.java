package service;

import entity.Progresso;

public class UsuarioService {

    public Progresso obterProgresso(int idUsuario){
        System.out.println("Progresso do usuario "+idUsuario);
        return new Progresso("Progresso do usuario "+idUsuario);
    }
}
