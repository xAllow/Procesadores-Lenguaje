%%
%int
define = "#define"
id = [a-zA-Z][a-zA-Z0-9_]*

%{
    TablaSimbolos t = new TablaSimbolos();
    String variable = "";
    String valor = "";
    String aux = "";
%}

%state ID, VALOR, ASIGNAR

%%
<YYINITIAL> {
    {define} {
        yybegin(ID);
    }
    \ +{define} {System.out.print(yytext());}
    \$\{/{id} {
        yybegin(ASIGNAR);
    }
    [^\$] {System.out.print(yytext());}
}

<ID> {
    {id} {
        variable = yytext();
        yybegin(VALOR);
    }
    [0-9_]*{id} {
        System.out.println("ERROR_DEFINICION");
        yybegin(YYINITIAL);
    }
    [^] {}

}

<VALOR> {
    \n {
        t.put(variable, valor);
        yybegin(YYINITIAL);
    }
    [^\n] {
        valor += yytext();
    }

}

<ASIGNAR> {
    \} {
        System.out.print(t.get(aux));
        aux = "";
        variable = "";
        valor = "";
        yybegin(YYINITIAL);
    }
    [^] {
        aux += yytext();
    }
}
