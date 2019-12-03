#include "ParsingContext.h"
#include "parser.hh"

ParsingContext::ParsingContext ()
  : trace_parsing (false), trace_scanning (false)
{
}

int ParsingContext::parse(const std::string &f)
{
  input_filename = f;
  location.initialize (&input_filename);
  scan_begin ();
  aa::parser parse(*this);
  parse.set_debug_level (trace_parsing);
  int res = parse ();
  scan_end ();
  return res;
}
