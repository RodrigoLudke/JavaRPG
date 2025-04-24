package model.missoes.primeiraMissao;
import controller.CombateController;
import controller.JogoController;
import model.Personagem;
import model.inimigos.Drones;
import model.missoes.Despertar;
import model.missoes.Missoes;
import view.utils.TextoAnimado;
import view.utils.TextoAnimadoLongo;

import java.util.Scanner;

import static view.utils.Cores.RESET;
import static view.utils.Cores.VERDE;

public class AbrirContainer extends Missoes {
    public AbrirContainer() {
        super("Abrir o container antes de entregá-lo ", "Jackie hesita. ");
    }

    public void executar(Personagem personagem, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        TextoAnimado.escrever("Abrir o container antes de entregá-lo");
        TextoAnimado.escrever("Jackie hesita. ");
        TextoAnimado.escrever("— Tem certeza? Se a gente abrir isso e for rastreado, tamo morto antes de ligar a moto. ");
        TextoAnimado.escrever("Mas " + personagem.getNome() + "já está plugando seu spike decodificador no painel do container. O selo começa a abrir... e o ar ao redor gela por um segundo.");
        TextoAnimado.escrever("— O que é isso? — Jackie pergunta, olhando para o container. ");
        TextoAnimado.escrever("Dentro:");
        TextoAnimado.escrever("uma criança-ciborgue, em animação suspensa. Pele artificial, olhos de espiral azul e conexões diretamente ligadas a um biochip experimental da Kang-Tao. No peito, um símbolo: ‘Specimen Y-ΔX’. A criatura abre os olhos — e " + personagem.getNome() + " sente uma pressão nos implantes cerebrais, como se alguém estivesse... escutando seus pensamentos. ");
        TextoAnimado.escrever("De repente, o sistema de alarme dispara. O selo de segurança estava conectado a uma rede satelital da Arasaka. ");
        TextoAnimadoLongo.escrever("Emboscada!");
        TextoAnimado.escrever("Drones Arasaka descem do céu, escudos ativos e metralhadoras rotativas zumbindo. ");
        TextoAnimado.escrever("Um solo equipado com exoesqueleto negro surge no telhado próximo: Operador Rei, caçador de protótipos. Ele fala como se já estivesse entediado:");
        TextoAnimado.escrever("— Objeto ΔX detectado. Eliminação de testemunhas autorizada. ");
        System.out.println();
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
        int atual2 = Drones.habilidade();
        int num2 = atual2 + numeroV;
        TextoAnimado.escrever("Total atual para de habilidades para combate: " + num2);
        //iniciar combate
        TextoAnimadoLongo.escrever("Incio do combate...");
        TextoAnimado.escrever("M: Vilão em campo "); //indica que a cena é um monstro
        TextoAnimado.escrever("N: " + Drones.nome()); // é o nome do monstro
        TextoAnimado.escrever( "H: "+ Drones.habilidade()); //é a habilidade
        TextoAnimado.escrever( "S: "+ Drones.sorte()); //é a sorte
        TextoAnimado.escrever( "E: "+ Drones.energia()); //é a energia
        CombateController.iniciarCombate(personagem, new Drones(), jogo);
        TextoAnimado.escrever("Depois de uma luta intensa, você vence!");
        TextoAnimado.escrever("No final, você e Jackie escapam... feridos, mas vivos. A criança olha pra você e fala: ");
        TextoAnimado.escrever("— Eu sou o começo. E você já está marcado. ");
        System.out.println(VERDE + "Nova Missão:" + RESET);
        Missoes despertar = new Despertar();
        despertar.executar(personagem, jogo);

        sc.close();
    }
}
