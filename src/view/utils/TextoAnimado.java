package view.utils;

import java.util.concurrent.TimeUnit;

public class TextoAnimado {

    public static void escrever(String texto) throws InterruptedException {
        String[] palavras = texto.split(" ");
        StringBuilder linha = new StringBuilder();
        String printable = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,;!?()[]{}<>: '\"-+=*/\\|@#$%^&`~";
        int maxColuna = 135;
        int colunaAtual = 0;

        for (String palavra : palavras) {
            int palavraLen = palavra.length();

            // Se estourar a linha, quebra antes de adicionar a palavra
            if (colunaAtual + palavraLen + 1 > maxColuna) {
                System.out.println();
                colunaAtual = 0;
                linha.setLength(0);
            }

            // Adiciona espaço antes da palavra (se não for início de linha)
            if (colunaAtual > 0) {
                linha.append(" ");
                System.out.print("\r" + linha);
                TimeUnit.MILLISECONDS.sleep(3);
                colunaAtual++;
            }

            // Letra por letra com efeito
            for (int i = 0; i < palavra.length(); i++) {
                char ch = palavra.charAt(i);
                int tentativas = 2 + (int) (Math.random() * 3);
                for (int t = 0; t < tentativas; t++) {
                    char fakeChar = printable.charAt((int) (Math.random() * printable.length()));
                    linha.append(fakeChar);
                    System.out.print("\r" + linha);
                    linha.setLength(linha.length() - 1);
                    TimeUnit.MILLISECONDS.sleep(25);
                }

                linha.append(ch);
                System.out.print("\r" + linha);
                TimeUnit.MILLISECONDS.sleep(30);
                colunaAtual++;
            }
        }

        System.out.println(); // final
    }
}