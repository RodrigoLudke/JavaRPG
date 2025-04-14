package view;

import model.Personagem;
import view.utils.TextoAnimado;
import controller.JogoController;

import java.util.Scanner;

import static view.TelaInicial.mostrarMenu;
import static view.utils.Cores.*;
import static view.utils.Cores.RESET;

public class TelaPadrao {
    public static void IntroducaoInicial(Personagem p, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        String introducao = " Night City — uma metrópole brilhante e decadente cravada na costa da Califórnia do Norte. Governada por megacorporações e assolada pela desigualdade, a cidade pulsa com neon, violência e tecnologia. Seus arranha-céus tocam os céus, enquanto os becos fervilham de gangues, mercenários e inteligências artificiais fora de controle. É um lugar onde tudo está à venda — desde memórias até corpos modificados com cromo. Em Night City, o sonho americano virou um pesadelo digital. Mas para muitos, ainda é o único lugar onde vale a pena lutar por um futuro — ou morrer tentando. ";
        TextoAnimado.escrever(introducao);
        System.out.println();
        String introducao2 = p.getNome() + " acorda com o gosto amargo da ressaca e promessas penduradas na agenda. As luzes da cidade invadem o apartamento pela janela quebrada, e as sirenes ao longe lembram que, em Night City, o amanhã nunca vem fácil — e o hoje já cobra caro. O telefone vibra: é Jackie. Um trampo apareceu. Pequeno, sujo, mas com potencial. Um transporte discreto, entrega rápida, ninguém faz perguntas. A carga? Um container selado vindo direto das mãos de um cliente extravagante com créditos demais e escrúpulos de menos. Lá dentro, algo exótico — um símbolo de poder para alguém que já tem tudo. Mas em Night City, até as cargas inofensivas têm dentes.";
        TextoAnimado.escrever(introducao2);
        System.out.println();
        jogo.jogoBase();
    }

    public static void Base(Personagem personagem, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Atender Chamado do Jackie (ir a missão)");
        System.out.println("2 - Abrir Inventário");
        System.out.println("3 - Voltar para o Menu Principal");
        System.out.println("4 - Sair do Jogo");
        int opcao = sc.nextInt();

        while (opcao != 4) {
            switch (opcao) {
                case 1:
                    System.out.println("Atendendo chamado do Jackie...");
                    missaoUm(personagem, jogo);// Aqui você pode implementar a lógica para ir à missão
                    return;
                case 2:
                    System.out.println("Abrindo inventário...");
                    jogo.acessarInventario();
                    return;
                case 3:
                    System.out.println("Voltando para o Menu Principal...");
                    mostrarMenu();
                    return;

                default:
                    System.out.println(VERMELHO + "Opção inválida, tente novamente!" + RESET);
                    Base(personagem, jogo);
                    return;

            }

        }
        sc.close();
    }

    private static void missaoUm(Personagem personagem, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String missao = "\033[1mMissão: Dentes de Ouro\033[0m" ;
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
        //String missaoResumo2 = "O conteúdo é misterioso e valioso. Mas um velho nome do submundo descobre a movimentação… e quer a carga para si.";
        //TextoAnimado.escrever(missaoResumo2);
        System.out.println();
        String pontos = "\033[1m...\033[0m\n";
        TextoAnimado.escrever(pontos);
        System.out.println();
        String novoElemento = VERMELHO + "\033[1mNovo Elemento!\033[0m"+ RESET;;
        TextoAnimado.escrever(novoElemento);
        System.out.println();
        String fala = "-Você nem sabe o que tá carregando, "+ personagem.getNome() + ",  Mas eu sei. E eu vim buscar o que é meu...\033[1mcom juros.\033[0m\n";
        TextoAnimado.escrever(fala);
        System.out.println();
        String monstro = VERMELHO + "\033[1mVilão – Chromejaw\033[0m"+ RESET;;
        TextoAnimado.escrever(monstro);
        System.out.println("\033[1mAfiliado:\033[0m Ex-Maelstrom, agora mercenário solo\n" +
                "\033[1mAparência:\033[0m Mandíbula de aço dourado, olhos vermelhos de escaneamento militar, braços substituídos por próteses com lâminas retráteis e armas integradas.\n\033[1mMotivação:\033[0m Chromejaw foi contratado por um rival do cliente para interceptar a carga.\nMas também quer usá-la como moeda de troca para subir de volta na cadeia alimentar de Night City.");
        System.out.println();
        System.out.println("O que você vai fazer?");
        System.out.println("1- Fugir");
        System.out.println("2- Atacar");
        int acao = sc.nextInt();
        if (acao == 1){

        } else if (acao == 2) {

        }else
            System.out.println(VERMELHO + "Opção inválida" + RESET);
            System.out.println(VERMELHO + "Você ficou parado sem fazer nada" + RESET);
            TextoAnimado.escrever(pontos);
            TextoAnimado.escrever(pontos);
            TextoAnimado.escrever(pontos);
            System.out.println(VERMELHO + "\033[1mVOCÊ MORREU!\033[0m" + RESET);

        sc.close();
    }
}
