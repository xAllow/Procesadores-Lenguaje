import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TablaS {
    private Map<String,TreeMap<Integer,Objeto>> tabla;
    // esta estructura guarda los nombres de las variables asociadas con
    // tablas que tienen correspondencias de numero de bloque y objeto

    public static int bloqueActual = 0;

    private static int etq = 0;

    public static String newEtiq () {
        return "E" + (etq++);
    }

    private static int cuntBloque = 0;

    public static int newBloque () {
        int ba = bloqueActual;
        cuntBloque++;
        bloqueActual = cuntBloque;
        return ba;
    }

    public TablaS () {
        // creamos la tabla vacia
        tabla = new HashMap<>();
    }

    public boolean contiene (String nombre) {
        // si la tabla contiene una correspondencia a ese nombre...
        return tabla.get(nombre) != null;
    }

    public boolean contiene (String nombre, int bloque) {
        TreeMap<Integer, Objeto> treeMap = tabla.get(nombre);
        return treeMap != null && treeMap.get(bloque) != null;
    }

    public int mayorBloque (String n) {
        // mayor bloque que contiene la variable n
        int nb = -1;
        for (Integer i : tabla.get(n).keySet()) {
            if (i > nb) nb = i;
        }
        return nb;
    }

    public Objeto objeto (String n) {
        // devuelve el objeto con mayor bloque
        int mayorBloque = mayorBloque(n);
        return tabla.get(n).get(mayorBloque);
    }

    public Objeto objeto (String n, int bloque) {
        return tabla.get(n).get(bloque);
    }

    public void addObj (Objeto o) {
        // añadir a la tabla el objeto o (en su correspondiente bloque que esta dentro de su informacion)
        TreeMap<Integer, Objeto> treeMap = tabla.get(o.getNombre());
        if (treeMap == null) {
            TreeMap<Integer,Objeto> auxiliar = new TreeMap<>();
            auxiliar.put(o.getBloque(), o);
            tabla.put(o.getNombre(),auxiliar);
        } else {
            treeMap.put(o.getBloque(), o);
        }
    }

    public void borrarBloque (int bloque) {
        // sirve para borrar todos los objetos de la tabla que esten en ese bloque
        // Lista para almacenar las claves que deben eliminarse después
        List<String> clavesAEliminar = new ArrayList<>();

        // Recorrer el mapa de tablas
        for (String clave : tabla.keySet()) {
            TreeMap<Integer, Objeto> treeMap = tabla.get(clave);

            // Eliminar la entrada en el TreeMap si contiene el número
            treeMap.entrySet().removeIf(entry -> entry.getKey() == bloque);

            // Si el TreeMap queda vacío, agregar la clave a la lista para eliminarla después
            if (treeMap.isEmpty()) {
                clavesAEliminar.add(clave);
            }
        }

        // Eliminar las claves que están vacías
        for (String clave : clavesAEliminar) {
            tabla.remove(clave);
        }
    }

    @Override
    public String toString () {
        StringBuilder stringBuilder = new StringBuilder();
    
        stringBuilder.append("Tabla:\n");
    
        for (Map.Entry<String, TreeMap<Integer, Objeto>> entry : tabla.entrySet()) {
            stringBuilder.append("Clave: ").append(entry.getKey()).append("\n");
        
            TreeMap<Integer, Objeto> treeMap = entry.getValue();
        
            if (treeMap != null) {
                for (Map.Entry<Integer, Objeto> nestedEntry : treeMap.entrySet()) {
                    stringBuilder.append("\tBloque: ").append(nestedEntry.getKey())
                             .append(" -> Objeto: ").append(nestedEntry.getValue())
                             .append("\n");
                }
            }
        }
    
        return stringBuilder.toString();
    }
}