
JAVAC = javac
JAVA = java
JUNIT_JAR = junit-platform-console-standalone-1.9.3.jar
SRC_DIR_U7 = U7O2
SRC_DIR_U6 = U6O1
TEST_CLASS_U7 = SortingTest
TEST_CLASS_U6 = ParantesSjekkerTest

JAVAC_FLAGS = -cp $(JUNIT_JAR):$(SRC_DIR_U7):$(SRC_DIR_U6)

all: compile run

compile:
	$(JAVAC) $(JAVAC_FLAGS) $(SRC_DIR_U7)/*.java $(SRC_DIR_U6)/*.java

run:
	$(JAVA) -cp $(JUNIT_JAR):$(SRC_DIR_U7):$(SRC_DIR_U6):$(SRC_DIR_U7)/$(TEST_CLASS_U7).class:$(SRC_DIR_U6)/$(TEST_CLASS_U6).class org.junit.platform.console.ConsoleLauncher --scan-classpath

clean:
	rm -f $(SRC_DIR_U7)/*.class $(SRC_DIR_U6)/*.class


