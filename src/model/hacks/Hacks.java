package model.hacks;

public class Hacks {
    private String nome;
    private String tipo;
    private boolean podeUsarEmCombate;
    private int bonusFA;
    private int bonusDano;

    public Hacks(String nome, String tipo, boolean podeUsarEmCombate, int bonusFA, int bonusDano) {
        this.nome = nome;
        this.tipo = tipo;
        this.podeUsarEmCombate = podeUsarEmCombate;
        this.bonusFA = bonusFA;
        this.bonusDano = bonusDano;
    }
    public String getNome() {
        return nome;
    }
    public boolean isPodeUsarEmCombate() {
        return podeUsarEmCombate;
    }
    public int getBonusDano() {
        return bonusDano;
    }
}