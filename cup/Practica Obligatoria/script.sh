#!/bin/bash



# Compilar la gramática CUP
cup *.cup

# Compilar el análisis léxico con JFlex
jflex *.flex

# Compilar el código fuente Java
javac -cp /usr/share/java/java-cup-0.11b-runtime.jar:. *.java

# Verificar si la compilación fue exitosa
if [ $? -eq 0 ]; then
    echo "Compilación exitosa. Ejecutando el programa..."
    
    # Ejecutar el programa Java con el nombre proporcionado por el usuario
    java -cp /usr/share/java/java-cup-0.11b-runtime.jar:. Matrices p1.mat
    echo -e "\nEjecución completada."

else
    echo "Error durante la compilación. Verifica tu código Java, CUP y JFlex."
fi
