package model.hacks;

public class Overheat extends Hacks {
    private static final String NOME = "Overheat";
    private static final String TIPO = "Hack";
    private static final boolean PODE_USAR_EM_COMBATE = true;
    private static final int BONUS_FA = 0;
    private static final int BONUS_DANO = 4;

    public Overheat() {
        super(NOME, TIPO, PODE_USAR_EM_COMBATE, BONUS_FA, BONUS_DANO);
    }
}
