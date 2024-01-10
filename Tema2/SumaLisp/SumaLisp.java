import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.text.ParseException;
import java.util.Objects;

public class SumaLisp {
    public static PrintStream out;
    private static Yylex lex;
    private static Yytoken actual;

    private static void checkActual() throws ParseException{
        if(actual == null){
            throw new ParseException("Fin de fichero inesperado", lex.linea);
        }
    }

    private static void avanzar(int token, String mensaje) throws ParseException, IOException{
        if(actual.getToken() == token){
            actual = lex.yylex();
        } else {
            throw new ParseException("Error", lex.linea);
        }        
    }

    private static void S() throws ParseException, IOException{
        checkActual();
        switch(actual.getToken()){
            case Yytoken.AP:
                L();
                avanzar(Yytoken.DOLAR, "Error, falta $");
                break;
            default:
                throw new ParseException("Error", lex.linea);
        }
    }

    private static void L() throws ParseException, IOException{
        int valor;
        checkActual();
        switch(actual.getToken()){
            case Yytoken.AP:
                valor = O();
                out.println(valor);
                E();
                break;
            default:
                throw new ParseException("Error L", lex.linea);
        }
    }

    private static void E() throws ParseException, IOException{
        checkActual();
        switch (actual.getToken()) {
            case Yytoken.AP:
                O();
                E();
                break;
            case Yytoken.DOLAR:
                break;
            default:
                throw new ParseException("Error E", lex.linea);
                
        }
    }

    private static int O() throws ParseException, IOException{
        int t1,t2, r;
        char op;
        checkActual();
        switch (actual.getToken()) {
            case Yytoken.AP:
                avanzar(Yytoken.AP, "Error");
                op = OP();
                t1 = T();
                t2 = T();
                avanzar(Yytoken.CP, "Error");
                switch (op) {
                    case '+':
                        r = t1 + t2;
                        break;
                    case '-':
                        r = t1 - t2;
                        break;
                    default:
                        throw new ParseException("Error", lex.linea);
                }
                
                break;
            default:
                throw new ParseException("Error E", lex.linea);
    
        }
        return r;
    }

    private static char OP() throws ParseException, IOException{
        char r;
        checkActual();
        switch (actual.getToken()) {
            case Yytoken.MAS:
                r = '+';
                avanzar(Yytoken.MAS, "Error");
                
                break;
            case Yytoken.MENOS:
                r = '-';
                avanzar(Yytoken.MENOS, "Error");
                
                break;
            default:
                throw new ParseException("Error E", lex.linea);
                
        }
        return r;
    }

    private static int T() throws ParseException, IOException{
        int valor;
        checkActual();
        switch (actual.getToken()) {
            case Yytoken.AP:
                valor = O();
                break;
            case Yytoken.ENTERO:
                valor = actual.getValor();
                avanzar(Yytoken.ENTERO, "Error");
                break;
            default:
                throw new ParseException("Error E", lex.linea);
                
        }
        return valor;
    }
    

    public static void main(String args[]) throws ParseException {
        try {
            Reader in = new InputStreamReader(System.in);
            out = System.out;
            if(args.length > 0){
                in = new FileReader(args[0]);
            }
            if(args.length > 1){
                out = new PrintStream(new FileOutputStream(args[1]));
            }
            lex = new Yylex(in);
            actual = lex.yylex();
            while(actual != null){
                S();
            }
            System.out.println("Parser finalizado correctamente");




        } catch (IOException e){
            out.println("Error "+ e.getMessage());
        }
    }
}


