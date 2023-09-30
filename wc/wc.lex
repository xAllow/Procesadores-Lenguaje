%%

%unicode

%%

[a-zA-Z]+ {
    return new Yytoken(Yytoken.PALABRA, yytext());
}

\n {
    return new Yytoken(Yytoken.SALTO, yytext());
}

[^\n] {
    return new Yytoken(Yytoken.ESPACIO, yytext());
}