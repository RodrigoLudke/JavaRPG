package model.missoes;
import controller.JogoController;
import model.Monstro;
import model.Personagem;
import view.utils.TextoAnimado;
import view.utils.TextoAnimadoLongo;
import java.util.Scanner;

import static view.TelaCombate.combate;
import static view.utils.Cores.RESET;
import static view.utils.Cores.VERMELHO;

public class AbrirContainer extends Missoes {
    public AbrirContainer() {
        super("Abrir o container antes de entregá-lo ", "Jackie hesita. ");
    }

    public void executar(Personagem personagem, JogoController jogo) throws InterruptedException {

    }
}
