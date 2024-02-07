import java.util.Vector;

public class TInt extends Tipo {

    /* de esta manera conseguimos que sea singleton y ademas como
    le estamos dando el valor 0, es global a todo el programa (es un
    tipo) */

    private static TInt instancia = new TInt();

    private TInt () {
        super("int", 0);
    }

    public static TInt getInstancia () {
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

            PLXC.out.println("\t" + o.getNombreBloque() + "=" + vect.firstElement().getNombreBloque() + ";");

        } else if (m.equals("suma")) {

            // if comprobaciones ... no hace falta la del mutable
            if (vect.size() != 1) errorYPara(m, vect);
            
            if (!(vect.firstElement() instanceof Instancia)) errorYPara(m, vect);
            
            if (((Instancia) vect.firstElement()).getTipo() != instancia
                    && ((Instancia) vect.firstElement()).getTipo() != TFloat.getInstancia()
                    && ((Instancia) vect.firstElement()).getTipo() != TChar.getInstancia()) errorDeTipos();
                
            Objeto nuevoO = new Instancia(Objeto.newNomObj(), instancia, TablaS.bloqueActual, false);
            
            if (((Instancia) vect.firstElement()).getTipo() == TFloat.getInstancia()) {
                Vector<Objeto> auxiliar = new Vector<>();
                auxiliar.add(o);
                Objeto aux = o.metodos("castingAFloat", auxiliar);
                PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + aux.getNombreBloque() + " +r " + vect.firstElement().getNombreBloque() + ";");
            } else {
                // este else ya contempla la suma con tipo char.
                PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + o.getNombreBloque() + "+" + vect.firstElement().getNombreBloque() + ";");
            }
            return nuevoO;

        } else if (m.equals("resta")) {
            if (vect.size() != 1) errorYPara(m, vect);

            if (!(vect.firstElement() instanceof Instancia)) errorYPara(m, vect);

            if (((Instancia) vect.firstElement()).getTipo() != instancia
                    && ((Instancia) vect.firstElement()).getTipo() != TFloat.getInstancia()
                    && ((Instancia) vect.firstElement()).getTipo() != TChar.getInstancia()) errorDeTipos();
                
            Objeto nuevoO = new Instancia(Objeto.newNomObj(), instancia, TablaS.bloqueActual, false);
            
            if (((Instancia) vect.firstElement()).getTipo() == TFloat.getInstancia()) {
                Objeto aux = o.metodos("castingAFloat", vect);
                PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + aux.getNombreBloque() + " -r " + vect.firstElement().getNombreBloque() + ";");
            } else {
                // este else ya contempla la resta con el tipo char.
                PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + o.getNombreBloque() + "-" + vect.firstElement().getNombreBloque() + ";");
            }
            return nuevoO;

        } else if (m.equals("multiplicacion")) {
            if (vect.size() != 1) errorYPara(m, vect);

            if (!(vect.firstElement() instanceof Instancia)) errorYPara(m, vect);

            if (((Instancia) vect.firstElement()).getTipo() != instancia
                    && ((Instancia) vect.firstElement()).getTipo() != TFloat.getInstancia()) errorDeTipos();
                
            Objeto nuevoO = new Instancia(Objeto.newNomObj(), instancia, TablaS.bloqueActual, false);
            
            if (((Instancia) vect.firstElement()).getTipo() == TFloat.getInstancia()) {
                Objeto aux = o.metodos("castingAFloat", vect);
                PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + aux.getNombreBloque() + " *r " + vect.firstElement().getNombreBloque() + ";");
            } else {
                PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + o.getNombreBloque() + "*" + vect.firstElement().getNombreBloque() + ";");
            }
            return nuevoO;

        } else if(m.equals("division")) {
            if (vect.size() != 1) errorYPara(m, vect);

            if (!(vect.firstElement() instanceof Instancia)) errorYPara(m, vect);

            if (((Instancia) vect.firstElement()).getTipo() != instancia
                    && ((Instancia) vect.firstElement()).getTipo() != TFloat.getInstancia()) errorDeTipos();
                
            Objeto nuevoO = new Instancia(Objeto.newNomObj(), instancia, TablaS.bloqueActual, false);
            
            if (((Instancia) vect.firstElement()).getTipo() == TFloat.getInstancia()) {
                Objeto aux = o.metodos("castingAFloat", vect);
                PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + aux.getNombreBloque() + " /r " + vect.firstElement().getNombreBloque() + ";");
            } else {
                PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + o.getNombreBloque() + "/" + vect.firstElement().getNombreBloque() + ";");
            }
            return nuevoO;

        } else if (m.equals("castingAFloat")) {
            if (vect.size() != 1) errorYPara(m, vect);

            if (!(vect.firstElement() instanceof Instancia)) errorYPara(m, vect);

            if (((Instancia) vect.firstElement()).getTipo() != instancia) errorDeTipos();

            // if (!o.getMutable()) errorYPara(m, vect);

            Objeto nuevoO = new Instancia(Objeto.newNomObj(), TFloat.getInstancia(), TablaS.bloqueActual, false);

            PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=(float)" + vect.firstElement().getNombreBloque() + ";");

            return nuevoO;
        } else if (m.equals("castingAChar")) {
            if (vect.size() != 1) errorYPara(m, vect);

            if (!(vect.firstElement() instanceof Instancia)) errorYPara(m, vect);
            
            if (((Instancia) vect.firstElement()).getTipo() != instancia) errorDeTipos();
            
            // if (!o.getMutable()) errorYPara(m, vect);

            Objeto nuevoO = new Instancia(o.getNombre(), TChar.getInstancia(), TablaS.bloqueActual, false);

            return nuevoO;
        }
        return o;
    }
}
