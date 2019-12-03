%{

/*************************/
/* GENERAL INCLUDE FILES */
/*************************/
#include <cerrno>
#include <climits>
#include <cstdlib>
#include <cstring>
#include <string>

/*************************/
/* PROJECT INCLUDE FILES */
/*************************/
#include "ParsingContext.h"
#include "parser.hh"

%}

/**********************************************/
/* ALWAYS BE PREPARED FOR THE FACT THIS MIGHT */
/* NOT BE THE ONLY LEXER IN YOUR PROGRAM      */
/**********************************************/
%option prefix="aa"

/**********************************************/
/* ALWAYS BE PREPARED FOR THE FACT THIS MIGHT */
/* NOT BE THE ONLY LEXER IN YOUR PROGRAM      */
/**********************************************/
%option noyywrap nounput noinput batch debug

id    [a-zA-Z][a-zA-Z_0-9]*
INT   [0-9]+
blank [ \t\r]

%{
  // Code run each time a pattern is matched.
  # define YY_USER_ACTION  loc.columns (yyleng);
%}
%%
%{
  // A handy shortcut to the location held by the driver.
  aa::location& loc = ctx.location;
  // Code run each time aalex is called.
  loc.step ();
%}
{blank}+   loc.step ();
\n+        loc.lines (yyleng); loc.step ();

"+"        return aa::parser::make_PLUS   (loc);
"-"        return aa::parser::make_MINUS  (loc);
"*"        return aa::parser::make_TIMES  (loc);
"/"        return aa::parser::make_DIVIDE (loc);
"("        return aa::parser::make_LPAREN (loc);
")"        return aa::parser::make_RPAREN (loc);
{INT}      return aa::parser::make_INT (atoi(aatext), loc);
.          {
             throw aa::parser::syntax_error
               (loc, "invalid character: " + std::string(yytext));
}
<<EOF>>    return aa::parser::make_EOF (loc);
%%

void ParsingContext::scan_begin ()
{
  aa_flex_debug = trace_scanning;
  if (input_filename.empty () || input_filename == "-")
    aain = stdin;
  else if (!(aain = fopen (input_filename.c_str (), "r")))
    {
      std::cerr << "cannot open " << input_filename << ": " << strerror(errno) << '\n';
      exit (EXIT_FAILURE);
    }
}

void ParsingContext::scan_end ()
{
  fclose (aain);
}
