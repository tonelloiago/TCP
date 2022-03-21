package orquestrador;

import decodificadores.DecodificadorTexto;
import tela.Interface;
import tocador.AdaptadorJfugue;
import tocador.ControladorMusical;
import tocador.TradutorJfugue;
import tradutores.TradutorTextoParaComando;

public class Orquestrador {
    private final ControladorMusical controladorMusical;
    private final DecodificadorTexto decodificadorTexto;

    public Orquestrador(){
        final var tocadorMusica = new AdaptadorJfugue(new TradutorJfugue());

        controladorMusical = new ControladorMusical(tocadorMusica);

        decodificadorTexto = new DecodificadorTexto(new TradutorTextoParaComando());
    }


    public void orquestrar(String textoUsuario){
        final var musica = decodificadorTexto.traduzTexto(textoUsuario);
        controladorMusical.executaMusica(musica);
    }
}
