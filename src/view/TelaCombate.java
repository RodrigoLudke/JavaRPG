package view;

import model.Personagem;
import view.utils.TextoAnimado;
import controller.JogoController;

import java.util.Scanner;

import static view.TelaInicial.mostrarMenu;
import static view.utils.Cores.*;
import static view.utils.Cores.RESET;

public class TelaCombate {
    public static void combate(Personagem p, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println(VERDE + "Você se depara com um inimigo!" + RESET);
        System.out.println("Escolha uma ação:");
        System.out.println("1 - Atacar");
        System.out.println("2 - Defender");
        System.out.println("3 - Fugir");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                System.out.println(VERDE + "Você atacou o inimigo!" + RESET);
                // Lógica de ataque
                break;
            case 2:
                System.out.println(VERDE + "Você se defendeu!" + RESET);
                // Lógica de defesa
                break;
            case 3:
                System.out.println(VERDE + "Você fugiu do combate!" + RESET);
                // Lógica de fuga
                break;
            default:
                System.out.println(VERMELHO + "Opção inválida, tente novamente!" + RESET);
                combate(p, jogo);
                break;
        }
    }
}
