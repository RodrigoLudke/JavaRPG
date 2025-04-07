package view;

import java.util.concurrent.TimeUnit;
import view.utils.TextoAnimado;
import controller.JogoController;
import java.util.Scanner;

public class TelaInicial {

    public static void mostrarMenu() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Novo Jogo");
        System.out.println("2 - Carregar Jogo");
        System.out.println("3 - Créditos");
        System.out.println("4 - Sair");
        int opcao = sc.nextInt();

        JogoController jogo = new JogoController();
        if (opcao == 1) {
            String introducao = " Night City — uma metrópole brilhante e decadente cravada na costa da Califórnia do Norte. Governada por megacorporações e assolada pela desigualdade, a cidade pulsa com neon, violência e tecnologia. Seus arranha-céus tocam os céus, enquanto os becos fervilham de gangues, mercenários e inteligências artificiais fora de controle. É um lugar onde tudo está à venda — desde memórias até corpos modificados com cromo. Em Night City, o sonho americano virou um pesadelo digital. Mas para muitos, ainda é o único lugar onde vale a pena lutar por um futuro — ou morrer tentando. ";
            TextoAnimado.escrever(introducao);
            System.out.println();

            System.out.println("Digite o nome do personagem:");
            String nome = sc.next();
            jogo.novoJogo(nome);
        }
    }
}
