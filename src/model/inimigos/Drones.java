package model.inimigos;

import model.itens.ArmaDoDrone;
import model.itens.CanhaoDePlasma;
import model.itens.Itens;

import java.util.ArrayList;

public class Drones extends Inimigos{
    public Drones() {
        super("Drones", 3, 4, 4);
        this.setOuro(0);
        this.setProvisoes(0);

        ArmaDoDrone armaDoDrone = new ArmaDoDrone(); // Cria a instância do Canhão de Plasma
        getInventario().add(armaDoDrone); // Adiciona ao inventário
        equiparItem(armaDoDrone); // Equipar o item
    }

    public static int habilidade() {return 3;}

    public static String nome() {return "Drones";}

    public static int sorte() {return 4;}

    public static int energia() {return 4;}

    public static int tesouro() {return 0;}

    public static ArrayList<Itens> inventario() {
        ArrayList<Itens> inventario = new ArrayList<>();
        inventario.add(new ArmaDoDrone()); // Adiciona o Canhão de Plasma ao inventário
        return inventario;
    }
}
