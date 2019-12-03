#ifndef MAT_READER_PARSING_CONTEXT
#define MAT_READER_PARSING_CONTEXT

/****************************************/
/* FILENAME: MatReader_ParsingContext.h */
/****************************************/

/*************************/
/* GENERAL INCLUDE FILES */
/*************************/
#include <map>
#include <string>

/*************************/
/* PROJECT INCLUDE FILES */
/*************************/
#include "parser.hh"

/********************************************************/
/* Conducting the whole lexing and parsing of MatReader */
/********************************************************/
class ParsingContext {
public:

	/*********************/
	/* Empty Constructor */
	/*********************/
	ParsingContext();

	/*******/
	/* AST */
	/*******/
	int result;

	/*****************************/
	/* parse (main API function) */
	/*****************************/
	int parse (const std::string& input_filename);

	/******************/
	/* input filename */
	/******************/
	std::string input_filename;
	
	// Whether to generate parser debug traces.
	bool trace_parsing;

	/******************************/
	/* Interfacing with the lexer */
	/******************************/
	void scan_begin();
	void scan_end();
	
	/****************************************************/
	/* Indicates whether to generate lexer debug traces */
	/****************************************************/
	bool trace_scanning;

	/***************************************************/
	/* Tokens locations used by the lexer --           */
	/* This location is updated during the lexing, and */
	/* mediated inside the symbol_type of each token   */
	/***************************************************/
	aa::location location;
};

/*****************************/
/* LEXING FUNCTION PROTOTYPE */
/*****************************/
#define YY_DECL aa::parser::symbol_type aalex(ParsingContext& ctx)

/*****************************************/
/* LEXING FUNCTION PROTOTYPE DECLARATION */
/*****************************************/
YY_DECL;

#endif
