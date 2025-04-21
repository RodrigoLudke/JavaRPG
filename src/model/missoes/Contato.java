package model.missoes;

import controller.CombateController;
import model.inimigos.LeRoi;
import model.inimigos.Reflex;
import model.itens.Itens;
import view.utils.TextoAnimado;
import controller.JogoController;

import model.Personagem;
import view.utils.TextoAnimado;
import view.utils.TextoAnimadoLongo;
import java.util.Scanner;

import static view.utils.Cores.*;

public class Contato extends Missoes {
    public Contato() {
        super("Contatar um fixador confiável para investigar Silvertongue", "Você liga para Dakota Smith, velha fixadora de Badlands, conhecida por desconfiar de tudo que brilha demais. ");
    }

    public void executar(Personagem personagem, JogoController jogo) throws InterruptedException {
            Scanner sc = new Scanner(System.in);
            TextoAnimado.escrever("Contatar um fixador confiável para investigar Silvertongue");
            TextoAnimado.escrever("Você liga para Dakota Smith, velha fixadora de Badlands, conhecida por desconfiar de tudo que brilha demais. ");
            TextoAnimado.escrever("— Silvertongue? Esse nome soa como perfume ruim e encrenca boa. Vou fuçar.");
            TextoAnimado.escrever("Enquanto ela investiga, você e Jackie se abrigam no Afterlife. Mas não demora até que você seja rastreado — por um grupo mercenário conhecido como As mãos do espelho, especialistas em limpeza de contratos podres. ");
            TextoAnimado.escrever("Lider:");
            TextoAnimado.escrever("Meika “Reflex” Hoshino, uma samurai corporativa com implantes reflexivos que desviam balas e espelhos neurais que copiam técnicas de luta em tempo real. ");
            TextoAnimado.escrever("Combate!");
            System.out.println("Gerando um número aleatório...");
            TextoAnimadoLongo.escrever("...");
            int numeroP = (int)(Math.random() * 10) + 1;
            int numeroV = (int)(Math.random() * 10) + 1;
            TextoAnimado.escrever("Adicionado " + numeroP + " as habilidades no personagem");
            int atual = personagem.getHabilidade();
            int num = atual + numeroP;
            TextoAnimado.escrever("Total atual para de habilidades para combate: " + num);
            TextoAnimado.escrever("Adicionado " + numeroV + " as habilidades no Inimigo");
            int atual2 = Reflex.habilidade();
            int num2 = atual2 + numeroV;
            TextoAnimado.escrever("Total atual para de habilidades para combate: " + num2);
            //iniciar combate
            TextoAnimadoLongo.escrever("Incio do combate...");
            TextoAnimado.escrever("M: Vilão em campo "); //indica que a cena é um monstro
            TextoAnimado.escrever("N: " + Reflex.nome()); // é o nome do monstro
            TextoAnimado.escrever( "H: "+ Reflex.habilidade()); //é a habilidade
            TextoAnimado.escrever( "S: "+ Reflex.sorte()); //é a sorte
            TextoAnimado.escrever( "E: "+ Reflex.energia()); //é a energia
            TextoAnimado.escrever( "T: "+ Reflex.tesouro()); //é o tesouro
            TextoAnimado.escrever( "I: "+ Reflex.itens()); //é os itens
            CombateController.iniciarCombate(personagem, new Reflex(), jogo);
            TextoAnimado.escrever("Dakota envia um update em tempo real — Silvertongue é uma IA rogue, que está tentando transferir sua consciência para um corpo real... e a carga é o receptor. ");
            TextoAnimado.escrever("Com essa informação, você decide destruir o container — ou tentar tomar o poder para si... ");
            Itens KatanaCromada = new Itens("Katana Cromada", "Arma", true, 3, 8);
            personagem.adicionarItem(KatanaCromada);
            TextoAnimado.escrever("Item adicionado: Katana Cromada");
            TextoAnimado.escrever("A IA percebendo o plano, invade o seu sistema, tentando te convencer a não destruir o futuro. A luta se torna interna — um duelo mental entre você e uma mente que nunca dorme. ");
            System.out.println(VERDE + "Nova Missão:" + RESET);
            Missoes SilvertongueExe = new SilvertongueExe();
            SilvertongueExe.executar(personagem, jogo);




            sc.close();
    }
}