###########
# BASEDIR #
###########
BASEDIR = $(shell pwd)

###############
# DIRECTORIES #
###############
TEX_DIR = ${BASEDIR}/FOLDER_0_TEX_FILES
FIG_DIR = ${BASEDIR}/FOLDER_1_FIG_FILES
CODEDIR = ${BASEDIR}/FOLDER_2_CODEFILES
IMG_DIR = ${BASEDIR}/FOLDER_3_IMG_FILES
DOT_DIR = ${BASEDIR}/FOLDER_4_DOT_FILES
FUZZDIR = ${BASEDIR}/FOLDER_5_FUZZFILES
SYMXDIR = ${BASEDIR}/FOLDER_6_SYMXFILES

#########
# FILES #
#########
TEX_FILES = $(wildcard ${TEX_DIR}/*.tex)
FIG_FILES = $(wildcard ${FIG_DIR}/*.tex)
CODEFILES = $(wildcard ${CODEDIR}/*.tex)
DOT_FILES = $(wildcard ${DOT_DIR}/*.dot)
IMG_FILES = $(addprefix ${IMG_DIR}/,$(notdir $(DOT_FILES:.dot=.png)))
FUZCFILES = $(wildcard ${FUZZDIR}/*.c)
FUZTFILES = $(FUZCFILES:.c=.txt)
SYMCFILES = $(wildcard ${SYMXDIR}/*.c)
SYMTFILES = $(SYMCFILES:.c=.csv)

#########
# FILES #
#########
AUX_FILES += ${SLIDES}.aux
AUX_FILES += ${SLIDES}.log
AUX_FILES += ${SLIDES}.nav
AUX_FILES += ${SLIDES}.out
AUX_FILES += ${SLIDES}.snm
AUX_FILES += ${SLIDES}.toc

##################
# PDFLATEX FLAGS #
##################
PDFLATEX_FLAGS =         \
-synctex                 \
-interaction=nonstopmode \
-aux-directory=${TMP_DIR}

##############
# KLEE FLAGS #
##############
KLEE_DIR = /home/oren/GIT/klee/vanilla.klee/klee/include/klee
KLEE_FLAGS =   \
-exit-on-error \
-posix-runtime \
--libc=uclibc

###############
# CLANG FLAGS #
###############
CLANG_FLAGS = \
-c            \
-O0           \
-I${KLEE_DIR} \
-emit-llvm    \

###############
# DEFINITIONS #
###############
TIMEOUT = 5

##########
# SLIDES #
##########
SLIDES = ${BASEDIR}/slides

##################
# DEFAULT TARGET #	
##################
.DEFAULT_GOAL := ${SLIDES}.pdf

#####################
# [5] ${SLIDES}.pdf #
#####################
${SLIDES}.pdf: \
${SLIDES}.tex  \
${TEX_FILES}   \
${FIG_FILES}   \
${CODEFILES}   \
${IMG_FILES}
	@echo "[ 5 ] *.tex -> $(notdir $@)"
	@pdflatex ${PDLATEX_FLAGS} $< #1>/dev/null
	@rm ${AUX_FILES}

######################
# [0] *.dot -> *.png #
######################
${IMG_DIR}/%.png: ${DOT_DIR}/%.dot
	@echo "[ 0 ] $(notdir $<) -> $(notdir $@)"
	dot -Tpng -o$@ $<

#####################
# [1] *.c -> *.fuzz #
#####################
${FUZZDIR}/%.txt: ${FUZZDIR}/%.c
	@echo "[ 1 ] compile $(notdir $<) w afl-gcc"
	@afl-gcc $< -o $(basename $<)
	@echo "[ 1 ] fuzz $(basename $(notdir $<))"
	@mkdir -p ${FUZZDIR}/INPUTS_$(basename $(notdir $<))
	@mkdir -p ${FUZZDIR}/OUTPUTS_$(basename $(notdir $<))
	@timeout ${TIMEOUT} afl-fuzz \
	-i ${FUZZDIR}/INPUTS_$(basename $(notdir $<))  \
	-o ${FUZZDIR}/OUTPUTS_$(basename $(notdir $<)) \
	$(basename $<) @@

###################
# [2] *.c -> *.bc #
###################
${SYMXDIR}/%.bc: ${SYMXDIR}/%.c
	@echo "[ 2 ] $(notdir $<) -> $(basename $(notdir $<)).bc"
	@clang ${CLANG_FLAGS} $< -o $@

.ONESHELL:
######################
# [3] *.bc -> *.klee #
######################
${SYMXDIR}/%.csv: ${SYMXDIR}/%.bc
	@echo "[ 3 ] $(basename $(notdir $<)).bc -> $(basename $(notdir $<)).txt"
	@START=$$(date +%s.%N)
	-timeout ${TIMEOUT} klee ${KLEE_FLAGS} $< 2> $(basename $@).log
	filename=$(basename $@).log
	example_name=$(basename $(notdir $<))
	x=$$(grep -c "Error: ASSERTION FAIL: 0" "$$filename")
	status="timeout"
	if [ "$$x" -ne "0" ];
	then
		status="found";
	fi;
	@END=$$(date +%s.%N)
	@TIME=$$(echo "$$END - $$START" | bc)
	@printf '%s, %s, %s\n' $$example_name $$status $$TIME > $@

############################
# [4] *.csv -> results.csv #
############################
${SYMXDIR}/results.csv: ${KLETFILES}
	@echo "[ 4 ] *.csv -> $(notdir $@)"
	@echo "SMP Name, Status, Time (seconds)" > $@
	@cat $^ >> $@

#########
# clean #	
#########
clean:
	@echo "rm -f $(notdir ${SLIDES}.pdf)"
	@rm -r ${SLIDES}.pdf

