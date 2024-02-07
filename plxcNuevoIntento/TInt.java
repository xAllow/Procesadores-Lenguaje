import java.util.Vector;

public class TInt extends Tipo{
    private static TInt instancia = new TInt();
    
    private TInt(){
        super("int", 0);
    }
    public static TInt getInstancia(){
        return instancia;
    }

    public Objeto metodos(String m, Vector<Objeto>p){
        errorYPara(m,p);
        return null;
    }

    public Objeto metodosInstancia(Objeto o, String m, Vector<Objeto>p){
        if(!(o instanceof Instancia)) {}
        if(((Instancia)o).getTipo() != instancia) {}
        if(m.equals("asigna")) {
            if(p.size() != 1) {}
            if(p.firstElement() instanceof Instancia) {}
            if(((Instancia) p.firstElement()).getTipo() != instancia) errorYPara(m, p);
            if(!o.getMutable()) {}
            PLXC.out.println(o.getNombre() + " = " + p.firstElement().getNombre()+";");
        }
        if(m.equals("suma")){
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre()+" = "+o.getNombre()+"+"+p.firstElement().getNombre()+";");
            return nObj;
        }
        if(m.equals("menos")){
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre()+" = "+o.getNombre()+"-"+p.firstElement().getNombre()+";");
            return nObj;
        }
        if(m.equals("por")){
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre()+" = "+o.getNombre()+"*"+p.firstElement().getNombre()+";");
            return nObj;
        }
        if(m.equals("div")){
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombre()+" = "+o.getNombre()+"/"+p.firstElement().getNombre()+";");
            return nObj;
        }
        if(m.equals("imprimir")){
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println("print " +o.getNombre()+";");
            return nObj;
        }
        if(m.equals("castChar")){
            Objeto nObj = new Instancia(o.getNombre(), TChar.getInstancia(), TablaSimbolos.bActual, false);
            return nObj;
        }
        return o;
    }
}
