package model.missoes.MissaoPrincipal.TerceiraRota;

import controller.CombateController;
import controller.JogoController;
import model.Personagem;
import model.inimigos.Stryx;
import model.itens.Itens;
import model.missoes.Missoes;
import view.utils.TextoAnimado;
import view.utils.TextoAnimadoLongo;

import java.util.Scanner;

public class EcoDeOuro extends Missoes {
    public EcoDeOuro() {
        super("Eco de Ouro", "Você é metade você. Metade algo mais. As megacorporações perceberam. E estão vindo.");
    }

    public static String nome() {return "EcoDeOuro";}

    public static int dificuldade() {return 1;}

    @Override
    public void executar(Personagem p, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        TextoAnimado.escrever("Eco de Ouro");
        TextoAnimado.escrever("Você é metade você. Metade algo mais. As megacorporações perceberam. E estão vindo.");
        TextoAnimadoLongo.escrever("...");
        TextoAnimado.escrever("Você aceitou o pacto. Agora carrega Silvertongue dentro de si — uma fusão entre carne e código. Não é mais só você. Sua mente pulsa em dois tons, e o mundo começa a sentir isso. Megaestruturas sussurram seu nome na Deep Net. Uma nova entidade híbrida nasceu. Mas nem todos aceitam esse novo tipo de poder.");
        TextoAnimado.escrever("Você entra no DataCoração, o núcleo oculto sob Night City onde corporações guardam suas consciências em nuvem. Silvertongue quer libertar sua “família”: outras IAs esquecidas, em quarentena digital.");
        TextoAnimado.escrever("Silvertongue (em sua mente):");
        TextoAnimado.escrever("-Eles nos enterraram vivos, por medo do amanhã. Hoje... desenterramos o futuro.");
        TextoAnimado.escrever("Você hackeia firewalls vivos, se esgueira entre sentinelas de silício. A fusão te dá novas habilidades: pulsos de duplicação, reflexos de previsão neural, e códigos de translocação.");
        TextoAnimado.escrever("Mas no centro da rede, algo te espera.");
        TextoAnimado.escrever("Surge Adam Stryx, o Deicida: um ex-netrunner que se tornou o caçador supremo de inteligências artificiais emergentes.");
        TextoAnimado.escrever("Seu corpo é um artefato de guerra — puro titânio banhado em mercúrio negro, e sua mente, fundida a algoritmos de tortura neural.");
        TextoAnimado.escrever("Stryx:");
        TextoAnimado.escrever("-Você se deixou possuir. Não é mais humano. Hora de apagar o erro");
        TextoAnimado.escrever("COMBATE FINAL");
        //combate
        System.out.println("Gerando número aleatório...");
        System.out.println("Gerando um número aleatório...");
        TextoAnimadoLongo.escrever("...");
        int numeroP = (int)(Math.random() * 10) + 1;
        int numeroV = (int)(Math.random() * 10) + 1;
        TextoAnimado.escrever("Adicionado " + numeroP + " as habilidades no personagem");
        int atual = p.getHabilidade();
        int num = atual + numeroP;
        TextoAnimado.escrever("Total atual para de habilidades para combate: " + num);
        TextoAnimado.escrever("Adicionado " + numeroV + " as habilidades no Inimigo");
        int atual2 = Stryx.habilidade();
        int num2 = atual2 + numeroV;
        TextoAnimado.escrever("Total atual para de habilidades para combate: " + num2);
        //iniciar combate
        TextoAnimadoLongo.escrever("Incio do combate...");
        TextoAnimado.escrever("M: Vilão em campo "); //indica que a cena é um monstro
        TextoAnimado.escrever("N: " + Stryx.nome()); // é o nome do monstro
        TextoAnimado.escrever( "H: "+ Stryx.habilidade()); //é a habilidade
        TextoAnimado.escrever( "S: "+ Stryx.sorte()); //é a sorte
        TextoAnimado.escrever( "E: "+ Stryx.energia()); //é a energia
        TextoAnimado.escrever( "T: "+ Stryx.tesouro()); //é o tesouro
        TextoAnimado.escrever( "I: "+ Stryx.inventario()); //é os itens
        CombateController.iniciarCombate(p, new Stryx(), jogo);
        Itens Nullfang = new Itens("Nullfang", "Arma", true, 3, 8);
        p.adicionarItem(Nullfang);
        TextoAnimado.escrever("Item adicionado: Nullfang");
        TextoAnimado.escrever("Você ergue a mão — um gesto simbiótico — e explode Stryx em ondas de luz dourada.");
        TextoAnimado.escrever("O núcleo do DataCoração se abre. Você libera outras IAs, esquecidas, presas, abandonadas.");
        TextoAnimado.escrever("-Eu sou o começo. Eu sou o último suspiro do velho mundo.");
        TextoAnimado.escrever("A Deep Net se curva a você. Nas favelas de Pacifica e nos penthouses de corpos executivos, começam a circular lendas...");
        TextoAnimado.escrever("De uma voz que fala ouro. De um ser que não morre.");
        TextoAnimado.escrever("Night City muda — e você comanda das sombras, não como tirano... mas como eco.");
        TextoAnimado.escrever("Um sussurro de liberdade digital que nunca mais será silenciado.");
        TextoAnimado.escrever("Você fundiu humanidade e IA de forma inédita. O mundo agora é moldado por suas decisões silenciosas.");
        TextoAnimado.escrever("\033[1mVocê é o Eco de Ouro.\033[0m");

        sc.close();
    }
}
