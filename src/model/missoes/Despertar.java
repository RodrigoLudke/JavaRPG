package model.missoes;

import controller.CombateController;
import controller.JogoController;
import model.Personagem;
import model.inimigos.ChromeJaw;
import model.inimigos.DoisGuardasArasaka;
import model.inimigos.LeRoi;
import view.utils.TextoAnimado;
import view.utils.TextoAnimadoLongo;

import java.util.Scanner;

public class Despertar extends Missoes{
    public Despertar() {
        super("ΔX: O Despertar", " Agora você carrega algo que as megacorporações vão caçar até os confins da Net.");

    }

    public static String nome() {return "Despertar";}

    public static int dificuldade() {return 1;}

    @Override
    public void executar(Personagem p, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("ΔX: O Despertar");
        System.out.println("Agora você carrega algo que as megacorporações vão caçar até os confins da Net.");
        TextoAnimado.escrever("Vocês entram num antigo armazém nos arredores de Little China, luzes de néon tremeluzem pelas frestas das portas metálicas. Jackie verifica ferimentos enquanto Eon, a criança‑ciborgue, encosta-se a uma pilastra: ");
        TextoAnimado.escrever("Eon (voz suave):");
        TextoAnimado.escrever(" -Não tenho medo de ser caçada. Só quero... viver.");
        TextoAnimado.escrever("Você conecta o decoder ao terminal local e descobre que o transporte final de dados sobre Projeto Vórtice Mental será feito hoje à noite, num velho navio cargueiro atracado no Porto Saber. ");
        TextoAnimadoLongo.escrever("...");
        TextoAnimado.escrever("Num cais silencioso, o cargueiro Rangeela Rangeela range sob a brisa salgada. Você e Jackie se aproximam de hover-bikes disfarçados. Dois guardas Arasaka fecham o portão de segurança: ");
        TextoAnimado.escrever("Comandante Arasaka:");
        TextoAnimado.escrever("Combate!");
        System.out.println("Gerando um número aleatório...");
        TextoAnimadoLongo.escrever("...");
        int numeroP = (int)(Math.random() * 10) + 1;
        int numeroV = (int)(Math.random() * 10) + 1;
        TextoAnimado.escrever("Adicionado " + numeroP + " as habilidades no personagem");
        int atual = p.getHabilidade();
        int num = atual + numeroP;
        TextoAnimado.escrever("Total atual para de habilidades para combate: " + num);
        TextoAnimado.escrever("Adicionado " + numeroV + " as habilidades no Inimigo");
        int atual2 = DoisGuardasArasaka.habilidade();
        int num2 = atual2 + numeroV;
        TextoAnimado.escrever("Total atual para de habilidades para combate: " + num2);
        //iniciar combate
        TextoAnimadoLongo.escrever("Incio do combate...");
        TextoAnimado.escrever("M: Vilão em campo "); //indica que a cena é um monstro
        TextoAnimado.escrever("N: " + DoisGuardasArasaka.nome()); // é o nome do monstro
        TextoAnimado.escrever( "H: "+ DoisGuardasArasaka.habilidade()); //é a habilidade
        TextoAnimado.escrever( "S: "+ DoisGuardasArasaka.sorte()); //é a sorte
        TextoAnimado.escrever( "E: "+ DoisGuardasArasaka.energia()); //é a energia
        TextoAnimado.escrever( "T: "+ DoisGuardasArasaka.tesouro()); //é o tesouro
        TextoAnimado.escrever( "I: "+ DoisGuardasArasaka.inventario()); //é os itens
        CombateController.iniciarCombate(p, new DoisGuardasArasaka(), jogo);
        TextoAnimado.escrever("Depois de uma luta intensa, você vence!");
        p.adicionarItem(DoisGuardasArasaka.inventario().get(0));
        TextoAnimado.escrever("Item adicionado ao inventário: rifles De Pulso");


        TextoAnimado.escrever("Com o caminho livre, vocês sobem a escada até o convés de carga. ");
        TextoAnimado.escrever("Dentro do porão principal, o container brilha com um selo holográfico. Antes que você possa conectar o spike, motores pesados ecoam: ");
        TextoAnimado.escrever("Voz pelos alto‑falantes:");
        TextoAnimado.escrever("Iniciada protocolo de destruição. Zona de contenção ativa.");
        TextoAnimado.escrever("Um exoesqueleto pesado Arasaka, call‑sign “Trovão Cinzento”, rompe a escotilha: ");
        TextoAnimado.escrever("Trovão Cinzento empunha um canhão de micro‑mísseis e lança três rajadas");
        //O combate vai aqui





        TextoAnimado.escrever("Com o gigante mecânico paralisado, você aplica um candango destemido no painel de emergência – desligando o robô de forma permanente. ");
        TextoAnimado.escrever("No escuro iluminado apenas pelos LEDs azuis, você conecta o spike e inicia o protocolo de wipe total: ");
        TextoAnimado.escrever("Deleção Segura: apaga todas as cópias digitais do “Projeto Vórtice Mental” na rede do cargueiro. ");
        TextoAnimado.escrever("Explosion Check: arma cargas de implosão magnética nos racks de dados para evitar recuperação. ");
        TextoAnimado.escrever("Enquanto Jackie segura a lanterna e Eon observa, o porão inteiro entra em colapso controlado. Vocês correm pelas rampas, saltam para as hover‑bikes e, num estrondo surdo, o navio explode num clarão alaranjado que reflete nas águas do porto. ");
        TextoAnimadoLongo.escrever("...");
        TextoAnimado.escrever("Na manhã seguinte, sob o neblina suave de Watson, vocês estacionam a moto num beco silencioso. O container está vazio, Eon vive livre de correntes digitais. ");
        TextoAnimado.escrever("Jackie (sorrindo, cansado): ");
        TextoAnimado.escrever(" “Acho que encerramos o jogo.” ");
        TextoAnimado.escrever("O sol de Neon City nasce entre prédios corroídos — por agora, o passado de “Specimen Y‑ΔX” foi varrido das memórias e dos servidores. Vocês compartilham um raro momento de paz: missão cumprida, futuro assegurado.");
        TextoAnimado.escrever("Missão Concluída: ΔX: O Despertar");
        // Aqui concluímos a missão!
        this.concluir();
        p.adicionarMissao(this);


        sc.close();
    }
}
