# see for more information README.md
JC = javac
JCFLAGS = -g
JBINDIR = bin	# :-) BITTE KEIN SLASH AM ANFANG VOM PFAD 'bin' SETZEN!
		# Erlaubt: ./bin oder bin;
		# Kritisch: /bin  :-) Beim Aufruf vom Target/Goal 'clean' oder 'distclean' mit Adminrechte könnte es Probleme geben!

JAVA = java
JAVAFLAGS = -cp

JDOC = javadoc
JDOCDIR = doc

MAINCLASS_HANOI   = edu.christophstach.hanoi.Application
MAINCLASS_SKYLINE = edu.christophstach.skyline.Application

SOURCES   = ./src/main/java/edu/christophstach/hanoi/Application.java \
            ./src/main/java/edu/christophstach/skyline/Application.java \
            ./src/main/java/edu/christophstach/util/ConsoleApplication.java \
            ./src/main/java/edu/christophstach/hanoi/game/Disc.java \
            ./src/main/java/edu/christophstach/hanoi/game/Peg.java \
            ./src/main/java/edu/christophstach/hanoi/game/TowersOfHanoi.java \
            ./src/main/java/edu/christophstach/hanoi/game/ITowersOfHanoi.java \
            ./src/main/java/edu/christophstach/skyline/Building.java \
            ./src/main/java/edu/christophstach/skyline/Skyline.java

default:
	echo 'Run target default'
	mkdir -p $(JBINDIR)
	$(JC) $(JCFLAGS) $(SOURCES) -d $(JBINDIR)

run-hanoi:
	@echo 'Run target run'
	cd $(JBINDIR); $(JAVA) $(JAVAFLAGS) . $(MAINCLASS_HANOI)

run-skyline:
	@echo 'Run target run'
	cd $(JBINDIR); $(JAVA) $(JAVAFLAGS) . $(MAINCLASS_SKYLINE)

doc:
	@echo 'Run target doc'
	$(JDOC) -version -author -d $(JDOCDIR) $(SOURCES)

clean:
	@echo 'Run target clean'
	$(RM) -r $(JBINDIR)

distclean: clean
	@echo 'Run target distclean'
	$(RM) -r $(JDOCDIR)

release: distclean default doc
