package tocador;

import enums.Comando;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class AdaptadorJfugue implements AdaptadorMusical {
    private final TradutorAdaptador tradutorAdaptador;
    private final Player player = new Player();

    private int currentInstrument = 1;

    public AdaptadorJfugue(TradutorAdaptador tradutorAdaptador) {
        this.tradutorAdaptador = tradutorAdaptador;
    }


    @Override
    public void tocarNota(Comando comando) {
            final var notaTraduzida = tradutorAdaptador.traduzParaAdapatador(comando);
            final var pattern = criaPattern(1,notaTraduzida);
            player.play(pattern);
    }

    @Override
    public void tocarNota(Comando comando, int repeticoes) {
        final var notaTraduzida = tradutorAdaptador.traduzParaAdapatador(comando);
        final var pattern = criaPattern(repeticoes, notaTraduzida);
        player.play(pattern);
    }

    private Pattern criaPattern(int repeticoes, String notaTraduzida) {
        final var pattern = new Pattern();
        pattern.setInstrument(this.currentInstrument);
        pattern.add(notaTraduzida, repeticoes);
        return pattern;
    }

    @Override
    public void aumentarOitava() {

    }

    @Override
    public void reduzirOitava() {

    }

    @Override
    public void aumentarVolume() {

    }

    @Override
    public void reduzirVolume() {

    }

    @Override
    public void incrementeInstrumento(int incremento) {
        this.currentInstrument = currentInstrument+incremento;
    }

    public void setCurrentInstrument(int novoInstumento) {
        this.currentInstrument = novoInstumento;
    }
}
