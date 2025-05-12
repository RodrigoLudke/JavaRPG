package model.missoes.MissaoPrincipal.PrimeiraRota;

import controller.CombateController;
import controller.JogoController;
import model.Personagem;
import model.TesteSorte;
import model.UparPersonagem;
import model.inimigos.*;
import model.inimigos.utils.ItemFormatter;
import model.itens.Itens;
import model.missoes.Missoes;
import view.TelaInicial;
import view.utils.ApagarConsole;
import view.utils.TextoAnimado;
import view.utils.TextoAnimadoLongo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Despertar extends Missoes {
    private Scanner sc;

    public Despertar() {
        super("ΔX: O Despertar", "Agora você carrega algo que as megacorporações vão caçar até os confins da Net.");
        this.sc = new Scanner(System.in);
    }

    public void executar(Personagem personagem, JogoController jogo) throws InterruptedException {
        ApagarConsole.limparConsole();
        introduzirMissao(personagem);
        lutarContraGuardas(personagem, jogo);
        verificarConclusao();
        sc.close();
    }

    private void introduzirMissao(Personagem personagem) throws InterruptedException {
        TextoAnimado.escrever("ΔX: O Despertar");
        TextoAnimado.escrever("Agora você carrega algo que as megacorporações vão caçar até os confins da Net.");
        TextoAnimado.escrever("Vocês entram num antigo armazém nos arredores de Little China, luzes de néon tremeluzem pelas frestas das portas metálicas. Jackie verifica ferimentos enquanto Eon, a criança‑ciborgue, encosta-se a uma pilastra: ");
        TextoAnimado.escrever("Eon (voz suave):");
        TextoAnimado.escrever(" -Não tenho medo de ser caçada. Só quero... viver.");
        TextoAnimado.escrever("Você conecta o decoder ao terminal local e descobre que o transporte final de dados sobre Projeto Vórtice Mental será feito hoje à noite, num velho navio cargueiro atracado no Porto Saber. ");
        TextoAnimadoLongo.escrever("...");
        TextoAnimado.escrever("Num cais silencioso, o cargueiro Rangeela Rangeela range sob a brisa salgada. Você e Jackie se aproximam de hover-bikes disfarçados. Dois guardas Arasaka fecham o portão de segurança: ");
        TextoAnimado.escrever("Comandante Arasaka:");
        System.out.println();
    }

    private void lutarContraGuardas(Personagem personagem, JogoController jogo) throws InterruptedException {
        TextoAnimado.escrever("Combate!");
        List<Inimigos> inimigosGuardas = new ArrayList<>();

        // Criar 2 guardas com habilidades aleatórias
        for (int i = 1; i <= 2; i++) {
            GuardaArasaka guardaArasaka = new GuardaArasaka();
            int numeroV = (int)(Math.random() * 10) + 1;
            guardaArasaka.setHabilidade(guardaArasaka.getHabilidade() + numeroV);
            TextoAnimado.escrever("Adicionado " + numeroV + " as habilidades no Inimigo");
            inimigosGuardas.add(guardaArasaka);

            System.out.println("\nInformações do Guarda " + i + ":");
            TextoAnimado.escrever("Total atual para de habilidades para combate: " + guardaArasaka.getHabilidade());
            mostrarInformacoesVilao(guardaArasaka);
        }

        // Número aleatório para o personagem
        System.out.println("\nGerando número aleatório para o personagem...");
        TextoAnimadoLongo.escrever("...");
        int numeroP = (int)(Math.random() * 10) + 1;
        TextoAnimado.escrever("Adicionado " + numeroP + " às habilidades do personagem");
        personagem.setHabilidade(personagem.getHabilidade() + numeroP);
        TextoAnimado.escrever("Total atual de habilidades para combate: " + personagem.getHabilidade());

        CombateController.iniciarCombateComVarios(personagem, inimigosGuardas, jogo);
        // Vasculhar corpos após o combate
        TextoAnimado.escrever("Após a batalha, você observa os corpos dos guardas caídos...");
        for (int i = 0; i < inimigosGuardas.size(); i++) {
            TextoAnimado.escrever("Guarda " + (i + 1) + ":");
            vasculharCorpo(personagem, inimigosGuardas.get(i));
        }
        UparPersonagem.uparAposCombate(personagem);
        meioMissao(personagem, jogo);
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

    private void meioMissao(Personagem personagem, JogoController jogo) throws InterruptedException {
        TextoAnimado.escrever("Depois de uma luta intensa, você vence!");
        TextoAnimado.escrever("Com o caminho livre, vocês sobem a escada até o convés de carga. ");
        TextoAnimado.escrever("Dentro do porão principal, o container brilha com um selo holográfico. Antes que você possa conectar o spike, motores pesados ecoam: ");
        TextoAnimado.escrever("Voz pelos alto‑falantes:");
        TextoAnimado.escrever("Iniciada protocolo de destruição. Zona de contenção ativa.");
        TextoAnimado.escrever("Um exoesqueleto pesado Arasaka, call‑sign “Trovão Cinzento”, rompe a escotilha: ");
        TextoAnimado.escrever("Trovão Cinzento empunha um canhão de micro‑mísseis e lança três rajadas");
        lutarContraTrovaCinzento(personagem, jogo);
    }

    private void lutarContraTrovaCinzento(Personagem personagem, JogoController jogo) throws InterruptedException {
        TextoAnimado.escrever("Combate!");

        TrovaoCinzento trovaoCinzento = new TrovaoCinzento();

        int numeroP = (int)(Math.random() * 10) + 1;
        int numeroV = (int)(Math.random() * 10) + 1;
        TextoAnimado.escrever("Adicionado " + numeroP + " as habilidades no personagem");
        int atual = personagem.getHabilidade();
        int num = atual + numeroP;
        TextoAnimado.escrever("Total atual para de habilidades para combate: " + num);
        TextoAnimado.escrever("Adicionado " + numeroV + " as habilidades no Inimigo");
        int atual2 = trovaoCinzento.getHabilidade();
        int num2 = atual2 + numeroV;
        TextoAnimado.escrever("Total atual para de habilidades para combate: " + num2);

        mostrarInformacoesVilao(trovaoCinzento);
        CombateController.iniciarCombate(personagem, trovaoCinzento, jogo);
        UparPersonagem.uparAposCombate(personagem);
        vasculharCorpo(personagem, trovaoCinzento);
        desfechoMissao(personagem, jogo);
    }

    private void desfechoMissao(Personagem personagem, JogoController jogo) throws InterruptedException {
        TextoAnimado.escrever("Com o gigante mecânico paralisado, você aplica um candango destemido no painel de emergência – desligando o robô de forma permanente. ");
        TextoAnimado.escrever("No escuro iluminado apenas pelos LEDs azuis, você conecta o spike e inicia o protocolo de wipe total: ");
        TextoAnimado.escrever("Deleção Segura: apaga todas as cópias digitais do “Projeto Vórtice Mental” na rede do cargueiro. ");
        TextoAnimado.escrever("Explosion Check: arma cargas de implosão magnética nos racks de dados para evitar recuperação. ");
        TextoAnimado.escrever("Enquanto Jackie segura a lanterna e Eon observa, o porão inteiro entra em colapso controlado. Vocês correm pelas rampas, saltam para as hover‑bikes e, num estrondo surdo, o navio explode num clarão alaranjado que reflete nas águas do porto. ");
        ApagarConsole.limparConsole();
        TextoAnimadoLongo.escrever("...");
        TextoAnimado.escrever("Na manhã seguinte, sob o neblina suave de Watson, vocês estacionam a moto num beco silencioso. O container está vazio, Eon vive livre de correntes digitais. ");
        TextoAnimado.escrever("Jackie (sorrindo, cansado): ");
        TextoAnimado.escrever(" “Acho que encerramos o jogo.” ");
        TextoAnimado.escrever("O sol de Neon City nasce entre prédios corroídos — por agora, o passado de “Specimen Y‑ΔX” foi varrido das memórias e dos servidores. Vocês compartilham um raro momento de paz: missão cumprida, futuro assegurado.");
        TextoAnimado.escrever("Missão Concluída: ΔX: O Despertar");
        this.concluir();
        // Aqui concluímos a missão!
        // FIM DA ROTA 1
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


    private void verificarConclusao() throws InterruptedException {
        if (this.isConcluida()) {
            TextoAnimado.escrever("Missão concluída com sucesso! ✔");
            TextoAnimado.escrever("FIM DA ROTA 1");
            // FIM DA ROTA 1
            TelaInicial.mostrarMenu();
        } else {
            TextoAnimado.escrever("Missão não concluída. ✖");
            TelaInicial.mostrarMenu();
        }
    }
}

