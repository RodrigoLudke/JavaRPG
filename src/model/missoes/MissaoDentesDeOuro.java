package model.missoes;

import controller.JogoController;
import model.Monstro;
import model.Personagem;
import view.utils.TextoAnimado;
import view.utils.TextoAnimadoLongo;
import java.util.Scanner;

import static view.TelaCombate.combate;
import static view.utils.Cores.RESET;
import static view.utils.Cores.VERMELHO;
public class MissaoDentesDeOuro extends Missoes {
    public MissaoDentesDeOuro() {
        super("Dentes de Ouro", "Transporte clandestino perigoso com recompensas altas.");
    }

    public void executar(Personagem personagem, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String missao = "\033[1mMissão: Dentes de Ouro\033[0m";
        TextoAnimado.escrever(missao);
        String tipo = "\033[1mTipo:\033[0m Transporte clandestino";
        TextoAnimado.escrever(tipo);
        String contato = "\033[1mContato:\033[0m Jackie Welles";
        TextoAnimado.escrever(contato);
        String cliente = "\033[1mCliente:\033[0m Desconhecido (via intermediário chamado \"Silvertongue\")";
        TextoAnimado.escrever(cliente);
        String recompensa = "\033[1mRecompensa:\033[0m + 4 habilidade";
        TextoAnimado.escrever(recompensa);
        String resumo = "\033[1mResumo da Missão\033[0m";
        TextoAnimado.escrever(resumo);
        String missaoResumo1 = personagem.getNome() + " deve transportar um container selado por Night City — de Japantown até um ponto de entrega em Pacifica. O conteúdo é misterioso e valioso. Mas um velho nome do submundo descobre a movimentação… e quer a carga para si.";
        TextoAnimado.escrever(missaoResumo1);
        String pontos = "...";
        TextoAnimadoLongo.escrever(pontos);
        TextoAnimadoLongo.escrever(pontos);
        TextoAnimadoLongo.escrever(pontos);
        String missaoResumo2 = "As luzes de Japantown ainda dançam nos reflexos do asfalto molhado quando " + personagem.getNome() +" encontra Jackie na garagem subterrânea do \"Red Lotus\", um clube de mahou-trance famoso entre netrunners e caçadores de glitch. Ele está encostado na sua Yaiba Kusanagi, mascando um cigarro eletrônico com sabor de tequila.";
        TextoAnimado.escrever(missaoResumo2);
        String dialogo1 = "— Ey" + personagem.getNome() + ", pronto pra isso? O tal do Silvertongue pagou bem, mas disse pra não abrir o container nem por um segundo. Palavras dele: ‘Se você olhar, talvez ele olhe de volta.’ Seja lá o que isso signifique… ";
        TextoAnimado.escrever(dialogo1);
        System.out.println();
        String missao1 = "O container selado está ali, com trancas biométricas e proteção anti-scanner. O painel de LED exibe uma linha de código piscando em vermelho: VX-KD_Ω. Não reconhece o código. Isso é coisa de alto escalão.";
        TextoAnimado.escrever(missao1);
        TextoAnimado.escrever("Enquanto se preparam para sair, a garagem estremece com o som de um motor antigo e nervoso.");
        TextoAnimado.escrever("\033[1mUma gangue de Maelstrom\033[0m invade o local, liderada por um velho conhecido dos becos de Watson: ");
        TextoAnimado.escrever("\033[1mChromejaw\033[0m, agora com metade do crânio substituído por uma mandíbula de ouro.");
        System.out.println();
        TextoAnimado.escrever("— Eu ouvi dizer que você tem algo que pertence ao meu cliente. Entregue, e ninguém precisa virar ração de drone. ");
        String Tensao = personagem.getNome() + " está cercado. Jackie olha pra " + personagem.getNome() + ", mão próxima da pistola.";
        TextoAnimado.escrever(Tensao);
        TextoAnimado.escrever("Escolha sua próxima ação: ");
        System.out.println("1 - Fugir pela rota lateral, arriscando um caminho por Kabuki ");
        System.out.println("2 - Encarar os Maelstrom e lutar por tempo ");
        System.out.println("3 - Negociar com Chromejaw ");
        int acao = sc.nextInt();

        if (acao == 1) {
            TextoAnimado.escrever("Jackie grita — “Corre!” — enquanto " + personagem.getNome() + " ativa a porta lateral da garagem com um chute. O som da velha grade se abrindo ecoa como um alarme. " + personagem.getNome() + " e Jackie montam nas motos e disparam pelos becos estreitos de Kabuki, onde neon se mistura com fumaça de alimentos de rua e lixo. ");
            TextoAnimado.escrever("Mas não demora até que \033[1mChromejaw\033[0m envie um dos seus caçadores: \n");
            TextoAnimado.escrever("Ramone, piloto da gangue, com um corpo tão modificado que a moto é praticamente uma extensão de seus membros cibernéticos. Os olhos dele piscam em vermelho enquanto se conecta à rede de trânsito, hackeando semáforos e cortando caminho pelas vias elevadas..");
            TextoAnimado.escrever("Uma perseguição insana começa. ");
            TextoAnimado.escrever(pontos);
            TextoAnimado.escrever(pontos);
            TextoAnimado.escrever(pontos);
            TextoAnimado.escrever("Escapam por pouco, chegando ao túnel de acesso de Pacifica. Mas o container sofreu danos — uma pequena rachadura no selo revela um brilho estranho..");
            TextoAnimado.escrever("\033[1mAlgo vivo\033[0m se move dentro.");
            TextoAnimado.escrever(personagem.getNome() + " sobreviveu ao primeiro obstáculo. Mas o que há dentro daquele container pulsa com vida própria...");
            TextoAnimado.escrever("e parece estar acordando. ");
            TextoAnimado.escrever("Escolha sua próxima ação: ");
            System.out.println("1 - Abrir o container antes de entregá-lo — saber o que carrega pode salvar sua vida. ");
            System.out.println("2 - Seguir com a entrega como combinado — sem perguntas.");
            System.out.println("3 - Contatar um fixador confiável para investigar Silvertongue. ");
            int escolha = sc.nextInt();
                if(escolha == 1){
                        //Chamar a missão AbrirContainer
                        return;
                }else if(escolha == 2){
                    //Chamar a missão Seguir
                    return;
                } else if (escolha == 3) {
                    //Chamar a missão Seguir
                    return;
                }else {
                    TextoAnimado.escrever("Opção inválida, você ficou parado e foi derrotado.");
                    TextoAnimado.escrever("Missão fracassada.");
                }
        } else if (acao == 2) {
            TextoAnimado.escrever("Você enfrentou Chromejaw com coragem...");
            TextoAnimado.escrever("Depois de uma luta intensa, você vence!");

            // Aqui concluímos a missão!
            this.concluir();
            personagem.adicionarMissao(this);

            // Recompensa: ex.
            personagem.setHabilidade(personagem.getHabilidade() + 4);
            TextoAnimado.escrever("Você ganhou +4 de habilidade!");
        } else {
            TextoAnimado.escrever("Opção inválida, você ficou parado e foi derrotado.");
            TextoAnimado.escrever("Missão fracassada.");
        }

        // mostrar se a missão foi concluída ou não
        if (this.isConcluida()) {
            TextoAnimado.escrever("Missão concluída com sucesso! ✔");
        } else {
            TextoAnimado.escrever("Missão não concluída. ✖");
        }


        sc.close();
    }
}
