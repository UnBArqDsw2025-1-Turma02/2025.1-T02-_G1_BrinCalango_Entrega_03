abstract class ConfiguracaoAcessibilidade {

    protected boolean contraste;
    protected int tamanhoFonte;
    protected int leitorDeTelas; // 0 = desligado, 1 = básico, 2 = completo
    protected boolean animacoes;

    public ConfiguracaoAcessibilidade() {
        System.out.println("-> Criando uma nova configuração de acessibilidade (Produto Base).");
    }

    public boolean isContraste() { return contraste; }
    public int getTamanhoFonte() { return tamanhoFonte; }
    public int getLeitorDeTelas() { return leitorDeTelas; }
    public boolean hasAnimacoes() { return animacoes; }

    public abstract void displayConfig();
}

// Produto Concreto 1
class ConfiguracaoAcessibilidade1 extends ConfiguracaoAcessibilidade {
    public ConfiguracaoAcessibilidade1() {
        super();
        System.out.println("   -> Instanciando Produto Concreto: ConfiguracaoAcessibilidade1.");
    }

    @Override
    public void displayConfig() {
        System.out.println("\n--- Configuração de Acessibilidade Perfil 1 ---");
        System.out.println("   Contraste Ativado: " + contraste);
        System.out.println("   Tamanho da Fonte: " + tamanhoFonte);
        System.out.println("   Leitor de Telas: " + (leitorDeTelas == 0 ? "Desligado" : (leitorDeTelas == 1 ? "Básico" : "Completo")));
        System.out.println("   Animações Ativadas: " + animacoes);
        System.out.println("----------------------------------------------");
    }
}

// Produto Concreto 2
class ConfiguracaoAcessibilidade2 extends ConfiguracaoAcessibilidade {
    public ConfiguracaoAcessibilidade2() {
        super();
        System.out.println("   -> Instanciando Produto Concreto: ConfiguracaoAcessibilidade2.");
    }

    @Override
    public void displayConfig() {
        System.out.println("\n--- Configuração de Acessibilidade Perfil 2 ---");
        System.out.println("   Contraste Ativado: " + contraste);
        System.out.println("   Tamanho da Fonte: " + tamanhoFonte);
        System.out.println("   Leitor de Telas: " + (leitorDeTelas == 0 ? "Desligado" : (leitorDeTelas == 1 ? "Básico" : "Completo")));
        System.out.println("   Animações Ativadas: " + animacoes);
        System.out.println("----------------------------------------------");
    }
}

// Interface Builder
interface Builder {
    void reset();
    void buildContraste(boolean contraste);
    void buildTamanhoFonte(int tamanhoFonte);
    void buildLeitorDeTelas(int leitorDeTelas);
    void buildAnimacoes(boolean animacoes);

    ConfiguracaoAcessibilidade getResult();
}

// Builder Concreto 1
class PerfilAcessibilidade1 implements Builder {

    private ConfiguracaoAcessibilidade1 produto;

    public PerfilAcessibilidade1() {
        this.reset();
    }

    @Override
    public void reset() {
        System.out.println("  -> PerfilAcessibilidade1: Reiniciando processo de construção para Perfil 1.");
        this.produto = new ConfiguracaoAcessibilidade1();
    }

    @Override
    public void buildContraste(boolean contraste) {
        System.out.println("  -> PerfilAcessibilidade1: Definindo contraste para " + contraste + ".");
        this.produto.contraste = contraste;
    }

    @Override
    public void buildTamanhoFonte(int tamanhoFonte) {
        System.out.println("  -> PerfilAcessibilidade1: Definindo tamanho da fonte para " + tamanhoFonte + ".");
        this.produto.tamanhoFonte = tamanhoFonte;
    }

    @Override
    public void buildLeitorDeTelas(int leitorDeTelas) {
        System.out.println("  -> PerfilAcessibilidade1: Definindo leitor de telas para " + leitorDeTelas + ".");
        this.produto.leitorDeTelas = leitorDeTelas;
    }

    @Override
    public void buildAnimacoes(boolean animacoes) {
        System.out.println("  -> PerfilAcessibilidade1: Definindo animações para " + animacoes + ".");
        this.produto.animacoes = animacoes;
    }

    @Override
    public ConfiguracaoAcessibilidade getResult() {
        System.out.println("  -> PerfilAcessibilidade1: Retornando o produto ConfiguracaoAcessibilidade1 finalizado.");
        return this.produto;
    }
}

// Builder Concreto 2
class PerfilAcessibilidade2 implements Builder {

    private ConfiguracaoAcessibilidade2 produto;

    public PerfilAcessibilidade2() {
        this.reset();
    }

    @Override
    public void reset() {
        System.out.println("  -> PerfilAcessibilidade2: Reiniciando processo de construção para Perfil 2.");
        this.produto = new ConfiguracaoAcessibilidade2();
    }

    @Override
    public void buildContraste(boolean contraste) {
        System.out.println("  -> PerfilAcessibilidade2: Definindo contraste para " + contraste + ".");
        this.produto.contraste = contraste;
    }

    @Override
    public void buildTamanhoFonte(int tamanhoFonte) {
        System.out.println("  -> PerfilAcessibilidade2: Definindo tamanho da fonte para " + tamanhoFonte + ".");
        this.produto.tamanhoFonte = tamanhoFonte;
    }

    @Override
    public void buildLeitorDeTelas(int leitorDeTelas) {
        System.out.println("  -> PerfilAcessibilidade2: Definindo leitor de telas para " + leitorDeTelas + ".");
        this.produto.leitorDeTelas = leitorDeTelas;
    }

    @Override
    public void buildAnimacoes(boolean animacoes) {
        System.out.println("  -> PerfilAcessibilidade2: Definindo animações para " + animacoes + ".");
        this.produto.animacoes = animacoes;
    }

    @Override
    public ConfiguracaoAcessibilidade getResult() {
        System.out.println("  -> PerfilAcessibilidade2: Retornando o produto ConfiguracaoAcessibilidade2 finalizado.");
        return this.produto;
    }
}

// Diretor
class ConfigAcessibilidadeDirector {

    private Builder builder;

    public void setBuilder(Builder builder) {
        this.builder = builder;
        System.out.println("Director: Builder configurado.");
    }

    public void construirPerfilPadrao() {
        System.out.println("\nDirector: Iniciando construção do Perfil Padrão.");
        builder.reset();
        builder.buildContraste(true);
        builder.buildTamanhoFonte(18);
        builder.buildLeitorDeTelas(1);
        builder.buildAnimacoes(false);
        System.out.println("Director: Perfil Padrão concluído.");
    }

    public void construirPerfilMinimalista() {
        System.out.println("\nDirector: Iniciando construção do Perfil Minimalista.");
        builder.reset();
        builder.buildContraste(false);
        builder.buildTamanhoFonte(12);
        builder.buildLeitorDeTelas(0);
        builder.buildAnimacoes(true);
        System.out.println("Director: Perfil Minimalista concluído.");
    }
}

// Cliente (Main)
public class Main {
    public static void main(String[] args) {
        System.out.println("Cliente: Iniciando demonstração do padrão Builder para Acessibilidade.");

        System.out.println("\nCliente: Criando PerfilAcessibilidade1.");
        Builder builder1 = new PerfilAcessibilidade1();

        System.out.println("\nCliente: Criando PerfilAcessibilidade2.");
        Builder builder2 = new PerfilAcessibilidade2();

        System.out.println("\nCliente: Criando o Director.");
        ConfigAcessibilidadeDirector director = new ConfigAcessibilidadeDirector();

        // Cenário 1
        System.out.println("\n--- Cenário 1: Construindo Perfil Padrão com PerfilAcessibilidade1 ---");
        director.setBuilder(builder1);
        director.construirPerfilPadrao();
        ConfiguracaoAcessibilidade perfilPadrao1 = builder1.getResult();
        perfilPadrao1.displayConfig();

        // Cenário 2
        System.out.println("\n--- Cenário 2: Construindo Perfil Minimalista com PerfilAcessibilidade2 ---");
        director.setBuilder(builder2);
        director.construirPerfilMinimalista();
        ConfiguracaoAcessibilidade perfilMinimalista2 = builder2.getResult();
        perfilMinimalista2.displayConfig();

        // Cenário 3
        System.out.println("\n--- Cenário 3: Construindo Perfil Padrão com PerfilAcessibilidade2 ---");
        director.setBuilder(builder2);
        director.construirPerfilPadrao();
        ConfiguracaoAcessibilidade perfilPadrao2 = builder2.getResult();
        perfilPadrao2.displayConfig();
    }
}