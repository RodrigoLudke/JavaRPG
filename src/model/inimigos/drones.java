package model.inimigos;

public class drones extends Inimigos{
    public drones() {
        super("Drones", 3, 4, 4);
        this.setOuro(0);
        this.setProvisoes(0);
    }

    public static int habilidade() {return 3;}

    public static String nome() {return "Drones";}

    public static int sorte() {return 4;}

    public static int energia() {return 4;}

    public static int tesouro() {return 0;}

    public static String itens() {
        String name = "drones";
        String tipo = "w";
        int combate = 1;
        int bonus = 2;
        int dano = 2;
        return name + "," + tipo  + "," + combate  + "," + bonus + "," + dano;
    }
}
