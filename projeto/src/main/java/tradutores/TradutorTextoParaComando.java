package tradutores;

import enums.Comando;

import static enums.Comando.*;

public class TradutorTextoParaComando implements TradutorTextoComando{
    @Override
    public Comando traduz(Character caracter) {
        switch (caracter){
            case 'A':
            case 'a':
                return La;
            case 'B':
            case 'b':
                return Si;
            case 'C':
            case 'c':
                return Do;
            case 'E':
            case 'e':
                return Re;
            case 'F':
            case 'f':
                return Fa;
            case 'G':
            case 'g':
                return Sol;
            default:
                return null;
        }
    }
}
