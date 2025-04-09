package controller;

import model.Personagem;
import view.*;

public class JogoController {
    private Personagem personagem;

    public void iniciarJogo() throws InterruptedException {
        TelaInicial.mostrarMenu();
    }

    public void novoJogo(String nomePersonagem) throws InterruptedException {
        this.personagem = new Personagem(nomePersonagem);
        TelaInventario.configurarPersonagem(personagem, this);
    }

    public void acessarInventario() throws InterruptedException {
        TelaInventario.abrirInventario(personagem, this); // só visualização
    }

    public void jogoPadrao() throws InterruptedException {
        TelaPadrao.IntroducaoInicial(personagem, this);
    }
    public void jogoBase() throws InterruptedException {
        TelaPadrao.Base(personagem, this);
    }
}