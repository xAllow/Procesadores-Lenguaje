import java.util.HashMap;

public class TablaSimbolos {
	
	public final static String ERROR_NOEXISTE = "ERROR6: No se ha encontrado este indentificador en la tabla de simbolos";
	
	private static HashMap<String,String> tabla = new HashMap<String,String>();
	
	public static String buscar(String ident) {
		return tabla.get(ident);
	}
	
	public static void insertar(String ident, String valor) {
		tabla.put(ident, valor);
	}
	
}