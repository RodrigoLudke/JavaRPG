package controller;

import model.Personagem;
import model.missoes.Missoes;
import model.missoes.MissaoPrincipal.MissaoDentesDeOuro;

import java.util.HashMap;
import java.util.Map;

public class MissaoController {
    private static final Map<String, Missoes> missoesDisponiveis = new HashMap<>();
    private static final Map<String, String> estadosMissao = new HashMap<>();

    static {
        // Inicializa as missões disponíveis
        missoesDisponiveis.put("MissaoDentesDeOuro", new MissaoDentesDeOuro());
    }

    public static void executarMissao(String titulo, Personagem p, JogoController jogo) throws InterruptedException {
        Missoes missao = missoesDisponiveis.get(titulo);
        String estadoAtual = jogo.getEstadoAtual();

        if (missao != null) {
            if (missao instanceof MissaoDentesDeOuro) {
                MissaoDentesDeOuro missaoDentesDeOuro = (MissaoDentesDeOuro) missao;
                switch (estadoAtual) {
                    case "inicio" -> missaoDentesDeOuro.executar(p, jogo);
                    case "MissaoDentesDeOuro_Escolha1" -> missaoDentesDeOuro.mostrarEscolhaInicial(p, jogo);
                    case "MissaoDentesDeOuro_EscolhaFinal" -> missaoDentesDeOuro.mostrarEscolhasFinais(p, jogo, estadoAtual);
                    default -> missaoDentesDeOuro.executar(p, jogo);
                }
            }
        } else {
            System.out.println("Missão não encontrada: " + titulo);
        }
    }

    public static String getEstadoAtual(String titulo) {
        return estadosMissao.get(titulo);
    }

    public static void atualizarEstado(String titulo, String novoEstado) {
        estadosMissao.put(titulo, novoEstado);
    }
}