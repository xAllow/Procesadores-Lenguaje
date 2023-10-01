import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;

public class JCom {
    public static PrintStream out;
    protected static int  sumaLinea = 0;
    protected static int  sumaBloque = 0;
    protected static int  sumaDocumentacion = 0;
    
    
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
                if(token.getToken() == Yytoken.LIN){
                    sumaLinea += token.getValor().length();
                }else if(token.getToken() == Yytoken.BLOQ){
                    sumaBloque += token.getValor().length();
                }else if(token.getToken() == Yytoken.DOC){
                    sumaDocumentacion += token.getValor().length();
                }
               
            }
            out.printf("//   %d%n", sumaLinea);
            out.printf("/*   %d%n", sumaBloque);
            out.printf("/**  %d%n", sumaDocumentacion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}