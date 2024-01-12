import java.util.Vector;

public abstract class Objeto implements Comparable<Objeto>{
    private String nombre;
    private int bloque;
    private  boolean mutable;
    private static int numObj = 0;
    public static String newNumObj(){
        String v = new String("t"+Integer.toString(numObj));
        numObj++;
        return v;
    }

    public Objeto(String n, int b, boolean mut){
        nombre = n;
        bloque = b;
        mutable = mut;
    }

    public int getBloque() {
        return bloque;
    }
    public String getNombre() {
        return nombre;
    }
    public static int getNumObj() {
        return numObj;
    }

    public  boolean getMutable(){
        return mutable;
    }
    public String getNombreB(){
        if(bloque == 0){
            return nombre;
        } else {
            return nombre + "$" + bloque;
        }
    }

    @Override
    public boolean equals(Object Obj){
        Objeto o = (Objeto) Obj;
        return o.getNombre().equals(this.getNombre()) && o.getBloque() == this.getBloque();
    }

    public int compareTo(Objeto c){
        if(this.getNombre().compareTo(c.getNombre()) < 0) return -1;
        if(this.getNombre().compareTo(c.getNombre()) > 0) return 1;
        if(this.getBloque() < c.getBloque()) return -1;
        if(this.getBloque() > c.getBloque()) return 1;
        return 0;
    }

    public abstract Objeto metodos(String m, Vector<Objeto> p);

    public void errorYPara(String mensaje, Vector<Objeto> p){

    }
}
