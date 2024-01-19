
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615
//----------------------------------------------------

import java_cup.runtime.*;
import java.util.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\027\000\002\003\004\000\002\002\004\000\002\003" +
    "\003\000\002\002\004\000\002\002\004\000\002\004\005" +
    "\000\002\010\006\000\002\010\006\000\002\010\006\000" +
    "\002\010\006\000\002\010\005\000\002\010\005\000\002" +
    "\010\003\000\002\010\005\000\002\010\003\000\002\007" +
    "\005\000\002\007\005\000\002\005\005\000\002\005\007" +
    "\000\002\005\005\000\002\005\003\000\002\011\005\000" +
    "\002\011\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\070\000\022\004\020\006\011\012\010\021\015\022" +
    "\006\023\004\024\007\025\005\001\002\000\004\004\070" +
    "\001\002\000\012\011\ufff5\014\066\015\ufff5\017\ufff5\001" +
    "\002\000\004\004\063\001\002\000\004\004\060\001\002" +
    "\000\006\012\040\026\037\001\002\000\006\012\040\026" +
    "\037\001\002\000\024\002\035\004\020\006\011\012\010" +
    "\021\015\022\006\023\004\024\007\025\005\001\002\000" +
    "\004\011\034\001\002\000\012\005\ufff3\011\ufff3\015\ufff3" +
    "\017\ufff3\001\002\000\004\004\031\001\002\000\010\011" +
    "\030\015\023\017\024\001\002\000\024\002\uffff\004\uffff" +
    "\006\uffff\012\uffff\021\uffff\022\uffff\023\uffff\024\uffff\025" +
    "\uffff\001\002\000\022\004\020\006\011\012\010\021\015" +
    "\022\006\023\004\024\007\025\021\001\002\000\012\005" +
    "\ufff5\011\ufff5\015\ufff5\017\ufff5\001\002\000\010\005\025" +
    "\015\023\017\024\001\002\000\022\004\020\006\011\012" +
    "\010\021\015\022\006\023\004\024\007\025\021\001\002" +
    "\000\022\004\020\006\011\012\010\021\015\022\006\023" +
    "\004\024\007\025\021\001\002\000\012\005\ufff4\011\ufff4" +
    "\015\ufff4\017\ufff4\001\002\000\012\005\ufff6\011\ufff6\015" +
    "\ufff6\017\ufff6\001\002\000\012\005\ufff7\011\ufff7\015\ufff7" +
    "\017\024\001\002\000\024\002\ufffe\004\ufffe\006\ufffe\012" +
    "\ufffe\021\ufffe\022\ufffe\023\ufffe\024\ufffe\025\ufffe\001\002" +
    "\000\022\004\020\006\011\012\010\021\015\022\006\023" +
    "\004\024\007\025\021\001\002\000\010\005\033\015\023" +
    "\017\024\001\002\000\012\005\ufffb\011\ufffb\015\ufffb\017" +
    "\ufffb\001\002\000\024\002\ufffd\004\ufffd\006\ufffd\012\ufffd" +
    "\021\ufffd\022\ufffd\023\ufffd\024\ufffd\025\ufffd\001\002\000" +
    "\004\002\000\001\002\000\024\002\001\004\001\006\001" +
    "\012\001\021\001\022\001\023\001\024\001\025\001\001" +
    "\002\000\012\007\uffeb\010\uffeb\011\uffeb\013\uffeb\001\002" +
    "\000\004\026\037\001\002\000\012\007\uffed\010\047\011" +
    "\uffed\013\uffed\001\002\000\010\007\044\010\043\011\045" +
    "\001\002\000\004\012\051\001\002\000\012\005\ufff2\011" +
    "\ufff2\015\ufff2\017\ufff2\001\002\000\004\026\037\001\002" +
    "\000\012\007\ufff0\010\047\011\ufff0\013\ufff0\001\002\000" +
    "\004\026\050\001\002\000\012\007\uffec\010\uffec\011\uffec" +
    "\013\uffec\001\002\000\006\012\040\026\037\001\002\000" +
    "\010\010\043\011\045\013\053\001\002\000\012\007\uffef" +
    "\010\uffef\011\uffef\013\uffef\001\002\000\006\010\047\013" +
    "\055\001\002\000\012\007\uffee\010\uffee\011\uffee\013\uffee" +
    "\001\002\000\010\010\043\011\045\013\057\001\002\000" +
    "\012\005\ufff1\011\ufff1\015\ufff1\017\ufff1\001\002\000\022" +
    "\004\020\006\011\012\010\021\015\022\006\023\004\024" +
    "\007\025\021\001\002\000\010\005\062\015\023\017\024" +
    "\001\002\000\012\005\ufff8\011\ufff8\015\ufff8\017\ufff8\001" +
    "\002\000\022\004\020\006\011\012\010\021\015\022\006" +
    "\023\004\024\007\025\021\001\002\000\010\005\065\015" +
    "\023\017\024\001\002\000\012\005\ufff9\011\ufff9\015\ufff9" +
    "\017\ufff9\001\002\000\022\004\020\006\011\012\010\021" +
    "\015\022\006\023\004\024\007\025\021\001\002\000\010" +
    "\011\ufffc\015\023\017\024\001\002\000\022\004\020\006" +
    "\011\012\010\021\015\022\006\023\004\024\007\025\021" +
    "\001\002\000\010\005\072\015\023\017\024\001\002\000" +
    "\012\005\ufffa\011\ufffa\015\ufffa\017\ufffa\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\070\000\014\002\016\003\011\004\012\007\013\010" +
    "\015\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\006\005\055\011\040\001" +
    "\001\000\006\005\041\011\040\001\001\000\012\002\035" +
    "\004\012\007\013\010\015\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\006\007\013\010\021\001\001\000\002\001" +
    "\001\000\002\001\001\000\006\007\013\010\026\001\001" +
    "\000\006\007\013\010\025\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\007\013\010\031\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\011\053\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\011\045\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\006\005\051\011\040\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\007\013\010\060\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\007\013\010\063\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\007\013\010\066\001\001\000" +
    "\002\001\001\000\006\007\013\010\070\001\001\000\002" +
    "\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {


    double[][] matriz; 
    ArrayList<ArrayList<Double>> filas = new ArrayList();
    ArrayList<Double> fila = new ArrayList();
    boolean ok = false;

    public boolean comprobarMatriz(ArrayList<ArrayList<Double>> matriz){
        ok = true;
        if(matriz == null | matriz.isEmpty()){
            throw new IllegalArgumentException("La matriz no puede estar vacía.");
        }
        int longitudPrimeraFila = matriz.get(0).size();

        for (int i = 1; i < matriz.size(); i++) {

            if (matriz.get(i).size() != longitudPrimeraFila) {
                // Las filas no tienen la misma longitud
                error(1);
                ok = false;
            }
        }
        return ok;
    }
    public boolean esCuadrada(double[][] matriz){
        
        return Matrices.filas(matriz)==Matrices.columnas(matriz);
    }

    public boolean comprobarMulti(double[][] matriz1,double[][]  matriz2){
        return (Matrices.columnas(matriz1)==Matrices.filas(matriz2));
    }

    public boolean comprobarSuma(double[][] matriz1,double[][]  matriz2) {
        return Matrices.filas(matriz1) == Matrices.filas(matriz2) && Matrices.columnas(matriz1) == Matrices.columnas(matriz2);
    }
    public void error(int id) {
        switch (id) {
            case 1 :
                System.err.print(Matrices.ERROR_FILAS);
                System.exit(1);
            
            case 2 :
                System.err.print(Matrices.ERROR_INVERSA);
                System.exit(1);

            case 3 :
                System.err.print(Matrices.ERROR_ADJUNTA);
                System.exit(1);
                
            case 4 :
                System.err.print(Matrices.ERROR_PROD);
                System.exit(1);
                
            case 5 :
                System.err.print(Matrices.ERROR_SUMA);
                System.exit(1);
            
            case 6 :
                System.err.print(TablaSimbolos.ERROR_NOEXISTE);
                System.exit(1);
            
            default:
                System.err.print("Error desconocido");
                System.exit(1);
        }
        
        ok = true;
    }

  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // lineas ::= lineas linea 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("lineas",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= lineas EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // lineas ::= linea 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("lineas",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // linea ::= funciones PYC 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("linea",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // linea ::= asignaciones PYC 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("linea",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // asignaciones ::= IDENT ASIG funciones 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int mleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int mright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ArrayList<ArrayList<Double>> m = (ArrayList<ArrayList<Double>>)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		TablaSimbolos.insertar(a, Matrices.toArray(m));
              CUP$parser$result = parser.getSymbolFactory().newSymbol("asignaciones",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // funciones ::= PRINT AP funciones CP 
            {
              ArrayList<ArrayList<Double>> RESULT =null;
		int mleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int mright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ArrayList<ArrayList<Double>> m = (ArrayList<ArrayList<Double>>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		Matrices.print(m);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("funciones",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // funciones ::= TRANSPUESTA AP funciones CP 
            {
              ArrayList<ArrayList<Double>> RESULT =null;
		int mleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int mright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ArrayList<ArrayList<Double>> m = (ArrayList<ArrayList<Double>>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = Matrices.toArrayList(Matrices.transpuesta(Matrices.toArray(m)));
              CUP$parser$result = parser.getSymbolFactory().newSymbol("funciones",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // funciones ::= INVERSA AP funciones CP 
            {
              ArrayList<ArrayList<Double>> RESULT =null;
		int mleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int mright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ArrayList<ArrayList<Double>> m = (ArrayList<ArrayList<Double>>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		if(esCuadrada(Matrices.toArray(m)))
                                                    RESULT = Matrices.toArrayList(Matrices.inversa(Matrices.toArray(m)));
                                                  else 
                                                    error(2);
                                                
              CUP$parser$result = parser.getSymbolFactory().newSymbol("funciones",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // funciones ::= ADJUNTA AP funciones CP 
            {
              ArrayList<ArrayList<Double>> RESULT =null;
		int mleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int mright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ArrayList<ArrayList<Double>> m = (ArrayList<ArrayList<Double>>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		if(esCuadrada(Matrices.toArray(m)))
                                                    RESULT = Matrices.toArrayList(Matrices.adjunta(Matrices.toArray(m)));
                                                  else 
                                                    error(3);
                                                
              CUP$parser$result = parser.getSymbolFactory().newSymbol("funciones",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // funciones ::= funciones MAS funciones 
            {
              ArrayList<ArrayList<Double>> RESULT =null;
		int m1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int m1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		ArrayList<ArrayList<Double>> m1 = (ArrayList<ArrayList<Double>>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int m2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int m2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ArrayList<ArrayList<Double>> m2 = (ArrayList<ArrayList<Double>>)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		if(comprobarSuma(Matrices.toArray(m1), Matrices.toArray(m2)))
                                                    RESULT = Matrices.toArrayList(Matrices.suma(Matrices.toArray(m1),Matrices.toArray(m2)));
                                                  else 
                                                    error(5);
                                                
              CUP$parser$result = parser.getSymbolFactory().newSymbol("funciones",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // funciones ::= funciones POR funciones 
            {
              ArrayList<ArrayList<Double>> RESULT =null;
		int m1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int m1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		ArrayList<ArrayList<Double>> m1 = (ArrayList<ArrayList<Double>>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int m2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int m2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ArrayList<ArrayList<Double>> m2 = (ArrayList<ArrayList<Double>>)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		if(comprobarMulti(Matrices.toArray(m1), Matrices.toArray(m2)))
                                                    RESULT = Matrices.toArrayList(Matrices.producto(Matrices.toArray(m1),Matrices.toArray(m2)));
                                                  else 
                                                    error(4);
                                                
              CUP$parser$result = parser.getSymbolFactory().newSymbol("funciones",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // funciones ::= IDENT 
            {
              ArrayList<ArrayList<Double>> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT = Matrices.toArrayList(TablaSimbolos.buscar(a));
              CUP$parser$result = parser.getSymbolFactory().newSymbol("funciones",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // funciones ::= AP funciones CP 
            {
              ArrayList<ArrayList<Double>> RESULT =null;
		int mleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int mright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ArrayList<ArrayList<Double>> m = (ArrayList<ArrayList<Double>>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = m;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("funciones",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // funciones ::= matriz 
            {
              ArrayList<ArrayList<Double>> RESULT =null;
		int mleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int mright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		ArrayList<ArrayList<Double>> m = (ArrayList<ArrayList<Double>>)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT=m;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("funciones",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // matriz ::= AC filas CC 
            {
              ArrayList<ArrayList<Double>> RESULT =null;
		if(comprobarMatriz(filas)){
                                                    RESULT = (ArrayList<ArrayList<Double>>)filas.clone(); 
                                                    filas.clear();
                                        }
                                    
              CUP$parser$result = parser.getSymbolFactory().newSymbol("matriz",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // matriz ::= ALL filas CLL 
            {
              ArrayList<ArrayList<Double>> RESULT =null;
		if(comprobarMatriz(filas)){
                                                    RESULT = (ArrayList<ArrayList<Double>>)filas.clone(); 
                                                    filas.clear();
                                        }
                                    
              CUP$parser$result = parser.getSymbolFactory().newSymbol("matriz",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // filas ::= filas PYC fila 
            {
              ArrayList<ArrayList<Double>> RESULT =null;
		filas.add((ArrayList<Double>)fila.clone()); fila.clear();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("filas",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // filas ::= filas COMA ALL filas CLL 
            {
              ArrayList<ArrayList<Double>> RESULT =null;
		filas.add((ArrayList<Double>)fila.clone()); fila.clear();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("filas",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // filas ::= ALL fila CLL 
            {
              ArrayList<ArrayList<Double>> RESULT =null;
		filas.add((ArrayList<Double>)fila.clone()); fila.clear();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("filas",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // filas ::= fila 
            {
              ArrayList<ArrayList<Double>> RESULT =null;
		filas.add((ArrayList<Double>)fila.clone()); fila.clear();
              CUP$parser$result = parser.getSymbolFactory().newSymbol("filas",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // fila ::= fila COMA NUMERO 
            {
              ArrayList<Double> RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Double n = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		fila.add(n);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("fila",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // fila ::= NUMERO 
            {
              ArrayList<Double> RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Double n = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		fila.add(n);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("fila",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
