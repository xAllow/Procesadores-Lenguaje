import java.util.Vector;

public class TArray extends Tipo {
    /* de esta manera conseguimos que sea singleton y ademas como
    le estamos dando el valor 0, es global a todo el programa (es un
    tipo) */

    private static TArray instancia = new TArray();

    private TArray () {
        super("array", 0);
    }

    public static TArray getInstancia () {
        return instancia;
    }

    @Override
    public Objeto metodos (String nameMethod, Vector<Objeto> vect) {
        errorYPara(nameMethod,vect);
        return null;
    }

    @Override
    public Objeto metodosInstancia (Objeto o, String m, Vector<Objeto> vect) {

        String tipoArray = (((Instancia) o).getSubtipo()).toString();

        if (!(o instanceof Instancia)) errorYPara(m, vect);
        if (((Instancia) o).getTipo() != instancia) errorYPara(m, vect);
        if (m.equals("asignaValorPos")) {
            if (vect.size() != 2) errorYPara(m, vect);

            if (!(vect.firstElement() instanceof Instancia)
                || !(vect.elementAt(1) instanceof Instancia)) errorYPara(m, vect);

            // comprobacion index...
            if (((Instancia) vect.elementAt(1)).getTipo() != TInt.getInstancia()) errorDeTipos();
            
            if (!o.getMutable()) errorYPara(m, vect);
            
            switch (tipoArray) {
                case "int":
                    if (((Instancia) vect.firstElement()).getTipo() != TInt.getInstancia()) errorDeTipos();
                    comprobacionRangos(vect.elementAt(1).getNombreBloque(),((Instancia) o).getTamArray());
                    String newObjectoName = o.getNombreBloque() + "[" + vect.elementAt(1).getNombreBloque() + "]";
                    Objeto nuevoO = new Instancia(newObjectoName, ((Instancia) o).getSubtipo(), o.getBloque(), true);
                    PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + vect.firstElement().getNombreBloque() + ";");
                    return nuevoO;
                case "float":
                    if (((Instancia) vect.firstElement()).getTipo() != TFloat.getInstancia()
                        && ((Instancia) vect.firstElement()).getTipo() != TInt.getInstancia()) errorDeTipos();
                    comprobacionRangos(vect.elementAt(1).getNombreBloque(),((Instancia) o).getTamArray());
                    String newObjectoName2 = o.getNombreBloque() + "[" + vect.elementAt(1).getNombreBloque() + "]";
                    Objeto nuevoO2 = new Instancia(newObjectoName2, ((Instancia) o).getSubtipo(), o.getBloque(), true);
                    PLXC.out.println("\t" + nuevoO2.getNombreBloque() + "=" + vect.firstElement().getNombreBloque() + ";");
                    return nuevoO2;
                case "char":
                    if (((Instancia) vect.firstElement()).getTipo() != TChar.getInstancia()) errorDeTipos();
                    comprobacionRangos(vect.elementAt(1).getNombreBloque(),((Instancia) o).getTamArray());
                    String newObjectoName3 = o.getNombreBloque() + "[" + vect.elementAt(1).getNombreBloque() + "]";
                    Objeto nuevoO3 = new Instancia(newObjectoName3, ((Instancia) o).getSubtipo(), o.getBloque(), true);
                    PLXC.out.println("\t" + nuevoO3.getNombreBloque() + "=" + vect.firstElement().getNombreBloque() + ";");
                    return nuevoO3;
                default:
                    break;
            }
        } else if (m.equals("accederA")) {
            if (vect.size() != 1) errorYPara(m, vect);

            if (!(vect.firstElement() instanceof Instancia)) errorYPara(m, vect);

            // comprobacion index...
            if (((Instancia) vect.firstElement()).getTipo() != TInt.getInstancia()) errorDeTipos();

            comprobacionRangos(vect.firstElement().getNombreBloque(), ((Instancia) o).getTamArray());

            Objeto nuevoO = null;
            if (((Instancia) o).getSubtipo() == TInt.getInstancia()) {
                nuevoO = new Instancia(Objeto.newNomObj(),TInt.getInstancia(),TablaS.bloqueActual,false);
            } else if (((Instancia) o).getSubtipo() == TFloat.getInstancia()) {
                nuevoO = new Instancia(Objeto.newNomObj(),TFloat.getInstancia(),TablaS.bloqueActual,false);
            } else if ((((Instancia) o).getSubtipo() == TChar.getInstancia())) {
                nuevoO = new Instancia(Objeto.newNomObj(),TChar.getInstancia(),TablaS.bloqueActual,false);
            }

            PLXC.out.println("\t" + nuevoO.getNombreBloque() + "=" + o.getNombreBloque() + "[" + vect.firstElement().getNombreBloque() + "];");

            return nuevoO;
        } else if (m.equals("asigna")) {
            if (vect.size() != 1) errorYPara(m, vect);

            if (!(vect.firstElement() instanceof Instancia)) errorYPara(m, vect);

            if (((Instancia) vect.firstElement()).getTipo() != TArray.getInstancia()) errorDeTipos();

            int tamO = Integer.parseInt(((Instancia) o).getTamArray());
            int tamVectElem = Integer.parseInt(((Instancia) vect.firstElement()).getTamArray());

            if (((Instancia) o).getEsString()) {
                tipoArray = "string";
            } else if (tamO < tamVectElem) {
                errorDimensiones();
            }

            switch (tipoArray) {
                case "int":
                    if (((Instancia) vect.firstElement()).getSubtipo() != TInt.getInstancia()) errorDeTipos();
                    for (int i = 0; i < tamVectElem; i++) {
                        Objeto auxiliar = new Instancia(Objeto.newNomObj(), TInt.getInstancia(), TablaS.bloqueActual, false);
                        PLXC.out.println("\t" + auxiliar.getNombreBloque() + "=" + vect.firstElement().getNombreBloque() + "[" + i + "];");
                        PLXC.out.println("\t" + o.getNombreBloque() + "[" + i + "]=" + auxiliar.getNombreBloque() + ";");
                    }
                    break;
                case "float":
                    if (((Instancia) vect.firstElement()).getSubtipo() != TFloat.getInstancia()) errorDeTipos();
                    for (int i = 0; i < tamVectElem; i++) {
                        Objeto auxiliar = new Instancia(Objeto.newNomObj(), TFloat.getInstancia(), TablaS.bloqueActual, false);
                        PLXC.out.println("\t" + auxiliar.getNombreBloque() + "=" + vect.firstElement().getNombreBloque() + "[" + i + "];");
                        PLXC.out.println("\t" + o.getNombreBloque() + "[" + i + "]=" + auxiliar.getNombreBloque() + ";");
                    }
                    break;
                case "char":
                    if (((Instancia) vect.firstElement()).getSubtipo() != TChar.getInstancia()) errorDeTipos();
                    for (int i = 0; i < tamVectElem; i++) {
                        Objeto auxiliar = new Instancia(Objeto.newNomObj(), TChar.getInstancia(), TablaS.bloqueActual, false);
                        PLXC.out.println("\t" + auxiliar.getNombreBloque() + "=" + vect.firstElement().getNombreBloque() + "[" + i + "];");
                        PLXC.out.println("\t" + o.getNombreBloque() + "[" + i + "]=" + auxiliar.getNombreBloque() + ";");
                    }
                    break;
                case "string":
                    if (((Instancia) vect.firstElement()).getSubtipo() != TChar.getInstancia()) errorDeTipos();

                    String length = "$" + ((Instancia) vect.firstElement()).getNombreBloque() + "_length";

                    Objeto index = ((Instancia) vect.firstElement()).getVariableIndex();

                    Objeto lengthVariable = new Instancia("$" + o.getNombre() + "_length", TInt.getInstancia(), TablaS.bloqueActual, true);

                    PLXC.out.println("\t" + lengthVariable.getNombre() + "=0;");
                    
                    String l0 = TablaS.newEtiq();
                    PLXC.out.println(l0 + ":");
                    String l1 = TablaS.newEtiq(), l2 = TablaS.newEtiq();
                    PLXC.out.println("\tif (" + index.getNombreBloque() + "<" + length + ") goto " + l1 + ";");
                    PLXC.out.println("\tgoto " + l2 + ";");
                    PLXC.out.println(l1 + ":");
                    String auxEt = Objeto.newNomObj();
                    PLXC.out.println("\t" + auxEt + "=" + ((Instancia) vect.firstElement()).getNombreBloque() + "[" + index.getNombreBloque() + "];");
                    String l4 = TablaS.newEtiq();
                    PLXC.out.println(l4 + ":");

                    PLXC.out.println("\t" + o.getNombreBloque() + "[" + lengthVariable.getNombreBloque() + "]=" + auxEt + ";");
                    //lengthVariable.metodos("suma", vectUno);
                    PLXC.out.println("\t" + lengthVariable.getNombreBloque() + "=" + lengthVariable.getNombreBloque() + "+1;");

                    String l5 = TablaS.newEtiq();
                    PLXC.out.println(l5 + ":");
                    // index.metodos("suma", vectUno);
                    PLXC.out.println("\t" + index.getNombreBloque() + "=" + index.getNombreBloque() + "+1;");
                    PLXC.out.println("\tgoto " + l0 + ";");
                    PLXC.out.println(l2 + ":");

                    // hasta aqui es la asignacion...

                    break;
                default:
                    break;
            }
        }
        return o;
    }

    public void comprobacionRangos(String index, String tamArray) {
        String etError = TablaS.newEtiq();
        String etAsig = TablaS.newEtiq();
        PLXC.out.println("\tif(" + index +"<0) goto " + etError + ";");
        PLXC.out.println("\tif(" + tamArray +"<" + index + ") goto " + etError + ";");
        PLXC.out.println("\tif(" + tamArray +"==" + index + ") goto " + etError + ";");
        PLXC.out.println("\tgoto " + etAsig + ";");

        PLXC.out.println(etError + ":\n\terror;\n\thalt;");
        PLXC.out.println(etAsig + ":");
    }
}
