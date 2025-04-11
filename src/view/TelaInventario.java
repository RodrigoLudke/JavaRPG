package view;

import model.Personagem;
import view.utils.TextoAnimado;
import controller.JogoController;
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

        System.out.println("Inventário:");
        System.out.println(ROXO + "Habilidade: " + personagem.getHabilidade() + RESET);
        System.out.println(CIANO +"Energia: " + personagem.getEnergia() + RESET);
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
                    jogo.jogoBase();
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
                    return;
            }

        }
        sc.close();
    }
}


