import java_cup.runtime.*;
%%

%cup

%%


\(                          {return new Symbol(sym.AP);}
\)                          {return new Symbol(sym.CP);}
\{                          {return new Symbol(sym.AC);}
\}                          {return new Symbol(sym.CC);}
\=                          {return new Symbol(sym.EQLN);}
\,                          {return new Symbol(sym.COMA);}
\=\=                        {return new Symbol(sym.IGUAL);}
\!                          {return new Symbol(sym.EX);}
\&\&                          {return new Symbol(sym.AND);}
\+                          {return new Symbol(sym.MAS);}
\-                          {return new Symbol(sym.MENOS);}
\*                          {return new Symbol(sym.POR);}
\|\|                          {return new Symbol(sym.O);}
\;                          {return new Symbol(sym.PYC);}
\!\=                        {return new Symbol(sym.DIFERENTE);}
\/                          {return new Symbol(sym.DIV);}
\<                          {return new Symbol(sym.MENOR);}
\>                          {return new Symbol(sym.MAYOR);}
0|[1-9][0-9]*               {return new Symbol(sym.ENTERO, new Integer(yytext()));}

"if"                          {return new Symbol(sym.IF, yytext());}
"else"                        {return new Symbol(sym.ELSE, yytext());}
"while"                       {return new Symbol(sym.WHILE, yytext());}
"do"                          {return new Symbol(sym.DO, yytext());}
"for"                         {return new Symbol(sym.FOR, yytext());}
"print"                       {return new Symbol(sym.PRINT, yytext());}
	[a-zA-Z][a-zA-Z0-9]*          {return new Symbol(sym.IDENT,yytext());}
[^]                           {}

