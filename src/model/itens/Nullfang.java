package model.itens;

public class Nullfang extends Itens{
    private static final String NOME = "Nullfang";
    private static final String TIPO = "Arma";
    private static final boolean PODE_USAR_EM_COMBATE = true;
    private static final int BONUS_FA = 2;
    private static final int BONUS_DANO = 5;

    public Nullfang() {
        super(NOME, TIPO, PODE_USAR_EM_COMBATE, BONUS_FA, BONUS_DANO);
    }
}
