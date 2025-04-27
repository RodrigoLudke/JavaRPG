package model;

import controller.CombateController;
import model.inimigos.Inimigos;
import view.utils.TextoAnimado;

import java.util.Random;

public class TesteSorte {

    public static boolean testarSorte(Personagem personagem) throws InterruptedException {
        if (personagem.getSorte() <= 0) {
            TextoAnimado.escrever("Você não tem mais sorte para testar!");
            return false;
        }

        Random random = new Random();
        int valorSorteado = random.nextInt(6) + 1; // Sorteia um valor entre 1 e 6
        TextoAnimado.escrever("Valor sorteado: " + valorSorteado);
        TextoAnimado.escrever("Sorte atual do personagem: " + personagem.getSorte());

        boolean sucesso = valorSorteado <= personagem.getSorte();
        personagem.setSorte(personagem.getSorte() - 1); // Decrementa a sorte

        if (sucesso) {
            TextoAnimado.escrever("Teste de sorte bem-sucedido!");
        } else {
            TextoAnimado.escrever("Teste de sorte falhou!");
        }

        return sucesso;
    }

    public static void aplicarSorteNoCombate(Personagem personagem, Inimigos inimigo, boolean sucesso) throws InterruptedException {
        if (sucesso) {
            int aumentoHabilidade = new Random().nextInt(5) + 1; // Sorteia um valor entre 1 e 5
            int habilidadeOriginal = personagem.getHabilidade();
            int aumentoEnergia = new Random().nextInt(5) + 1; // Sorteia um valor entre 1 e 5
            personagem.setHabilidade(habilidadeOriginal + aumentoHabilidade);
            personagem.setEnergia(personagem.getEnergia() + aumentoEnergia);


            TextoAnimado.escrever("Sua habilidade aumentou em " + aumentoHabilidade + " pontos!");
            TextoAnimado.escrever("Sua energia aumentou em " + aumentoEnergia + " pontos!");
            TextoAnimado.escrever("Habilidade atual: " + personagem.getHabilidade());
            TextoAnimado.escrever("Energia atual: " + personagem.getEnergia());


        } else {
            TextoAnimado.escrever("Nenhum efeito foi aplicado, pois o teste de sorte falhou.");
        }
    }
}