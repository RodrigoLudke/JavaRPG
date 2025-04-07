package controller;

import model.Personagem;
import view.*;

public class JogoController {
    private Personagem personagem;

    public void iniciarJogo() throws InterruptedException {
        TelaInicial.mostrarMenu();
    }

    public void novoJogo(String nomePersonagem) {
        this.personagem = new Personagem(nomePersonagem);
        TelaInventario.configurarPersonagem(personagem);
    }
}
