public class Yytoken {
    public static final int PALABRA = 1;
    public static final int SALTO = 2;
    public static final int ESPACIO = 3;


    private int token;
    private String valor;
    public Yytoken(int token, String valor){
        this.token = token;
        this.valor = valor;
    }

    public int getToken(){
        return token;
    }

    public String getValor(){
        return valor;
    }

    @Override
    public String toString(){
        return "<"+token+","+valor+">";
    }
}
