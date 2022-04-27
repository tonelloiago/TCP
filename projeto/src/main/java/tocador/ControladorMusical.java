package tocador;

import decodificadores.validadores.ValidadorDeComando;
import entidades.Musica;
import entidades.VisaoDeComando;
import enums.Comando;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ControladorMusical {
    private final  AdaptadorMusical adaptadorMusical;
    private final ValidadorDeComando validadorDeComando;
    private final List<Comando> instrumentos = List.of(Comando.Flute,Comando.Agogo,Comando.Bells,Comando.Organ,Comando.Horpischord);


    public ControladorMusical(AdaptadorMusical adaptadorMusical, ValidadorDeComando validadorDeComando) {
        this.adaptadorMusical = adaptadorMusical;
        this.validadorDeComando = validadorDeComando;
    }

    public void executaMusica(Musica musica){
        final var visaoDeComandos = musica.getSequenciaDeVisaoDeComandos();

        visaoDeComandos.forEach(tocaNota());
    }

    public void defineInstrumento(Comando comando){
        adaptadorMusical.setInstrumento(comando);
    }

    private Consumer<VisaoDeComando> tocaNota() {
        return visaoDeComando -> {
            final var comando = visaoDeComando.getComando();

            if (validadorDeComando.eNota(comando)){
                adaptadorMusical.tocarNota(comando,visaoDeComando.getRepeticoes());
            }

            if (validadorDeComando.eComandoDeIncrementaInstrumento(comando)){
                adaptadorMusical.incrementeInstrumento(visaoDeComando.getRepeticoes());
            }

            if (validadorDeComando.eComandoDeInstrumento(comando)){
                adaptadorMusical.setInstrumento(comando);
            }

            //adicionar casos de oitava, volume,etc
        };
    }

}
