package controller;

import model.Personagem;
import model.inimigos.Inimigos;
import view.*;

import java.io.*;

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
    public void salvarJogo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("savegame.dat"))) {
            oos.writeObject(personagem);
            System.out.println("Jogo salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o jogo: " + e.getMessage());
        }
    }
    public boolean carregarJogo(boolean b) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("savegame.dat"))) {
            personagem = (Personagem) ois.readObject();
            System.out.println("Jogo carregado com sucesso!");
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar o jogo: " + e.getMessage());
        }
        return false;
    }
}