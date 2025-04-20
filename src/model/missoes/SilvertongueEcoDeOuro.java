package model.missoes;

import controller.JogoController;
import model.Personagem;

import java.util.Scanner;

public class SilvertongueEcoDeOuro extends Missoes {
    public SilvertongueEcoDeOuro() {
        super("Silvertongue: Eco de Ouro", "Você começa a ouvir boatos — sobre um novo deus digital sendo criado nas sombras... e sobre um entregador que talvez tenha dado a chave sem saber.");

    }
    public static String nome() {return "SilvertongueEcoDeOuro";}

    public static int dificuldade() {return 1;}

    @Override
    public void executar(Personagem p, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Silvertongue: Eco de Ouro");
        System.out.println("Você começa a ouvir boatos — sobre um novo deus digital sendo criado nas sombras... e sobre um entregador que talvez tenha dado a chave sem saber.");



        sc.close();
    }
}
