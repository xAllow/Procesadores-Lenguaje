import java.io.FileReader;
import java.io.IOException;

public class Prep {
    public static void main(String[] args) {
        if(args.length>0){
            try {
                Yylex lex = new Yylex(new FileReader(args[0]));
                lex.yylex();
            } catch (IOException e) {
                
            }
        }
    }
}
