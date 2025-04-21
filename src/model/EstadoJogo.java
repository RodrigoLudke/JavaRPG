package model;

import model.Personagem;

import java.io.Serializable;

public class EstadoJogo implements Serializable {
    private Personagem personagem;
    private String missaoAtual;

    public EstadoJogo(Personagem personagem, String missaoAtual) {
        this.personagem = personagem;
        this.missaoAtual = missaoAtual;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public String getMissaoAtual() {
        return missaoAtual;
    }

    public void setMissaoAtual(String missaoAtual) {
        this.missaoAtual = missaoAtual;
    }
}