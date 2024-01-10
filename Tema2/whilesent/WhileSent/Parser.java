import java.io.FileReader;
import java.io.IOException;
import java.io.FileReader;

class Parser {

private static int token;
private static Yylex lex;
private static int yylex() {
	int token = 0;
	try {
		token = lex.yylex();
	} catch (IOException e) {
		System.out.println("IOException");
		System.exit(0);
	}
	return token;
}

public static void main(String[] arg) {
    if (arg.length>0) {
		int token = 0;
        try {
            lex = new Yylex(new FileReader(arg[0]));
            /// .... A completar .....
			token = yylex();
			axioma();
        } catch (IOException e) {
        } 
    }
}

public static void axioma(){
	switch (token) {
		//R0
		case Yytoken.DO:
		case Yytoken.IDENT:
		case Yytoken.ALL:
		case Yytoken.WHILE:
		case Yytoken.EOF:

			Yytoken.regla(0);
			listaSent();
			if(token == Yytoken.EOF){
				token = yylex();
			}else{
				Yytoken.error(token);
			}
			break;
		default: break;
		
	}
}

public static void listaSent() {
	switch (token) {
		case Yytoken.DO:
		case Yytoken.IDENT:
		case Yytoken.ALL:
		case Yytoken.WHILE:
		Yytoken.regla(1);
		sent();
		listaSent();
		break;
	default:
		Yytoken.regla(2 );
		break;
	}
}

public static void sent(){
	switch (token) {
		case Yytoken.WHILE:
		Yytoken.regla(3);
		if(token == Yytoken.WHILE){
			token = yylex();
		}else{
			Yytoken.error(token);
		}
		if(token == Yytoken.AP){
			token = yylex();
		}else{
			Yytoken.error(token);
		}
		cond();
		if(Yytoken.CP == token){
			token = yylex();
		}else{
			Yytoken.error(token);
		}
		sent();
		break;

		case Yytoken.DO:
		Yytoken.regla(4);
		if(token == Yytoken.DO){
			token = yylex();
		}else{
			Yytoken.error(token);
		}
		sent();
		
		if(token == Yytoken.WHILE){
			token = yylex();
		}else{
			Yytoken.error(token);
		}

		if(token == Yytoken.AP){
			token = yylex();
		}else{
			Yytoken.error(token);
		}
		cond();
		if(token == Yytoken.CP){
			token = yylex();
		}else{
			Yytoken.error(token);
		}
		if(token == Yytoken.PYC){
			token = yylex();
		}else{
			Yytoken.error(token);
		}
		break;

		case Yytoken.IDENT:
		Yytoken.regla(5);
		if(token == Yytoken.IDENT){
			token = yylex();
		}else{
			Yytoken.error(token);
		}
		if(token == Yytoken.IGUAL){
			token = yylex();
		}else{
			Yytoken.error(token);
		}
		var();
		if(token == Yytoken.PYC){
			token = yylex();
		}else{
			Yytoken.error(token);
		}
		break;

		case Yytoken.ALL:
		Yytoken.regla(6);
		if(token == Yytoken.ALL){
			token = yylex();
		}else{
			Yytoken.error(token);
		}
		listaSent();
		if(token == Yytoken.CLL){
			token = yylex();
		}else{
			Yytoken.error(token);
		}
		break;
		
		default:
				Yytoken.error(0);
				break;
	}
}

public static void cond(){
	switch (token) {
		case Yytoken.IDENT:
		Yytoken.regla(7);
		var();

		if(token == Yytoken.MENOR){
			token = yylex();
		}else{
			Yytoken.error(token);
		}
		var();
		break;
		case Yytoken.NUMERO:

		Yytoken.regla(7);
		var();

		if(token == Yytoken.MENOR){
			token = yylex();
		}else{
			Yytoken.error(token);
		}
		var();
		break;


		default:
			Yytoken.error(0);
			break;
	}
}

public static void var(){
	switch(token){
		case Yytoken.IDENT:
		Yytoken.regla(8);
		if(token == Yytoken.IDENT){
			token = yylex();
		}else{
			Yytoken.error(Yytoken.IDENT);
		}
		break;
		case Yytoken.NUMERO:
		Yytoken.regla(9);
		if(token == Yytoken.NUMERO){
			token = yylex();
		}else{
			Yytoken.error(Yytoken.NUMERO);
		}
		default:
		Yytoken.error(0);
			break;
	}
}


}