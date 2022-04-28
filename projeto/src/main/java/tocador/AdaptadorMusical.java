package tocador;


import enums.Comando;

public interface AdaptadorMusical {
    void tocarNota(Comando comando);
    void tocarNota(Comando comando,int repeticoes);
    void aumentarOitava();
    void reduzirOitava();
    void aumentarVolume();
    void reduzirVolume();
    void incrementeInstrumento(int incremento);
    void setInstrumento(Comando comando);

    void limpaMusica();

    void salvaMusica();
}
