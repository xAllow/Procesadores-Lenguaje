public class Yytoken {
    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 3;
    public static final int D = 4;

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
