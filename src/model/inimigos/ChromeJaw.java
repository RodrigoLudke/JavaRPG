package model.inimigos;

import model.itens.CanhaoDePlasma;
import model.itens.Itens;

import java.util.ArrayList;

public class ChromeJaw extends Inimigos {
    public ChromeJaw() {
        super("Chrome Jaw", 8, 10, 6);
        this.setOuro(0);
        this.setProvisoes(0);

        CanhaoDePlasma canhaoDePlasma = new CanhaoDePlasma(); // Cria a instância do Canhão de Plasma
        getInventario().add(canhaoDePlasma); // Adiciona ao inventário
        equiparItem(canhaoDePlasma);
    }

    public static int habilidade() {
        return 8;
    }

    public static String nome() {
        return "Chrome Jaw";
    }

    public static int sorte() {
        return 6;
    }

    public static int energia() {
        return 10;
    }

    public static int tesouro() {
        return 500;
    }

    public static ArrayList<Itens> inventario() {
        ArrayList<Itens> inventario = new ArrayList<>();
        inventario.add(new CanhaoDePlasma()); // Adiciona o Canhão de Plasma ao inventário
        return inventario;
    }
}
