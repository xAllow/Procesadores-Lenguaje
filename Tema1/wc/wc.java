import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;

public class wc {
    public static PrintStream out;
    protected static int  sumaLinea = 0;
    protected static int  sumaPalabras = 0;
    protected static int  sumaCaracter = 0;
    
    
    public static void main(String[] args) {
        Reader in;
        Yytoken token = null;
        
        try {
            if(args.length > 0){
                in = new FileReader(args[0]);
            } else {
                in = new InputStreamReader(System.in);
            }

            if(args.length > 1){
                out = new PrintStream(new FileOutputStream(args[1]));
            } else {
                out = System.out;
            }
            Yylex lex = new Yylex(in);  
            while((token = lex.yylex()) != null){
                if(token.getToken() == Yytoken.PALABRA){
                    sumaPalabras++;
                    sumaCaracter += token.getValor().length();
                }else if(token.getToken() == Yytoken.SALTO){
                    sumaLinea++;
                    sumaCaracter++;
                }else if(token.getToken() == Yytoken.ESPACIO){
                    sumaCaracter++;
                }
               
            }
            out.println(sumaLinea+"     "+sumaPalabras+"      "+sumaCaracter+" "+args[0]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}