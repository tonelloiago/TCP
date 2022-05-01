package tocador;

import decodificadores.validadores.ValidadorDeComando;
import entidades.Musica;
import entidades.VisaoDeComando;
import enums.Comando;

import java.util.List;
import java.util.function.Consumer;

public class ControladorMusical {
    private final  AdaptadorMusical adaptadorMusical;
    private final ValidadorDeComando validadorDeComando;


    public ControladorMusical(AdaptadorMusical adaptadorMusical, ValidadorDeComando validadorDeComando) {
        this.adaptadorMusical = adaptadorMusical;
        this.validadorDeComando = validadorDeComando;
    }

    public void executaMusica(Musica musica, boolean salvaMusica){
        final var visaoDeComandos = musica.getSequenciaDeVisaoDeComandos();

        visaoDeComandos.forEach(adicionaComando());

        this.adaptadorMusical.tocaMusica();

        if (salvaMusica){
            this.adaptadorMusical.salvaMusica();
        }

        this.adaptadorMusical.limpaMusica();
    }

    public void defineInstrumento(Comando comando){
        adaptadorMusical.defineInstrumento(comando);
    }

    private Consumer<VisaoDeComando> adicionaComando() {
        return visaoDeComando -> {
            final var comando = visaoDeComando.getComando();

            if (validadorDeComando.eNota(comando)){
                adaptadorMusical.adicionaNota(comando,visaoDeComando.getRepeticoes());
            }

            if (validadorDeComando.eComandoDeIncrementaInstrumento(comando)){
                adaptadorMusical.incrementaInstrumento(visaoDeComando.getRepeticoes());
            }

            if (validadorDeComando.eComandoDeInstrumento(comando)){
                adaptadorMusical.defineInstrumento(comando);
            }

            if (validadorDeComando.eComandoDeVolume(comando)){
                adaptadorMusical.aumentarVolume();
            }

            if (validadorDeComando.eComandoDeOitava(comando)){
                adaptadorMusical.aumentarOitava();
            }
        };
    }

}
