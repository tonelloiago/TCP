package tocador;

import enums.Comando;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import tocador.downloader.DownloaderJfugue;

import java.io.IOException;

public class AdaptadorJfugue implements AdaptadorMusical {
    private final TradutorAdaptador tradutorAdaptador;
    private final Player player = new Player();

    private int instrumentoAtual = 1;
    private int volumeAtual;
    private int oitavaAtual;

    private static final int VOLUME_MIN = 30;
    private static final int VOLUME_MAX = 127;

    private static final int MENOR_OITAVA = 1;
    private static final int MAIOR_OITAVA = 10;

    private final Pattern pattern_criado = new Pattern();

    private String criaComandoVolume(int volume) {
        return ":CON(7,"+volume+") ";
    }

    public AdaptadorJfugue(TradutorAdaptador tradutorAdaptador) {
        this.tradutorAdaptador = tradutorAdaptador;
        this.pattern_criado.add(criaComandoVolume(VOLUME_MIN));
        this.volumeAtual = VOLUME_MIN;
    }


    @Override
    public void adicionaNota(Comando comando) {
            final var notaTraduzida = tradutorAdaptador.traduzParaAdapatador(comando);
            final var pattern = incrementaPattern(1,notaTraduzida);
            player.play(pattern);
    }

    @Override
    public void adicionaNota(Comando comando, int repeticoes) {
        var notaTraduzida = tradutorAdaptador.traduzParaAdapatador(comando);
        incrementaPattern(repeticoes, notaTraduzida);
    }

    @Override
    public void tocaMusica() {
        this.player.play(this.pattern_criado);
    }

    private Pattern incrementaPattern(int repeticoes, String notaTraduzida) {
        final var pattern = new Pattern();
        pattern.setInstrument(this.instrumentoAtual);
        pattern.add(ajustaNota(notaTraduzida), repeticoes);
        this.pattern_criado.add(pattern);
        return pattern;
    }

    @Override
    public void aumentarOitava() {
        var novaOitava = this.oitavaAtual + 1;

        if (novaOitava >= MAIOR_OITAVA){
            novaOitava = MENOR_OITAVA;
        }

        this.oitavaAtual = novaOitava;
    }

    @Override
    public void aumentarVolume() {
        var novoVolume = this.volumeAtual * 2;

        if (novoVolume > VOLUME_MAX){
            novoVolume = VOLUME_MIN;
        }

        this.volumeAtual = novoVolume;

        this.pattern_criado.add(criaComandoVolume(this.volumeAtual));
        this.player.play(pattern_criado);
    }

    @Override
    public void incrementaInstrumento(int incremento) {
        this.instrumentoAtual = instrumentoAtual + incremento;
    }

    @Override
    public void defineInstrumento(Comando comando) {
        this.instrumentoAtual = Integer.parseInt(tradutorAdaptador.traduzParaAdapatador(comando));
    }

    @Override
    public void limpaMusica() {
        this.pattern_criado.clear();
        this.volumeAtual = VOLUME_MIN;
    }
    @Override
    public void salvaMusica(){
        try {
            DownloaderJfugue.downloadMusica(this.pattern_criado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String ajustaNota(String nota){
        return nota+this.oitavaAtual;
    }
}
