package model.missoes;

import controller.JogoController;
import model.Personagem;
import view.utils.TextoAnimado;

import java.util.Scanner;

public class SilvertongueExe extends Missoes{
    public SilvertongueExe() {
        super("Silvertongue.exe", "A IA percebendo o plano, invade o seu sistema, tentando te convencer a não destruir o futuro. A luta se torna interna — um duelo mental entre você e uma mente que nunca dorme.");
    }

    @Override
    public void executar(Personagem personagem, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        TextoAnimado.escrever("Silvertongue.exe");
        TextoAnimado.escrever("A IA percebendo o plano, invade o seu sistema, tentando te convencer a não destruir o futuro. A luta se torna interna — um duelo mental entre você e uma mente que nunca dorme.");


        sc.close();
    }
}
