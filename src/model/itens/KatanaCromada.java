package model.itens;

public class KatanaCromada extends Itens{
    private static final String NOME = "Katana Cromada";
    private static final String TIPO = "Arma";
    private static final boolean PODE_USAR_EM_COMBATE = true;
    private static final int BONUS_FA = 3;
    private static final int BONUS_DANO = 8;

    public KatanaCromada() {
        super(NOME, TIPO, PODE_USAR_EM_COMBATE, BONUS_FA, BONUS_DANO);
    }
}
