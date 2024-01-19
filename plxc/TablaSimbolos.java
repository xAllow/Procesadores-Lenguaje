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
        // Devuelve el mayor bloque
        int mayorBloque = -1;
        TreeMap<Integer, Objeto> objetoMap = tabla.get(n);

        for (Integer bloque : objetoMap.keySet()) {
            if (bloque > mayorBloque) {
                mayorBloque = bloque;
            }
        }

        return mayorBloque;
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
        // Añadir el objeto en su correspondiente bloque
        String nombre = o.getNombre();
        int bloque = o.getBloque();
        
        if (!tabla.containsKey(nombre)) {
            tabla.put(nombre, new TreeMap<>());
        }

        tabla.get(nombre).put(bloque, o);
        
    }

    public void borrarBloque(int bloque) {
        // Borrar el bloque entero en todos los objetos
        for (Map.Entry<String, TreeMap<Integer, Objeto>> entry : tabla.entrySet()) {
            String nombre = entry.getKey();
            TreeMap<Integer, Objeto> objetoMap = entry.getValue();
    
            if (objetoMap != null && objetoMap.containsKey(bloque)) {
                objetoMap.remove(bloque);
    
                // Eliminar la entrada completa si no hay más objetos en el TreeMap
                if (objetoMap.isEmpty()) {
                    tabla.remove(nombre);
                }
            }
        }
    }
    

}