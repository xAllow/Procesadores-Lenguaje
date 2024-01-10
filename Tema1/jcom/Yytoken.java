public class Yytoken {
    public static final int LIN = 1;
    public static final int BLOQ = 2;
    public static final int DOC = 3;


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
