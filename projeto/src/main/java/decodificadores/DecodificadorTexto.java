package decodificadores;

import entidades.Musica;
import enums.Comando;
import decodificadores.tradutores.TradutorTextoComando;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;

import static java.util.stream.Collectors.*;

public class DecodificadorTexto {
    private final TradutorTextoComando tradutorTextoComando;

    public DecodificadorTexto(TradutorTextoComando tradutorTextoComando) {
        this.tradutorTextoComando = tradutorTextoComando;
    }

    public Musica traduzTexto(String textoATraduzir){

        final var listaDeComandos = stringParaLista(textoATraduzir).stream()
                .map(paraComando())
                .collect(toList());

        return new Musica(listaDeComandos);
    }

    private Function<Character, Comando> paraComando() {
        return character -> {
            final var comando = tradutorTextoComando.traduz(character);
            tradutorTextoComando.defineUltimoCaracter(character);
            return comando;
        };
    }

    private List<Character> stringParaLista(String textoATraduzir) {
        return textoATraduzir.chars().mapToObj(intParaChar()).collect(toList());
    }

    private IntFunction<Character> intParaChar() {
        return letra -> (char) letra;
    }

    ;
}
