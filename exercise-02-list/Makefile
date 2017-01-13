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

MAINCLASS = edu.christophstach.list.Application

SOURCES     = ./src/main/java/edu/christophstach/list/Application.java \
              ./src/main/java/edu/christophstach/list/predicate/FirstNameEqualsPredicate.java \
              ./src/main/java/edu/christophstach/list/predicate/LastNameEqualsPredicate.java \
              ./src/main/java/edu/christophstach/list/predicate/GenderEqualsPredicate.java \
              ./src/main/java/edu/christophstach/list/predicate/MnEqualsPredicate.java \
              ./src/main/java/edu/christophstach/list/predicate/ProgramEqualsPredicate.java \
              ./src/main/java/edu/christophstach/list/predicate/Predicable.java \
              ./src/main/java/edu/christophstach/list/list/search/Searchable.java \
              ./src/main/java/edu/christophstach/list/list/search/LinearSearch.java \
              ./src/main/java/edu/christophstach/list/list/sort/Sortable.java \
              ./src/main/java/edu/christophstach/list/list/sort/BubbleSort.java \
              ./src/main/java/edu/christophstach/list/list/sort/QuickSort.java \
              ./src/main/java/edu/christophstach/list/comparator/Comparable.java \
              ./src/main/java/edu/christophstach/list/comparator/FirstNameComparator.java \
              ./src/main/java/edu/christophstach/list/comparator/LastNameComparator.java \
              ./src/main/java/edu/christophstach/list/comparator/GenderComparator.java \
              ./src/main/java/edu/christophstach/list/comparator/MnComparator.java \
              ./src/main/java/edu/christophstach/list/comparator/ProgramComparator.java \
              ./src/main/java/edu/christophstach/list/util/ConsoleApplication.java \
              ./src/main/java/edu/christophstach/list/data/Program.java \
              ./src/main/java/edu/christophstach/list/data/Student.java \
              ./src/main/java/edu/christophstach/list/data/Gender.java \
              ./src/main/java/edu/christophstach/list/list/Listable.java \
              ./src/main/java/edu/christophstach/list/list/SinglyLinkedList.java \
              ./src/main/java/edu/christophstach/list/list/DoublyLinkedList.java

TESTSOURCES = ./src/test/java/edu/christophstach/list/list/SinglyLinkedListTest.java \
              ./src/test/java/edu/christophstach/list/list/DoublyLinkedListTest.java \
              ./src/test/java/edu/christophstach/list/list/ListableTest.java \
              ./src/main/java/edu/christophstach/list/predicate/FirstNameEqualsPredicate.java \
              ./src/main/java/edu/christophstach/list/predicate/LastNameEqualsPredicate.java \
              ./src/main/java/edu/christophstach/list/predicate/GenderEqualsPredicate.java \
              ./src/main/java/edu/christophstach/list/predicate/MnEqualsPredicate.java \
              ./src/main/java/edu/christophstach/list/predicate/ProgramEqualsPredicate.java \
              ./src/main/java/edu/christophstach/list/predicate/Predicable.java \
              ./src/main/java/edu/christophstach/list/list/search/Searchable.java \
              ./src/main/java/edu/christophstach/list/list/search/LinearSearch.java \
              ./src/main/java/edu/christophstach/list/list/sort/Sortable.java \
              ./src/main/java/edu/christophstach/list/list/sort/BubbleSort.java \
              ./src/main/java/edu/christophstach/list/list/sort/HeapSort.java \
              ./src/main/java/edu/christophstach/list/list/sort/QuickSort.java \
              ./src/main/java/edu/christophstach/list/list/sort/SelectionSort.java \
              ./src/main/java/edu/christophstach/list/comparator/Comparable.java \
              ./src/main/java/edu/christophstach/list/comparator/FirstNameComparator.java \
              ./src/main/java/edu/christophstach/list/comparator/LastNameComparator.java \
              ./src/main/java/edu/christophstach/list/comparator/GenderComparator.java \
              ./src/main/java/edu/christophstach/list/comparator/MnComparator.java \
              ./src/main/java/edu/christophstach/list/comparator/ProgramComparator.java \
              ./src/main/java/edu/christophstach/list/data/Program.java \
              ./src/main/java/edu/christophstach/list/data/Student.java \
              ./src/main/java/edu/christophstach/list/data/Gender.java \
              ./src/main/java/edu/christophstach/list/list/Listable.java \
              ./src/main/java/edu/christophstach/list/list/SinglyLinkedList.java \
              ./src/main/java/edu/christophstach/list/list/DoublyLinkedList.java

TESTCLASSES = edu.christophstach.list.list.SinglyLinkedListTest \
              edu.christophstach.list.list.DoublyLinkedListTest



default:
	echo 'Run target default'
	mkdir -p $(JBINDIR)
	$(JC) $(JCFLAGS) $(SOURCES) -d $(JBINDIR)

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

run-test:
	@echo 'Run target test'
	mkdir -p $(JBINDIR)
	$(JC) -cp .:$(JUNIT) $(TESTSOURCES) -d $(JBINDIR)
	cd $(JBINDIR); $(JAVA) -cp .:../$(JUNIT):../$(HAMCREST) org.junit.runner.JUnitCore $(TESTCLASSES)

release: distclean default doc
