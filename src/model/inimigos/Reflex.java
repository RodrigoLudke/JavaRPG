package model.inimigos;

import model.itens.CanhaoDePlasma;
import model.itens.Itens;
import model.itens.KatanaCromada;

import java.util.ArrayList;

public class Reflex extends Inimigos{
    public Reflex() {
        super("Meika “Reflex” Hoshino", 15, 18, 13);
        this.setOuro(0);
        this.setProvisoes(0);

        KatanaCromada katanaCromada = new KatanaCromada(); // Cria a instância do Canhão de Plasma
        getInventario().add(katanaCromada); // Adiciona ao inventário
        equiparItem(katanaCromada); // Equipar o item

    }

    public static int habilidade() {return 15;}

    public static String nome() {return "Meika “Reflex” Hoshino";}

    public static int sorte() {return 13;}

    public static int energia() {return 18;}

    public static int tesouro() {return 1500;}

    public static ArrayList<Itens> inventario() {
        ArrayList<Itens> inventario = new ArrayList<>();
        inventario.add(new KatanaCromada()); // Adiciona o Canhão de Plasma ao inventário
        return inventario;
    }
}
