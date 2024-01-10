import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.io.FileReader;

class Parser {

public final static int EOF = Yylex.EOF;
public final static int NUMERO = Yylex.NUMERO ;         
public final static int COMA = Yylex.COMA;
public final static int AC = Yylex.AC; // Abre corchete
public final static int CC = Yylex.CC; // Cierra corchete
public final static int AP = Yylex.AP; // Abre parentesis
public final static int CP = Yylex.CP; // Cierra parentesis
public final static int NELEM = Yylex.NELEM;         
public final static int MAXLENGTH = Yylex.MAXLENGTH;         
public final static int MAXDEPTH = Yylex.MAXDEPTH;         
	
private static int token;
private static Yylex lex;
private static int yylex() {
	int token = 0;
	try {
		token = lex.yylex();
	} catch (IOException e) {
		System.out.println("ERROR");
		System.exit(0);
	}
	return token;
}

public static void main(String[] arg) throws ParseException {
    if (arg.length>0) {
        try {
            lex = new Yylex(new FileReader(arg[0]));
            token = yylex();
            S();
            if(token == EOF){
                System.out.println("CORRECTO");
            }else {
                System.out.println("ERROR");
            }
            /// .... A completar .....
        } catch (IOException e) {
        } 
    }
}

/// .... A completar .....
private static void S() throws ParseException{
    switch (token) {
        case AC:
            if(token == AC)
                token = yylex();
            A();
            
            break;
    
        default:
            System.out.println("ERROR");
		    System.exit(0);
    }
}
private static void A() throws ParseException{
    switch (token) {
        case AC:
            B();
            if(token == CC)
                token = yylex();  
            break;
        case CC:
            if(token == CC)
                token = yylex();
            break;
        case NUMERO:
            B();
            if(token == CC)
                token = yylex(); 
            break;
        default:
          System.out.println("ERROR");
		System.exit(0);
    }
}
private static void B() throws ParseException{
    switch (token) {
        case AC:
            E();
            F();
            break;
        case NUMERO:
            E();
            F();
            break;
        default:
          System.out.println("ERROR");
		System.exit(0);
    }
}
private static void E() throws ParseException{
    switch (token) {
        case AC:
            S();
            break;
        case NUMERO:
            if(token == NUMERO)
                token = yylex();
            break;
        default:
          System.out.println("ERROR");
		System.exit(0);
    }   
}
private static void F() throws ParseException{
    switch (token) {
        case CC:
            break;
        case COMA:
            if(token == COMA)
                token = yylex();
            B();
            break;
        default:
            System.out.println("ERROR");
		System.exit(0);
    }
}
}