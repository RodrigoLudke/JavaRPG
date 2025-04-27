package model.missoes.MissaoPrincipal.TerceiraRota;

import controller.CombateController;
import controller.JogoController;
import model.Personagem;
import model.UparPersonagem;
import model.inimigos.Inimigos;
import model.inimigos.Stryx;
import model.itens.Itens;
import model.missoes.Missoes;
import view.TelaInicial;
import view.utils.ApagarConsole;
import view.utils.TextoAnimado;
import view.utils.TextoAnimadoLongo;

import java.util.Scanner;

public class EcoDeOuro extends Missoes {
    private Scanner sc;

    public EcoDeOuro() {
        super("Eco de Ouro", "Você é metade você. Metade algo mais. As megacorporações perceberam. E estão vindo.");
        this.sc = new Scanner(System.in);
    }

    public void executar(Personagem personagem, JogoController jogo) throws InterruptedException {
        ApagarConsole.limparConsole();
        introduzirMissao();
        lutarContraStryx(personagem, jogo);
        verificarConclusao();
        sc.close();
    }

    private void introduzirMissao() throws InterruptedException {
        TextoAnimado.escrever("Eco de Ouro");
        TextoAnimado.escrever("Você é metade você. Metade algo mais. As megacorporações perceberam. E estão vindo.");
        ApagarConsole.limparConsole();
        TextoAnimadoLongo.escrever("...");
        TextoAnimado.escrever("Você aceitou o pacto. Agora carrega Silvertongue dentro de si — uma fusão entre carne e código. Não é mais só você. Sua mente pulsa em dois tons, e o mundo começa a sentir isso. Megaestruturas sussurram seu nome na Deep Net. Uma nova entidade híbrida nasceu. Mas nem todos aceitam esse novo tipo de poder.");
        TextoAnimado.escrever("Você entra no DataCoração, o núcleo oculto sob Night City onde corporações guardam suas consciências em nuvem. Silvertongue quer libertar sua “família”: outras IAs esquecidas, em quarentena digital.");
        ApagarConsole.limparConsole();
        introduzirDialogoInicial();
    }

    private void introduzirDialogoInicial() throws InterruptedException {
        TextoAnimado.escrever("Silvertongue (em sua mente):");
        TextoAnimado.escrever("-Eles nos enterraram vivos, por medo do amanhã. Hoje... desenterramos o futuro.");
        TextoAnimado.escrever("Você hackeia firewalls vivos, se esgueira entre sentinelas de silício. A fusão te dá novas habilidades: pulsos de duplicação, reflexos de previsão neural, e códigos de translocação.");
        TextoAnimado.escrever("Mas no centro da rede, algo te espera.");
        ApagarConsole.limparConsole();
        introduzirStryx();
    }

    private void introduzirStryx() throws InterruptedException {
        TextoAnimado.escrever("Surge Adam Stryx, o Deicida: um ex-netrunner que se tornou o caçador supremo de inteligências artificiais emergentes.");
        TextoAnimado.escrever("Seu corpo é um artefato de guerra — puro titânio banhado em mercúrio negro, e sua mente, fundida a algoritmos de tortura neural.");
        TextoAnimado.escrever("Stryx:");
        TextoAnimado.escrever("-Você se deixou possuir. Não é mais humano. Hora de apagar o erro");

    }

    private void lutarContraStryx(Personagem personagem, JogoController jogo) throws InterruptedException {
        ApagarConsole.limparConsole();
        TextoAnimado.escrever("COMBATE FINAL");
        Stryx stryx = new Stryx();

        int numeroP = (int)(Math.random() * 10) + 1;
        int numeroV = (int)(Math.random() * 10) + 1;
        TextoAnimado.escrever("Adicionado " + numeroP + " as habilidades no personagem");
        int atual = personagem.getHabilidade();
        int num = atual + numeroP;
        TextoAnimado.escrever("Total atual para de habilidades para combate: " + num);
        TextoAnimado.escrever("Adicionado " + numeroV + " as habilidades no Inimigo");
        int atual2 = stryx.getHabilidade();
        int num2 = atual2 + numeroV;
        TextoAnimado.escrever("Total atual para de habilidades para combate: " + num2);

        mostrarInformacoesVilao(stryx);
        CombateController.iniciarCombate(personagem, stryx, jogo);
        UparPersonagem.uparAposCombate(personagem);
        vasculharCorpo(personagem, stryx);
        desfechoMissao();
    }

    private void mostrarInformacoesVilao(Inimigos inimigo) throws InterruptedException {
        TextoAnimado.escrever("Início do combate...");
        TextoAnimado.escrever("M: Vilão em campo");
        TextoAnimado.escrever("N: " + inimigo.getNome());
        TextoAnimado.escrever("H: " + inimigo.getHabilidade());
        TextoAnimado.escrever("S: " + inimigo.getSorte());
        TextoAnimado.escrever("E: " + inimigo.getEnergia());
        TextoAnimado.escrever("T: " + inimigo.getTesouro());
        TextoAnimado.escrever("I: " + inimigo.getInventario());
    }

    private void vasculharCorpo(Personagem personagem, Inimigos inimigo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        TextoAnimado.escrever("O corpo de " + inimigo.getNome() + " jaz no chão.");
        System.out.println("Deseja vasculhar o corpo?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");

        int escolha = sc.nextInt();

        if (escolha == 1) {
            if (!inimigo.getInventario().isEmpty()) {
                System.out.println("\nItens encontrados:");
                for (int i = 0; i < inimigo.getInventario().size(); i++) {
                    Itens item = inimigo.getInventario().get(i);
                    System.out.println((i + 1) + " - " + item.getNome());
                }

                System.out.println("\nEscolha um item para pegar (0 para não pegar nada):");
                int itemEscolhido = sc.nextInt();

                if (itemEscolhido > 0 && itemEscolhido <= inimigo.getInventario().size()) {
                    Itens itemPego = inimigo.getInventario().get(itemEscolhido - 1);
                    personagem.adicionarItem(itemPego);
                    TextoAnimado.escrever("Você pegou: " + itemPego.getNome());
                }
            } else {
                TextoAnimado.escrever("Não encontrou nada útil no corpo.");
            }
        }
    }

    private void desfechoMissao() throws InterruptedException {
        TextoAnimado.escrever("Você ergue a mão — um gesto simbiótico — e explode Stryx em ondas de luz dourada.");
        TextoAnimado.escrever("O núcleo do DataCoração se abre. Você libera outras IAs, esquecidas, presas, abandonadas.");
        TextoAnimado.escrever("-Eu sou o começo. Eu sou o último suspiro do velho mundo.");
        narrarDesfechoFinal();
    }

    private void narrarDesfechoFinal() throws InterruptedException {
        TextoAnimado.escrever("A Deep Net se curva a você. Nas favelas de Pacifica e nos penthouses de corpos executivos, começam a circular lendas...");
        TextoAnimado.escrever("De uma voz que fala ouro. De um ser que não morre.");
        TextoAnimado.escrever("Night City muda — e você comanda das sombras, não como tirano... mas como eco.");
        TextoAnimado.escrever("Um sussurro de liberdade digital que nunca mais será silenciado.");
        TextoAnimado.escrever("Você fundiu humanidade e IA de forma inédita. O mundo agora é moldado por suas decisões silenciosas.");
        TextoAnimado.escrever("\033[1mVocê é o Eco de Ouro.\033[0m");
        this.concluir();
        //FIM DA ROTA 3
    }

    private void verificarConclusao() throws InterruptedException {
        if (this.isConcluida()) {
            TextoAnimado.escrever("Missão concluída com sucesso! ✔");
            //FIM DA ROTA 3
            TelaInicial.mostrarMenu();
        } else {
            TextoAnimado.escrever("Missão não concluída. ✖");
            TelaInicial.mostrarMenu();
        }
    }
}