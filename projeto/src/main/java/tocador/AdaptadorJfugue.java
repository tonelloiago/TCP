package tocador;

import enums.Comando;
import org.jfugue.player.Player;

import java.util.List;


public class AdaptadorJfugue implements AdaptadorMusical {
    private final TradutorAdaptador tradutorAdaptador;
    private final Player player = new Player();

    public AdaptadorJfugue(TradutorAdaptador tradutorAdaptador) {
        this.tradutorAdaptador = tradutorAdaptador;
    }


    @Override
    public void tocarNota(Comando comando) {
            final var notaTraduzida = tradutorAdaptador.traduzParaAdapatador(comando);
            player.play(notaTraduzida);
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
}
