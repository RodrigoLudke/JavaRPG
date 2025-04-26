package model.missoes.MissaoPrincipal.SegundaRota;

import controller.CombateController;
import controller.JogoController;

import model.Personagem;
import model.inimigos.LeRoi;
import model.inimigos.utils.ItemFormatter;
import model.itens.Itens;
import model.missoes.Missoes;
import view.utils.TextoAnimado;
import view.utils.TextoAnimadoLongo;

import java.util.Scanner;

import static view.utils.Cores.RESET;
import static view.utils.Cores.VERDE;

public class Seguir extends Missoes {
    public Seguir() {
        super("Seguir com a entrega como combinado — sem perguntas ", "Você decide manter o código. Night City já cobra caro por quem quebra acordos.  ");
    }

    public void executar(Personagem personagem, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        TextoAnimado.escrever("Seguir com a entrega como combinado — sem perguntas ");
        TextoAnimado.escrever("Você decide manter o código. Night City já cobra caro por quem quebra acordos. ");
        TextoAnimado.escrever("Jackie não discute — apenas acelera. Vocês passam por Charter Hill, atravessam um bloqueio policial com ajuda de subornos e finalmente entram nas ruínas decadentes de Pacifica. ");
        TextoAnimado.escrever("O ponto de entrega é uma torre abandonada, onde uma figura encapuzada os espera: Silvertongue. Ele sorri com dentes de ouro polido, a voz suave e venenosa. ");
        TextoAnimado.escrever("— Muito bem. Profissionalismo raro hoje em dia.");
        TextoAnimado.escrever("Mas enquanto o container é transferido, uma gangue Voodoo Boys renegada aparece. Eles querem o conteúdo para si — não por dinheiro, mas por informação genética. Liderados por LeRoi, um ex-nômade convertido em tecnoxamã, eles falam com espíritos da Net. ");
        TextoAnimado.escrever("Combate!");
        System.out.println("Gerando um número aleatório...");
        TextoAnimadoLongo.escrever("...");
        int numeroP = (int)(Math.random() * 10) + 1;
        int numeroV = (int)(Math.random() * 10) + 1;
        TextoAnimado.escrever("Adicionado " + numeroP + " as habilidades no personagem");
        int atual = personagem.getHabilidade();
        int num = atual + numeroP;
        TextoAnimado.escrever("Total atual para de habilidades para combate: " + num);
        TextoAnimado.escrever("Adicionado " + numeroV + " as habilidades no Inimigo");
        int atual2 = LeRoi.habilidade();
        int num2 = atual + numeroV;
        TextoAnimado.escrever("Total atual para de habilidades para combate: " + num2);
        //iniciar combate
        TextoAnimadoLongo.escrever("Incio do combate...");
        TextoAnimado.escrever("M: Vilão em campo "); //indica que a cena é um monstro
        TextoAnimado.escrever("N: " + LeRoi.nome()); // é o nome do monstro
        TextoAnimado.escrever( "H: "+ LeRoi.habilidade()); //é a habilidade
        TextoAnimado.escrever( "S: "+ LeRoi.sorte()); //é a sorte
        TextoAnimado.escrever( "E: "+ LeRoi.energia()); //é a energia
        TextoAnimado.escrever( "T: "+ LeRoi.tesouro()); //é o tesouro
        TextoAnimado.escrever( "I: "+ ItemFormatter.formatarInventario(LeRoi.inventario())); //é os itens
        CombateController.iniciarCombate(personagem, new LeRoi(), jogo);
        TextoAnimado.escrever("Depois de uma luta intensa, você vence!");
        Itens DronesReciclados = new Itens("Drones Reciclados", "Arma", true, 5, 10);
        personagem.adicionarItem(DronesReciclados);
        TextoAnimado.escrever("Você pega os Drones Reciclados e os coloca na mochila.");
        TextoAnimado.escrever("— Você fez bem, mas... o que estava dentro, agora vai mudar o mundo. Espero que você nunca descubra como. ");
        TextoAnimado.escrever("Ele desaparece numa névoa de partículas, levando o container. ");
        System.out.println(VERDE + "Nova Missão:" + RESET);
        Missoes EcoOuro = new SilvertongueEcoDeOuro();
        EcoOuro.executar(personagem, jogo);

        sc.close();

    }
}
