import java.util.Vector;
public class TChar extends Tipo{
    private static TChar instancia = new TChar();
    
    private TChar(){
        super("int", 0);
    }
    public static TChar getInstancia(){
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
            if(p.size() != 1) errorYPara(m, p);
            if(p.firstElement() instanceof Instancia) {}
            System.out.println("AQUI"+p.firstElement());
            if(((Instancia) p.firstElement()).getTipo() != instancia) errorYPara("Error de tipos", p);
            if(!o.getMutable()) {}
            PLXC.out.println(o.getNombre() + " = " + p.firstElement().getNombre()+";");
        }
        if(m.equals("imprimir")){
            Objeto nObj = new Instancia(Objeto.newNumObj(), instancia, TablaSimbolos.bActual, false);
            PLXC.out.println("printc " +o.getNombre()+";");
            return nObj;
        }
        return null;
    }
}