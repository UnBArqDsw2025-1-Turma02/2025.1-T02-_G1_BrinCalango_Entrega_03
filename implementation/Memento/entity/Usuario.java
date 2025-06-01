import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import entity.ProgressoMemento;

public class Usuario {
    private int id;
    public LocalDate dataNascimento;
    public String nome;
    private String email;
    private String senha;
    private ConfigAcessibilidade preferenciasAcessibilidade;
    private Progresso progresso;
    public List<ProgressoMemento> progressoSalvo;

    // Construtor
    public Usuario(int id, String nome, String email, String senha, LocalDate dataNascimento, ConfigAcessibilidade config, Progresso progresso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = gerarHashSenha(senha);
        this.dataNascimento = dataNascimento;
        this.preferenciasAcessibilidade = config;
        this.progresso = progresso;
        this.progressoSalvo = new ArrayList<>();
    }

    public boolean validarEmail() {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(regex, this.email);
    }

    public int calcularIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    public Teoria lerTeoria(int capitulo) {
        return new Teoria(capitulo, "Conteúdo do capítulo " + capitulo);
    }

    public Feedback realizarAtividade(int idQuestao) {
        boolean acertou = Math.random() > 0.3;
        if (acertou) {
            progresso.atualizarProgresso(10); // Ganha 10 XP por acerto
        } else {
            progresso.incrementarErros(); // Supondo que Progresso tenha esse método
        }
        return new Feedback(idQuestao, acertou);
    }

    public Progresso consultarProgresso() {
        return progresso;
    }

    private String gerarHashSenha(String senhaOriginal) {
        return Integer.toHexString(senhaOriginal.hashCode()); // Simples hash como exemplo
    }

    public boolean salvarDados() {
        // Simulação de persistência (banco de dados, arquivo, etc.)
        return true;
    }

    public void atualizarAcessibilidade(ConfigAcessibilidade config) {
        this.preferenciasAcessibilidade = config;
    }

    public void salvarProgresso() {
        progressoSalvo.add(progresso.salvarEstado());
    }

    public void restaurarProgresso() {
        if (!progressoSalvo.isEmpty()) {
            progresso.restaurarEstado(progressoSalvo.get(progressoSalvo.size() - 1));
        }
    }

    // Classe auxiliar para Teoria
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

    // Classe auxiliar para ConfigAcessibilidade
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
}
