package decodificadores.tradutores;

import enums.Comando;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static enums.Comando.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TradutorTextoParaComandoTest {
    @InjectMocks
    private TradutorTextoParaComando tradutorTextoParaComando;
    private Character caracterATraduzir;
    private Comando comandoTraduzido;

    @Test
    void deveTraduzirNotaComum(){
        dadoCaracter('A');
        traduzCaracter();
        entaoComandoTraduzidoE(La);
    }

    @Test
    void deveTraduzirLetraNotaMinusculaOndeUltimoComandoEraNota(){
        dadoCaracter('D');
        traduzCaracter();
        dadoCaracter('a');
        traduzCaracter();
        entaoComandoTraduzidoE(Re);
    }

    @Test
    void deveTraduzirLetraNotaMinusculaOndeUltimoComandoNaoEraNota(){
        dadoCaracter(',');
        traduzCaracter();
        dadoCaracter('a');
        traduzCaracter();
        entaoComandoTraduzidoE(Silencio);
    }

    @Test
    void deveTraduzirEspaco(){
        dadoCaracter(' ');
        traduzCaracter();
        entaoComandoTraduzidoE(Volume);
    }

    @Test
    void deveTraduzirExclamacao(){
        dadoCaracter('!');
        traduzCaracter();
        entaoComandoTraduzidoE(Agogo);
    }

    @Test
    void traduzVogal(){
        dadoCaracter('i');
        traduzCaracter();
        entaoComandoTraduzidoE(Horpischord);
    }

    @Test
    void traduzConsoante(){
        dadoCaracter('z');

        dadoUltimoCaracter('A');
        traduzCaracter();
        entaoComandoTraduzidoE(La);

        dadoUltimoCaracter('f');
        traduzCaracter();
        entaoComandoTraduzidoE(Silencio);
    }

    @Test
    void traduzNumero(){
        dadoCaracter('1');
        traduzCaracter();
        entaoComandoTraduzidoE(IncrementaInstrumento);
    }

    @Test
    void traduzInterrogacao(){
        dadoCaracter('?');
        traduzCaracter();
        entaoComandoTraduzidoE(AumentaOitava);
    }

    @Test
    void traduzNovaLinha(){
        dadoCaracter('\n');
        traduzCaracter();
        entaoComandoTraduzidoE(Bells);
    }

    @Test
    void traduzPontoEVirgula(){
        dadoCaracter(';');
        traduzCaracter();
        entaoComandoTraduzidoE(Flute);
    }

    @Test
    void traduzVirgula(){
        dadoCaracter(',');
        traduzCaracter();
        entaoComandoTraduzidoE(Organ);
    }

    @Test
    void traduzQualquerOutroCaracter(){
        dadoCaracter('&');

        dadoUltimoCaracter('F');
        traduzCaracter();
        entaoComandoTraduzidoE(Fa);

        dadoUltimoCaracter(',');
        traduzCaracter();
        entaoComandoTraduzidoE(Silencio);
    }


    private void dadoCaracter(final Character caracter){
        caracterATraduzir = caracter;
    }

    private void dadoUltimoCaracter(final Character caracter){
        tradutorTextoParaComando.defineUltimoCaracter(caracter);
    }

    private void traduzCaracter(){
        comandoTraduzido = tradutorTextoParaComando.traduz(caracterATraduzir);
    }

    private void entaoComandoTraduzidoE(final Comando comando){
        assertEquals(comando,comandoTraduzido);
    }


}