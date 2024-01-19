import java.util.Vector;

public class TFloat extends Tipo{
    private static TFloat instancia = new TFloat();
    
    private TFloat(){
        super("float", 0);
    }
    public static TFloat getInstancia(){
        return instancia;
    }

    public Objeto metodos(String m, Vector<Objeto>p){
        errorYPara(m,p);
        return null;
    }

    public Objeto metodosInstancia(Objeto o, String m, Vector<Objeto>p){
        if(!(o instanceof Instancia)) errorYPara(m, p);
        if(((Instancia)o).getTipo() != instancia) errorYPara(m, p);
        if(m.equals("asigna")) {
            if(p.size() != 1) errorYPara(m, p);
            if(p.firstElement() instanceof Instancia) errorYPara(m, p);
            if(((Instancia) p.firstElement()).getTipo() != instancia) errorYPara(m, p);
            if(!o.getMutable()) errorYPara(m, p);
            PLXC.out.println(o.getNombre() + " = " + p.firstElement().getNombre()+";");
        }
        if(m.equals("suma")){
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println(nObj.getNombreB()+" = "+o.getNombreB()+"+"+p.firstElement().getNombreB()+";");
        }
        
        return o;
    }
}
