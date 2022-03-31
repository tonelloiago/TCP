package decodificadores.validadores;

import enums.Comando;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static enums.Comando.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ValidadorDeComandoTest {
    @InjectMocks ValidadorDeComando validadorDeComando;
    private Boolean resultadoValidacao;

    @Test
    void eNota(){
        resultadoValidacao = validadorDeComando.eNota(Do);
        assertTrue(resultadoValidacao);
    }


    @Test
    void naoENota(){
        resultadoValidacao = validadorDeComando.eNota(Agogo);
        assertFalse(resultadoValidacao);
    }

    @Test
    void eComandoDeVolume(){
        resultadoValidacao = validadorDeComando.eComandoDeVolume(Volume);
        assertTrue(resultadoValidacao);
    }

    @Test
    void naoEComandoVolume(){
        resultadoValidacao = validadorDeComando.eComandoDeVolume(Do);
        assertFalse(resultadoValidacao);
    }

    @Test
    void eComandoDeOitava(){
        resultadoValidacao = validadorDeComando.eComandoDeOitava(AumentaOitava);
        assertTrue(resultadoValidacao);
    }

    @Test
    void naoEComandoDeOitava(){
        resultadoValidacao = validadorDeComando.eComandoDeOitava(Re);
        assertFalse(resultadoValidacao);
    }

    @Test
    void eComandoDeInstrumento(){
        resultadoValidacao = validadorDeComando.eComandoDeInstrumento(Agogo);
        assertTrue(resultadoValidacao);
    }

    @Test
    void naoEComandoDeInstrumento(){
        resultadoValidacao = validadorDeComando.eComandoDeInstrumento(Volume);
        assertFalse(resultadoValidacao);
    }
}
