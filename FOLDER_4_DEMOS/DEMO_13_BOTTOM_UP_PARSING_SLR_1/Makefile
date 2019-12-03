# This Makefile is designed to be simple and readable.  It does not
# aim at portability.  It requires GNU Make.

BASE = calc++
BISON = bison
CXX = g++
FLEX = flex
XSLTPROC = xsltproc

all: $(BASE)

%.cc %.hh %.xml %.gv: %.yy
	$(BISON) $(BISONFLAGS) --xml --graph=$*.gv -o $*.cc $<

%.cpp: %.lex
	$(FLEX) $(FLEXFLAGS) -o$@ $<

%.o: %.cc
	$(CXX) $(CXXFLAGS) -c -o$@ $<

$(BASE): $(BASE).o driver.o parser.o MatReader.o
	$(CXX) -o $@ $^

$(BASE).o: parser.hh
parser.o: parser.hh
MatReader.o: parser.hh

run: $(BASE)
	@echo "Type arithmetic expressions.  Quit with ctrl-d."
	./$< -

html: parser.html
%.html: %.xml
	$(XSLTPROC) $(XSLTPROCFLAGS) -o $@ $$($(BISON) --print-datadir)/xslt/xml2xhtml.xsl $<

CLEANFILES =										\
  $(BASE) *.o										\
  parser.hh parser.cc parser.output parser.xml parser.html parser.gv location.hh	\
  MatReader.cpp
clean:
	rm -f $(CLEANFILES)
