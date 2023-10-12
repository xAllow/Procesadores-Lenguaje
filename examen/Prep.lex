%%
%int
define = "#define "
ifde = "#ifdef "
end = "#endif "
id = [a-zA-Z][a-zA-Z0-9_]*

%{
    TablaSimbolos t = new TablaSimbolos();
    String variable = "";
    String valor = "";
    String aux = "";
    String ifde = "";
%}

%state ID, VALOR, ASIGNAR, ERROR, IFDEF

%%
<YYINITIAL> {
    {define} {
        yybegin(ID);
    }
    {end} {}
    {ifde} {
        yybegin(IFDEF);
    }
    \ +{define} {System.out.print(yytext());}
    \ +{end} {System.out.print(yytext());}
    \ +{ifde} {System.out.print(yytext());}
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
        yybegin(ERROR);
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

<ERROR> {
    \n {
        yybegin(YYINITIAL);
    }
    {end} {
        yybegin(YYINITIAL);
    }
    [^] {}
}

<IFDEF> {
    {id} {
        if(t.get(yytext()) != "ID_NO_DEFINIDO"){
            yybegin(YYINITIAL);
        } else {
            yybegin(ERROR);
        }
    }
    [^] {}
}
