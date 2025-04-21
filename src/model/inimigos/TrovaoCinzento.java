package model.inimigos;

import model.itens.CanhaoMicroMisseis;
import model.itens.Itens;
import model.itens.RiflesDePulso;

import java.util.ArrayList;

public class TrovaoCinzento extends Inimigos{
    public TrovaoCinzento() {
        super("Trovão Cinzento", 18, 20, 15);
        this.setOuro(0);
        this.setProvisoes(0);

        CanhaoMicroMisseis canhaoMicroMisseis = new CanhaoMicroMisseis(); // Cria a instância do Canhão de Plasma
        getInventario().add(canhaoMicroMisseis); // Adiciona ao inventário
        equiparItem(canhaoMicroMisseis);
    }

    public static int habilidade() {return 18;}

    public static String nome() {
        return "Trovão Cinzento";
    }

    public static int sorte() {
        return 15;
    }

    public static int energia() {
        return 20;
    }

    public static int tesouro() {
        return 0;
    }

    public static ArrayList<Itens> inventario() {
        ArrayList<Itens> inventario = new ArrayList<>();
        inventario.add(new CanhaoMicroMisseis()); // Adiciona o Canhão de Plasma ao inventário
        return inventario;
    }
}
