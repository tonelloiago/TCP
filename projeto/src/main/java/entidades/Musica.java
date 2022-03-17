package entidades;

import enums.Comando;

import java.util.Collections;
import java.util.List;

public class Musica {
    private List<Comando> sequenciaDeComandos;

    public Musica(List<Comando> sequenciaDeComandos) {
        this.sequenciaDeComandos = sequenciaDeComandos;
    }

    public List<Comando> getSequenciaDeComandos() {
        return sequenciaDeComandos;
    }

    public void setSequenciaDeComandos(List<Comando> sequenciaDeComandos) {
        this.sequenciaDeComandos = sequenciaDeComandos;
    }

    public void addComando(Comando comando){
        sequenciaDeComandos.add(comando);
    }

    public void limpaMusica(){
        sequenciaDeComandos = Collections.emptyList();
    }
}
