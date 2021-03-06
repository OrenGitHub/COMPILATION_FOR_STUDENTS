###########
# BASEDIR #
###########
BASEDIR = $(shell pwd)

###############
# DIRECTORIES #
###############
XMPLDIR = ${BASEDIR}
FIG_DIR = ${BASEDIR}/../FOLDER_1_FIG_FILES

###########
# C FILES #
###########
XMPLFILES_C        = $(wildcard  ${XMPLDIR}/*.c)
PNG_FILES_C_BEFORE = $(addprefix ${FIG_DIR}/,$(notdir $(XMPLFILES_C:.c=_before.png)))
PNG_FILES_C_AFTER  = $(addprefix ${FIG_DIR}/,$(notdir $(XMPLFILES_C:.c=_after.png)))
PNG_FILES_C        =  \
${PNG_FILES_C_BEFORE} \
${PNG_FILES_C_AFTER}

#############
# CPP FILES #
#############
XMPLFILES_CPP        = $(wildcard  ${XMPLDIR}/*.cpp)
PNG_FILES_CPP_BEFORE = $(addprefix ${FIG_DIR}/,$(notdir $(XMPLFILES_CPP:.cpp=_before.png)))
PNG_FILES_CPP_AFTER  = $(addprefix ${FIG_DIR}/,$(notdir $(XMPLFILES_CPP:.cpp=_after.png)))
PNG_FILES_CPP        =  \
${PNG_FILES_CPP_BEFORE} \
${PNG_FILES_CPP_AFTER}

################
# PYTHON FILES #
################
XMPLFILES_PYTHON        = $(wildcard  ${XMPLDIR}/*.py)
PNG_FILES_PYTHON_BEFORE = $(addprefix ${FIG_DIR}/,$(notdir $(XMPLFILES_PYTHON:.py=_before.png)))
PNG_FILES_PYTHON_AFTER  = $(addprefix ${FIG_DIR}/,$(notdir $(XMPLFILES_PYTHON:.py=_after.png)))
PNG_FILES_PYTHON        =  \
${PNG_FILES_PYTHON_BEFORE} \
${PNG_FILES_PYTHON_AFTER}

################
# PYTHON FILES #
################
XMPLFILES_HASKELL        = $(wildcard  ${XMPLDIR}/*.hs)
PNG_FILES_HASKELL_BEFORE = $(addprefix ${FIG_DIR}/,$(notdir $(XMPLFILES_HASKELL:.hs=_before.png)))
PNG_FILES_HASKELL_AFTER  = $(addprefix ${FIG_DIR}/,$(notdir $(XMPLFILES_HASKELL:.hs=_after.png)))
PNG_FILES_HASKELL        =  \
${PNG_FILES_HASKELL_BEFORE} \
${PNG_FILES_HASKELL_AFTER}

#########
# FILES #
#########
PNG_FILES =          \
${PNG_FILES_C}       \
${PNG_FILES_CPP}     \
${PNG_FILES_PYTHON}  \
${PNG_FILES_HASKELL}

########
# DONE #
########
DONE = ${BASEDIR}/done.txt

##################
# DEFAULT TARGET #	
##################
.DEFAULT_GOAL := ${DONE}

.ONESHELL:
############################
# [1] C EXAMPLES :: Before #
############################
${FIG_DIR}/%_before.png: ${XMPLDIR}/%.c
	@mkdir -p ${FIG_DIR}
	resize -s 3 3
	clear
	setterm -term linux -fore blue
	echo "\033[1m\$$ cat $(notdir $<)\033[0m"
	setterm -term linux -fore white
	cat $<
	gnome-screenshot -w -f $@
	@rm -f *.hi *.o *.vo *.glob

.ONESHELL:
###########################
# [2] C EXAMPLES :: After #
###########################
${FIG_DIR}/%_after.png: ${XMPLDIR}/%.c
	resize -s 3 3
	clear
	setterm -term linux -fore blue
	echo "\033[1m\$$ cat $(notdir $<)\033[0m"
	setterm -term linux -fore white
	cat $<
	setterm -term linux -fore blue
	echo "\033[1m\$$ gcc -Wall $(notdir $<)\033[0m"
	setterm -term linux -fore white
	gcc -Wall $(notdir $<)
	sleep 2
	gnome-screenshot -w -f $@
	@rm -f *.hi *.o *.vo *.glob

.ONESHELL:
##############################
# [3] CPP EXAMPLES :: Before #
##############################
${FIG_DIR}/%_before.png: ${XMPLDIR}/%.cpp
	@mkdir -p ${FIG_DIR}
	resize -s 3 3
	clear
	setterm -term linux -fore blue
	echo "\033[1m\$$ cat $(notdir $<)\033[0m"
	setterm -term linux -fore white
	cat $<
	gnome-screenshot -w -f $@
	@rm -f *.hi *.o *.vo *.glob

.ONESHELL:
#############################
# [4] CPP EXAMPLES :: After #
#############################
${FIG_DIR}/%_after.png: ${XMPLDIR}/%.cpp
	resize -s 3 3
	clear
	setterm -term linux -fore blue
	echo "\033[1m\$$ cat $(notdir $<)\033[0m"
	setterm -term linux -fore white
	cat $<
	setterm -term linux -fore blue
	echo "\033[1m\$$ g++ -Wall $(notdir $<)\033[0m"
	setterm -term linux -fore white
	g++ -Wall $(notdir $<)
	sleep 2
	gnome-screenshot -w -f $@
	@rm -f *.hi *.o *.vo *.glob

.ONESHELL:
##################################
# [5] HASKELL EXAMPLES :: Before #
##################################
${FIG_DIR}/%_before.png: ${XMPLDIR}/%.hs
	@mkdir -p ${FIG_DIR}
	resize -s 3 3
	clear
	setterm -term linux -fore blue
	echo "\033[1m\$$ cat $(notdir $<)\033[0m"
	setterm -term linux -fore white
	cat $<
	gnome-screenshot -w -f $@
	@rm -f *.hi *.o *.vo *.glob

.ONESHELL:
#################################
# [6] HASKELL EXAMPLES :: After #
#################################
${FIG_DIR}/%_after.png: ${XMPLDIR}/%.hs
	resize -s 3 3
	clear
	setterm -term linux -fore blue
	echo "\033[1m\$$ cat $(notdir $<)\033[0m"
	setterm -term linux -fore white
	cat $<
	setterm -term linux -fore blue
	echo "\033[1m\$$ ghc $(notdir $<)\033[0m"
	setterm -term linux -fore white
	ghc $(notdir $<)
	sleep 2
	gnome-screenshot -w -f $@
	@rm -f *.hi *.o *.vo *.glob

###########################
# [2] COLLECT ALL RESULTS #
###########################
${DONE}: ${PNG_FILES}
	@echo "[ 2 ] create PNG files"
	@echo "done" > $@

#########
# CLEAN #
#########
clean:
	@rm -f ${PNG_FILES}
	@echo "rm -f $(notdir ${PNG_FILES})"

