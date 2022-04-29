package decodificadores;

import entidades.Musica;
import entidades.VisaoDeComando;
import enums.Comando;
import decodificadores.tradutores.TradutorTextoComando;

import java.util.ArrayList;
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

        final var listaDeCaracter = stringParaLista(textoATraduzir).stream();


        final List<VisaoDeComando> listaDeVisaoDeComando = new ArrayList<>();

        listaDeCaracter.forEach( caracter -> {
            final var comando = tradutorTextoComando.traduz(caracter);

            if (comando == Comando.IncrementaInstrumento) {
                listaDeVisaoDeComando.add(criaIncrementaInstrumento(caracter,comando));
            }
            else if (eIgualAUltimaVisao(listaDeVisaoDeComando, comando)){
                getUltimaVisao(listaDeVisaoDeComando).incRepeticao();
            }else{
                listaDeVisaoDeComando.add(new VisaoDeComando(comando));
            }
        });

        return new Musica(listaDeVisaoDeComando);
    }

    private VisaoDeComando criaIncrementaInstrumento(Character caracter, Comando comando) {
        final var visaoDeComando = new VisaoDeComando(comando);

        visaoDeComando.setRepeticoes(Integer.parseInt(caracter.toString()));

        return visaoDeComando;
    }

    private boolean eIgualAUltimaVisao(List<VisaoDeComando> listaDeVisaoDeComando, Comando comando) {
        if (listaDeVisaoDeComando.isEmpty()){
            return false;
        }

        Comando ultimoComando = getUltimaVisao(listaDeVisaoDeComando).getComando();

        return ultimoComando == comando && ultimoComando != Comando.IncrementaInstrumento;
    }

    private VisaoDeComando getUltimaVisao(List<VisaoDeComando> listaDeVisaoDeComando) {
        return listaDeVisaoDeComando.get(listaDeVisaoDeComando.size() - 1);
    }

    private List<Character> stringParaLista(String textoATraduzir) {
        return textoATraduzir.chars().mapToObj(intParaChar()).collect(toList());
    }

    private IntFunction<Character> intParaChar() {
        return letra -> (char) letra;
    }
}
