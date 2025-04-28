package model;

import model.hacks.Hacks;
import model.itens.Itens;
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
    private List<Itens> inventario = new ArrayList<>();
    private List<Hacks> hacks = new ArrayList<>();
    private int ouro = 0;
    private int provisoes = 0;
    private List<Missoes> missoes = new ArrayList<>();
    private Itens itemEquipado;
    private int xp = 0;
    private int level = 1;
    private int energiaMaxima = 20;


    public Personagem(String nome) {
        this.nome = nome;
        if (nome.equals("wize")) {
            Itens EspadaDoDev = new Itens("EspadaDoDev", "Arma", true, 100, 999);
            adicionarItem(EspadaDoDev);
        }
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

    public List<Itens> getInventario() {
        return inventario;
    }

    public void adicionarItem(Itens item) { inventario.add(item);}

    public List<Hacks> getHacks() {
        return hacks;
    }

    public void adicionarHack(Hacks hack) {
        hacks.add(hack);
    }

    // Getters e setters, adicionar item, usar provisão, etc.
    public Itens getItemEquipado() {
        return itemEquipado;
    }

    public void equiparItem(Itens item) {
        if (inventario.contains(item)) {
            // Desequipa todos os itens do mesmo tipo
            for (Itens i : inventario) {
                if (i.getTipo().equals(item.getTipo())) {
                    i.setEquipado(false);
                }
            }

            // Equipa o novo item
            this.itemEquipado = item;
            item.setEquipado(true);
            System.out.println(item.getNome() + " foi equipado.");
        } else {
            throw new IllegalArgumentException("O item não está no inventário.");
        }
    }

    public void desequiparItem() {
        if (itemEquipado != null) {
            itemEquipado.setEquipado(false); // Marca o item como não equipado
            System.out.println(itemEquipado.getNome() + " foi desequipado.");
            this.itemEquipado = null;
        } else {
            System.out.println("Nenhum item está equipado.");
        }
    }
    //Getters e setters para XP e Level
    public int getXp() { return xp; }
    public void setXp(int xp) { this.xp = xp; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    public int getEnergiaMaxima() { return energiaMaxima; }
    public void setEnergiaMaxima(int energiaMaxima) { this.energiaMaxima = energiaMaxima; }
}
