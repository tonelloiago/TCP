package tela.popup;

import javax.swing.*;

import static javax.swing.JOptionPane.showInputDialog;

public class DownloadPopup {

        public static String solicitaArquivo() {
            JFrame jFrame = new JFrame();

            return showInputDialog(jFrame, "Por favor entre o nome do arquivo a ser salvo:");
        }
    }
