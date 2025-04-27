package model.inimigos;

import model.itens.Itens;
import model.itens.RiflesDePulso;

import java.util.ArrayList;

public class GuardaArasaka  extends Inimigos{
    public GuardaArasaka() {
        super("Guarda Arasaka", 8, 12, 5);
        this.setOuro(0);
        this.setProvisoes(0);

        RiflesDePulso riflesDePulso = new RiflesDePulso(); // Cria a instância do Canhão de Plasma
        getInventario().add(riflesDePulso); // Adiciona ao inventário
        equiparItem(riflesDePulso);
    }

    public static int habilidade() {return 8;}

    public static String nome() {
        return "Guarda Arasaka";
    }

    public static int sorte() {
        return 5;
    }

    public static int energia() {
        return 12;
    }

    public static int tesouro() {
        return 50;
    }
    public static ArrayList<Itens> inventario() {
        ArrayList<Itens> inventario = new ArrayList<>();
        inventario.add(new RiflesDePulso()); // Adiciona o Canhão de Plasma ao inventário
        return inventario;
    }
}
