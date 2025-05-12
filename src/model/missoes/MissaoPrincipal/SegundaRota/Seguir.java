package model.missoes.MissaoPrincipal.SegundaRota;

import controller.CombateController;
import controller.JogoController;
import model.Personagem;
import model.UparPersonagem;
import model.inimigos.Inimigos;
import model.inimigos.LeRoi;
import model.inimigos.utils.ItemFormatter;
import model.itens.Itens;
import model.missoes.Missoes;
import view.TelaInicial;
import view.utils.ApagarConsole;
import view.utils.TextoAnimado;
import view.utils.TextoAnimadoLongo;

import java.util.Scanner;

import static view.utils.Cores.RESET;
import static view.utils.Cores.VERDE;

public class Seguir extends Missoes {
    private Scanner sc;

    public Seguir() {
        super("Seguir com a entrega como combinado — sem perguntas", "Você decide manter o código. Night City já cobra caro por quem quebra acordos.");
        this.sc = new Scanner(System.in);
    }

    public void executar(Personagem personagem, JogoController jogo) throws InterruptedException {
        ApagarConsole.limparConsole();
        introduzirMissao(personagem);
        lutarContraLeRoi(personagem, jogo);
        verificarConclusao(personagem, jogo);
        sc.close();
    }

    private void introduzirMissao(Personagem personagem) throws InterruptedException {
        TextoAnimado.escrever("Seguir com a entrega como combinado — sem perguntas");
        TextoAnimado.escrever("Você decide manter o código. Night City já cobra caro por quem quebra acordos.");
        TextoAnimado.escrever("Jackie não discute — apenas acelera. Vocês passam por Charter Hill, atravessam um bloqueio policial com ajuda de subornos e finalmente entram nas ruínas decadentes de Pacifica.");
        TextoAnimado.escrever("O ponto de entrega é uma torre abandonada, onde uma figura encapuzada os espera: Silvertongue. Ele sorri com dentes de ouro polido, a voz suave e venenosa.");
        TextoAnimado.escrever("— Muito bem. Profissionalismo raro hoje em dia.");
        TextoAnimado.escrever("Mas enquanto o container é transferido, uma gangue Voodoo Boys renegada aparece. Eles querem o conteúdo para si — não por dinheiro, mas por informação genética. Liderados por LeRoi, um ex-nômade convertido em tecnoxamã, eles falam com espíritos da Net.");
    }

    private void lutarContraLeRoi(Personagem personagem, JogoController jogo) throws InterruptedException {
        TextoAnimado.escrever("Combate!");
        LeRoi leRoi = new LeRoi();

        int numeroP = (int)(Math.random() * 10) + 1;
        int numeroV = (int)(Math.random() * 10) + 1;
        TextoAnimado.escrever("Adicionado " + numeroP + " as habilidades no personagem");
        int atual = personagem.getHabilidade();
        int num = atual + numeroP;
        TextoAnimado.escrever("Total atual para de habilidades para combate: " + num);
        TextoAnimado.escrever("Adicionado " + numeroV + " as habilidades no Inimigo");
        int atual2 = leRoi.getHabilidade();
        int num2 = atual2 + numeroV;
        TextoAnimado.escrever("Total atual para de habilidades para combate: " + num2);

        mostrarInformacoesVilao(leRoi);
        CombateController.iniciarCombate(personagem, leRoi, jogo);
        UparPersonagem.uparAposCombate(personagem);
        vasculharCorpo(personagem, leRoi);
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

        CombateController.vasculharCorpo(personagem, inimigo, escolha);
    }

    private void desfechoMissao(Personagem personagem, JogoController jogo) throws InterruptedException {
        TextoAnimado.escrever("— Você fez bem, mas... o que estava dentro, agora vai mudar o mundo. Espero que você nunca descubra como.");
        TextoAnimado.escrever("Ele desaparece numa névoa de partículas, levando o container.");
        this.concluir();
    }

    private void verificarConclusao(Personagem personagem, JogoController jogo) throws InterruptedException {
        if (this.isConcluida()) {
            TextoAnimado.escrever("Missão concluída com sucesso! ✔");
            jogo.atualizarEstadoAtual("SilvertongueEcoDeOuro");
            jogo.jogoBase();
            // Implmentar logica para ir pra proxima missao
        } else {
            TextoAnimado.escrever("Missão não concluída. ✖");
            TelaInicial.mostrarMenu();
        }
    }
}
