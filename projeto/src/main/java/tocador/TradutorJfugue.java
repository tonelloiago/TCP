package tocador;

import decodificadores.validadores.ValidadorDeComando;
import enums.Comando;

public class TradutorJfugue implements TradutorAdaptador{
    final ValidadorDeComando validadorDeComando = new ValidadorDeComando();

    @Override
    public String traduzParaAdapatador(Comando comando) {
        if (validadorDeComando.eNota(comando)){
            return traduzNota(comando);
        }

        if (validadorDeComando.eComandoDeInstrumento(comando)){
            return traduzInstrumento(comando);
        }
        return "";
    }

    private String traduzInstrumento(Comando comando) {
        switch (comando){
            case Agogo:
                return "114";
            case Harpsichord:
                return "7";
            case TubularBells:
                return "15";
            case PanFlute:
                return "75";
            case ChurchOrgan:
                return "20";
            default:
                return "";
        }
    }

    private String traduzNota(Comando comando) {
        switch (comando){
            case Do:
                return "C";
            case Re:
                return "D";
            case Mi:
                return "E";
            case Fa:
                return "F";
            case Sol:
                return "G";
            case La:
                return "A";
            case Si:
                return "B";
            default:
                return "";
        }
    }
}
