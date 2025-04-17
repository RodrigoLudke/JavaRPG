package view;

import controller.JogoController;
import model.Personagem;
import model.inimigos.Inimigos;

import java.util.Scanner;

public class TelaCombate {
    public static void combate(Personagem personagem, Inimigos inimigo, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Você encontrou um inimigo: " + inimigo.getNome());
        System.out.println("Habilidade: " + inimigo.getHabilidade());
        System.out.println("Energia: " + inimigo.getEnergia());

        while (personagem.getEnergia() > 0 && inimigo.getEnergia() > 0) {
            System.out.println("\nEscolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Defender");
            System.out.println("3 - Fugir");
            int escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    int danoPersonagem = personagem.getHabilidade() - inimigo.getHabilidade();
                    int danoInimigo = inimigo.getHabilidade() - personagem.getHabilidade();

                    if (danoPersonagem > 0) {
                        inimigo.setEnergia(inimigo.getEnergia() - danoPersonagem);
                        System.out.println("Você causou " + danoPersonagem + " de dano ao inimigo!");
                    } else {
                        System.out.println("Seu ataque não foi eficaz.");
                    }

                    if (danoInimigo > 0) {
                        personagem.setEnergia(personagem.getEnergia() - danoInimigo);
                        System.out.println("O inimigo causou " + danoInimigo + " de dano a você!");
                    } else {
                        System.out.println("O ataque do inimigo não foi eficaz.");
                    }
                    break;

                case 2:
                    System.out.println("Você se defendeu e reduziu o dano do próximo ataque!");
                    personagem.setEnergia(personagem.getEnergia() - Math.max(0, (inimigo.getHabilidade() / 2)));
                    break;

                case 3:
                    System.out.println("Você fugiu do combate!");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println("\nStatus Atual:");
            System.out.println("Sua Energia: " + personagem.getEnergia());
            System.out.println("Energia do Inimigo: " + inimigo.getEnergia());
        }

        if (personagem.getEnergia() <= 0) {
            System.out.println("Você foi derrotado...");
            jogo.salvarJogo(); // Opcional: salvar o estado do jogo antes de encerrar
        } else if (inimigo.getEnergia() <= 0) {
            System.out.println("Você derrotou o inimigo!");
        }
    }
}