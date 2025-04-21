package controller;

import model.Personagem;
import model.hacks.Hacks;
import model.inimigos.Inimigos;
import model.itens.Itens;
import view.TelaCombate;

import java.util.List;
import java.util.Random;
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
            turnoInimigo(inimigo, personagem);

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
            // Calcular chance de acerto
            int chanceBase = 70; // Chance base de 70%
            int modificadorHabilidade = personagem.getHabilidade() - inimigo.getHabilidade();
            int chanceFinal = chanceBase + modificadorHabilidade + itemEquipado.getBonusFA();

            // Gerar número aleatório para determinar acerto
            int resultado = (int) (Math.random() * 100);
            if (resultado < chanceFinal) {
                int dano = Math.max(0, itemEquipado.getBonusDano() + personagem.getHabilidade() - inimigo.getHabilidade());
                inimigo.setEnergia(inimigo.getEnergia() - dano);
                System.out.println("Você atacou com " + itemEquipado.getNome() + " e causou " + dano + " de dano!");
            } else {
                System.out.println("Você atacou com " + itemEquipado.getNome() + ", mas errou o ataque!");
            }
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
    private static void turnoInimigo(Inimigos inimigo, Personagem personagem) {
        Random random = new Random();
        boolean podeCurar = inimigo.getInventario().stream()
                .anyMatch(item -> item.getTipo().equalsIgnoreCase("Cura"));

        boolean vaiAtacar = !podeCurar || random.nextBoolean(); // Ataca se não puder curar ou decide aleatoriamente


        if (vaiAtacar) {
            realizarAtaqueInimigo(inimigo, personagem);
        } else {
            tentarCurarInimigo(inimigo);
        }
    }

    private static void realizarAtaqueInimigo(Inimigos inimigo, Personagem personagem) {
        Random random = new Random();
        boolean usarHack = !inimigo.getHacks().isEmpty() && random.nextBoolean(); // Decide aleatoriamente se vai usar hack ou arma

        if (usarHack) {
            Hacks hack = inimigo.getHacks().get(random.nextInt(inimigo.getHacks().size())); // Seleciona um hack aleatório
            int dano = Math.max(0, hack.getBonusDano() + inimigo.getHabilidade() - personagem.getHabilidade());
            personagem.setEnergia(personagem.getEnergia() - dano);
            System.out.println("O inimigo usou o hack " + hack.getNome() + " e causou " + dano + " de dano!");
        } else {
            // Verifica se o inimigo já tem uma arma equipada
            Itens armaEquipada = inimigo.getItemEquipado();

            if (armaEquipada != null && armaEquipada.isPodeUsarEmCombate()) {
                // Usa a arma equipada
                int dano = Math.max(0, armaEquipada.getBonusDano() + inimigo.getHabilidade() - personagem.getHabilidade());
                personagem.setEnergia(personagem.getEnergia() - dano);
                System.out.println("O inimigo atacou com " + armaEquipada.getNome() + " e causou " + dano + " de dano!");
            } else {
                // Seleciona uma arma válida do inventário
                armaEquipada = inimigo.getInventario().stream()
                        .filter(item -> item.isPodeUsarEmCombate())
                        .findFirst()
                        .orElse(null);

                if (armaEquipada != null) {
                    int dano = Math.max(0, armaEquipada.getBonusDano() + inimigo.getHabilidade() - personagem.getHabilidade());
                    personagem.setEnergia(personagem.getEnergia() - dano);
                    System.out.println("O inimigo atacou com " + armaEquipada.getNome() + " e causou " + dano + " de dano!");
                } else {
                    System.out.println("O inimigo tentou atacar, mas não possui arma ou hack utilizável!");
                }
            }
        }
    }

    private static void tentarCurarInimigo(Inimigos inimigo) {
        Itens kitMedico = inimigo.getInventario().stream()
                .filter(item -> item.getTipo().equalsIgnoreCase("Cura"))
                .findFirst()
                .orElse(null);

        if (kitMedico != null) {
            inimigo.setEnergia(inimigo.getEnergia() + 10); // Recupera 10 de energia
            inimigo.getInventario().remove(kitMedico); // Remove o kit médico do inventário
            System.out.println("O inimigo usou um Kit Médico e recuperou 10 de energia!");
        } else {
            System.out.println("O inimigo tentou se curar, mas não possui um Kit Médico!");
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////


    public static void iniciarCombateComVarios(Personagem personagem, List<Inimigos> inimigos, JogoController jogo) throws InterruptedException {
        if (personagem.getEnergia() <= 0) {
            System.out.println("Você não tem energia suficiente para lutar!");
            return;
        }

        System.out.println("O combate contra múltiplos inimigos começou!");
        for (Inimigos inimigo : inimigos) {
            System.out.println("- " + inimigo.getNome() + " (Energia: " + inimigo.getEnergia() + ")");
        }

        while (personagem.getEnergia() > 0 && !inimigos.isEmpty()) {

            Scanner sc = new Scanner(System.in);
            int escolha = TelaCombate.mostrarOpcoesInimigos(personagem, inimigos);

            switch (escolha) {
                case 1: // Atacar
                    System.out.println("Escolha um inimigo para atacar:");
                    for (int i = 0; i < inimigos.size(); i++) {
                        System.out.println((i + 1) + " - " + inimigos.get(i).getNome() + " (Energia: " + inimigos.get(i).getEnergia() + ")");
                    }
                    int alvo = sc.nextInt() - 1;

                    if (alvo >= 0 && alvo < inimigos.size()) {
                        Inimigos inimigo = inimigos.get(alvo);
                        realizarAtaque(personagem, inimigo);

                        if (inimigo.getEnergia() <= 0) {
                            System.out.println("Você derrotou " + inimigo.getNome() + "!");
                            inimigos.remove(inimigo);
                        }
                    } else {
                        System.out.println("Escolha inválida.");
                    }
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

            // Turno dos inimigos
            for (Inimigos inimigo : inimigos) {
                if (inimigo.getEnergia() > 0) {
                    turnoInimigo(inimigo, personagem);
                }
            }

            // Verificar se o jogador foi derrotado
            if (personagem.getEnergia() <= 0) {
                System.out.println("Você foi derrotado...");
                return;
            }
        }

        if (inimigos.isEmpty()) {
            System.out.println("Você derrotou todos os inimigos!");
        }
    }
}