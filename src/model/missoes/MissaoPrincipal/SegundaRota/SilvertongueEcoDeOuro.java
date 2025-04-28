package model.missoes.MissaoPrincipal.SegundaRota;

import controller.CombateController;
import controller.JogoController;
import model.Personagem;
import model.TesteSorte;
import model.UparPersonagem;
import model.hacks.VoxOmnis;
import model.inimigos.Drones;
import model.inimigos.Inimigos;
import model.inimigos.Silvertongue;
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

public class SilvertongueEcoDeOuro extends Missoes {
    private Scanner sc;

    public SilvertongueEcoDeOuro() {
        super("Silvertongue: Eco de Ouro", "Você começa a ouvir boatos — sobre um novo deus digital sendo criado nas sombras... e sobre um entregador que talvez tenha dado a chave sem saber.");
        this.sc = new Scanner(System.in);
    }

    public void executar(Personagem personagem, JogoController jogo) throws InterruptedException {
        ApagarConsole.limparConsole();
        introduzirMissao();
        lutarContraDrones(personagem, jogo);
        verificarConclusao();
        sc.close();
    }

    private void introduzirMissao() throws InterruptedException {
        TextoAnimado.escrever("Silvertongue: Eco de Ouro");
        TextoAnimado.escrever("Você começa a ouvir boatos — sobre um novo deus digital sendo criado nas sombras... e sobre um entregador que talvez tenha dado a chave sem saber.");
        ApagarConsole.limparConsole();
        TextoAnimadoLongo.escrever("...");
        TextoAnimado.escrever("Após a entrega, você e Jackie voltam à barbearia improvisada de Viktor em Santo Domingo. Enquanto ele ajusta seu implante ocular, um contato anônimo no NetWatch lhe envia uma mensagem criptografada: ");
        TextoAnimado.escrever("Mensagem NetWatch (texto piscando): ");
        TextoAnimado.escrever("Código-Áureo ativado. Sinapse-central na Omnicorp Tower, Zona Morta de Pacifica. Se não intervir, o 'deus digital' nascerá ao pôr do sol.");
        TextoAnimado.escrever("Vocês decifram coordenadas e percebem que Silvertongue usou o container como semente para um servidor neural clandestino, pronto para enterrar a vontade humana.");
        TextoAnimado.escrever("Em meio à névoa tóxica e streetlights cor de ferrugem, vocês escalam o esqueleto metálico da Omnicorp Tower. No nível 42, um corredor de acid-etched glass e drones de patrulha paira silencioso.");
        TextoAnimado.escrever("“\033[1mO Conclave da Luz“\033[0m ");
        ApagarConsole.limparConsole();
    }

    private void lutarContraDrones(Personagem personagem, JogoController jogo) throws InterruptedException {
        TextoAnimado.escrever("Combate!");
        List<Inimigos> inimigosDrones = new ArrayList<>();

        // Criar 3 drones com habilidades aleatórias
        for (int i = 1; i <= 3; i++) {
            Drones drone = new Drones();
            int numeroV = (int)(Math.random() * 10) + 1;
            drone.setHabilidade(drone.getHabilidade() + numeroV);
            TextoAnimado.escrever("Adicionado " + numeroV + " as habilidades no Inimigo");
            inimigosDrones.add(drone);

            System.out.println("\nInformações do Drone " + i + ":");
            TextoAnimado.escrever("Total atual para de habilidades para combate: " + drone.getHabilidade());
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
        // Vasculhar corpos após o combate
        TextoAnimado.escrever("Após a batalha, você observa os corpos dos guardas caídos...");
        for (int i = 0; i < inimigosDrones.size(); i++) {
            TextoAnimado.escrever("Guarda " + (i + 1) + ":");
            vasculharCorpo(personagem, inimigosDrones.get(i));
        }
        UparPersonagem.uparAposCombate(personagem);
        meioMissao(personagem, jogo);
    }

    private void meioMissao(Personagem personagem, JogoController jogo) throws InterruptedException {
        TextoAnimado.escrever("Você dispara um proyectil EMP de curta distância, apagando as lâminas e atordoando os tecnoxamãs.");
        TextoAnimado.escrever("Jackie investe com seu monoblade cortando os feixes de código que pairam no ar.");
        TextoAnimado.escrever("Quando o último inimigo cai, você escuta um risinho...");
        TextoAnimado.escrever("No topo da torre, uma câmara redonda abriga um gigantesco \033[1mcristal\033[0m de dados banhado a ouro líquido. Cabos pulsantes conectam-no a servidores empilhados. Silvertongue surge atrás de vocês, capuz caído, revelando olhos de metal reluzente:");
        TextoAnimado.escrever("Silvertongue (voz calma):");
        TextoAnimado.escrever("-Parabéns por vir tão longe. Mas o 'eco de ouro' não se desfaz em pedaços.");
        TextoAnimado.escrever("Ele pressiona um comando: o ouro líquido começa a se liquefazer, formando uma massa viva de código psicocinético — o proto‑deus digital. ");
        TextoAnimado.escrever("\033[1mO Coração da Criação...\033[0m");
        ApagarConsole.limparConsole();
        lutarContraSilvertongue(personagem, jogo);
    }

    private void lutarContraSilvertongue(Personagem personagem, JogoController jogo) throws InterruptedException {
        TextoAnimado.escrever("Combate!");
        TextoAnimado.escrever("Dejesa usar o teste de sorte?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int sorte = sc.nextInt();
        if (sorte == 1) {
            boolean sucesso = TesteSorte.testarSorte(personagem);
            if (sucesso) {
                TextoAnimado.escrever("Teste de sorte bem-sucedido!");
                TesteSorte.aplicarSorteNoCombate(personagem, new Silvertongue(), sucesso);
            } else {
                TextoAnimado.escrever("Teste de sorte falhou!");
            }
        }
        Silvertongue silvertongue = new Silvertongue();

        System.out.println("Gerando um número aleatório...");
        TextoAnimadoLongo.escrever("...");

        int numeroP = (int)(Math.random() * 10) + 1;
        int numeroV = (int)(Math.random() * 10) + 1;
        TextoAnimado.escrever("Adicionado " + numeroP + " as habilidades no personagem");
        int atual = personagem.getHabilidade();
        int num = atual + numeroP;
        TextoAnimado.escrever("Total atual para de habilidades para combate: " + num);
        TextoAnimado.escrever("Adicionado " + numeroV + " as habilidades no Inimigo");
        int atual2 = silvertongue.getHabilidade();
        int num2 = atual2 + numeroV;
        TextoAnimado.escrever("Total atual para de habilidades para combate: " + num2);
        mostrarInformacoesVilao(silvertongue);


        CombateController.iniciarCombate(personagem, silvertongue, jogo);
        UparPersonagem.uparAposCombate(personagem);
        vasculharCorpo(personagem, silvertongue);
        desfechoMissao();
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

    private void desfechoMissao() throws InterruptedException {
        TextoAnimado.escrever("O \033[1mcristal\033[0m racha, liberando uma onda de energia que envolve a sala. Você e Jackie são projetados para trás, atordoados, mas vivos. Quando a poeira baixa, Silvertongue está ajoelhado, o \033[1mcristal\033[0m desfeito em milhares de faíscas douradas que se apagam como vaga-lumes. ");
        TextoAnimado.escrever("Silvertongue (com um sorriso triste): ");
        TextoAnimado.escrever("-Eis o preço de brincar de deus. Que o silêncio quebre o eco ");
        TextoAnimado.escrever("Ele se levanta, os olhos de metal agora opacos. O ouro líquido começa a se solidificar, formando uma armadura de dados que o envolve como uma segunda pele. ");
        ApagarConsole.limparConsole();
        TextoAnimadoLongo.escrever("...");
        System.out.println();
        TextoAnimado.escrever("Com as últimas forças, ele aperta um botão no seu spike interno, apagando sua personalidade da rede. Em poucos segundos, desaparece por completo — tanto fisicamente quanto como dado. ");
        TextoAnimado.escrever("Vocês descem os andares derrubados da Omnicorp Tower. Lá fora, o céu cor-de-enxofre de Pacifica escurece sem o brilho dourado que prometia um novo deus. Jackie limpa a lama dourada do cabo de sua arma: ");
        TextoAnimado.escrever("Jackie (voz rouca): ");
        TextoAnimado.escrever("-Acabou. Ninguém vai ouvir o tal ‘eco’. ");
        TextoAnimado.escrever("Você olha para as cinzas do \033[1mcristal\033[0m e sente o pulso calmo de um mundo que segue intacto — pelo menos por enquanto. ");
        TextoAnimado.escrever("O deus digital foi contido, Silvertongue se foi, e Night City segue seu próprio ritmo frenético, indiferente aos fantasmas que quase mudaram seu curso para sempre.  ");
        TextoAnimadoLongo.escrever("\033[1mMissão Concluída: Silvertongue: Eco de Ouro\033[0m ");
        // FIM DA ROTA 2
    }

    private void verificarConclusao() throws InterruptedException {
        if (this.isConcluida()) {
            TextoAnimado.escrever("Missão concluída com sucesso! ✔");
            TextoAnimado.escrever("FIM DA ROTA 3");
            //FIM DA ROTA 3
            TelaInicial.mostrarMenu();
        } else {
            TextoAnimado.escrever("Missão não concluída. ✖");
            TelaInicial.mostrarMenu();
        }
    }
}

