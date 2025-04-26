package controller;

import model.EstadoJogo;
import model.Personagem;
import model.inimigos.Inimigos;
import view.*;

import java.io.*;

public class JogoController {
    private Personagem personagem;
    private String estadoAtual = "Início do jogo"; // Estado inicial do jogo

    public void iniciarJogo() throws InterruptedException {
        TelaInicial.mostrarMenu();
    }

    public void novoJogo(String nomePersonagem) throws InterruptedException {
        this.personagem = new Personagem(nomePersonagem);
        TelaInventario.configurarPersonagem(personagem, this);
    }

    public void acessarInventario() throws InterruptedException {
        TelaInventario.abrirInventario(personagem, this);// só visualização
    }

    public void jogoPadrao() throws InterruptedException {
        TelaPadrao.IntroducaoInicial(personagem, this);
    }

    public void jogoBase() throws InterruptedException {
        TelaPadrao.Base(personagem, this);
    }

    public void atualizarEstadoAtual(String novoEstado) {
        this.estadoAtual = novoEstado;
    }

    public String getEstadoAtual() {
        return this.estadoAtual;
    }

    public void salvarJogo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("savegame.dat"))) {
            EstadoJogo estado = new EstadoJogo(personagem, estadoAtual);
            oos.writeObject(estado);
            System.out.println("Jogo salvo com sucesso! Ponto atual: " + estadoAtual);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o jogo: " + e.getMessage());
        }
    }

    public boolean carregarJogo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("savegame.dat"))) {
            EstadoJogo estado = (EstadoJogo) ois.readObject();
            this.personagem = estado.getPersonagem();
            this.estadoAtual = estado.getMissaoAtual(); // Garante que o estado é restaurado
            System.out.println("Jogo carregado com sucesso! Estado atual: " + estadoAtual);
            TelaInventario.abrirInventario(this.personagem, this); // Abre o inventário após carregar
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar o jogo: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}