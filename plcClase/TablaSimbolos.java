import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TablaSimbolos {
    private Map<String, TreeMap<Integer, Objeto>> tabla;
    private static int numEt = 0;
    public static int bActual = 0;
    private static int countBloque = 0;

    public TablaSimbolos(){
        tabla = new HashMap<String, TreeMap<Integer, Objeto>>();
    }

    public static String newEtiq(){
        String v = new String("L"+Integer.toString(numEt));
        numEt++;
        return v;
    }

    public static int newBloque(){
        int ba = bActual;
        countBloque++;
        bActual = countBloque;
        return ba;
    }

    public boolean contiene(String nombre){
        return tabla.containsKey(nombre);
    }

    public boolean contiene(String nombre, int bloque){
        TreeMap<Integer,Objeto> t = tabla.get(nombre);
        return t.containsKey(bloque);
    }

    public int mayorBloque(String n){
        //Devuelve el mayor bloque
        int cnt = -1;
        for(Integer i : tabla.get(n).keySet()){
        
        }
    }

    public Objeto objeto(String n){
        //Devuelve objeto con mayor bloque
        int mayorBloque = mayorBloque(n);
        return tabla.get(n).get(mayorBloque);
    }
    public Objeto objeto(String n, int b){
       return tabla.get(n).get(b);
    }

    public void addObj(Objeto o){
        //Añadir el objeto en su correspondiente bloque
    }

    public void borrarBloque(int bloque){
        //Borrar el bloque entero
    }

}