import java.util.Vector;

public class TChar extends Tipo {
        /* de esta manera conseguimos que sea singleton y ademas como
    le estamos dando el valor 0, es global a todo el programa (es un
    tipo) */

    private static TChar instancia = new TChar();

    private TChar () {
        super("char", 0);
    }

    public static TChar getInstancia () {
        return instancia;
    }

    @Override
    public Objeto metodos (String nameMethod, Vector<Objeto> vect) {
        errorYPara(nameMethod,vect);
        return null;
    }

    @Override
    public Objeto metodosInstancia (Objeto o, String m, Vector<Objeto> vect) {
        if (!(o instanceof Instancia)) errorYPara(m, vect);
        if (((Instancia) o).getTipo() != instancia) errorYPara(m, vect);
        if (m.equals("asigna")) {
            
            if (vect.size() != 1) errorYPara(m, vect);

            if (!(vect.firstElement() instanceof Instancia)) errorYPara(m, vect);
            
            if (((Instancia) vect.firstElement()).getTipo() != instancia) errorDeTipos();
            
            if (!o.getMutable()) errorYPara(m, vect);

            Objeto nuevoO = new Instancia(o.getNombre(), TInt.getInstancia(), TablaS.bloqueActual, false);

            PLXC.out.println("\t" + o.getNombreBloque() + "=" + vect.firstElement().getNombreBloque() + ";");

            return nuevoO;

        } else if (m.equals("castingAInt")) {
            if (vect.size() != 1) errorYPara(m, vect);

            if (!(vect.firstElement() instanceof Instancia)) errorYPara(m, vect);
            
            if (((Instancia) vect.firstElement()).getTipo() != instancia) errorDeTipos();
            
            Objeto nuevoO = new Instancia(o.getNombre(), TInt.getInstancia(), TablaS.bloqueActual, false);

            return nuevoO;
        } else if (m.equals("suma")) {
            if (vect.size() != 1) errorYPara(m, vect);

            if (!(vect.firstElement() instanceof Instancia)) errorYPara(m, vect);

            if (((Instancia) vect.firstElement()).getTipo() != TInt.getInstancia()) errorDeTipos();
                
            Objeto nuevoO = new Instancia(Objeto.newNomObj(), TInt.getInstancia(), TablaS.bloqueActual, false);

            PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + o.getNombreBloque() + "+" + vect.firstElement().getNombreBloque() + ";");
            
            return nuevoO;
        } else if (m.equals("resta")) {
            if (vect.size() != 1) errorYPara(m, vect);

            if (!(vect.firstElement() instanceof Instancia)) errorYPara(m, vect);

            if (((Instancia) vect.firstElement()).getTipo() != instancia
                && ((Instancia) vect.firstElement()).getTipo() != TInt.getInstancia()) errorDeTipos();
                
            Objeto nuevoO = new Instancia(Objeto.newNomObj(), TInt.getInstancia(), TablaS.bloqueActual, false);

            PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + o.getNombreBloque() + "-" + vect.firstElement().getNombreBloque() + ";");
            
            return nuevoO;
        }
        return o;
    }
}
