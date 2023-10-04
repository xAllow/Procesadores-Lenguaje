%%
%unicode

articulos = [a-zA-Z\s]+
unidades = [1-9][0-9]*


%{
    Ticket t = new Ticket();
    int unidad = 1;
    float descuento = 0;
%}

%state ARTICULO, DESCUENTOS, UNIDAD
%%
<YYINITIAL> {
    "-"{articulos}  {
        t.addItemsDistintos(1);
        descuento = 0;
        unidad = 1;
        
        yybegin(ARTICULO);
    }
    \ +"-" {}
    
    \n {}
    [^] {}
}

<ARTICULO> {
    {unidades}/"uds" {
        unidad = Integer.parseInt(yytext());
    }
    [1-9][0-9]*(\.[1-9][0-9]*)?/\% {
        
        descuento = Float.parseFloat(yytext());
    }
    E[0-9][0-9]*(\.[0-9][0-9]*)? {
        
        if(descuento != 0){
            t.addCompra(unidad*(1-(descuento/100))*Float.parseFloat(yytext().substring(1)));
        } else {
            t.addCompra(unidad*Float.parseFloat(yytext().substring(1)));
        }
        t.addItems(unidad);
        yybegin(YYINITIAL);
    }
    [0-9][0-9]*(\.[0-9][0-9]*)? {
        
        if(descuento != 0){
             t.addCompra(unidad*(1-(descuento/100))*Float.parseFloat(yytext()));
        } else {
            t.addCompra(unidad*Float.parseFloat(yytext()));
        }
        t.addItems(unidad);
        yybegin(YYINITIAL);
    }
    [0-9][0-9]*(\.[0-9][0-9]*)?/E {
        if(descuento != 0){
             t.addCompra(unidad*(1-(descuento/100))*Float.parseFloat(yytext()));
        } else {
            t.addCompra(unidad*Float.parseFloat(yytext()));
        }
        t.addItems(unidad);
        yybegin(YYINITIAL);
    }
    
    [^] {}
}
