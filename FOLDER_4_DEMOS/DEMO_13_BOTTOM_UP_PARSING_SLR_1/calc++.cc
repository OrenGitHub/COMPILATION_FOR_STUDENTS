#include <iostream>
#include "ParsingContext.h"

int main (int argc, char *argv[])
{
	int res = 0;
	ParsingContext ctx;
	ctx.parse(argv[1]);
	std::cout << ctx.result << '\n';
	return 0;
}
