package tocador;

import decodificadores.validadores.ValidadorDeComando;
import entidades.Musica;
import enums.Comando;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.List;

import static enums.Comando.*;

public class ControladorMusical {
    private final  AdaptadorMusical adaptadorMusical;
    private final ValidadorDeComando validadorDeComando;


    public ControladorMusical(AdaptadorMusical adaptadorMusical, ValidadorDeComando validadorDeComando) {
        this.adaptadorMusical = adaptadorMusical;
        this.validadorDeComando = validadorDeComando;
    }

    public void executaMusica(Musica musica){
        final var comandos = musica.getSequenciaDeComandos();

        comandos.forEach(comando -> {
            if (validadorDeComando.eNota(comando)){
                adaptadorMusical.tocarNota(comando);
            }
        });
    }

}
