package model.itens;

public class RiflesDePulso extends Itens{
    private static final String NOME = "Rifles de Pulso";
    private static final String TIPO = "Arma";
    private static final boolean PODE_USAR_EM_COMBATE = true;
    private static final int BONUS_FA = 0;
    private static final int BONUS_DANO = 15;

    public RiflesDePulso() {
        super(NOME, TIPO, PODE_USAR_EM_COMBATE, BONUS_FA, BONUS_DANO);
    }
}
