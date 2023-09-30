%%

entero 	= [1-9][0-9]*
octal   = 0[0-7]* 
hex 	= 0x[0-9A-Fa-f]+
enteros = {entero} | {octal} | {hex}
exp_n 	= [0-9]+E[+-]?[0-9]+
exp_e 	= E[+-]?[0-9]+
exp	=   {exp_n} | {exp_e}  
err 	= [0-9A-Za-z\.+-]+

real 	= 	{ent}\.	|
		\.{ent}	|
		{ent}\.{ent}	|
		{exp}		|
		{ent}\.{exp}	|
		\.{exp_n}

%%
	
{ent | octal}[dD] | {real}[dD]?	{return new Yytoken(Yytoken.TOKEN_CTE_REAL_LARGO, yytext());}
({enteros})[fF]		{return new Yytoken(Yytoken.TOKEN_CTE_REAL_CORTO, yytext());}

{ent}|{hex} 			{return new Yytoken(Yytoken.TOKEN_CTE_ENTERO, yytext());}
({enteros})[lL]		{return new Yytoken(Yytoken.TOKEN_CTE_ENTERO_LARGO, yytext());}

[\ \n\t\\]			{}	

{err}|[^] 			{return new Yytoken(Yytoken.TOKEN_ERROR,yytext());}