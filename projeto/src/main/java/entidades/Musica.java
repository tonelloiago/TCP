package entidades;

import java.util.Collections;
import java.util.List;

public class Musica {
    private List<VisaoDeComando> sequenciaDeComandos;

    public Musica(List<VisaoDeComando> sequenciaDeComandos) {
        this.sequenciaDeComandos = sequenciaDeComandos;
    }

    public List<VisaoDeComando> getSequenciaDeVisaoDeComandos() {
        return sequenciaDeComandos;
    }

    public void setSequenciaDeVisaoDeComandos(List<VisaoDeComando> sequenciaDeComandos) {
        this.sequenciaDeComandos = sequenciaDeComandos;
    }

    public void addVisaoDeComando(VisaoDeComando visaoDeComando){
        sequenciaDeComandos.add(visaoDeComando);
    }

    public void limpaMusica(){
        sequenciaDeComandos = Collections.emptyList();
    }
}
