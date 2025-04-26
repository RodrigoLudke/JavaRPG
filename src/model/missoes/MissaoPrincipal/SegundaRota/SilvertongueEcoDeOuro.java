package model.missoes.MissaoPrincipal.SegundaRota;

import controller.CombateController;
import controller.JogoController;
import model.Personagem;
import model.inimigos.Drones;
import model.inimigos.Silvertongue;
import model.itens.VoxOmnis;
import model.missoes.Missoes;
import view.utils.TextoAnimado;
import view.utils.TextoAnimadoLongo;

import java.util.Scanner;

public class SilvertongueEcoDeOuro extends Missoes {
    public SilvertongueEcoDeOuro() {
        super("Silvertongue: Eco de Ouro", "Você começa a ouvir boatos — sobre um novo deus digital sendo criado nas sombras... e sobre um entregador que talvez tenha dado a chave sem saber.");

    }
    public static String nome() {return "SilvertongueEcoDeOuro";}

    public static int dificuldade() {return 1;}

    @Override
    public void executar(Personagem p, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Silvertongue: Eco de Ouro");
        System.out.println("Você começa a ouvir boatos — sobre um novo deus digital sendo criado nas sombras... e sobre um entregador que talvez tenha dado a chave sem saber.");
        TextoAnimadoLongo.escrever("...");
        TextoAnimado.escrever("Após a entrega, você e Jackie voltam à barbearia improvisada de Viktor em Santo Domingo. Enquanto ele ajusta seu implante ocular, um contato anônimo no NetWatch lhe envia uma mensagem criptografada: ");
        TextoAnimado.escrever("Mensagem NetWatch (texto piscando): ");
        TextoAnimado.escrever("“Código-Áureo ativado. Sinapse-central na Omnicorp Tower, Zona Morta de Pacifica. Se não intervir, o ‘deus digital’ nascerá ao pôr do sol.” ");
        TextoAnimado.escrever("Vocês decifram coordenadas e percebem que Silvertongue usou o container como semente para um servidor neural clandestino, pronto para enterrar a vontade humana.  ");
        TextoAnimado.escrever("Em meio à névoa tóxica e streetlights cor de ferrugem, vocês escalam o esqueleto metálico da Omnicorp Tower. No nível 42, um corredor de acid-etched glass e drones de patrulha paira silencioso. ");
        TextoAnimado.escrever("“\033[1mO Conclave da Luz“\033[0m ");
        TextoAnimado.escrever("Comandante! ");
        //combate drones
        System.out.println("Gerando um número aleatório...");
        TextoAnimadoLongo.escrever("...");
        int numeroP = (int)(Math.random() * 10) + 1;
        int numeroV = (int)(Math.random() * 10) + 1;
        TextoAnimado.escrever("Adicionado " + numeroP + " as habilidades no personagem");
        int atual = p.getHabilidade();
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
        CombateController.iniciarCombate(p, new Drones(), jogo);

        TextoAnimado.escrever("Você dispara um proyectil EMP de curta distância, apagando as lâminas e atordoando os tecnoxamãs. ");
        TextoAnimado.escrever("Jackie investe com seu monoblade cortando os feixes de código que pairam no ar. ");
        TextoAnimado.escrever("Quando o último inimigo cai, você escuta um risinho... ");
        TextoAnimado.escrever("No topo da torre, uma câmara redonda abriga um gigantesco \033[1mcristal\033[0m de dados banhado a ouro líquido. Cabos pulsantes conectam-no a servidores empilhados. Silvertongue surge atrás de vocês, capuz caído, revelando olhos de metal reluzente: ");
        TextoAnimado.escrever("Silvertongue (voz calma): ");
        TextoAnimado.escrever("-Parabéns por vir tão longe. Mas o ‘eco de ouro’ não se desfaz em pedaços.");
        TextoAnimado.escrever("Ele pressiona um comando: o ouro líquido começa a se liquefazer, formando uma massa viva de código psicocinético — o proto‑deus digital. ");
        TextoAnimadoLongo.escrever("\033[1mO Coração da Criação...\033[0m");
        TextoAnimado.escrever("Combate!");
        System.out.println("Gerando um número aleatório...");
        TextoAnimadoLongo.escrever("...");
        int numeroPe = (int)(Math.random() * 10) + 1;
        int numeroVi = (int)(Math.random() * 10) + 1;
        TextoAnimado.escrever("Adicionado " + numeroPe + " as habilidades no personagem");
        int atuall = p.getHabilidade();
        int numn = atuall + numeroP;
        TextoAnimado.escrever("Total atual para de habilidades para combate: " + numn);
        TextoAnimado.escrever("Adicionado " + numeroVi + " as habilidades no Inimigo");
        int atuall2 = Silvertongue.habilidade(); // Habilidade do inimigo
        int numn2 = atuall2 + numeroVi;
        TextoAnimado.escrever("Total atual para de habilidades para combate: " + numn2);
        //iniciar combate
        TextoAnimadoLongo.escrever("Incio do combate...");
        TextoAnimado.escrever("M: Vilão em campo "); //indica que a cena é um monstro
        TextoAnimado.escrever("N: " + Silvertongue.nome()); // é o nome do monstro
        TextoAnimado.escrever( "H: "+ Silvertongue.habilidade()); //é a habilidade
        TextoAnimado.escrever( "S: "+ Silvertongue.sorte()); //é a sorte
        TextoAnimado.escrever( "E: "+ Silvertongue.energia()); //é a energia
        TextoAnimado.escrever( "T: "+ Silvertongue.tesouro()); //é o tesouro
        TextoAnimado.escrever( "I: "+ Silvertongue.inventario()); //é os itens
        TextoAnimado.escrever(VoxOmnis.descricao());
        CombateController.iniciarCombate(p, new Silvertongue(), jogo);
        p.adicionarItem(Silvertongue.inventario().get(0));
        TextoAnimado.escrever("Item adicionado ao inventário: Vox Omnis");

        TextoAnimado.escrever("O \033[1mcristal\033[0m racha, liberando uma onda de energia que envolve a sala. Você e Jackie são projetados para trás, atordoados, mas vivos. Quando a poeira baixa, Silvertongue está ajoelhado, o \033[1mcristal\033[0m desfeito em milhares de faíscas douradas que se apagam como vaga-lumes. ");
        TextoAnimado.escrever("Silvertongue (com um sorriso triste): ");
        TextoAnimado.escrever("-Eis o preço de brincar de deus. Que o silêncio quebre o eco ");
        TextoAnimado.escrever("Ele se levanta, os olhos de metal agora opacos. O ouro líquido começa a se solidificar, formando uma armadura de dados que o envolve como uma segunda pele. ");
        TextoAnimadoLongo.escrever("...");
        System.out.println();
        TextoAnimado.escrever("Com as últimas forças, ele aperta um botão no seu spike interno, apagando sua personalidade da rede. Em poucos segundos, desaparece por completo — tanto fisicamente quanto como dado. ");
        TextoAnimado.escrever("Vocês descem os andares derrubados da Omnicorp Tower. Lá fora, o céu cor-de-enxofre de Pacifica escurece sem o brilho dourado que prometia um novo deus. Jackie limpa a lama dourada do cabo de sua arma: ");
        TextoAnimado.escrever("Jackie (voz rouca): ");
        TextoAnimado.escrever("-Acabou. Ninguém vai ouvir o tal ‘eco’. ");
        TextoAnimado.escrever("Você olha para as cinzas do \033[1mcristal\033[0m e sente o pulso calmo de um mundo que segue intacto — pelo menos por enquanto. ");
        TextoAnimado.escrever("O deus digital foi contido, Silvertongue se foi, e Night City segue seu próprio ritmo frenético, indiferente aos fantasmas que quase mudaram seu curso para sempre.  ");
        TextoAnimadoLongo.escrever("\033[1mMissão Concluída: Silvertongue: Eco de Ouro\033[0m ");

        sc.close();
    }
}
