import java_cup.runtime.*;

%%

%int
%cup

%%

// Palabras reservadas del lenguaje
"if"        { return new Symbol(sym.IF);    }
"else"      { return new Symbol(sym.ELSE);  }
"do"        { return new Symbol(sym.DO);    }
"while"     { return new Symbol(sym.WHILE); }
"for"       { return new Symbol(sym.FOR);   }
"print"     { return new Symbol(sym.PRINT); }


// Simbolos de aperturas y cierres
"("         { return new Symbol(sym.AP);    }
")"         { return new Symbol(sym.CP);    }
"["         { return new Symbol(sym.AC);    }
"]"         { return new Symbol(sym.CC);    }
"{"         { return new Symbol(sym.ALL);    }
"}"         { return new Symbol(sym.CLL);    }

// Operadores lógicos
"=="        { return new Symbol(sym.EQ);    }
"!="        { return new Symbol(sym.NE);    }
"<="        { return new Symbol(sym.LE);    }
"<"         { return new Symbol(sym.LT);    }
">="        { return new Symbol(sym.GE);    }
">"         { return new Symbol(sym.GT);    }
"&&"        { return new Symbol(sym.AND);   }
"||"        { return new Symbol(sym.OR);    }
"!"         { return new Symbol(sym.NO);    }

// Castings
"(int)"         { return new Symbol(sym.CASTINGINT);    }
"(float)"       { return new Symbol(sym.CASTINGFLOAT);  }
"(char)"        { return new Symbol(sym.CASTINGCHAR);   }

// Operadores matemáticos
"+"         { return new Symbol(sym.MAS);   }
"-"         { return new Symbol(sym.MENOS);   }
"*"         { return new Symbol(sym.POR);   }
"/"         { return new Symbol(sym.DIV);   }
"="         { return new Symbol(sym.IGUAL); }

// Fin de sentencia y otros
","         { return new Symbol(sym.COMA);  }
";"         { return new Symbol(sym.PYC);   }
".length"   { return new Symbol(sym.LENGTH);}

// Valores 
// mandamos directamente los numeros como String ya que realmente en la
// generacion de codigo intermedio no vamos a jugar con los valores numericos
// como tal

0|[1-9][0-9]*                                   { return new Symbol(sym.NUM, yytext());         }
[0-9]*\.[0-9]+([eE][-+]?[0-9]+)?				{ return new Symbol(sym.REAL,yytext());         }
[_a-zA-Z][_a-zA-Z0-9]*                          { return new Symbol(sym.IDENT, yytext());       }
'(\\([\"'\\bfnrt]|u[0-9A-Fa-f]{4})|[^\\'])'		{ return new Symbol(sym.CHARTEXT,yytext());     }
\"([a-zA-Z]|[\\\"]*|u[0-9A-Fa-f]{4})+\"		    { return new Symbol(sym.STRINGTEXT,yytext());   }

// Para todo lo demás
[^]         { }