package view;

import model.EstadoJogo;
import model.Personagem;
import model.itens.Itens;
import model.missoes.*;
import view.utils.TextoAnimado;
import controller.JogoController;

import java.util.List;
import java.util.Scanner;

import static view.TelaInicial.mostrarMenu;
import static view.utils.Cores.*;

public class TelaInventario {
    public static void configurarPersonagem(Personagem p, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);


        // Aqui você implementa a lógica de distribuir pontos de HABILIDADE, ENERGIA, SORTE
        System.out.println("Distribua 12 pontos entre Habilidade (min 6), Energia (min 12), e Sorte (min 6):");
        int pontos = 12;
        // input e validações

        //Habilidades
        System.out.println("Habilidades:");
        int HabilidadeBase = 6;
        int valorH = sc.nextInt();
        while (valorH > pontos || valorH < 0) {
            System.out.println("Valor inválido! Deve ser no mínimo 6 e no máximo " + pontos + ".");
            valorH = sc.nextInt();
        }
        ;
        pontos -= valorH;
        HabilidadeBase += valorH;

        // Energia
        System.out.println("Energia:");
        int EnergiaBase = 12;
        int valorE = sc.nextInt();
        while (valorE < 0 || valorE > pontos) {
            System.out.println("Valor inválido! Deve ser no mínimo 12 e no máximo " + pontos + ".");
            valorE = sc.nextInt();
        }
        pontos -= valorE;
        EnergiaBase += valorE;

        // Sorte
        System.out.println("Sorte:");
        int SorteBase = 6;
        int valorS = sc.nextInt();
        while (valorS < 0 || valorS > pontos) {
            System.out.println("Valor inválido! Deve ser no mínimo 6 e no máximo " + pontos + ".");
            valorS = sc.nextInt();
        }
        SorteBase += valorS;

        // Aqui você poderia setar os valores no objeto `Personagem`
        p.setHabilidade(HabilidadeBase);
        p.setEnergia(EnergiaBase);
        p.setSorte(SorteBase);

        System.out.println("\nResumo:");
        System.out.printf("Habilidade: %d | Energia: %d | Sorte: %d\n", HabilidadeBase, EnergiaBase, SorteBase);
        System.out.println();

        jogo.jogoPadrao();

    }
    // Aqui você pode implementar a lógica para abrir o inventário in game

    public static void abrirInventario(Personagem personagem, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Inventário ===");
        System.out.println(ROXO + "Habilidade: " + personagem.getHabilidade() + RESET);
        System.out.println(CIANO + "Energia: " + personagem.getEnergia() + RESET);
        System.out.println(AZUL + "Sorte: " + personagem.getSorte() + RESET);

        System.out.println();

        System.out.println("1 - Voltar para o Jogo");
        System.out.println("2 - Salvar Jogo");
        System.out.println("3 - Sair para o Menu Principal");
        System.out.println("4 - Sair do Jogo");
        int opcao = sc.nextInt();

        while (opcao != 4) {
            switch (opcao) {
                case 1:
                    System.out.println("Voltando para o jogo...");
                    if (jogo.carregarJogo()) {
                        jogo.acessarInventarioExploracao();
                    }
                    return;

                case 2:
                    System.out.println("Salvando jogo...");
                    jogo.salvarJogo();
                    jogo.acessarInventario();

                    return;

                case 3:
                    System.out.println("Voltando para o Menu Principal...");
                    mostrarMenu();
                    return;

                default:
                    System.out.println(VERMELHO + "Opção inválida, tente novamente!" + RESET);
                    abrirInventario(personagem, jogo);
                    return;
            }

        }
        sc.close();
    }

    public static void abrirInventarioCombate(Personagem personagem, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=== Inventário ===");
            System.out.println("Item equipado: " + (personagem.getItemEquipado() != null ? personagem.getItemEquipado().getNome() : "Nenhum"));
            System.out.println("Habilidade: " + personagem.getHabilidade());
            System.out.println("Energia: " + personagem.getEnergia());
            System.out.println("Sorte: " + personagem.getSorte());
            System.out.println();

            List<Itens> inventario = personagem.getInventario();
            if (inventario.isEmpty()) {
                System.out.println("Seu inventário está vazio.");
            } else {
                for (int i = 0; i < inventario.size(); i++) {
                    Itens item = inventario.get(i);
                    System.out.println((i + 1) + " - " + item.getNome() + (item.isEquipado() ? " (Equipado)" : ""));
                }
            }

            System.out.println("0 - Voltar ao jogo");
            System.out.print("Escolha um item para usar ou 0 para sair: ");
            int escolha = sc.nextInt();

            if (escolha == 0) {
                System.out.println("Voltando ao jogo...");
                return;
            }

            if (escolha > 0 && escolha <= inventario.size()) {
                Itens itemSelecionado = inventario.get(escolha - 1);

                if (itemSelecionado.getTipo().equals("Cura")) {
                    // Exemplo: Usar o Kit Médico para curar
                    int cura = 10; // Valor de cura pode ser ajustado
                    personagem.setEnergia(personagem.getEnergia() + cura);
                    System.out.println("Você usou " + itemSelecionado.getNome() + " e recuperou " + cura + " de energia!");
                    inventario.remove(itemSelecionado); // Remove o item após o uso, se necessário
                } else if (itemSelecionado.getTipo().equals("Arma")) {
                    // Exemplo: Equipar a arma
                    if (!itemSelecionado.isEquipado()) {
                        personagem.equiparItem(itemSelecionado);
                        itemSelecionado.setEquipado(true);
                        System.out.println("Você equipou " + itemSelecionado.getNome() + "!");
                    } else {
                        System.out.println(itemSelecionado.getNome() + " já está equipado.");
                    }
                } else if (itemSelecionado.getTipo().equals("Acessorio")) {
                    // Exemplo: Equipar o acessório
                    if (!itemSelecionado.isEquipado()) {
                        personagem.equiparItem(itemSelecionado);
                        itemSelecionado.setEquipado(true);
                        System.out.println("Você equipou " + itemSelecionado.getNome() + "!");
                    } else {
                        System.out.println(itemSelecionado.getNome() + " já está equipado.");
                    }
                } else {
                    System.out.println("Este item não pode ser usado.");
                }
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    public static void abrirInventarioExploracao(Personagem personagem, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Inventário ===");
        System.out.println("Item equipado: " + (personagem.getItemEquipado() != null ? personagem.getItemEquipado().getNome() : "Nenhum"));
        System.out.println("Habilidade: " + personagem.getHabilidade());
        System.out.println("Energia: " + personagem.getEnergia());
        System.out.println("Sorte: " + personagem.getSorte());
        System.out.println();

        List<Itens> inventario = personagem.getInventario();
        if (inventario.isEmpty()) {
            System.out.println("Seu inventário está vazio.");
        } else {
            for (int i = 0; i < inventario.size(); i++) {
                Itens item = inventario.get(i);
                System.out.println((i + 1) + " - " + item.getNome() + (item.isEquipado() ? " (Equipado)" : ""));
            }
        }

        System.out.println("0 - Voltar ao jogo");
        System.out.println("S - Salvar Jogo");
        System.out.print("Escolha um item para usar ou 0 para sair: ");
        String escolha = sc.next();

        if (escolha.equals("0")) {
            System.out.println("Voltando ao jogo...");
            voltarParaTelaAnterior(jogo, personagem);
            return;
        }

        if (escolha.equalsIgnoreCase("S")) {
            System.out.println("Salvando jogo...");
            jogo.salvarJogo();
            abrirInventarioExploracao(personagem, jogo);
            return;
        }

        try {
            int escolhaInt = Integer.parseInt(escolha);
            if (escolhaInt > 0 && escolhaInt <= inventario.size()) {
                Itens itemSelecionado = inventario.get(escolhaInt - 1);

                if (itemSelecionado.getTipo().equals("Cura")) {
                    int cura = 10; // Valor de cura pode ser ajustado
                    personagem.setEnergia(personagem.getEnergia() + cura);
                    System.out.println("Você usou " + itemSelecionado.getNome() + " e recuperou " + cura + " de energia!");
                    inventario.remove(itemSelecionado);
                } else if (itemSelecionado.getTipo().equals("Arma")) {
                    if (!itemSelecionado.isEquipado()) {
                        personagem.equiparItem(itemSelecionado);
                        itemSelecionado.setEquipado(true);
                        System.out.println("Você equipou " + itemSelecionado.getNome() + "!");
                    }
                }
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida! Tente novamente.");
        }
    }

    private static void voltarParaTelaAnterior(JogoController jogo, Personagem personagem) throws InterruptedException {
        String estadoAtual = jogo.getEstadoAtual();
        MissaoDentesDeOuro missao = new MissaoDentesDeOuro();

        switch (estadoAtual) {
            case "Início do jogo" -> {
                jogo.iniciarJogo();
            }
            case "MissaoDentesDeOuro_Escolha1" -> missao.mostrarEscolhaInicial(personagem, jogo);
            case "MissaoDentesDeOuro_FugirLateral",
                 "MissaoDentesDeOuro_EncararMaelstrom",
                 "MissaoDentesDeOuro_NegociarChromejaw" -> missao.mostrarEscolhasFinais(personagem, jogo, estadoAtual);
            case "MissaoDentesDeOuro_AbrirContainer" -> {
                Missoes abrir = new AbrirContainer();
                abrir.executar(personagem, jogo);
            }
            case "MissaoDentesDeOuro_SeguirEntrega" -> {
                Missoes seguir = new Seguir();
                seguir.executar(personagem, jogo);
            }
            case "MissaoDentesDeOuro_ContatarFixador" -> {
                Missoes contato = new Contato();
                contato.executar(personagem, jogo);
            }
            case null -> {
                System.out.println("Estado não encontrado. Voltando ao menu principal.");
                TelaInicial.mostrarMenu();
            }
            default -> {
                System.out.println("Estado desconhecido: " + estadoAtual + ". Voltando ao menu principal.");
                TelaInicial.mostrarMenu();
            }
        }
    }
}