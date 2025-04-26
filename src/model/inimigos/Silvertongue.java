package model.inimigos;

import model.itens.CanhaoDePlasma;
import model.itens.Itens;
import model.itens.VoxOmnis;

import java.util.ArrayList;

public class Silvertongue extends Inimigos{
    public Silvertongue() {
        super("Silvertongue", 20, 20, 20);
        this.setOuro(0);
        this.setProvisoes(0);

        VoxOmnis voxOmnis = new VoxOmnis();
        getInventario().add(voxOmnis);
        equiparItem(voxOmnis);

    }

    public static int habilidade() {
        return 20;
    }

    public static String nome() {
        return "Silvertongue";
    }

    public static int sorte() {
        return 20;
    }

    public static int energia() {
        return 20;
    }

    public static int tesouro() {
        return 5000;
    }

    public static ArrayList<Itens> inventario() {
        ArrayList<Itens> inventario = new ArrayList<>();
        inventario.add(new VoxOmnis());
        return inventario;
    }
}
