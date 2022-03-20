package tela;

import decodificadores.DecodificadorTexto;
import entidades.Musica;
import tocador.AdaptadorJfugue;
import tocador.ControladorMusical;
import tocador.TradutorJfugue;
import tradutores.TradutorTextoParaComando;

public class ControladorDeGui extends Interface{

    private String texto;

    public ControladorDeGui() {

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


            final var tocadorMusica = new AdaptadorJfugue(new TradutorJfugue());

            final var controladorMusical = new ControladorMusical(tocadorMusica);

            final var decodificador = new DecodificadorTexto(new TradutorTextoParaComando());


            try {

                System.out.println(this.texto);

                Musica musica = decodificador.traduzTexto(this.texto);

                controladorMusical.executaMusica(musica);


            }catch (Exception e) {

                //Faz algo
                System.out.println("Chegou aqui");

            }finally {


            }

        }
    }

    private void abrirTela() {

        setVisible(true);
    }


}
