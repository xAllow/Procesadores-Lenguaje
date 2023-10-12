%%
%int
%unicode
%state LINEA, BLOQUE, DOCUMENTACION, COMILLAS

%%

<YYINITIAL> {
    \" {
        yybegin(COMILLAS);
    }


    \/\/ {
        yybegin(LINEA);
    }

    \/\* {
        yybegin(BLOQUE);
    }

    \/\*\* {
        yybegin(DOCUMENTACION);
    }

    [^] {}
}

<LINEA> {
    \n {
        yybegin(YYINITIAL);
    }
    [^\s\t\n\r]+ {
        return new Yytoken(Yytoken.LIN, yytext());
    }
    
    \" {
        yybegin(COMILLAS);
    }

    [^] {}
}

<BLOQUE> {
    \*\/ {
        yybegin(YYINITIAL);
    }

    [^\s\t\n\r]+ {
        return new Yytoken(Yytoken.BLOQ, yytext());
    }

    [^] {}
}

<DOCUMENTACION> {
    \*\/ {
        yybegin(YYINITIAL);
    }

    [^\s\t\n\r]+ {
        return new Yytoken(Yytoken.DOC, yytext());
    }

    [^] {}
}

<COMILLAS> {
    \" {yybegin(YYINITIAL);}
    [^\"] {}
}