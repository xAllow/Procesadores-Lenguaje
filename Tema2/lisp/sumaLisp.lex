%%

%{
    public int linea = 1;
%}

%unicode

Espacio = \s
Retorno = \R

%%

\$  {return new Yytoken(Yytoken.DOLAR, 0);}
\(  {return new Yytoken(Yytoken.AP, 0);}
\)  {return new Yytoken(Yytoken.CP, 0);}
\+  {return new Yytoken(Yytoken.MAS, 0);}
\-  {return new Yytoken(Yytoken.MENOS, 0);}

[+-]?[0-9]+  {return new Yytoken(Yytoken.ENTERO, Integer.parseInt(yytext()));}

{Retorno}   {linea++;}

{Espacio} {}

[^] {return new Yytoken(Yytoken.ERROR, linea);}