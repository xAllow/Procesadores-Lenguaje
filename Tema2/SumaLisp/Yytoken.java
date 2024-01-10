public class Yytoken {
    public static final int DOLAR = 0;
    public static final int AP = 1;
    public static final int CP = 2;
    public static final int MAS = 3;
    public static final int MENOS = 4;
    public static final int ENTERO = 5;
    public static final int ERROR = 6;

    private int token;
    private int valor;
    public Yytoken(int token, int valor){
        this.token = token;
        this.valor = valor;
    }

    public int getToken(){
        return token;
    }

    public int getValor(){
        return valor;
    }

    @Override
    public String toString(){
        return "<"+token+","+valor+">";
    }
}
