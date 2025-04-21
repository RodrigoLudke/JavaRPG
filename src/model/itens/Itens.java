package model.itens;

import java.io.Serializable;

public class Itens implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String tipo;
    private boolean podeUsarEmCombate;
    private int bonusFA;
    private int bonusDano;
    private boolean equipado;

    public Itens(String nome, String tipo, boolean podeUsarEmCombate, int bonusFA, int bonusDano) {
        this.nome = nome;
        this.tipo = tipo;
        this.podeUsarEmCombate = podeUsarEmCombate;
        this.bonusFA = bonusFA;
        this.bonusDano = bonusDano;
        this.equipado = false;
    }
    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }
    public int getBonusFA() {
        return bonusFA;
    }
    public boolean isPodeUsarEmCombate() {
        return podeUsarEmCombate;
    }
    public boolean isEquipado() {
        return equipado;
    }
    public void setEquipado(boolean equipado) {
        this.equipado = equipado;
    }
    public int getBonusDano() {
        return bonusDano;
    }
}
