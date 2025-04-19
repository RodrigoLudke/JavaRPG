package model.missoes;

import controller.JogoController;
import model.Personagem;

public abstract class Missoes {
    private String titulo;
    private String descricao;
    private boolean concluida;

    public Missoes(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void concluir() {
        this.concluida = true;
    }

    public abstract void executar(Personagem p, JogoController jogo) throws InterruptedException; // cada missão terá sua própria lógica de execução

    @Override
    public String toString() {
        return (concluida ? "[✔] " : "[ ] ") + titulo + ": " + descricao;
    }
}
