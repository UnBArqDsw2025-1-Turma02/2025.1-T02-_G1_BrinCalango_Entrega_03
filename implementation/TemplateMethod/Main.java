import entity.*;

public class Main {
    public static void main(String[] args) {
        TrilhaTeoria trilha1 = new TrilhaTeoriaPadrao();
        trilha1.carregarTeoria("Capítulo 1");

        System.out.println("-----------");

        TrilhaTeoria trilha2 = new TrilhaTeoriaInclusiva();
        trilha2.carregarTeoria("Capítulo 2");
    }
}