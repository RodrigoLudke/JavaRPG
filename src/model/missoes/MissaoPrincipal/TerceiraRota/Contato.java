package model.missoes.MissaoPrincipal.TerceiraRota;

import controller.CombateController;
import controller.JogoController;
import model.Personagem;
import model.UparPersonagem;
import model.inimigos.Inimigos;
import model.inimigos.Reflex;
import model.inimigos.utils.ItemFormatter;
import model.itens.Itens;
import model.missoes.Missoes;
import view.TelaInicial;
import view.utils.ApagarConsole;
import view.utils.TextoAnimado;
import view.utils.TextoAnimadoLongo;

import java.util.Scanner;

import static view.utils.Cores.VERDE;
import static view.utils.Cores.RESET;

public class Contato extends Missoes {
        private Scanner sc;

        public Contato() {
                super("Contatar um fixador confiável para investigar Silvertongue",
                        "Você liga para Dakota Smith, velha fixadora de Badlands, conhecida por desconfiar de tudo que brilha demais.");
                this.sc = new Scanner(System.in);
        }

        public void executar(Personagem personagem, JogoController jogo) throws InterruptedException {
                ApagarConsole.limparConsole();
                introduzirMissao();
                lutarContraReflex(personagem, jogo);
                verificarConclusao(personagem, jogo);
                sc.close();
        }

        private void introduzirMissao() throws InterruptedException {
                TextoAnimado.escrever("Contatar um fixador confiável para investigar Silvertongue");
                TextoAnimado.escrever("Você liga para Dakota Smith, velha fixadora de Badlands, conhecida por desconfiar de tudo que brilha demais.");
                TextoAnimado.escrever("— Silvertongue? Esse nome soa como perfume ruim e encrenca boa. Vou fuçar.");
                TextoAnimado.escrever("Enquanto ela investiga, você e Jackie se abrigam no Afterlife. Mas não demora até que você seja rastreado — por um grupo mercenário conhecido como As mãos do espelho, especialistas em limpeza de contratos podres.");
                TextoAnimado.escrever("Lider:");
                TextoAnimado.escrever("Meika “Reflex” Hoshino, uma samurai corporativa com implantes reflexivos que desviam balas e espelhos neurais que copiam técnicas de luta em tempo real. ");
        }

        private void lutarContraReflex(Personagem personagem, JogoController jogo) throws InterruptedException {
                TextoAnimado.escrever("Combate!");
                Reflex reflex = new Reflex();

                System.out.println("\nGerando número aleatório para o personagem...");
                TextoAnimadoLongo.escrever("...");
                int numeroP = (int)(Math.random() * 10) + 1;
                int numeroV = (int)(Math.random() * 10) + 1;
                TextoAnimado.escrever("Adicionado " + numeroP + " as habilidades no personagem");
                int atual = personagem.getHabilidade();
                int num = atual + numeroP;
                TextoAnimado.escrever("Total atual para de habilidades para combate: " + num);
                TextoAnimado.escrever("Adicionado " + numeroV + " as habilidades no Inimigo");
                int atual2 = reflex.getHabilidade();
                int num2 = atual2 + numeroV;
                TextoAnimado.escrever("Total atual para de habilidades para combate: " + num2);

                mostrarInformacoesVilao(reflex);

                CombateController.iniciarCombate(personagem, reflex, jogo);
                UparPersonagem.uparAposCombate(personagem);
                vasculharCorpo(personagem, reflex);
                desfechoMissao(personagem, jogo);
        }

        private void mostrarInformacoesVilao(Inimigos inimigo) throws InterruptedException {
                TextoAnimado.escrever("M: Vilão em campo");
                TextoAnimado.escrever("N: " + inimigo.getNome());
                TextoAnimado.escrever("H: " + inimigo.getHabilidade());
                TextoAnimado.escrever("S: " + inimigo.getSorte());
                TextoAnimado.escrever("E: " + inimigo.getEnergia());
                TextoAnimado.escrever("T: " + inimigo.getTesouro());
                TextoAnimado.escrever("I: " + ItemFormatter.formatarInventario(inimigo.getInventario()));
        }

        private void vasculharCorpo(Personagem personagem, Inimigos inimigo) throws InterruptedException {
                Scanner sc = new Scanner(System.in);

                TextoAnimado.escrever("O corpo de " + inimigo.getNome() + " jaz no chão.");
                System.out.println("Deseja vasculhar o corpo?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");

                int escolha = sc.nextInt();

                if (escolha == 1) {
                        if (!inimigo.getInventario().isEmpty()) {
                                System.out.println("\nItens encontrados:");
                                for (int i = 0; i < inimigo.getInventario().size(); i++) {
                                        Itens item = inimigo.getInventario().get(i);
                                        System.out.println((i + 1) + " - " + item.getNome());
                                }

                                System.out.println("\nEscolha um item para pegar (0 para não pegar nada):");
                                int itemEscolhido = sc.nextInt();

                                if (itemEscolhido > 0 && itemEscolhido <= inimigo.getInventario().size()) {
                                        Itens itemPego = inimigo.getInventario().get(itemEscolhido - 1);
                                        personagem.adicionarItem(itemPego);
                                        TextoAnimado.escrever("Você pegou: " + itemPego.getNome());
                                }
                        } else {
                                TextoAnimado.escrever("Não encontrou nada útil no corpo.");
                        }
                }
        }

        private void desfechoMissao(Personagem personagem, JogoController jogo) throws InterruptedException {
                TextoAnimado.escrever("Dakota envia um update em tempo real — Silvertongue é uma IA rogue, que está tentando transferir sua consciência para um corpo real... e a carga é o receptor.");
                TextoAnimado.escrever("Com essa informação, você decide destruir o container — ou tentar tomar o poder para si...");
                TextoAnimado.escrever("A IA percebendo o plano, invade o seu sistema, tentando te convencer a não destruir o futuro. A luta se torna interna — um duelo mental entre você e uma mente que nunca dorme.");
                this.concluir();
        }

        private void verificarConclusao(Personagem personagem, JogoController jogo) throws InterruptedException {
                if (this.isConcluida()) {
                        TextoAnimado.escrever("Missão concluída com sucesso! ✔");
                        jogo.atualizarEstadoAtual("SilvertongueExe");
                        jogo.jogoBase();
                        // Implementar logica par ir para proxima missao (SilvertongueExe)
                } else {
                        TextoAnimado.escrever("Missão não concluída. ✖");
                        TelaInicial.mostrarMenu();
                }
        }
}