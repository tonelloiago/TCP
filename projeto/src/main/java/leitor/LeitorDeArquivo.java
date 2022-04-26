package leitor;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeitorDeArquivo {

    private File arquivoAnexado;
    private boolean temArquivo;

    public LeitorDeArquivo() {
        this.temArquivo = false;
    }

    public String getConteudoDoArquivo() throws IOException {
         return Files.readString(Path.of(getCaminhoDoArquivo()), StandardCharsets.UTF_8);
    }

    public void abrirFileSystemView() {

        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int achouArquivo = fileChooser.showOpenDialog(null);

        if (achouArquivo == JFileChooser.APPROVE_OPTION) {
            this.arquivoAnexado = fileChooser.getSelectedFile();
            this.temArquivo = true;
        }
    }

    public String getCaminhoDoArquivo() {
        return this.arquivoAnexado.getAbsolutePath();
    }

    public boolean getTemArquivo() {
        return this.temArquivo;
    }



}
