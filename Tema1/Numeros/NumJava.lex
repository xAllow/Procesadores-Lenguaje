%%

numeroEntero = 0 | [1-9][0-9]*
octal = 0[1-7]*
hexadecimal = 0x[0-9A-Za-z]+
potencia = [eE][\+\-]*{numeroEntero}

%%

{numeroEntero}|{octal}|{hexadecimal} {return new Yytoken(Yytoken.TOKEN_CTE_ENTERO, )}

({numeroEntero}|{octal}|{hexadecimal})[lL] {return Yytoken}