package model.inimigos;

public class LeRoi extends Inimigos{
    public LeRoi() {
        super("Le Roi", 10, 15, 10);
        this.setOuro(0);
        this.setProvisoes(0);
    }

    public static int habilidade() {return 10;}

    public static String nome() {return "Le Roi";}

    public static int sorte() {return 10;}

    public static int energia() {return 15;}

    public static int tesouro() {return 1000;}

    public static String itens() {
        String name = "Drones Reciclados";
        String tipo = "w";
        int combate = 10;
        int bonus = 5;
        int dano = 10;
        return name + "," + tipo  + "," + combate  + "," + bonus + "," + dano;
    }
}
