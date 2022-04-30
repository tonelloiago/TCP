import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import tela.ControladorDeGui;
import tocador.downloader.DownloaderJfugue;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ControladorDeGui interfaceDeUsuario = new ControladorDeGui();
        interfaceDeUsuario.executa();
    }
}
