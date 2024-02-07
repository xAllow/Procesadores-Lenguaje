import java.util.Vector;

public class Instancia extends Objeto {
    private Tipo tipo;
    private Tipo subtipo = null;
    private String tamArray = "-1";

    private boolean esString = false;
    private Objeto variableIndex = null;

    public Instancia (String n, Tipo t, int b, boolean mut) {
        super(n,b,mut);
        tipo = t;
    }

    // constructor para arrays...
    public Instancia (String n, Tipo t, Tipo st, String tA, int b, boolean mut) {
        super(n,b,mut);
        tipo = t;
        subtipo = st;
        tamArray = tA;
    }

    // constructor para arrays y en concreto string
    public Instancia (String n, Tipo t, Tipo st, String tA, int b, boolean mut, boolean esString, Objeto varIndex) {
        super(n,b,mut);
        tipo = t;
        subtipo = st;
        tamArray = tA;
        this.esString = esString;
        variableIndex = varIndex;
    }

    public Tipo getTipo () {
        return tipo;
    }

    public Tipo getSubtipo() {
        return subtipo;
    }

    public String getTamArray() {
        return tamArray;
    }

    public boolean getEsString () {
        return esString;
    }

    public Objeto getVariableIndex() {
        return variableIndex;
    }

    public Objeto metodos (String m, Vector<Objeto> vect) {
        return tipo.metodosInstancia(this, m, vect);
    }

    @Override
    public String toString () {
        return "(nombre: " + getNombre() + ", bloque: " + getBloque() + ", mutable: " + getMutable() + ", tipo: " + tipo + (subtipo != null ? ", subtipo: " + subtipo + (esString ? ", {ES UN STRING}, " : "") + ", tamañoArray: " + tamArray : "") + ")";
    }
}
