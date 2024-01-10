import java_cup.runtime.*;
%%

/*  Declaraciones */   
   
%cup 
%line
%column
%{
       public int getLine(){
            return yyline;
       }                 
       public int getColumn(){
            return yycolumn;
       }
%}

%%   

/* Expresiones y reglas */
   
    "+"                { return new Symbol(sym.MAS); }
    "-"                { return new Symbol(sym.MENOS); }
    "*"                { return new Symbol(sym.POR); }
    "/"                { return new Symbol(sym.DIV); }
    "("                { return new Symbol(sym.AP); }
    ")"                { return new Symbol(sym.CP); }
    ";"                { return new Symbol(sym.PYC); }
    "="                { return new Symbol(sym.IGUAL); }
    [A-Za-Z_][A-Za-z0-9_]* { return new Symbol(sym.ID,new String(yytext())); }
    0|[1-9][0-9]*      { return new Symbol(sym.NUMERO, new Integer(yytext()) ); }
    \r|\n              { return new Symbol(sym.EOLN); }   
    \ |\t\f            {  }  
    [^]                { throw new Error("Illegal character <"+yytext()+">"); }
