package controller;

import model.Personagem;
import model.missoes.Missoes;

import java.util.ArrayList;
import java.util.List;

public class MissaoController {
    private List<Missoes> missoes = new ArrayList<>();

    public void adicionarMissao(Missoes m) {
        missoes.add(m);
    }

    public void mostrarMissoes() {
        for (Missoes m : missoes) {
            System.out.println((m.isConcluida() ? "[✔] " : "[ ] ") + m.getTitulo());
        }
    }

    public void executarMissoes(String titulo, Personagem p, JogoController jogo) throws InterruptedException {
        for (Missoes m : missoes) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                m.executar(p, jogo);
                break;
            }
        }
    }
}
