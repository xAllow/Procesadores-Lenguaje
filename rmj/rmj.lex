%%
%int
%state MAIN, CODIGO, WRITE, STRINGW, STRINGP, PRINT

Variables = [a-zA-Z_][a-zA-Z0-9_]*

%{
TablaSimbolos ts = new TablaSimbolos();
String variable = new String();
StringBuffer con = new StringBuffer();

%}
%%
<YYINITIAL> {
    [\t\ ]*\{ {  System.out.print("_rmj" + yytext());
                 yybegin(MAIN);
    }

    [^] {System.out.print(yytext());}
}

<MAIN> {
    \{ {System.out.print(yytext()); yybegin(CODIGO);}

    [^] {System.out.print(yytext());}
}

<CODIGO> {
    String {} //Cuando me encuentro el tipo string lo ignoro

    [\t\ ]*System\.out\.print(ln)?[\t\ ]*\( { /*reset de con y empiezo a imprimir sout*/
        System.out.print(yytext() + "\""); 
        con.setLength(0); 
        yybegin(PRINT);
    } 

    {Variables} { /*Almaceno el valor de la variable*/
        variable = yytext();
    } 

    [\t\ ]*}[\t\ ]* { //Final del codigo
        System.out.print(yytext());
    } 

    = {
        con.setLength(0); 
        yybegin(WRITE);
    }

    \n {System.out.print(yytext());}

    [^] {}
}
<WRITE> {
    \" {yybegin(STRINGW);}

    \; {
        ts.put(variable, con.toString()); 
        yybegin(CODIGO);
    }

    {Variables} {
        con.append(ts.get(yytext()));
    }

    [^] {}
}
<STRINGW> {
    \" {yybegin(WRITE);}
    \\\" {con.append("\\\"");}
    \\\n {con.append("\\\n");}
    \\\t {con.append("\\\t");}
    \\\\ {con.append("\\\\");}
    [^] {con.append(yytext());}
}
<PRINT> {
    \" {yybegin(STRINGP);}

    {Variables} {
        con.append(ts.get(yytext()));
    }

    \)\; {
        System.out.print(con.toString() + "\"" + yytext()); 
        yybegin(CODIGO);
    }

    [^] {}
}

<STRINGP>{
    \" {yybegin(PRINT);}
    \\\" {con.append("\\\"");}
    \\\n {con.append("\\\n");}
    \\\t {con.append("\\\t");}
    \\\\ {con.append("\\\\");}
    [^] {con.append(yytext());}
}
