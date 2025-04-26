package view.utils;

public class ApagarConsole {
    public static void limparConsole() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            str.append("\n");
        }
        System.out.print(str.toString());
    }
}