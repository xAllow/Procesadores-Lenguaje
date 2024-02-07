import java.util.Vector;

public abstract class Tipo extends Objeto {
    public Tipo (String n, int b) {
        super(n,b,false);
    }

    // por si el examen pide tipo mutable
    public Tipo (String n, int b, boolean mut) {
        super(n, b, mut);
    }

    public abstract Objeto metodosInstancia (Objeto o, String m, Vector<Objeto> vect);

    @Override
    public String toString () {
        return getNombre();
    }
}
