package model.inimigos;

import model.hacks.Hacks;
import model.itens.Itens;

import java.util.ArrayList;
import java.util.List;

public class Inimigos {
    private String nome;
    private int habilidade;
    private int energia;
    private int sorte;
    private int ouro;
    private int provisoes;
    private List<Itens> inventario = new ArrayList<>();
    private List<Hacks> hacks = new ArrayList<>();
    private Itens itemEquipado;

    public Inimigos(String nome, int habilidade, int energia, int sorte) {
        this.nome = nome;
        this.habilidade = habilidade;
        this.energia = energia;
        this.sorte = sorte;
    }

    // Getters e setters, adicionar item, usar provisão, etc.
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public List<Itens> getInventario() {
        return inventario;
    }

    public void adicionarItem(Itens item) {
        inventario.add(item);
    }

    public List<Hacks> getHacks() {
        return hacks;
    }

    public void adicionarHack(Hacks hack) {
        hacks.add(hack);
    }

    public Itens getItemEquipado() {
        return itemEquipado;
    }

    public void equiparItem(Itens item) {
        if (inventario.contains(item)) {
            this.itemEquipado = item;
            item.setEquipado(true); // Marca o item como equipado
        } else {
            throw new IllegalArgumentException("O item não está no inventário.");
        }
    }

    @Override
    public String toString() {
        return "Inimigo: " + nome + "\n" +
                "Habilidade: " + habilidade + "\n" +
                "Energia: " + energia;
    }
}
