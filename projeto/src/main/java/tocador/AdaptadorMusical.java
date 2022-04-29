package tocador;


import enums.Comando;

public interface AdaptadorMusical {
    void tocarNota(Comando comando);
    void tocarNota(Comando comando,int repeticoes);
    void aumentarOitava();
    void aumentarVolume();

    void incrementaInstrumento(int incremento);
    void defineInstrumento(Comando comando);

    void limpaMusica();

    void salvaMusica();
}
