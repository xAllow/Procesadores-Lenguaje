import java_cup.runtime.*;
%%

%cup

%%

"("                          {return new Symbol(sym.AP, yytext());}
")"                          {return new Symbol(sym.CP, yytext());}
"{"                          {return new Symbol(sym.AC, yytext());}
"}"                          {return new Symbol(sym.CC, yytext());}
";"                          {return new Symbol(sym.PYC, yytext());}
"="                          {return new Symbol(sym.IGUAL, yytext());}
"+"                          {return new Symbol(sym.MAS, yytext());}
"-"                          {return new Symbol(sym.MENOS, yytext());}
"*"                          {return new Symbol(sym.POR, yytext());}
"/"                          {return new Symbol(sym.DIV, yytext());}
0 | [1-9][0-9]*             {return new Symbol(sym.NUM, yytext());}
"return"                        {return new Symbol(sym.RETURN, yytext());}
[a-zA-Z][a-zA-Z0-9]*          {return new Symbol(sym.IDENT,yytext());}