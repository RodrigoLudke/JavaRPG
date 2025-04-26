package model.missoes.MissaoPrincipal.PrimeiraRota;
import controller.CombateController;
import controller.JogoController;
import model.Personagem;
import model.inimigos.ChromeJaw;
import model.inimigos.Drones;
import model.inimigos.Inimigos;
import model.inimigos.utils.ItemFormatter;
import model.missoes.Missoes;
import view.TelaInicial;
import view.utils.ApagarConsole;
import view.utils.TextoAnimado;
import view.utils.TextoAnimadoLongo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static view.utils.Cores.RESET;
import static view.utils.Cores.VERDE;

public class AbrirContainer extends Missoes {
    private String pontos = "...";
    private Scanner sc;

    public AbrirContainer() {
        super("Abrir o container antes de entregá-lo ", "Jackie hesita. ");
        this.sc = new Scanner(System.in);
    }

    public void executar(Personagem personagem, JogoController jogo) throws InterruptedException {
        ApagarConsole.limparConsole();
        introduzirMissao(personagem);
        lutarContraDrones(personagem, jogo);
        verificarConclusao();
        sc.close();
    }

    private void introduzirMissao(Personagem personagem) throws InterruptedException {
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
    }

    private void lutarContraDrones(Personagem personagem, JogoController jogo) throws InterruptedException {
        TextoAnimado.escrever("Combate!");
        List<Inimigos> inimigosDrones = new ArrayList<>();

        // Criar 3 drones com habilidades aleatórias
        for (int i = 1; i <= 3; i++) {
            Drones drone = new Drones();
            int numeroV = (int)(Math.random() * 10) + 1;
            drone.setHabilidade(drone.getHabilidade() + numeroV);
            inimigosDrones.add(drone);

            TextoAnimado.escrever("\nInformações do Drone " + i + ":");
            mostrarInformacoesVilao(drone);
        }

        // Número aleatório para o personagem
        System.out.println("\nGerando número aleatório para o personagem...");
        TextoAnimadoLongo.escrever("...");
        int numeroP = (int)(Math.random() * 10) + 1;
        TextoAnimado.escrever("Adicionado " + numeroP + " às habilidades do personagem");
        personagem.setHabilidade(personagem.getHabilidade() + numeroP);
        TextoAnimado.escrever("Total atual de habilidades para combate: " + personagem.getHabilidade());

        CombateController.iniciarCombateComVarios(personagem, inimigosDrones, jogo);
        desfechoMissao(personagem, jogo);
    }

    private void mostrarInformacoesVilao(Inimigos drone) throws InterruptedException {
        TextoAnimado.escrever("M: Vilão em campo");
        TextoAnimado.escrever("N: " + drone.getNome());
        TextoAnimado.escrever("H: " + drone.getHabilidade());
        TextoAnimado.escrever("S: " + drone.getSorte());
        TextoAnimado.escrever("E: " + drone.getEnergia());
        TextoAnimado.escrever("T: " + drone.getTesouro());
        TextoAnimado.escrever("I: " + ItemFormatter.formatarInventario(drone.getInventario()));
    }

    private void desfechoMissao(Personagem personagem, JogoController jogo) throws InterruptedException {
        TextoAnimado.escrever("Depois de uma luta intensa, você vence!");
        TextoAnimado.escrever("No final, você e Jackie escapam... feridos, mas vivos. A criança olha pra você e fala: ");
        TextoAnimado.escrever("— Eu sou o começo. E você já está marcado. ");
        Missoes despertar = new Despertar();
        despertar.executar(personagem, jogo);
    }

    private void verificarConclusao() throws InterruptedException {
        if (this.isConcluida()) {
            TextoAnimado.escrever("Missão concluída com sucesso! ✔");
            //implementar logica para ir para proxima missao
        } else {
            TextoAnimado.escrever("Missão não concluída. ✖");
            TelaInicial.mostrarMenu();
        }
    }
}
