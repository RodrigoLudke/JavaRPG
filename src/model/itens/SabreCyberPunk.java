package model.itens;

public class SabreCyberPunk extends Itens {
    private static final String NOME = "SabreCyberPunk";
    private static final String TIPO = "Arma";
    private static final boolean PODE_USAR_EM_COMBATE = true;
    private static final int BONUS_FA = 0;
    private static final int BONUS_DANO = 10;

    public SabreCyberPunk() {
        super(NOME, TIPO, PODE_USAR_EM_COMBATE, BONUS_FA, BONUS_DANO);
    }
}
