package model.inimigos;

import model.itens.CanhaoDePlasma;
import model.itens.Itens;
import model.itens.KitMedico;

import java.util.ArrayList;

public class ChromeJaw extends Inimigos {
    public ChromeJaw() {
        super("Chrome Jaw", 6, 7, 6);
        this.setProvisoes(0);

        CanhaoDePlasma canhaoDePlasma = new CanhaoDePlasma(); // Cria a instância do Canhão de Plasma
        getInventario().add(canhaoDePlasma); // Adiciona ao inventário
        equiparItem(canhaoDePlasma);
        KitMedico kitMedico = new KitMedico(); // Cria a instância do Kit Médico
        getInventario().add(kitMedico); // Adiciona ao inventário
    }

    public static int habilidade() {
        return 6;
    }

    public static String nome() {
        return "Chrome Jaw";
    }

    public static int sorte() {
        return 6;
    }

    public static int energia() {
        return 7;
    }

    public static int tesouro() {
        return 500;
    }

    public static ArrayList<Itens> inventario() {
        ArrayList<Itens> inventario = new ArrayList<>();
        inventario.add(new CanhaoDePlasma());  // Adiciona o Canhão de Plasma ao inventário
        return inventario;
    }
}
