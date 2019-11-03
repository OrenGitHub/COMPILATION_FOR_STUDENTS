###########
# BASEDIR #
###########
BASEDIR = $(shell pwd)

###############
# DIRECTORIES #
###############
XMPLDIR = ${BASEDIR}/FOLDER_0_XMPLFILES
FIG_DIR = ${BASEDIR}/FOLDER_1_FIG_FILES
TEX_DIR = ${BASEDIR}/FOLDER_2_TEX_FILES
TMP_DIR = ${BASEDIR}/FOLDER_3_TMP_FILES

#########
# FILES #
#########
TEX_FILES = $(wildcard ${TEX_DIR}/*.tex)

##################
# PDFLATEX FLAGS #
##################
PDFLATEX_FLAGS =         \
-synctex                 \
-interaction=nonstopmode \
-aux-directory=${TMP_DIR}

#########
# PAPER #
#########
SLIDES = ${BASEDIR}/slides

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
# DEFAULT TARGET #	
##################
.DEFAULT_GOAL := ${SLIDES}.pdf

################
# ${PAPER}.pdf #	
################
${SLIDES}.pdf: ${SLIDES}.tex ${TEX_FILES}
	@echo "[ 1 ] $(notdir $^) -> $(notdir $@)"
	@pdflatex ${PDLATEX_FLAGS} $< 1>/dev/null
	@pdflatex ${PDLATEX_FLAGS} $< 1>/dev/null
	@echo "[ 2 ] rm -f $(notdir ${AUX_FILES})"
	@rm -f ${AUX_FILES}

#########
# clean #	
#########
clean:
	@echo "rm -f $(notdir ${SLIDES}.pdf)"
	@rm -r ${SLIDES}.pdf

