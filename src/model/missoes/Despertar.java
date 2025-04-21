package model.missoes;

import controller.JogoController;
import model.Personagem;

import java.util.Scanner;

public class Despertar extends Missoes{
    public Despertar() {
        super("ΔX: O Despertar", " Agora você carrega algo que as megacorporações vão caçar até os confins da Net.");

    }

    public static String nome() {return "Despertar";}

    public static int dificuldade() {return 1;}

    @Override
    public void executar(Personagem p, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("ΔX: O Despertar");
        System.out.println("Agora você carrega algo que as megacorporações vão caçar até os confins da Net.");



        sc.close();
    }
}
