%%

%state ANALIZAR
%{
    int cant = 1;
    double des = 0;
%}
numero = [0-9][0-9]*
porcentaje = {numero}\.[0-9][0-9]*|{numero}
%%

<YYINITIAL>{
    \-/[\ ]*[a-zA-Z][\ ]*                        {
                                                cant = 1;
                                                des = 0;
                                            yybegin(ANALIZAR);}
[\ ]+\-/[\ ]*[a-zA-Z][\ ]*                  {}
    [^]                         {}
}

<ANALIZAR>{
    {porcentaje}\%              {
                                des =Double.parseDouble(yytext().substring(0,((yytext().length())-1)));
                                des = des/100;
                                }

    \s                         {}
    [a-zA-Z][a-zA-Z]*          {}
    E{porcentaje}                  {Ticket.totalCompra += cant*(Double.parseDouble(yytext().substring(1,yytext().length())))*(1-des);
                                Ticket.numItems += cant;
                                Ticket.numItemsDistintos++;
                                yybegin(YYINITIAL);}


    {porcentaje}|{porcentaje}/E {
                                Ticket.totalCompra += cant*(Double.parseDouble(yytext()))*(1-des);
                                Ticket.numItems += cant;
                                Ticket.numItemsDistintos++;
                                yybegin(YYINITIAL);
                                }
    {porcentaje}                 {
                                Ticket.totalCompra += cant*(Double.parseDouble(yytext()))*(1-des);
                                Ticket.numItems += cant;
                                Ticket.numItemsDistintos++;
                                yybegin(YYINITIAL);
                                }

    {numero}/uds            {
                            cant = Integer.parseInt(yytext());}
    [^]                         {System.out.println(yytext());}
}
