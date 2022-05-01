package decodificadores.validadores;

import enums.Comando;

import java.util.List;

import static enums.Comando.*;

public class ValidadorDeComando {
    private static final List<Comando> LISTA_DE_NOTAS = List.of(Do,Re,Mi,Fa,Sol,La,Si,Silencio);

    private static final List<Comando> LISTA_DE_INSTRUMENTOS = List.of(Agogo, Harpsichord, TubularBells, PanFlute, ChurchOrgan);

    public Boolean eNota(Comando comando){
        return LISTA_DE_NOTAS.contains(comando);
    }
    public Boolean eComandoDeVolume(Comando comando){
        return Volume.equals(comando);
    }

    public Boolean eComandoDeOitava(Comando comando){
        return AumentaOitava.equals(comando);
    }
    public Boolean eComandoDeInstrumento(Comando comando){
        return LISTA_DE_INSTRUMENTOS.contains(comando);
    }
    public Boolean eComandoDeIncrementaInstrumento(Comando comando){return IncrementaInstrumento==comando;}
}
