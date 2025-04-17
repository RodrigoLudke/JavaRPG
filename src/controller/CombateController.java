package controller;

import model.Personagem;
import model.inimigos.Inimigos;

public class CombateController {
    public static void iniciarCombate(Personagem personagem, Inimigos inimigo, JogoController jogo) throws InterruptedException {
        System.out.println("Iniciando combate contra: " + inimigo.getNome());
        // Lógica de combate simplificada
        while (personagem.getEnergia() > 0 && inimigo.getEnergia() > 0) {
            int danoPersonagem = personagem.getHabilidade() - inimigo.getHabilidade();
            int danoInimigo = inimigo.getHabilidade() - personagem.getHabilidade();

            if (danoPersonagem > 0) {
                inimigo.setEnergia(inimigo.getEnergia() - danoPersonagem);
                System.out.println("Você causou " + danoPersonagem + " de dano ao inimigo!");
            }

            if (danoInimigo > 0) {
                personagem.setEnergia(personagem.getEnergia() - danoInimigo);
                System.out.println("O inimigo causou " + danoInimigo + " de dano a você!");
            }

            System.out.println("Sua Energia: " + personagem.getEnergia());
            System.out.println("Energia do Inimigo: " + inimigo.getEnergia());
        }

        if (personagem.getEnergia() <= 0) {
            System.out.println("Você foi derrotado...");
        } else if (inimigo.getEnergia() <= 0) {
            System.out.println("Você derrotou o inimigo!");
        }
    }
}