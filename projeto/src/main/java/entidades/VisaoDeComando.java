package entidades;

import enums.Comando;

public class VisaoDeComando {
    private Comando comando;
    private int repeticoes;

    public VisaoDeComando(Comando comando) {
        this.comando = comando;
        this.repeticoes = 1;
    }

    public Comando getComando() {
        return comando;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public void incRepeticao(){
        this.repeticoes++;
    }
}
