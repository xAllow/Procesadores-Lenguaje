%%
%int
%unicode
%{
    int nSub = 0;
    int h1, m1, s1 = 0;
    int nLineas = 0;
    int nPalabras = 0;
    int h2, m1, s2 = 0;
%}

numero = 0 | [1-9][0-9]*
hora = [0-5][0-9]
palabras = [a-zA-Z\?\!\¡\¿]
%state HORA1

%%  

<YYINITIAL> {
    {numero}\n {nSub++;}
    {hora}/\:{hora}\:{hora} {

    }
}

