package tocador;

import enums.Comando;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import tocador.downloader.DownloaderJfugue;

import java.io.IOException;

public class AdaptadorJfugue implements AdaptadorMusical {
    private final TradutorAdaptador tradutorAdaptador;
    private final Player player = new Player();

    private int currentInstrument = 1;

    private Pattern pattern_criado = new Pattern();

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
        this.pattern_criado.add(pattern);
        return pattern;
    }

    @Override
    public void aumentarOitava() {

    }

    @Override
    public void aumentarVolume() {

    }

    @Override
    public void incrementaInstrumento(int incremento) {
        this.currentInstrument = currentInstrument+incremento;
    }

    @Override
    public void defineInstrumento(Comando comando) {
        this.currentInstrument = Integer.parseInt(tradutorAdaptador.traduzParaAdapatador(comando));
    }

    @Override
    public void limpaMusica() {
        this.pattern_criado.clear();
    }

    public void salvaMusica(){
        try {
            DownloaderJfugue.downloadMusica(this.pattern_criado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
