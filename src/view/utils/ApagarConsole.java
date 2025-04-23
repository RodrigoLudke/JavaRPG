package view.utils;

public class ApagarConsole {
    public static void limparConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            for (int i = 0; i < 100; i++) System.out.println();
            System.out.println("Erro ao limpar o console: " + e.getMessage());
        }
    }
}
