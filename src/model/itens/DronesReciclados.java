package model.itens;

public class DronesReciclados extends Itens{
    private static final String NOME = "Drones Reciclados";
    private static final String TIPO = "Arma";
    private static final boolean PODE_USAR_EM_COMBATE = true;
    private static final int BONUS_FA = 5;
    private static final int BONUS_DANO = 10;

    public DronesReciclados() {
        super(NOME, TIPO, PODE_USAR_EM_COMBATE, BONUS_FA, BONUS_DANO);
    }
}
