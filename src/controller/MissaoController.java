package controller;

import model.Personagem;
import model.missoes.Missoes;
import model.missoes.MissaoDentesDeOuro;

import java.util.HashMap;
import java.util.Map;

public class MissaoController {
    private static final Map<String, Missoes> missoesDisponiveis = new HashMap<>();

    // Inicializa as missões disponíveis
    static {
        missoesDisponiveis.put("Dentes de Ouro", new MissaoDentesDeOuro());
        // Adicione outras missões aqui
    }

    public static void executarMissao(String titulo, Personagem p, JogoController jogo) throws InterruptedException {
        Missoes missao = missoesDisponiveis.get(titulo); // Busca a missão pelo título
        if (missao != null) {
            missao.executar(p, jogo); // Executa a missão
        } else {
            System.out.println("Missão não encontrada: " + titulo);
        }
    }
}