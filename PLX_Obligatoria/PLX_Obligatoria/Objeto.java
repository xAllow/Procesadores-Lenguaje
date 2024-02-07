import java.util.Vector;

public abstract class Objeto implements Comparable<Objeto> {
    private String nombre;
    private int bloque;
    private boolean mutable;
    private static int numObj = 0;

    public static String newNomObj () {
        return "$v" + (numObj++);
    }

    public Objeto (String n, int b, boolean mut) {
        nombre = n;
        bloque = b;
        mutable = mut;
    }

    public String getNombre() {
        return nombre;
    }

    public int getBloque() {
        return bloque;
    }

    public boolean getMutable () {
        return mutable;
    }

    public String getNombreBloque () {
        if (bloque == 0) {
            return nombre;
        } else {
            String devolver = nombre + "$" + bloque;
            char primerCaracterNombreVector = devolver.charAt(0);
            if (Character.isDigit(primerCaracterNombreVector)) {
                int indiceDolar = devolver.indexOf('$');
                if (indiceDolar != -1) {
                    devolver = devolver.substring(0, indiceDolar);
                }
            }
            return devolver;
        }
    }

    @Override
    public boolean equals (Object obj) {
        Objeto o = (Objeto) obj;
        return o.getNombre().equals(this.getNombre())
            && o.getBloque() == this.getBloque();
    }

    public int compareTo (Objeto c) {
        if (this.getNombre().compareTo(c.getNombre()) < 0) {
            return -1;
        } else if (this.getNombre().compareTo(c.getNombre()) > 0) {
            return 1;
        }

        if (this.getBloque() < getBloque()) {
            return -1;
        } else if (this.getBloque() > getBloque()) {
            return 1;
        }

        return 0;
    }

    // funcion abstracta para realizar metodos sobre el objeto en el que nos
    // encontramos -> vect son los argumentos.
    public abstract Objeto metodos (String nameMethod, Vector<Objeto> vect);

    public void errorYPara (String mensaje, Vector<Objeto> vect) {
        PLXC.out.println("error ;");
		PLXC.out.println("# " + mensaje + " con argumentos " + vect.toString() + ")");
		PLXC.out.println("halt ;");
    }

    public void errorDeTipos () {
		PLXC.out.println("# error de tipos");
        PLXC.out.println("error ;");
    }

    public void errorDimensiones () {
        PLXC.out.println("# ERROR: Las dimensiones de los arrays no encajan");
        PLXC.out.println("error;\nhalt;");
    }
}