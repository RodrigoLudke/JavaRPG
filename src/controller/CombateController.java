package controller;

import model.Personagem;
import model.inimigos.Inimigos;
import view.TelaCombate;

public class CombateController {

    public static void iniciarCombate(Personagem personagem, Inimigos inimigo, JogoController jogo) throws InterruptedException {
        if (personagem.getEnergia() <= 0) {
            System.out.println("Você não tem energia suficiente para lutar!");
            return;
        }
        if (inimigo.getEnergia() <= 0) {
            System.out.println("O inimigo já foi derrotado!");
            return;
        }

        System.out.println("O combate começou!");

        while (personagem.getEnergia() > 0 && inimigo.getEnergia() > 0) {
            // Turno do jogador
            int escolha = TelaCombate.mostrarOpcoes(personagem, inimigo);
            switch (escolha) {
                case 1: // Atacar
                    int danoPersonagem = Math.max(0, personagem.getHabilidade() - inimigo.getHabilidade());
                    inimigo.setEnergia(inimigo.getEnergia() - danoPersonagem);
                    System.out.println("Você causou " + danoPersonagem + " de dano ao inimigo!");
                    break;

                case 2: // Acessar inventário
                    TelaCombate.abrirInventario(personagem, jogo);
                    continue;

                case 3: // Fugir
                    System.out.println("Você fugiu do combate!");
                    return;

                default:
                    System.out.println("Opção inválida!");
                    continue;
            }

            // Verificar se o inimigo foi derrotado
            if (inimigo.getEnergia() <= 0) {
                System.out.println("Você derrotou o inimigo!");
                return;
            }

            // Turno do inimigo
            int danoInimigo = Math.max(0, inimigo.getHabilidade() - personagem.getHabilidade());
            personagem.setEnergia(personagem.getEnergia() - danoInimigo);
            System.out.println("O inimigo causou " + danoInimigo + " de dano a você!");

            // Verificar se o jogador foi derrotado
            if (personagem.getEnergia() <= 0) {
                System.out.println("Você foi derrotado...");
                return;
            }
        }
    }
}