package model.inimigos;

import model.itens.Itens;
import model.itens.KitMedico;
import model.itens.Nullfang;

import java.util.ArrayList;

public class Stryx extends Inimigos{
    public Stryx() {
        super("Stryx", 10, 10, 10);
        this.setProvisoes(0);

        Nullfang nullfang = new Nullfang();
        getInventario().add(nullfang);
        equiparItem(nullfang);

        KitMedico kitMedico = new KitMedico(); // Cria a instância do Kit Médico
        getInventario().add(kitMedico); // Adiciona ao inventário

    }

    public static int habilidade() {
        return 10;
    }

    public static String nome() {
        return "Stryx";
    }

    public static int sorte() {
        return 10;
    }

    public static int energia() {
        return 10;
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
