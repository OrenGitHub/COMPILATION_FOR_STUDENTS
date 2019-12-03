/*****************/
/* SKELETON FILE */
/*****************/
%skeleton "lalr1.cc"

/*****************/
/* BISON VERSION */
/*****************/
%require "3.4"

/************************/
/* GENERATE HEADER FILE */
/************************/
%defines

/**************************/
/* PREFIX (instead of yy) */
/**************************/
%define api.prefix {aa}

/******************************************************/
/* PROVIDE TOKEN CONSTRUCTORS TO BE USED BY THE LEXER */
/******************************************************/
%define api.token.constructor

/****************************************************/
/* TOKENS and VARIABLES with a certified (C++) type */
/****************************************************/
%define api.value.type variant

/*******************/
/* PARSING CONTEXT */
/*******************/
%define parse.assert

/*******************/
/* PARSING CONTEXT */
/*******************/
%code requires
{
    #include <string>
    class ParsingContext;
}

/***********************/
/* THE PARSING CONTEXT */
/***********************/
%param { ParsingContext& ctx }

/*************/
/* LOCATIONS */
/*************/
%locations

/**************************************/
/* FOR DEBUG AND EDUCATIONAL PURPOSES */
/**************************************/
%define parse.trace
%define parse.error verbose

/***************************/
/* INCLUDE PARSING CONTEXT */
/***************************/
%code
{
    #include "ParsingContext.h"
}

%define api.token.prefix {TOK_}
%token EOF 0  "EOF"
%token PLUS    "+"
%token MINUS   "-"
%token TIMES   "*"
%token DIVIDE  "/"
%token LPAREN  "("
%token RPAREN  ")"

%token <int> INT "INT"
%type  <int> E
%type  <int> T
%type  <int> F

%printer { yyo << $$; } <*>;

%%
%start E;

%left "+" "-";
%left "*" "/";

E:
E "+" T   { $$ = $1 + $3; } |
E "-" T   { $$ = $1 - $3; } |
T         { $$ = $1;      }

T:
T '*' F     { $$ = $1 * $3; } |
T '/' F     { $$ = $1 / $3; } |
F           { $$ = $1;      }

F:
"INT"       { $$ = $1;    } |
"(" E ")"   { $$ = $2;    }

%%

void
aa::parser::error (const location_type& l, const std::string& m)
{
  std::cerr << l << ": " << m << '\n';
}

