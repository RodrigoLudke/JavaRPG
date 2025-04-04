package view;

import controller.JogoController;
import java.util.Scanner;

public class TelaInicial {
    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Novo Jogo");
        System.out.println("2 - Carregar Jogo");
        System.out.println("3 - Créditos");
        System.out.println("4 - Sair");
        int opcao = sc.nextInt();

        JogoController jogo = new JogoController();
        if (opcao == 1) {
            System.out.println("Digite o nome do personagem:");
            String nome = sc.next();
            jogo.novoJogo(nome);
        }
    }
}
