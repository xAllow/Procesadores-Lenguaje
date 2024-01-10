%%
%int
%unicode

%state SUMA,RESTA,MULTI,DIVI,PAREN
%{
    int res = 0;
    int aux = 0;

%}
%%
<YYINITIAL>{
    0 | [1-9][0-9]*             {res = Integer.parseInt(yytext());}

    \+ {yybegin(SUMA);}

    \- {yybegin(RESTA);}

    \* {yybegin(MULTI);}

    \/ {yybegin(DIVI);}

    \; {
        System.out.println(res);
        aux = 0;
        res = 0;
    }

    \( {
        if(aux != 0){
            res *= aux;
        }
        aux = res;
        yybegin(PAREN);
    }

    \) {
        if(aux != 0){
            res *= aux;
            aux = 0;
        }
    }

    [^]                     {}
}


<PAREN>{
    0 | [1-9][0-9]*         {res = Integer.parseInt(yytext());}

    \+                  {yybegin(SUMA);}

    \-                  {yybegin(RESTA);}

    \*                  {yybegin(MULTI);}

    \/                  {yybegin(DIVI);}

    \( {
        if(aux != 0){
            aux *= res;
        } else {
            aux = res;
        }
    }

    \)  {
            res = aux*res;
            aux = 0;
            yybegin(YYINITIAL);
    }

    [^] {}
}


<SUMA>{
0 | [1-9][0-9]*             {res += Integer.parseInt(yytext());
                        yybegin(YYINITIAL);}
[^] {}

}
<RESTA>{
0 | [1-9][0-9]*             {res -= Integer.parseInt(yytext());
                        yybegin(YYINITIAL);}
[^] {}
}

<MULTI>{
0 | [1-9][0-9]*             {res = res *(Integer.parseInt(yytext()));
                        yybegin(YYINITIAL);}
[^] {}
}

<DIVI>{
0 | [1-9][0-9]*             {res = res/ (Integer.parseInt(yytext()));
                        yybegin(YYINITIAL);}
[^] {}
}