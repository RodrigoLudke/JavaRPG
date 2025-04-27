package model.inimigos;

import model.hacks.Hacks;
import model.itens.Itens;
import model.hacks.VoxOmnis;

import java.util.ArrayList;

public class Silvertongue extends Inimigos{
    public Silvertongue() {
        super("Silvertongue", 10, 20, 10);
        this.setOuro(0);
        this.setProvisoes(0);

        VoxOmnis voxOmnis = new VoxOmnis(); // Cria a instância do Vox Omnis
        getHacks().add(voxOmnis); // Adiciona ao inventário

    }

    public static int habilidade() {
        return 10;
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
        return new ArrayList<>();
    }
    public static ArrayList<Hacks> hacks() {
        ArrayList<Hacks> hacks = new ArrayList<>();
        hacks.add(new VoxOmnis());
        return hacks;
    }
}
