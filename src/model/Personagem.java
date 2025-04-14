package model;

import model.missoes.Missoes;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Personagem implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private int habilidade;
    private int energia;
    private int sorte;
    private List<Item> inventario = new ArrayList<>();
    private List<Hacks> hacks = new ArrayList<>();
    private int ouro = 0;
    private int provisoes = 2;
    private List<Missoes> missoes = new ArrayList<>();

    public Personagem(String nome) {
        this.nome = nome;
    }

    // Getters e setters, adicionar item, usar provisão, etc.
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarMissao(Missoes m) {
        missoes.add(m);
    }

    public List<Missoes> getMissoes() {
        return missoes;
    }

    public int getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(int habilidade) {
        this.habilidade = habilidade;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getSorte() {
        return sorte;
    }

    public void setSorte(int sorte) {
        this.sorte = sorte;
    }

    public int getOuro() {
        return ouro;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public int getProvisoes() {
        return provisoes;
    }

    public void setProvisoes(int provisoes) {
        this.provisoes = provisoes;
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public void adicionarItem(Item item) {
        inventario.add(item);
    }

    public List<Hacks> getHacks() {
        return hacks;
    }

    public void adicionarHack(Hacks hack) {
        hacks.add(hack);
    }

}
