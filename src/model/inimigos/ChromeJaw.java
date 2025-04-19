package model.inimigos;

public class ChromeJaw extends Inimigos {
    public ChromeJaw() {
        super("Chrome Jaw", 8, 10, 6);
        this.setOuro(5);
        this.setProvisoes(0);
    }

    public static int habilidade() {return 8;}

    public static String nome() {return "Chrome Jaw";}

    public static int sorte() {return 6;}

    public static int energia() {return 10;}

    public static int tesouro() {return 500;}

    public static String itens() {
        String name = "canhão de plasma";
        String tipo = "w";
        int combate = 1;
        int bonus = 5;
        int dano = 5;
        return name + "," + tipo  + "," + combate  + "," + bonus + "," + dano;
    }
}
