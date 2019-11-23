
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

import java_cup.runtime.*;
import AST.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return TokenNames.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\033\000\002\002\004\000\002\006\004\000\002\006" +
    "\003\000\002\002\003\000\002\002\003\000\002\003\005" +
    "\000\002\003\007\000\002\004\011\000\002\015\004\000" +
    "\002\015\003\000\002\014\003\000\002\014\004\000\002" +
    "\014\006\000\002\014\011\000\002\014\011\000\002\007" +
    "\003\000\002\007\003\000\002\007\003\000\002\007\003" +
    "\000\002\010\003\000\002\010\006\000\002\012\005\000" +
    "\002\012\005\000\002\012\005\000\002\012\005\000\002" +
    "\011\006\000\002\013\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\077\000\004\030\005\001\002\000\004\002\101\001" +
    "\002\000\004\030\012\001\002\000\006\002\ufffd\030\ufffd" +
    "\001\002\000\006\002\ufffe\030\ufffe\001\002\000\006\002" +
    "\uffff\030\005\001\002\000\004\002\000\001\002\000\010" +
    "\020\014\026\015\027\013\001\002\000\014\002\ufffc\004" +
    "\ufffc\015\ufffc\025\ufffc\030\ufffc\001\002\000\004\021\044" +
    "\001\002\000\006\030\016\031\023\001\002\000\024\005" +
    "\uffee\006\uffee\010\uffee\012\uffee\020\040\021\uffee\022\uffee" +
    "\023\uffee\027\uffee\001\002\000\020\005\uffef\006\uffef\010" +
    "\uffef\012\uffef\021\uffef\023\uffef\027\uffef\001\002\000\020" +
    "\005\ufff0\006\ufff0\010\ufff0\012\ufff0\021\ufff0\023\ufff0\027" +
    "\ufff0\001\002\000\022\005\ufff1\006\ufff1\010\ufff1\012\ufff1" +
    "\021\ufff1\022\035\023\ufff1\027\ufff1\001\002\000\014\005" +
    "\025\006\024\010\027\012\030\027\026\001\002\000\020" +
    "\005\ufff2\006\ufff2\010\ufff2\012\ufff2\021\ufff2\023\ufff2\027" +
    "\ufff2\001\002\000\006\030\016\031\023\001\002\000\006" +
    "\030\016\031\023\001\002\000\014\002\ufffb\004\ufffb\015" +
    "\ufffb\025\ufffb\030\ufffb\001\002\000\006\030\016\031\023" +
    "\001\002\000\006\030\016\031\023\001\002\000\020\005" +
    "\uffeb\006\uffeb\010\uffeb\012\uffeb\021\uffeb\023\uffeb\027\uffeb" +
    "\001\002\000\020\005\uffec\006\uffec\010\uffec\012\030\021" +
    "\uffec\023\uffec\027\uffec\001\002\000\020\005\uffe9\006\uffe9" +
    "\010\027\012\030\021\uffe9\023\uffe9\027\uffe9\001\002\000" +
    "\020\005\025\006\uffea\010\027\012\030\021\uffea\023\uffea" +
    "\027\uffea\001\002\000\006\030\016\031\023\001\002\000" +
    "\014\005\025\006\024\010\027\012\030\023\037\001\002" +
    "\000\024\005\uffed\006\uffed\010\uffed\012\uffed\021\uffed\022" +
    "\uffed\023\uffed\026\uffed\027\uffed\001\002\000\006\030\016" +
    "\031\023\001\002\000\014\005\025\006\024\010\027\012" +
    "\030\021\uffe7\001\002\000\004\021\043\001\002\000\020" +
    "\005\uffe8\006\uffe8\010\uffe8\012\uffe8\021\uffe8\023\uffe8\027" +
    "\uffe8\001\002\000\004\024\045\001\002\000\010\004\055" +
    "\015\052\030\046\001\002\000\012\020\040\022\uffee\026" +
    "\uffee\030\100\001\002\000\012\004\055\015\052\025\ufff8" +
    "\030\046\001\002\000\004\025\076\001\002\000\004\027" +
    "\075\001\002\000\004\020\067\001\002\000\006\022\035" +
    "\026\064\001\002\000\012\004\ufff7\015\ufff7\025\ufff7\030" +
    "\ufff7\001\002\000\004\020\056\001\002\000\006\030\016" +
    "\031\023\001\002\000\014\005\025\006\024\010\027\012" +
    "\030\021\060\001\002\000\004\024\061\001\002\000\010" +
    "\004\055\015\052\030\046\001\002\000\004\025\063\001" +
    "\002\000\012\004\ufff4\015\ufff4\025\ufff4\030\ufff4\001\002" +
    "\000\006\030\016\031\023\001\002\000\014\005\025\006" +
    "\024\010\027\012\030\027\066\001\002\000\012\004\ufff5" +
    "\015\ufff5\025\ufff5\030\ufff5\001\002\000\006\030\016\031" +
    "\023\001\002\000\014\005\025\006\024\010\027\012\030" +
    "\021\071\001\002\000\004\024\072\001\002\000\010\004" +
    "\055\015\052\030\046\001\002\000\004\025\074\001\002" +
    "\000\012\004\ufff3\015\ufff3\025\ufff3\030\ufff3\001\002\000" +
    "\012\004\ufff6\015\ufff6\025\ufff6\030\ufff6\001\002\000\006" +
    "\002\ufffa\030\ufffa\001\002\000\004\025\ufff9\001\002\000" +
    "\006\026\015\027\013\001\002\000\004\002\001\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\077\000\012\002\007\003\006\004\005\006\003\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\012\002\007\003\006\004\005\006" +
    "\010\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\012\007\021\010\020\011" +
    "\017\012\016\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\012\007\033\010\020\011\017\012\016" +
    "\001\001\000\012\007\032\010\020\011\017\012\016\001" +
    "\001\000\002\001\001\000\012\007\031\010\020\011\017" +
    "\012\016\001\001\000\012\007\030\010\020\011\017\012" +
    "\016\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\012\007\035\010\020\011" +
    "\017\012\016\001\001\000\002\001\001\000\002\001\001" +
    "\000\014\007\040\010\020\011\017\012\016\013\041\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\014\003\053\010\052\011\050\014" +
    "\046\015\047\001\001\000\002\001\001\000\014\003\053" +
    "\010\052\011\050\014\046\015\076\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\012\007\056\010" +
    "\020\011\017\012\016\001\001\000\002\001\001\000\002" +
    "\001\001\000\014\003\053\010\052\011\050\014\046\015" +
    "\061\001\001\000\002\001\001\000\002\001\001\000\012" +
    "\007\064\010\020\011\017\012\016\001\001\000\002\001" +
    "\001\000\002\001\001\000\012\007\067\010\020\011\017" +
    "\012\016\001\001\000\002\001\001\000\002\001\001\000" +
    "\014\003\053\010\052\011\050\014\046\015\072\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
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
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {

	Symbol s;
	s = lexer.next_token();
	System.out.print(s.sym);
	if (s.value != null)
	{
		System.out.print("(");
		System.out.print(s.value);
		System.out.print(")");
	}
	System.out.print("\n");
	return s; 

    }


	public Lexer lexer;

	public Parser(Lexer lexer)
	{
		super(lexer);
		this.lexer = lexer;
	}
	public void report_error(String message, Object info)
	{
		System.out.print("ERROR >> ");		
		System.out.print("[");
		System.out.print(lexer.getLine());
		System.out.print(":");
		System.out.print(lexer.getCharPos());
		System.out.print("] ");		
		System.exit(0);
	}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= decList EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		AST_DEC_LIST start_val = (AST_DEC_LIST)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // decList ::= dec decList 
            {
              AST_DEC_LIST RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		AST_DEC d = (AST_DEC)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AST_DEC_LIST l = (AST_DEC_LIST)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AST_DEC_LIST(d,l);    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("decList",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // decList ::= dec 
            {
              AST_DEC_LIST RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AST_DEC d = (AST_DEC)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AST_DEC_LIST(d,null); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("decList",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // dec ::= varDec 
            {
              AST_DEC RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AST_DEC_VAR d = (AST_DEC_VAR)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = d; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("dec",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // dec ::= funcDec 
            {
              AST_DEC RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AST_DEC_FUNC d = (AST_DEC_FUNC)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = d; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("dec",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // varDec ::= ID ID SEMICOLON 
            {
              AST_DEC_VAR RESULT =null;
		int typeleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int typeright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String type = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int varleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String var = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new AST_DEC_VAR(type,var,null); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("varDec",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // varDec ::= ID ID ASSIGN exp SEMICOLON 
            {
              AST_DEC_VAR RESULT =null;
		int typeleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).left;
		int typeright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).right;
		String type = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-4)).value;
		int varleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int varright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String var = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		AST_EXP e = (AST_EXP)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new AST_DEC_VAR(type,var,e);    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("varDec",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // funcDec ::= ID ID LPAREN RPAREN LBRACE stmtList RBRACE 
            {
              AST_DEC_FUNC RESULT =null;
		int retleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)).left;
		int retright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)).right;
		String ret = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-6)).value;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-5)).value;
		int bodyleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int bodyright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		AST_STMT_LIST body = (AST_STMT_LIST)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new AST_DEC_FUNC(ret,name,null,body); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("funcDec",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // stmtList ::= stmt stmtList 
            {
              AST_STMT_LIST RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		AST_STMT s = (AST_STMT)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int lleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AST_STMT_LIST l = (AST_STMT_LIST)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AST_STMT_LIST(s,l);    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmtList",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // stmtList ::= stmt 
            {
              AST_STMT_LIST RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AST_STMT s = (AST_STMT)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AST_STMT_LIST(s,null); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmtList",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // stmt ::= varDec 
            {
              AST_STMT RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AST_DEC_VAR v = (AST_DEC_VAR)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AST_STMT_DEC_VAR(v);       
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // stmt ::= callExp SEMICOLON 
            {
              AST_STMT RESULT =null;
		int callExpleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int callExpright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		AST_EXP_CALL callExp = (AST_EXP_CALL)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new AST_STMT_CALL(callExp);    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // stmt ::= varExp ASSIGN exp SEMICOLON 
            {
              AST_STMT RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		AST_EXP_VAR v = (AST_EXP_VAR)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		AST_EXP e = (AST_EXP)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new AST_STMT_ASSIGN(v,e);      
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // stmt ::= IF LPAREN exp RPAREN LBRACE stmtList RBRACE 
            {
              AST_STMT RESULT =null;
		int condleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).left;
		int condright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).right;
		AST_EXP cond = (AST_EXP)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-4)).value;
		int bodyleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int bodyright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		AST_STMT_LIST body = (AST_STMT_LIST)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new AST_STMT_IF(cond,body);    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // stmt ::= WHILE LPAREN exp RPAREN LBRACE stmtList RBRACE 
            {
              AST_STMT RESULT =null;
		int condleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).left;
		int condright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).right;
		AST_EXP cond = (AST_EXP)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-4)).value;
		int bodyleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int bodyright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		AST_STMT_LIST body = (AST_STMT_LIST)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new AST_STMT_WHILE(cond,body); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // exp ::= INT 
            {
              AST_EXP RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Integer i = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AST_EXP_INT(i); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("exp",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // exp ::= varExp 
            {
              AST_EXP RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int vright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AST_EXP_VAR v = (AST_EXP_VAR)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = v;                  
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("exp",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // exp ::= callExp 
            {
              AST_EXP RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AST_EXP_CALL e = (AST_EXP_CALL)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = e;                  
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("exp",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // exp ::= binopExp 
            {
              AST_EXP RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AST_EXP_BINOP e = (AST_EXP_BINOP)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = e;                  
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("exp",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // varExp ::= ID 
            {
              AST_EXP_VAR RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AST_EXP_VAR_SIMPLE(name);   
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("varExp",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // varExp ::= varExp LBRACK exp RBRACK 
            {
              AST_EXP_VAR RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		AST_EXP_VAR v = (AST_EXP_VAR)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		AST_EXP e = (AST_EXP)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new AST_EXP_VAR_SUBSCRIPT(v,e); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("varExp",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // binopExp ::= exp PLUS exp 
            {
              AST_EXP_BINOP RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		AST_EXP e1 = (AST_EXP)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AST_EXP e2 = (AST_EXP)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AST_EXP_BINOP(e1,e2,0); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("binopExp",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // binopExp ::= exp TIMES exp 
            {
              AST_EXP_BINOP RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		AST_EXP e1 = (AST_EXP)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AST_EXP e2 = (AST_EXP)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AST_EXP_BINOP(e1,e2,2); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("binopExp",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // binopExp ::= exp EQ exp 
            {
              AST_EXP_BINOP RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		AST_EXP e1 = (AST_EXP)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AST_EXP e2 = (AST_EXP)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AST_EXP_BINOP(e1,e2,3); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("binopExp",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // binopExp ::= exp LT exp 
            {
              AST_EXP_BINOP RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		AST_EXP e1 = (AST_EXP)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AST_EXP e2 = (AST_EXP)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AST_EXP_BINOP(e1,e2,4); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("binopExp",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // callExp ::= ID LPAREN expListComma RPAREN 
            {
              AST_EXP_CALL RESULT =null;
		int funcNameleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int funcNameright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String funcName = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int elleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int elright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		AST_EXP_LIST el = (AST_EXP_LIST)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new AST_EXP_CALL(funcName,el); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("callExp",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // expListComma ::= exp 
            {
              AST_EXP_LIST RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		AST_EXP e = (AST_EXP)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new AST_EXP_LIST(e,null); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expListComma",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}