JFLAGS = -g 
JC = javac 
JVM= java # Added by JP
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Chat.java \
	Conex.java\
	Mensj.java\
	HiloLecturaStream.java\
	HiloServidor.java\
	VentanaChat.java
			
# main variable: Added by JP

MAIN = Chat
PUERTO = 3000
default: classes

classes: $(CLASSES:.java=.class)

# run target added by JP

run: 
	$(JVM) $(MAIN) $(PUERTO)

clean: 
	$(RM) *.class
