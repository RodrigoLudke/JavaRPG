package model.itens;

public class ArmaDoDrone extends Itens {
    private static final String NOME = "Arma do Drone";
    private static final String TIPO = "w";
    private static final boolean PODE_USAR_EM_COMBATE = true;
    private static final int BONUS_FA = 1;
    private static final int BONUS_DANO = 2;

    public ArmaDoDrone() {
        super(NOME, TIPO, PODE_USAR_EM_COMBATE, BONUS_FA, BONUS_DANO);
    }
}
