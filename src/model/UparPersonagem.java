package model;

import view.utils.TextoAnimado;

public class UparPersonagem {
    private static final int XP_POR_COMBATE = 100;
    private static final int XP_BASE_LEVEL = 200;

    public static void uparAposCombate(Personagem personagem) throws InterruptedException {
        // Adiciona XP após o combate
        personagem.setXp(personagem.getXp() + XP_POR_COMBATE);
        TextoAnimado.escrever("Você ganhou " + XP_POR_COMBATE + " pontos de experiência!");

        // Verifica se pode subir de nível
        verificarLevel(personagem);
    }

    private static void verificarLevel(Personagem personagem) throws InterruptedException {
        int xpNecessario = XP_BASE_LEVEL * personagem.getLevel();

        if (personagem.getXp() >= xpNecessario) {
            subirLevel(personagem);
        } else {
            TextoAnimado.escrever("XP atual: " + personagem.getXp() + "/" + xpNecessario);
        }
    }

    private static void subirLevel(Personagem personagem) throws InterruptedException {
        personagem.setLevel(personagem.getLevel() + 1);
        TextoAnimado.escrever("=== LEVEL UP! ===");
        TextoAnimado.escrever("Você alcançou o nível " + personagem.getLevel() + "!");

        // Aumenta atributos
        aumentarAtributos(personagem);

        // Restaura energia
        personagem.setEnergia(personagem.getEnergiaMaxima());
        TextoAnimado.escrever("Energia restaurada!");
    }

    private static void aumentarAtributos(Personagem personagem) throws InterruptedException {
        // Aumenta habilidade
        int bonusHabilidade = 2;
        personagem.setHabilidade(personagem.getHabilidade() + bonusHabilidade);
        TextoAnimado.escrever("Habilidade +" + bonusHabilidade + " (Total: " + personagem.getHabilidade() + ")");

        // Aumenta energia máxima
        int bonusEnergia = 5;
        personagem.setEnergiaMaxima(personagem.getEnergiaMaxima() + bonusEnergia);
        TextoAnimado.escrever("Energia Máxima +" + bonusEnergia + " (Total: " + personagem.getEnergiaMaxima() + ")");

        // Aumenta sorte
        int bonusSorte = 1;
        personagem.setSorte(personagem.getSorte() + bonusSorte);
        TextoAnimado.escrever("Sorte +" + bonusSorte + " (Total: " + personagem.getSorte() + ")");
    }
}