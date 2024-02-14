import java.util.Vector;

public class TBoolean extends Tipo{
    private static TBoolean instancia = new TBoolean();
    
    private TBoolean(){
        super("boolean", 0);
    }
    public static TBoolean getInstancia(){
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
            if(((Instancia) p.firstElement()).getTipo() != instancia) {}
            if(!o.getMutable()) {}
            PLXC.out.println(o.getNombre() + " = " +";");
        }
        
        if(m.equals("imprimir")){
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println("print " +o.getNombre()+";");
            return nObj;
        }
        
        return o;
    }
}
