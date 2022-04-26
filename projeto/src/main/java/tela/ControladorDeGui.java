package tela;
import orquestrador.Orquestrador;
import java.io.IOException;

public class ControladorDeGui extends Interface{

    private String texto;
    private final Orquestrador orquestrador;

    public ControladorDeGui() {
        orquestrador = new Orquestrador();
    }

    public void executa(){
        this.texto = "";
        this.abrirTela();
        this.monitorDeEventoConverter();
        this.monitorDeAnexoDeArquivo();
    }

    private void monitorDeEventoConverter() {
        converterButton.addActionListener(actionEvent -> {
            try {
                processaMusica();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void monitorDeAnexoDeArquivo() {
        anexarArquivo.addActionListener(actionEvent -> anexarArquivo());
    }

    private void entraTexto() throws IOException {
        this.texto = textArea.getText();

        if(leitor.getTemArquivo()) {
            this.texto += leitor.getConteudoDoArquivo();
        }
    }

    //Pode ser quebrada em outra classe
    //Tirar responsabilidade da GUI de processar o texto
    private void processaMusica() throws IOException {

        this.entraTexto();

        if(!this.texto.isBlank()) {

            try {

                orquestrador.orquestrar(texto);


            }catch (Exception e) {

                //Faz algo
                System.out.println("Chegou aqui");
                e.printStackTrace();
            }
        }
    }

    private void abrirTela() {

        setVisible(true);
    }


}