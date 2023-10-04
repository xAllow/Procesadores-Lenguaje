%%

%int
%unicode
%{
    int tiempoTotal = 0;
    int nSub = 0;
    int h1 = 0, m1 = 0, s1 = 0;
    int nLineas = 0;
    int nPalabras = 0;
    int h2 = 0, m2 = 0, s2 = 0;
%}

%eof{
    System.out.println("NUM_SUBTITULOS "+nSub);
    System.out.println("TIEMPO_TOTAL "+ tiempoTotal);
    System.out.println("NUM_LINEAS " + nLineas);
    System.out.println("NUM_PALABRAS " +nPalabras);
%eof}
separador = \s
numero = 0 | [1-9][0-9]*
hora = [0-5][0-9]
palabras = [a-zA-Z0-9\?¿!¡,\.\"\'\<\>\(\)\[\]\-\/\{\}♪:]+
flecha = "-->"
milisegundos = ","[0-9]{3}
%state HORA1, HORA2, TEXTO


%%
<YYINITIAL> {
    {numero}\n {nSub++;}

    {hora}/\:{hora}\:{hora}{milisegundos}{separador}{flecha}{separador}{hora}\:{hora}\:{hora}{milisegundos}\n {
        h1 = Integer.parseInt(yytext());
        yybegin(HORA1);
    }
    
    
    [^] {}
}

<HORA1> {
    {hora}/\: {
        m1 = Integer.parseInt(yytext());
        
    }

    {hora}/{milisegundos} {
        s1 = Integer.parseInt(yytext());
    }

    {milisegundos} {}

    {separador}{flecha}{separador} {
        yybegin(HORA2);}

    \: {}

    [^] {}
}

<HORA2> {
    {hora}/\:{hora}\: {
        h2 = Integer.parseInt(yytext());
        
    }

    {hora}/\:{hora} {
        m2 = Integer.parseInt(yytext());
        
    }
    
    \: {}
    {hora}/{milisegundos} {
        s2 = Integer.parseInt(yytext());
        tiempoTotal += (h2 - h1) * 3600 + (m2 - m1) * 60 + (s2 - s1);
              
    }
    {milisegundos} {
        yybegin(TEXTO); 
    }
    [^] {}

}

<TEXTO>{
    {palabras}[\n]   {nPalabras++;nLineas++;}
    {palabras}  {nPalabras++;}
    
    \s|\t                               {}
    [\n]/[1-9][0-9]*                     {yybegin(YYINITIAL);}
    [^]                                 {}
}