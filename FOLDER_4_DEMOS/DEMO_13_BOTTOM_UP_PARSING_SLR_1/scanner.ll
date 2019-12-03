%{ /* -*- C++ -*- */
# include <cerrno>
# include <climits>
# include <cstdlib>
# include <cstring> // strerror
# include <string>
# include "ParsingContext.h"
# include "parser.hh"
%}

%option prefix="aa"

%option noyywrap nounput noinput batch debug

%{
  // A number symbol corresponding to the value in S.
  aa::parser::symbol_type
  make_INT (const std::string &s, const aa::parser::location_type& loc);
%}

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

"+"		return aa::parser::make_PLUS   (loc);
"-"		return aa::parser::make_MINUS  (loc);
"*"		return aa::parser::make_TIMES  (loc);
"/"		return aa::parser::make_DIVIDE (loc);
"("		return aa::parser::make_LPAREN (loc);
")"		return aa::parser::make_RPAREN (loc);
{INT}	return make_INT        (aatext, loc);
.		{
			throw aa::parser::syntax_error(
				loc,
				"INVALID TOKEN( "   +
				std::string(yytext) +
				" )\n");
		}
<<EOF>>	return aa::parser::make_EOF (loc);
%%

aa::parser::symbol_type
make_INT (const std::string &s, const aa::parser::location_type& loc)
{
  errno = 0;
  long n = strtol (s.c_str(), NULL, 10);
  if (! (INT_MIN <= n && n <= INT_MAX && errno != ERANGE))
    throw aa::parser::syntax_error (loc, "integer is out of range: " + s);
  return aa::parser::make_INT ((int) n, loc);
}

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

