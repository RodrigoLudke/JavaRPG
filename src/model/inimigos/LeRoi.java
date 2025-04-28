package model.inimigos;

import model.itens.CanhaoDePlasma;
import model.itens.DronesReciclados;
import model.itens.Itens;
import model.itens.KitMedico;

import java.util.ArrayList;

public class LeRoi extends Inimigos{
    public LeRoi() {
        super("Le Roi", 10, 15, 10);
        this.setProvisoes(0);

        DronesReciclados dronesReciclados = new DronesReciclados();// Cria a instância do Drones Reciclados
        getInventario().add(dronesReciclados); // Adiciona ao inventário
        equiparItem(dronesReciclados); // Equipar o item

        KitMedico kitMedico = new KitMedico(); // Cria a instância do Kit Médico
        getInventario().add(kitMedico); // Adiciona ao inventário
    }


    public static int habilidade() {return 10;}

    public static String nome() {return "Le Roi";}

    public static int sorte() {return 10;}

    public static int energia() {return 15;}

    public static int tesouro() {return 1000;}

    public static ArrayList<Itens> inventario() {
        ArrayList<Itens> inventario = new ArrayList<>();
        inventario.add(new DronesReciclados()); // Adiciona o Canhão de Plasma ao inventário
        return inventario;
    }
}
