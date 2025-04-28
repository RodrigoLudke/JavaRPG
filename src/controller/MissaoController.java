package controller;

import model.Personagem;
import model.missoes.Missoes;
import model.missoes.MissaoPrincipal.MissaoDentesDeOuro;
import model.missoes.MissaoPrincipal.PrimeiraRota.AbrirContainer;
import model.missoes.MissaoPrincipal.PrimeiraRota.Despertar;
import model.missoes.MissaoPrincipal.SegundaRota.Seguir;
import model.missoes.MissaoPrincipal.SegundaRota.SilvertongueEcoDeOuro;
import model.missoes.MissaoPrincipal.TerceiraRota.Contato;
import model.missoes.MissaoPrincipal.TerceiraRota.EcoDeOuro;
import model.missoes.MissaoPrincipal.TerceiraRota.SilvertongueExe;

import java.util.HashMap;
import java.util.Map;

public class MissaoController {
    private static final Map<String, Missoes> missoesDisponiveis = new HashMap<>();
    private static final Map<String, String> estadosMissao = new HashMap<>();

    static {
        // Inicializa as missões disponíveis
        missoesDisponiveis.put("MissaoDentesDeOuro", new MissaoDentesDeOuro());
        //Primeira Rota
        missoesDisponiveis.put("AbrirContainer", new AbrirContainer());
        missoesDisponiveis.put("Despertar", new Despertar());
        //Segunda Rota
        missoesDisponiveis.put("Seguir", new Seguir());
        missoesDisponiveis.put("SilvertongueEcoDeOuro", new SilvertongueEcoDeOuro());
        //Terceira Rota
        missoesDisponiveis.put("Contato", new Contato());
        missoesDisponiveis.put("SilvertongueExe", new SilvertongueExe());
        missoesDisponiveis.put("EcoDeOuro", new EcoDeOuro());
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
            //Primeira Rota
            if (missao instanceof AbrirContainer) {
                AbrirContainer abrirContainer = (AbrirContainer) missao;
                abrirContainer.executar(p, jogo);
            }
            if (missao instanceof Despertar) {
                Despertar despertar = (Despertar) missao;
                despertar.executar(p, jogo);
            }
            //Segunda Rota
            if (missao instanceof Seguir) {
                Seguir seguir = (Seguir) missao;
                seguir.executar(p, jogo);
            }
            if (missao instanceof SilvertongueEcoDeOuro) {
                SilvertongueEcoDeOuro silvertongueEcoDeOuro = (SilvertongueEcoDeOuro) missao;
                silvertongueEcoDeOuro.executar(p, jogo);
            }
            //Terceira Rota
            if (missao instanceof Contato) {
                Contato contato = (Contato) missao;
                contato.executar(p, jogo);
            }
            if (missao instanceof SilvertongueExe) {
                SilvertongueExe silvertongueExe = (SilvertongueExe) missao;
                silvertongueExe.executar(p, jogo);
            }
            if (missao instanceof EcoDeOuro) {
                EcoDeOuro ecoDeOuro = (EcoDeOuro) missao;
                ecoDeOuro.executar(p, jogo);
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