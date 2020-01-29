###########
# BASEDIR #
###########
BASEDIR = $(shell pwd)

###############
# DIRECTORIES #
###############
TEX_DIR = ${BASEDIR}/FOLDER_0_TEX_FILES
FIG_DIR = ${BASEDIR}/FOLDER_1_FIG_FILES
COQ_DIR = ${BASEDIR}/FOLDER_2_COQ_FILES
IMG_DIR = ${BASEDIR}/FOLDER_3_IMG_FILES
DOT_DIR = ${BASEDIR}/FOLDER_4_DOT_FILES
FUZZDIR = ${BASEDIR}/FOLDER_5_FUZZFILES
SYMXDIR = ${BASEDIR}/FOLDER_6_SYMXFILES
HSKLDIR = ${BASEDIR}/FOLDER_7_HSKLFILES
DFNYDIR = ${BASEDIR}/FOLDER_8_DFNYFILES

#########
# FILES #
#########
TEX_FILES = $(wildcard ${TEX_DIR}/*.tex)
FIG_FILES = $(wildcard ${FIG_DIR}/*.tex)
COQ_FILES = $(wildcard ${COQ_DIR}/*.v)
HSKLFILES = $(addprefix ${HSKLDIR}/,$(notdir $(COQ_FILES:.v=.hs)))
DOT_FILES = $(wildcard ${DOT_DIR}/*.dot)
IMG_FILES = $(wildcard ${IMG_DIR}/*.png)
FUZCFILES = $(wildcard ${FUZZDIR}/*.c)
FUZTFILES = $(FUZCFILES:.c=.txt)
SYMCFILES = $(wildcard ${SYMXDIR}/*.c)
SYMTFILES = $(SYMCFILES:.c=.csv)
DFNYFILES = $(wildcard ${DFNYDIR}/*.dfy)

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
${HSKLFILES}   \
${IMG_FILES}
	@echo "[ 5 ] *.tex -> $(notdir $@)"
	@pdflatex ${PDLATEX_FLAGS} $< #1>/dev/null
	@rm ${AUX_FILES}

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

.ONESHELL:
###################
# [4] *.v -> *.hs #
###################
${HSKLDIR}/Code_01_div_q_r.hs: \
${COQ_DIR}/Code_01_div_q_r.v
	@echo "[ 5 ] $(notdir $<) -> $(notdir $@)"
	@coqc $< >/dev/null
	@resize -s 8 70
	@clear
	@setterm -term linux -fore blue
	@echo "\033[1m\$$ sed -n '87,92p;93q' $(notdir $<)\033[0m"
	@setterm -term linux -fore white
	@sed -n '87,92p;93q' $<
	@gnome-screenshot -w -f /tmp/figure.png
	@mv /tmp/figure.png ${IMG_DIR}/Code_01_div_q_r_coq.png
	@resize -s 6 70
	@clear
	@setterm -term linux -fore blue
	@echo "\033[1m\$$ sed -n '26,28p;29q' $(notdir $@)\033[0m"
	@setterm -term linux -fore white
	@sed -n '26,28p;29q' $@
	@gnome-screenshot -w -f /tmp/figure.png
	@mv /tmp/figure.png ${IMG_DIR}/Code_01_div_q_r_hs.png
	@resize -s 32 70
	@clear
	@setterm -term linux -fore blue
	@echo "\033[1m\$$ sed -n '87,116p;117q' $(notdir $<) | egrep --color 'exists|\$$'\033[0m"
	@setterm -term linux -fore white
	@sed -n '87,116p;117q' $< | egrep --color 'exists|$$'
	@gnome-screenshot -w -f /tmp/figure.png
	@mv /tmp/figure.png ${IMG_DIR}/Code_01_div_q_r_coq_whole.png
	@resize -s 20 70
	@clear
	@setterm -term linux -fore blue
	@echo "\033[1m\$$ sed -n '26,40p;41q' $(notdir $@) | egrep --color 'exists|\$$'\033[0m"
	@setterm -term linux -fore white
	@sed -n '26,40p;41q' $@ | egrep --color 'ExistT|$$'
	@gnome-screenshot -w -f /tmp/figure.png
	@mv /tmp/figure.png ${IMG_DIR}/Code_01_div_q_r_hs_whole.png

######################
# [5] *.dfy -> *.png #
######################
${IMG_DIR}/Code_02_max.png: \
${DFNYDIR}/max.dfy
	@echo "[ 6 ] $(notdir $<) -> $(notdir $@)"
	@resize -s 22 70
	@clear
	@setterm -term linux -fore blue
	@echo "\033[1m\$$ sed -n '1,19p;20q' $(notdir $<)         | egrep --color 'invariant|requires|ensures\$$'\033[0m"
	@setterm -term linux -fore white
	@sed -n '1,19p;20q' $< | egrep --color 'invariant|requires|ensures|$$'
	@gnome-screenshot -w -f /tmp/figure.png
	@mv /tmp/figure.png ${IMG_DIR}/Code_02_max.png

.ONESHELL:
######################
# [5] *.dfy -> *.png #
######################
${IMG_DIR}/Code_02_max_inv.png: \
${DFNYDIR}/Code_02_max.dfy
	@resize -s 22 70
	@clear
	@setterm -term linux -fore blue
	@echo "\033[1m\$$ sed -n '1,19p;20q' $(notdir $<) | egrep --color 'invariant|requires|ensures\$$'\033[0m"
	@setterm -term linux -fore white
	@sed -n '1,19p;20q' $< | egrep --color 'invariant|requires|ensures|$$'
	@gnome-screenshot -w -f /tmp/figure.png
	@mv /tmp/figure.png ${IMG_DIR}/Code_02_max_inv.png

#########
# clean #
#########
clean:
	@echo "rm -f $(notdir ${SLIDES}.pdf)"
	@rm -r ${SLIDES}.pdf

