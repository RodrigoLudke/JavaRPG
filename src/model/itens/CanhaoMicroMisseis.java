package model.itens;

public class CanhaoMicroMisseis extends Itens{
    private static final String NOME = "Canhão Micro-Mísseis";
    private static final String TIPO = "Arma";
    private static final boolean PODE_USAR_EM_COMBATE = true;
    private static final int BONUS_FA = 0;
    private static final int BONUS_DANO = 25;

    public CanhaoMicroMisseis() {
        super(NOME, TIPO, PODE_USAR_EM_COMBATE, BONUS_FA, BONUS_DANO);
    }
}
