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

MAINCLASS = exercise.Application

SOURCES = ./src/main/java/exercise/Application.java \
          ./src/main/java/exercise/data/Program.java \
          ./src/main/java/exercise/data/Student.java \
          ./src/main/java/exercise/lists/SinglyLinkedList.java \
          ./src/main/java/exercise/lists/DoublyLinkedList.java \

TESTS   = ./src/test/java/exercise/Application.java \
          ./src/test/java/exercise/data/ProgramTest.java \
          ./src/test/java/exercise/data/StudentTest.java \
          ./src/test/java/exercise/lists/SinglyLinkedListTest.java \
          ./src/test/java/exercise/lists/DoublyLinkedListTest.java


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

release: distclean default doc
