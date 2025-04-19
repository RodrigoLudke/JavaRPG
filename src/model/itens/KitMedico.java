package model.itens;

public class KitMedico extends Itens {
    private static final String NOME = "Kit Medico";
    private static final String TIPO = "Cura";
    private static final boolean PODE_USAR_EM_COMBATE = false;
    private static final int BONUS_FA = 0;
    private static final int BONUS_DANO = 0;

    public KitMedico() {
        super(NOME, TIPO, PODE_USAR_EM_COMBATE, BONUS_FA, BONUS_DANO);
    }
}
