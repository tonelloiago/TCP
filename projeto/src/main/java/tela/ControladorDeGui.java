package tela;
import enums.Comando;
import orquestrador.Orquestrador;

import java.io.IOException;
import java.util.Arrays;
import java.util.function.Predicate;

public class ControladorDeGui extends Interface{

    private String texto;
    private final Orquestrador orquestrador;

    public ControladorDeGui() {
        orquestrador = new Orquestrador();
    }

    public void executa(){
        this.texto = "";
        setInstrumentos();
        setTituloInterface("Gerador De Música");
        setLabelCheckBox("Baixar MIDI");
        this.abrirTela();
        this.monitorDeEventoConverter();
        this.monitorDeAnexoDeArquivo();
    }

    //Implementa monitores de evento no botoes da interface
    private void monitorDeEventoConverter() {
        converterButton.addActionListener(actionEvent -> {
            try {
                this.preProcessaTexto();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void monitorDeAnexoDeArquivo() {
        anexarArquivo.addActionListener(actionEvent -> getArquivoDeTexto());
    }

    private void entraTexto() throws IOException {

        this.texto = getConteudoTextArea();
        if(leitor.getTemArquivo()) {
            this.texto += leitor.getConteudoDoArquivo();
        }
    }

    private void preProcessaTexto() throws IOException {

        this.entraTexto();
        if(!this.texto.isBlank()) {

            try {
                orquestrador.defineInstrumento(this.getInstrumentoSelecionado());
                orquestrador.orquestrar(texto, checkBoxMarcada());
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Abre a interface
    private void abrirTela() {
        setVisible(true);
    }

    private void setInstrumentos() {

        String[] instrumentos = new String[]{"Agogo", "Harpsichord", "Tubular Bells", "Pan Flute", "Church Organ" };
        setOpcoesComboBox(instrumentos);
    }

    //Passei para controlador de gui pra interface ficar mais reutilizavel
    public Comando getInstrumentoSelecionado(){
        final var comandos = Comando.values();

        return Arrays.stream(comandos).filter(porInstrumentoSelecionado()).findFirst().orElse(Comando.IncrementaInstrumento);
    }

    private Predicate<Comando> porInstrumentoSelecionado() {
        return comando -> comando.name().equals(this.itens.getSelectedItem());
    }

}