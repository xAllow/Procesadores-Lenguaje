import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;

public class cpv {
    public static PrintStream out;
    protected static int  sumaA = 0;
    protected static int  sumaB = 0;
    protected static int  sumaC = 0;
    protected static int  sumaD = 0;
    
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
                if(token.getToken() == Yytoken.A){
                    sumaA++;
                }
                if(token.getToken() == Yytoken.B){
                    sumaB++;
                }
                if(token.getToken() == Yytoken.C){
                    sumaC++;
                }
                if(token.getToken() == Yytoken.D){
                    sumaD++;
                }
            }
            out.println("A "+Integer.toString(sumaA));
            out.println("B "+Integer.toString(sumaB));
            out.println("C "+Integer.toString(sumaC));
            out.println("D "+Integer.toString(sumaD));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}