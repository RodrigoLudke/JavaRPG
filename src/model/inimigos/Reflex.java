package model.inimigos;

public class Reflex extends Inimigos{
    public Reflex() {
        super("Meika “Reflex” Hoshino", 15, 18, 13);
        this.setOuro(0);
        this.setProvisoes(0);
    }

    public static int habilidade() {return 15;}

    public static String nome() {return "Meika “Reflex” Hoshino";}

    public static int sorte() {return 13;}

    public static int energia() {return 18;}

    public static int tesouro() {return 1500;}

    public static String itens() {
        String name = "Katana Cromada";
        String tipo = "w";
        int combate = 10;
        int bonus = 3;
        int dano = 8;
        return name + "," + tipo  + "," + combate  + "," + bonus + "," + dano;
    }
}
