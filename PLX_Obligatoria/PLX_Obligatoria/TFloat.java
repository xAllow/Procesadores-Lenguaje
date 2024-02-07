import java.util.Vector;

public class TFloat extends Tipo {
    /* de esta manera conseguimos que sea singleton y ademas como
    le estamos dando el valor 0, es global a todo el programa (es un
    tipo) */

    private static TFloat instancia = new TFloat();

    private TFloat () {
        super("float", 0);
    }

    public static TFloat getInstancia () {
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

            if (((Instancia) vect.firstElement()).getTipo() != instancia
                    && ((Instancia) vect.firstElement()).getTipo() != TInt.getInstancia()) errorDeTipos();
            
            if (!o.getMutable()) errorYPara(m, vect);

            if (((Instancia) vect.firstElement()).getTipo() == TInt.getInstancia()) {
                PLXC.out.println("\t" + o.getNombreBloque() + "=(float)" + vect.firstElement().getNombreBloque() + ";");
            } else {
                PLXC.out.println("\t" + o.getNombreBloque() + "=" + vect.firstElement().getNombreBloque() + ";");
            }

        } else if (m.equals("suma")) {
            // if comprobaciones ... no hace falta la del mutable
            if (vect.size() != 1) errorYPara(m, vect);
           
            if (!(vect.firstElement() instanceof Instancia)) errorYPara(m, vect);

            if (((Instancia) vect.firstElement()).getTipo() != instancia
                    && ((Instancia) vect.firstElement()).getTipo() != TInt.getInstancia()) errorDeTipos();
                       
            Objeto nuevoO = new Instancia(Objeto.newNomObj(), instancia, TablaS.bloqueActual, false);
            
            if (((Instancia) vect.firstElement()).getTipo() == TInt.getInstancia()) {
                Objeto aux = vect.firstElement().metodos("castingAFloat", vect);
                PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + o.getNombreBloque() + " +r " + aux.getNombreBloque() + ";");
            } else {
                PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + o.getNombreBloque() + " +r " + vect.firstElement().getNombreBloque() + ";");
            }
            return nuevoO;

        } else if (m.equals("resta")) {
            if (vect.size() != 1) errorYPara(m, vect);
           
            if (!(vect.firstElement() instanceof Instancia)) errorYPara(m, vect);

            if (((Instancia) vect.firstElement()).getTipo() != instancia
                    && ((Instancia) vect.firstElement()).getTipo() != TInt.getInstancia()) errorDeTipos();
           
            Objeto aux = vect.firstElement().metodos("castingAFloat", vect);
                    
            Objeto nuevoO = new Instancia(Objeto.newNomObj(), instancia, TablaS.bloqueActual, false);
            
            if (((Instancia) vect.firstElement()).getTipo() == TInt.getInstancia()) {
                PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + o.getNombreBloque() + " -r " + aux.getNombreBloque() + ";");
            } else {
                PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + o.getNombreBloque() + " -r " + vect.firstElement().getNombreBloque() + ";");
            }
            return nuevoO;

        } else if (m.equals("multiplicacion")) {
            if (vect.size() != 1) errorYPara(m, vect);
           
            if (!(vect.firstElement() instanceof Instancia)) errorYPara(m, vect);

            if (((Instancia) vect.firstElement()).getTipo() != instancia
                    && ((Instancia) vect.firstElement()).getTipo() != TInt.getInstancia()) errorDeTipos();
           
            Objeto aux = vect.firstElement().metodos("castingAFloat", vect);
                    
            Objeto nuevoO = new Instancia(Objeto.newNomObj(), instancia, TablaS.bloqueActual, false);
            
            if (((Instancia) vect.firstElement()).getTipo() == TInt.getInstancia()) {
                PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + o.getNombreBloque() + " *r " + aux.getNombreBloque() + ";");
            } else {
                PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + o.getNombreBloque() + " *r " + vect.firstElement().getNombreBloque() + ";");
            }
            return nuevoO;

        } else if(m.equals("division")) {
        
            if (vect.size() != 1) errorYPara(m, vect);
           
            if (!(vect.firstElement() instanceof Instancia)) errorYPara(m, vect);

            if (((Instancia) vect.firstElement()).getTipo() != instancia
                    && ((Instancia) vect.firstElement()).getTipo() != TInt.getInstancia()) errorDeTipos();
           
            Objeto aux = vect.firstElement().metodos("castingAFloat", vect);
                    
            Objeto nuevoO = new Instancia(Objeto.newNomObj(), instancia, TablaS.bloqueActual, false);
            
            if (((Instancia) vect.firstElement()).getTipo() == TInt.getInstancia()) {
                PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + o.getNombreBloque() + " /r " + aux.getNombreBloque() + ";");
            } else {
                PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + o.getNombreBloque() + " /r " + vect.firstElement().getNombreBloque() + ";");
            }
            return nuevoO;
        } else if (m.equals("castingAInt")) {
            if (vect.size() != 1) errorYPara(m, vect);

            if (!(vect.firstElement() instanceof Instancia)) errorYPara(m, vect);

            if (((Instancia) vect.firstElement()).getTipo() != instancia) errorDeTipos();

            // if (!o.getMutable()) errorYPara(m, vect);
            // quizas hay que pasarle a nuevoO que va a ser un INT
            Objeto nuevoO = new Instancia(Objeto.newNomObj(), TInt.getInstancia(), TablaS.bloqueActual, false);

            PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=(int)" + vect.firstElement().getNombreBloque() + ";");

            return nuevoO;
        }
        return o;
    }
}
