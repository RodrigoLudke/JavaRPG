package model.missoes;

import controller.JogoController;
import model.Personagem;

public class Despertar extends Missoes{
    public Despertar() {
        super("ΔX: O Despertar", " Agora você carrega algo que as megacorporações vão caçar até os confins da Net.");

    }

    public static String nome() {return "Despertar";}

    public static int dificuldade() {return 1;}

    @Override
    public void executar(Personagem p, JogoController jogo) throws InterruptedException {

    }
}
