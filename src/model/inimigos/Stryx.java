package model.inimigos;

import model.itens.Itens;
import model.itens.Nullfang;

import java.util.ArrayList;

public class Stryx extends Inimigos{
    public Stryx() {
        super("Stryx", 15, 15, 15);
        this.setOuro(0);
        this.setProvisoes(0);

        Nullfang nullfang = new Nullfang();
        getInventario().add(nullfang);
        equiparItem(nullfang);

    }

    public static int habilidade() {
        return 15;
    }

    public static String nome() {
        return "Stryx";
    }

    public static int sorte() {
        return 15;
    }

    public static int energia() {
        return 15;
    }

    public static int tesouro() {
        return 0;
    }

    public static ArrayList<Itens> inventario() {
        ArrayList<Itens> inventario = new ArrayList<>();
        inventario.add(new Nullfang());
        return inventario;
    }
}
