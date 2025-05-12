package view;

import controller.JogoController;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JogoController jogo = new JogoController();
        jogo.iniciarJogo();
    }
}