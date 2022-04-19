package decodificadores.tradutores;

import enums.Comando;

public interface TradutorTextoComando {
    Comando traduz(Character caracter);
    void defineUltimoCaracter(Character caracter);
}
