package tocador;

import enums.Comando;

public class TradutorJfugue implements TradutorAdaptador{

    @Override
    public String traduzParaAdapatador(Comando comando) {
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
