package model.missoes;

import controller.JogoController;
import model.Personagem;
import model.inimigos.ChromeJaw;
import model.inimigos.Inimigos;
import view.utils.TextoAnimado;

import java.util.Scanner;

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
        String missaoResumo1 = "Você deve transportar um container selado por Night City — de Japantown até um ponto de entrega em Pacifica. O conteúdo é misterioso e valioso. Mas um velho nome do submundo descobre a movimentação… e quer a carga para si.";
        TextoAnimado.escrever(missaoResumo1);
        System.out.println();
        String pontos = "\033[1m...\033[0m\n";
        TextoAnimado.escrever(pontos);
        System.out.println();
        String novoElemento = VERMELHO + "\033[1mNovo Elemento!\033[0m" + RESET;
        TextoAnimado.escrever(novoElemento);
        System.out.println();
        String fala = "-Você nem sabe o que tá carregando, " + personagem.getNome() + ",  Mas eu sei. E eu vim buscar o que é meu...\033[1mcom juros.\033[0m\n";
        TextoAnimado.escrever(fala);
        System.out.println();
        String monstro = VERMELHO + "\033[1mVilão – Chromejaw\033[0m" + RESET;
        TextoAnimado.escrever(monstro);
        System.out.println("\033[1mAfiliado:\033[0m Ex-Maelstrom, agora mercenário solo\n" +
                "\033[1mAparência:\033[0m Mandíbula de aço dourado, olhos vermelhos de escaneamento militar, braços substituídos por próteses com lâminas retráteis e armas integradas.\n\033[1mMotivação:\033[0m Chromejaw foi contratado por um rival do cliente para interceptar a carga.\nMas também quer usá-la como moeda de troca para subir de volta na cadeia alimentar de Night City.");

        jogo.jogoCombate(new ChromeJaw());

        sc.close();
    }
}
