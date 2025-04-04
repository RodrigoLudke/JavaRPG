package model;

public class Item {
    private String nome;
    private String tipo;
    private boolean podeUsarEmCombate;
    private int bonusFA;
    private int bonusDano;

    public Item(String nome, String tipo, boolean podeUsarEmCombate, int bonusFA, int bonusDano) {
        this.nome = nome;
        this.tipo = tipo;
        this.podeUsarEmCombate = podeUsarEmCombate;
        this.bonusFA = bonusFA;
        this.bonusDano = bonusDano;
    }
}
