package model.missoes;
import controller.JogoController;
import model.Personagem;
import view.utils.TextoAnimadoLongo;

public class AbrirContainer extends Missoes {
    public AbrirContainer() {
        super("Abrir o container antes de entregá-lo ", "Jackie hesita. ");
    }

    public void executar(Personagem personagem, JogoController jogo) throws InterruptedException {

    }
}
