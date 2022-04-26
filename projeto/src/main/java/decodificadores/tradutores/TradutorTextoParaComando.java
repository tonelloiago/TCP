package decodificadores.tradutores;

import entidades.VisaoDeComando;
import enums.Comando;

import java.util.List;

import static enums.Comando.*;

public class TradutorTextoParaComando implements TradutorTextoComando{
    private final List<Character> notas = List.of('A','B','C','D','E','F','G');
    private final List<Character> notasMinusculas = List.of('a','b','c','d','e','f','g');
    private final List<Character> vogais = List.of('O','I','U','o','i','u');
    private Character ultimoCaracter = ' ';
    @Override
    public Comando traduz(Character caracter) {
        if (notas.contains(caracter)) {
            return traduzNote(caracter);
        }

        if (notasMinusculas.contains(caracter)) {
            return verificaUltimoComando();
        }

        return traduzComandoDiverso(caracter);
    }

    private Comando traduzComandoDiverso(Character caracter) {
    switch (caracter) {
        case ' ':
            return Volume;
        case '!':
            return Agogo;
        case '?':
            return AumentaOitava;
        case '\n':
            return Bells;
        case ';':
            return Flute;
        case ',':
            return Organ;
        default:
            return verificaCaracteresGerais(caracter);
    }
}

    private Comando verificaUltimoComando() {
        return notas.contains(ultimoCaracter) ? traduz(ultimoCaracter) : Silencio;
    }

    private Comando verificaCaracteresGerais(Character caracter) {
        if (vogais.contains(caracter)){
            return Horpischord;
        }
        if (Character.isDigit(caracter)){
            return IncrementaInstrumento;
        }
        return verificaUltimoComando();
    }

    public void defineUltimoCaracter(Character ultimoCaracter) {
        this.ultimoCaracter = ultimoCaracter;
    }

    private Comando traduzNote(Character caracter) {
        switch (caracter) {
                case 'A':
                    return La;
                case 'B':
                    return Si;
                case 'C':
                    return Do;
                case 'E':
                    return Mi;
                case 'D':
                    return Re;
                case 'F':
                    return Fa;
                case 'G':
                    return Sol;
            default:
                return null;
        }
    }
}
