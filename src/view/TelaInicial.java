package view;

import java.util.concurrent.TimeUnit;
import model.Personagem;
import view.utils.TextoAnimado;
import controller.JogoController;
import java.util.Scanner;
import static view.utils.Cores.*;


public class TelaInicial {

    public static void mostrarMenu() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Novo Jogo");
        System.out.println("2 - Carregar Jogo");
        System.out.println("3 - Créditos");
        System.out.println("4 - Sair");
        int opcao = sc.nextInt();
        JogoController jogo = new JogoController();


        while (opcao != 4) {
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do personagem:");
                    String nome = sc.next();
                    Personagem p = new Personagem(nome);

                    jogo.novoJogo(nome);
                    return;
                case 2:
                    System.out.println("Carregando jogo...");
                    if (jogo.carregarJogo(true)) {
                        ;
                        jogo.acessarInventario();
                    }
                    return;

                case 3:
                    System.out.println(VERDE + "--- Créditos ---");
                    System.out.println("Desenvolvedores:");
                    System.out.println( " - Ana Julia Teixeira de Melo");
                    System.out.println( " - Rodrigo S. Ludke");
                    System.out.println( "----------------" + RESET);
                    mostrarMenu();
                    return;

                default:
                    System.out.println(VERMELHO + "Opção inválida, tente novamente!" + RESET);
                    mostrarMenu();
                    return;
            }

        }
        sc.close();
        System.out.println(AMARELO + "Saindo...");


    }

}



