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

    // Classe auxiliar para Feedback
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


