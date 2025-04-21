package view;

import model.Personagem;
import model.inimigos.Inimigos;
import controller.JogoController;

import java.util.List;
import java.util.Scanner;

public class TelaCombate {

    public static int mostrarOpcoes(Personagem personagem, Inimigos inimigo) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nSua energia: " + personagem.getEnergia());
        System.out.println("Energia do inimigo: " + inimigo.getEnergia());
        System.out.println("Escolha uma ação:");
        System.out.println("1 - Atacar");
        System.out.println("2 - Acessar Inventário");
        System.out.println("3 - Fugir");

        return sc.nextInt();
    }
    public static int mostrarOpcoesInimigos(Personagem personagem, List<Inimigos> inimigos) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nSua energia: " + personagem.getEnergia());
        System.out.println("Inimigos:");
        for (Inimigos inimigoAtual : inimigos) {
            System.out.println("- " + inimigoAtual.getNome() + " (Energia: " + inimigoAtual.getEnergia() + ")");
        }
        System.out.println("Escolha uma ação:");
        System.out.println("1 - Atacar");
        System.out.println("2 - Acessar Inventário");
        System.out.println("3 - Fugir");

        return sc.nextInt();
    }


    public static void abrirInventario(Personagem personagem, JogoController jogo) throws InterruptedException {
        System.out.println("Abrindo o inventário...");
        TelaInventario.abrirInventarioCombate(personagem, jogo);
    }
}