package model;

import java.util.ArrayList;
import java.util.List;

public class Personagem {
    private String nome;
    private int habilidade;
    private int energia;
    private int sorte;
    private List<Item> inventario = new ArrayList<>();
    private List<Magia> magias = new ArrayList<>();
    private int ouro = 0;
    private int provisoes = 2;

    public Personagem(String nome) {
        this.nome = nome;
    }

    // Getters e setters, adicionar item, usar provisão, etc.
}
