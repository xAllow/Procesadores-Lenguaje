%%
%int 
%unicode
%{
    TablaSimbolos ts = new TablaSimbolos();
    StringBuffer cadena = new StringBuffer();
    String aux ="";
%}

%state ASIGNACION, VALOR, IMPRIMIR

%%

<YYINITIAL> {
    [a-zA-Z_][a-zA-Z_0-9\ ]*\= {
        cadena.setLength(0);
        cadena.append(yytext());
        aux = "";
        cadena.deleteCharAt(cadena.length()-1);
        yybegin(ASIGNACION);
    }
    [a-zA-Z_][a-zA-Z_0-9]*[\ ]+ {
        System.out.print(yytext());
        yybegin(IMPRIMIR);
    }
    [\s\n] {}
    
}

<ASIGNACION> {
    \$[a-zA-Z_][a-zA-Z_0-9]* {
        aux += ts.get(yytext());
    }
    \"  {yybegin(VALOR);}
    \\\; {aux +=yytext();}
    [^\n\s\;] {aux +=yytext();}
    [\n;] {
        ts.put(cadena.toString(), aux);
        yybegin(YYINITIAL);
    }
    

    
}

<VALOR> {
    \$[a-zA-Z_][a-zA-Z_0-9]* {
        aux += ts.get(yytext());
    }
    \\\" | \\\$ {aux += yytext();}

    [^\"] {aux += yytext();}

    \" {yybegin(ASIGNACION);}
}

<IMPRIMIR> {
    \$[a-zA-Z_][a-zA-Z_0-9]* {
        System.out.println(ts.get(yytext()));
    }
    [^\n$] {System.out.print(yytext());}
    \n {
        yybegin(YYINITIAL);
    }
}