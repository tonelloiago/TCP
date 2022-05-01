package tocador.downloader;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;

public class DownloaderJfugue {

    public static final String EXTENSAO_MIDI = ".midi";

    public static void downloadMusica(Pattern musicaABaixar) throws IOException {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        var fileFilter = new FileNameExtensionFilter("Midi files","midi");

        fileChooser.setFileFilter(fileFilter);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if(JFileChooser.CANCEL_OPTION == fileChooser.showSaveDialog(null)){
            return;
        };

        var arquivoMidi = fileChooser.getSelectedFile();
        final var nomeDoArquivo = fileChooser.getSelectedFile().getAbsolutePath();

        if (!nomeDoArquivo.endsWith(EXTENSAO_MIDI)){
            arquivoMidi.delete();
            arquivoMidi = new File(nomeDoArquivo+EXTENSAO_MIDI);
        }

        final var player = new Player();
        final var sequence = player.getSequence(musicaABaixar);

        MidiFileManager.save(sequence, arquivoMidi.getAbsoluteFile());
    }
}
