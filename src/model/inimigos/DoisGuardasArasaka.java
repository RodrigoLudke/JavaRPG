package model.inimigos;

import model.itens.CanhaoDePlasma;
import model.itens.Itens;
import model.itens.RiflesDePulso;

import java.util.ArrayList;

public class DoisGuardasArasaka extends Inimigos{
    public DoisGuardasArasaka() {
        super("Dois Guardas Arasaka", 15, 20, 6);
        this.setOuro(0);
        this.setProvisoes(0);

        RiflesDePulso riflesDePulso = new RiflesDePulso(); // Cria a instância do Canhão de Plasma
        getInventario().add(riflesDePulso); // Adiciona ao inventário
        equiparItem(riflesDePulso);
    }

    public static int habilidade() {return 15;}

    public static String nome() {
        return "Dois Guardas Arasaka";
    }

    public static int sorte() {
        return 6;
    }

    public static int energia() {
        return 20;
    }

    public static int tesouro() {
        return 100;
    }

    public static ArrayList<Itens> inventario() {
        ArrayList<Itens> inventario = new ArrayList<>();
        inventario.add(new RiflesDePulso()); // Adiciona o Canhão de Plasma ao inventário
        return inventario;
    }
}
