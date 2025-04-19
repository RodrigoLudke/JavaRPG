package controller;

import model.Personagem;
import model.hacks.Hacks;
import model.inimigos.Inimigos;
import model.itens.Itens;
import view.TelaCombate;

import java.util.List;
import java.util.Scanner;

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
                    realizarAtaque(personagem, inimigo);
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

    private static void realizarAtaque(Personagem personagem, Inimigos inimigo) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha seu ataque:");
        int opcao = 1;

        // Exibir item equipado
        Itens itemEquipado = personagem.getItemEquipado();
        if (itemEquipado != null && itemEquipado.isPodeUsarEmCombate()) {
            System.out.println(opcao + " - Atacar com " + itemEquipado.getNome() + " (Dano: " + itemEquipado.getBonusDano() + ")");
            opcao++;
        }

        // Exibir hacks disponíveis
        List<Hacks> hacks = personagem.getHacks();
        for (Hacks hack : hacks) {
            if (hack.isPodeUsarEmCombate()) {
                System.out.println(opcao + " - Usar hack " + hack.getNome() + " (Dano: " + hack.getBonusDano() + ")");
                opcao++;
            }
        }

        int escolha = sc.nextInt();
        opcao = 1;

        // Aplicar dano com o item equipado
        if (itemEquipado != null && itemEquipado.isPodeUsarEmCombate() && escolha == opcao) {
            int dano = Math.max(0, itemEquipado.getBonusDano() + personagem.getHabilidade() - inimigo.getHabilidade());
            inimigo.setEnergia(inimigo.getEnergia() - dano);
            System.out.println("Você atacou com " + itemEquipado.getNome() + " e causou " + dano + " de dano!");
            return;
        }
        opcao++;

        // Aplicar dano com o hack escolhido
        for (Hacks hack : hacks) {
            if (hack.isPodeUsarEmCombate() && escolha == opcao) {
                int dano = Math.max(0, hack.getBonusDano() + personagem.getHabilidade() - inimigo.getHabilidade());
                inimigo.setEnergia(inimigo.getEnergia() - dano);
                System.out.println("Você usou o hack " + hack.getNome() + " e causou " + dano + " de dano!");
                return;
            }
            opcao++;
        }

        System.out.println("Opção inválida!");
    }
}