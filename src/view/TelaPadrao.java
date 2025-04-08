package view;

import model.Personagem;
import view.utils.TextoAnimado;
import controller.JogoController;
import java.util.Scanner;

public class TelaPadrao {
    public static void IntroducaoInicial(Personagem p) throws InterruptedException {

        String introducao = " Night City — uma metrópole brilhante e decadente cravada na costa da Califórnia do Norte. Governada por megacorporações e assolada pela desigualdade, a cidade pulsa com neon, violência e tecnologia. Seus arranha-céus tocam os céus, enquanto os becos fervilham de gangues, mercenários e inteligências artificiais fora de controle. É um lugar onde tudo está à venda — desde memórias até corpos modificados com cromo. Em Night City, o sonho americano virou um pesadelo digital. Mas para muitos, ainda é o único lugar onde vale a pena lutar por um futuro — ou morrer tentando. ";
        TextoAnimado.escrever(introducao);
        System.out.println();
        String introducao2 = p.getNome() + " acorda com o gosto amargo da ressaca e promessas penduradas na agenda. As luzes da cidade invadem o apartamento pela janela quebrada, e as sirenes ao longe lembram que, em Night City, o amanhã nunca vem fácil — e o hoje já cobra caro. O telefone vibra: é Jackie. Um trampo apareceu. Pequeno, sujo, mas com potencial. Um transporte discreto, entrega rápida, ninguém faz perguntas. A carga? Um container selado vindo direto das mãos de um cliente extravagante com créditos demais e escrúpulos de menos. Lá dentro, algo exótico — um símbolo de poder para alguém que já tem tudo. Mas em Night City, até as cargas inofensivas têm dentes.";
        TextoAnimado.escrever(introducao2);
        System.out.println();

    }
}
