package tela;

import orquestrador.Orquestrador;

public class ControladorDeGui extends Interface{

    private String texto;
    private final Orquestrador orquestrador;

    public ControladorDeGui() {
        orquestrador = new Orquestrador();
    }

    public void executa(){
        this.texto = "";
        this.abrirTela();
        this.monitorDeEvento();
    }

    private void monitorDeEvento() {

        /*
         Adiciona um monitor de evento de botao
         Retorna o texto digitado na interface quando o botao é pressionado
         */
        converterButton.addActionListener(actionEvent -> processaMusica());

    }

    private void entraTexto() {
        this.texto = textArea.getText();
    }

    //Pode ser quebrada em outra classe
    //Tirar responsabilidade da GUI de processar o texto
    private void processaMusica() {

        String stringVazia = "";

        this.entraTexto();

        if(!this.texto.equals(stringVazia)) {


            try {

                orquestrador.orquestrar(texto);


            }catch (Exception e) {

                //Faz algo
                System.out.println("Chegou aqui");

            }
        }
    }

    private void abrirTela() {

        setVisible(true);
    }


}
