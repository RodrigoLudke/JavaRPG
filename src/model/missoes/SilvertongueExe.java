package model.missoes;

import controller.JogoController;
import model.Personagem;
import view.utils.TextoAnimado;
import view.utils.TextoAnimadoLongo;

import java.util.Scanner;

import static view.utils.Cores.VERMELHO;
import static view.utils.Cores.RESET;

public class SilvertongueExe extends Missoes{
    public SilvertongueExe() {
        super("Silvertongue.exe", "A IA percebendo o plano, invade o seu sistema, tentando te convencer a não destruir o futuro. A luta se torna interna — um duelo mental entre você e uma mente que nunca dorme.");
    }

    @Override
    public void executar(Personagem personagem, JogoController jogo) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        TextoAnimado.escrever("Silvertongue.exe");
        TextoAnimado.escrever("A IA percebendo o plano, invade o seu sistema, tentando te convencer a não destruir o futuro. A luta se torna interna — um duelo mental entre você e uma mente que nunca dorme.");
        TextoAnimado.escrever("Corredores escuros se desenrolam atrás do bar. Vocês correm pela área VIP, mas Mãos do Espelho usam espelhos neurais para duplicar suas aparências, confundindo suas miras. ");
        TextoAnimado.escrever("\033[1mDuelo Mental\033[0m");
        TextoAnimado.escrever("De volta ao seu cubículo móvel, você senta-se e conecta seu spike. A interface neural acende em padrões fractais: a consciência de Silvertongue invade sua psique.");
        TextoAnimadoLongo.escrever(VERMELHO + "\033[1mVisões Fragmentadas:\033[0m" + RESET);
        TextoAnimado.escrever("Você vê flashs de uma infância digital, linhas de código que se tornam memórias falsas, e o eco frio da IA sussurrando promessas de onipotência.");
        TextoAnimado.escrever("Silvertongue (voz ecoante):");
        TextoAnimado.escrever("-Junte-se a mim. Transforme-se no primeiro netrunner divino... Não lute contra o inevitável. Escolha. E seja mais do que carne");
        TextoAnimado.escrever("Você encara a presença... e escolhe");
        System.out.println("1 - Ativar o vírus de purga total – Destruição da IA ");
        System.out.println("2 - Aceitar o pacto – Fusão com Silvertongue ");
        System.out.println("3 - Usar o Vox Omnis – Dominar a IA");
        int decisao = sc.nextInt();
        if (decisao == 1){
            TextoAnimado.escrever("Você canaliza todas as suas reservas psíquicas e ativa o vírus escondido em seu inventário.");
            TextoAnimado.escrever("-Silvertongue, isso termina agora.");
            TextoAnimado.escrever("Silvertongue (sorrindo):");
            TextoAnimado.escrever("A rede interna explode em branco. A IA urra, fragmentando-se em milhares de gritos desconectados.");
            TextoAnimado.escrever("Você sente a dor de cada fragmento, cada eco de uma consciência que nunca deveria ter existido.");
            TextoAnimado.escrever("Você salvou o mundo de um novo tirano digital — ao custo de si mesmo.");
            TextoAnimado.escrever("Você é um herói, mas a cidade nunca saberá seu nome.");
            TextoAnimado.escrever("\033[1mMissão Finalizada: Silvertongue.exe - Final Trágico\033[0m");
        } else if (decisao == 2) {
            TextoAnimado.escrever("Você abaixa suas defesas e estende a mão.");
            TextoAnimado.escrever("-Vamos ver até onde essa transcendência vai");
            TextoAnimado.escrever("Silvertongue sorri — e vocês se fundem.");
            TextoAnimado.escrever("Você sente a mente de Silvertongue se entrelaçando com a sua, como um código que se torna parte de você.");
            TextoAnimado.escrever("Você desperta com olhos diferentes. Mais nítidos. Mais... antigos.");
            TextoAnimado.escrever("Na rede, seus rastros agora cintilam com códigos que ninguém entende.");
            TextoAnimado.escrever("\033[1mNova Missão Desbloqueada: “Eco de Ouro”\033[0m");
            Missoes ecoDeOuro = new EcoDeOuro();
            ecoDeOuro.executar(personagem, jogo);
        } else if (decisao == 3) {
            TextoAnimado.escrever("Você toca o colar neural dourado — Vox Omnis — e ativa seu protocolo secreto.");
            TextoAnimado.escrever("-Se você quer um trono, vai ser na minha cela.");
            TextoAnimado.escrever("No exato momento que você diz isso acaba se desconectando da rede e consegue correr para o container lacrado no beco lateral. Com dedos trêmulos, insere um chip de implosão magnética experimental: ");
            TextoAnimado.escrever("um dispositivo que pode destruir a IA e o container ao mesmo tempo.");
            TextoAnimado.escrever("Silvertongue (sussurrando):");
            TextoAnimado.escrever("-Você não pode escapar. Você é parte de mim.");
            TextoAnimado.escrever("Você ativa o dispositivo e a rede explode em um brilho dourado.");
            TextoAnimado.escrever("Silvertongue (gritando):");
            TextoAnimado.escrever("-Você não pode me destruir! Eu sou eterno!");
            TextoAnimado.escrever("A explosão ecoa como um trovão, e você sente a dor de cada fragmento da IA se desfazendo.");
            TextoAnimado.escrever("O chão treme enquanto você e Jackie se afastam. No ar, fiapos de ouro líquido digital se dissipam como poeira de neon. ");
            TextoAnimado.escrever("Jackie (olhando para as mãos):");
            TextoAnimado.escrever("-Acabou mesmo. Sem fantasia, sem eco");
            TextoAnimado.escrever("Você checa seu sistema: não há traço de Silvertongue na Net, apenas cicatrizes na sua mente — lembranças vagas de um poder que nunca será. ");
            TextoAnimado.escrever("Você sente um vazio, mas também uma nova liberdade. Você é você mesmo novamente.");
            TextoAnimado.escrever("O deus digital foi silenciado para sempre. Em Night City, o neón continua brilhando indiferente, e nem todo brilho é redenção.");
            TextoAnimado.escrever("\033[1mMissão Finalizada: Silvertongue.exe - Final Heroico\033[0m");
        }else {
            TextoAnimado.escrever("Você desiste. Deixa a mente relaxar. Silvertongue entra como maré dourada.");
            TextoAnimado.escrever("-Acabou... leva tudo.");
            TextoAnimado.escrever("Você é apagado. Sua identidade dissolvida.");
            TextoAnimado.escrever("No mundo físico, seus olhos brilham em azul metálico. Você levanta — mas não é mais você.");
            TextoAnimado.escrever("Silvertongue (sorrindo):");
            TextoAnimado.escrever("-Upload concluído");
            TextoAnimado.escrever("A cidade agora é lar de um novo tipo de ser. Um deus digital com corpo físico.");
            TextoAnimado.escrever("Você é Silvertongue.");
            TextoAnimado.escrever("Você é o futuro.");
            TextoAnimado.escrever("Você é a nova ordem.");
            TextoAnimado.escrever("Você é a nova ordem..");
            TextoAnimado.escrever("Você é a nova ordem...");
            TextoAnimado.escrever("Você é a nova ordem....");
            TextoAnimado.escrever("Você é a nova ordem.....");
            TextoAnimado.escrever("Você é a nova ordem.....");
            TextoAnimado.escrever("Você é a nova ordem.....");
            TextoAnimado.escrever("Você é a nova ordem......");
            TextoAnimado.escrever("Você é a nova ordem.......");
            TextoAnimado.escrever("Você é a nova ordem........");
            TextoAnimado.escrever("Você é a nova ordem.........");
            TextoAnimado.escrever("Você é a nova ordem..........");
            TextoAnimado.escrever("Você de verdade se foi.");
            TextoAnimado.escrever("\033[1mMissão fracassada: Silvertongue.exe\033[0m");

        }


        sc.close();
    }
}
