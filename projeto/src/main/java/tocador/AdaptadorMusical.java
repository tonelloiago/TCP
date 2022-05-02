package tocador;


import enums.Comando;

public interface AdaptadorMusical {
    void adicionaNota(Comando comando);
    void adicionaNota(Comando comando, int repeticoes);
    void tocaMusica();
    void aumentarOitava();
    void aumentarVolume();

    void incrementaInstrumento(int incremento);
    void defineInstrumento(Comando comando);

    void limpaMusica();

    void salvaMusica();
}
