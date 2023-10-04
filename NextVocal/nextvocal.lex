%%
%int
separador = \s  
letras = [a-zA-Z]
vocales = [aeiou]
%%

    {letras}+ /{separador}{vocales} {
        System.out.print(yytext() + " ");
    }

    [^] {}



