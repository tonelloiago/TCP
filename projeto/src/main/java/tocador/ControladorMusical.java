package tocador;

import decodificadores.validadores.ValidadorDeComando;
import entidades.Musica;
import entidades.VisaoDeComando;
import enums.Comando;

import java.util.function.Consumer;
import java.util.function.Function;

public class ControladorMusical {
    private final  AdaptadorMusical adaptadorMusical;
    private final ValidadorDeComando validadorDeComando;


    public ControladorMusical(AdaptadorMusical adaptadorMusical, ValidadorDeComando validadorDeComando) {
        this.adaptadorMusical = adaptadorMusical;
        this.validadorDeComando = validadorDeComando;
    }

    public void executaMusica(Musica musica){
        final var visaoDeComandos = musica.getSequenciaDeVisaoDeComandos();

        visaoDeComandos.forEach(tocaNota());
    }

    private Consumer<VisaoDeComando> tocaNota() {
        return visaoDeComando -> {
            final var comando = visaoDeComando.getComando();

            if (validadorDeComando.eNota(comando)){
                adaptadorMusical.tocarNota(comando,visaoDeComando.getRepeticoes());
            }

            if (comando == Comando.IncrementaInstrumento){
                adaptadorMusical.incrementeInstrumento(visaoDeComando.getRepeticoes());
            }
        };
    }

}
