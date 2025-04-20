package model.missoes;

import controller.JogoController;

import model.Personagem;

public class Seguir extends Missoes {
    public Seguir() {
        super("Seguir com a entrega como combinado — sem perguntas ", "Você decide manter o código. Night City já cobra caro por quem quebra acordos.  ");
    }

    public void executar(Personagem personagem, JogoController jogo) throws InterruptedException {

    }
}
