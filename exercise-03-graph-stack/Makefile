JUNIT = junit/junit-4.12.jar
HAMCREST = junit/hamcrest-core-1.3.jar
JC = javac
JCFLAGS = -g
JBINDIR = bin	# :-) BITTE KEIN SLASH AM ANFANG VOM PFAD 'bin' SETZEN!
		# Erlaubt: ./bin oder bin;
		# Kritisch: /bin  :-) Beim Aufruf vom Target/Goal 'clean' oder 'distclean' mit Adminrechte könnte es Probleme geben!

JAVA = java
JAVAFLAGS = -cp

JDOC = javadoc
JDOCDIR = doc

MAINCLASS   = exercise.Application

SOURCES     = ./src/main/java/exercise/Application.java

TESTSOURCES = ./src/main/java/exercise/stack/Stack.java \
              ./src/main/java/exercise/stack/Stackable.java \
              ./src/main/java/exercise/data/Program.java \
              ./src/main/java/exercise/data/Student.java \
              ./src/main/java/exercise/data/Gender.java \
              ./src/main/java/exercise/stack/Stack.java \
              ./src/test/java/exercise/stack/StackTest.java

TESTCLASSES = exercise.stack.StackTest


default:
	echo 'Run target default'
	mkdir -p $(JBINDIR)
	$(JC) $(JCFLAGS) $(SOURCES) -d $(JBINDIR)$

run-app:
	@echo 'Run target run'
	cd $(JBINDIR); $(JAVA) $(JAVAFLAGS) . $(MAINCLASS)

doc:
	@echo 'Run target doc'
	$(JDOC) -version -author -d $(JDOCDIR) $(SOURCES)

clean:
	@echo 'Run target clean'
	$(RM) -r $(JBINDIR)

distclean: clean
	@echo 'Run target distclean'
	$(RM) -r $(JDOCDIR)

test:
	@echo 'Run target test'
	mkdir -p $(JBINDIR)
	$(JC) -cp .:$(JUNIT) $(TESTSOURCES) -d $(JBINDIR)
	cd $(JBINDIR); $(JAVA) -cp .:../$(JUNIT):../$(HAMCREST) org.junit.runner.JUnitCore $(TESTCLASSES)

release: distclean default doc
