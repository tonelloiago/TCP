package tocador;

import entidades.Musica;
import enums.Comando;

import java.util.List;

import static enums.Comando.*;

public class ControladorMusical {
    private final  AdaptadorMusical adaptadorMusical;
    final List<Comando> listaDeNotas = List.of(Do,Re,Mi,Fa,Sol,La,Si);


    public ControladorMusical(AdaptadorMusical adaptadorMusical) {
        this.adaptadorMusical = adaptadorMusical;
    }

    public void executaMusica(Musica musica){
        final var comandos = musica.getSequenciaDeComandos();

        comandos.forEach(comando -> {
            if (eNota(comando)){
                adaptadorMusical.tocarNota(comando);
            }
        });
    }

    private boolean eNota(Comando comando) {
        return listaDeNotas.contains(comando);
    }
}
