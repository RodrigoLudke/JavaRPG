package model.hacks;

public class VoxOmnis extends Hacks {
    private static final String NOME = "VoxOmnis";
    private static final String TIPO = "Hack";
    private static final boolean PODE_USAR_EM_COMBATE = true;
    private static final int BONUS_FA = 0;
    private static final int BONUS_DANO = 0;

    public VoxOmnis() {
        super(NOME, TIPO, PODE_USAR_EM_COMBATE, BONUS_FA, BONUS_DANO);
    }
    public static String descricao(){
        return "\033[1mControle de campo de batalha:\033[0m Ele emite impulsos subliminares que desestabilizam os sentidos dos inimigos — criando ilusões auditivas e visuais em tempo real.\n " +
                "\033[1mManipulação de rede local:\033[0m Hackeia drones, câmeras, e cyberware inimigo instantaneamente, como se comandasse um exército invisível.\n" +
                "\033[1mInterferência de vontade:\033[0m Se ele estabelecer conexão neural direta (por olhar ou voz), pode plantar comandos mentais temporários — fazendo até aliados hesitarem por segundos fatais.\n" +
                "\033[1mAutodefesa reativa:\033[0m Se o colar detectar que Silvertongue está sob ameaça direta, ele projeta um escudo prismático momentâneo, feito de dados densificados.";
    }
}
