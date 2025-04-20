package model.missoes;

import view.utils.TextoAnimado;
import controller.JogoController;

import model.Personagem;
import view.utils.TextoAnimado;
import view.utils.TextoAnimadoLongo;
import java.util.Scanner;

import static view.utils.Cores.RESET;
import static view.utils.Cores.VERMELHO;

public class Contato extends Missoes {
    public Contato() {
        super("Contatar um fixador confiável para investigar Silvertongue", "Você liga para Dakota Smith, velha fixadora de Badlands, conhecida por desconfiar de tudo que brilha demais. ");
    }

    public void executar(Personagem personagem, JogoController jogo) throws InterruptedException {

    }
}