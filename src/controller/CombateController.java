package controller;

import model.Personagem;
import model.inimigos.Inimigos;
import view.TelaCombate;

public class CombateController {
    public static void iniciarCombate(Personagem personagem, Inimigos inimigo, JogoController jogo) throws InterruptedException {
        // Validação: Verifica se o personagem ou inimigo têm energia suficiente
        if (personagem.getEnergia() <= 0) {
            System.out.println("Você não tem energia suficiente para lutar!");
            return;
        }
        if (inimigo.getEnergia() <= 0) {
            System.out.println("O inimigo já foi derrotado!");
            return;
        }

        // Armazena os valores originais
        int habilidadeOriginalPersonagem = personagem.getHabilidade();
        int habilidadeOriginalInimigo = inimigo.getHabilidade();

        // Inicialização: Configura buffs ou penalidades
        System.out.println("Preparando o combate...");
        personagem.setHabilidade(habilidadeOriginalPersonagem + 2); // Exemplo de buff temporário
        inimigo.setHabilidade(habilidadeOriginalInimigo - 1); // Exemplo de penalidade temporária

        // Manipulação de estados: Exemplo de log ou atualização de status
//        System.out.println("Status inicial do combate:");
//        System.out.println("Personagem: Energia = " + personagem.getEnergia() + ", Habilidade = " + personagem.getHabilidade());
//        System.out.println("Inimigo: Energia = " + inimigo.getEnergia() + ", Habilidade = " + inimigo.getHabilidade());

        // Chama a TelaCombate
        TelaCombate.combate(personagem, inimigo, jogo);

        // Restaura os valores originais
        personagem.setHabilidade(habilidadeOriginalPersonagem);
        inimigo.setHabilidade(habilidadeOriginalInimigo);

        System.out.println("Combate finalizado. Estados restaurados.");
    }
}