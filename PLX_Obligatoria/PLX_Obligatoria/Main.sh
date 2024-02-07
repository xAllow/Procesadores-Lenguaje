java -jar /usr/share/java/java-cup-0.11b.jar PLXC.cup              
jflex PLXC.flex                                                    
javac -cp /usr/share/java/java-cup-0.11b-runtime.jar:. *.java      
java -cp /usr/share/java/java-cup-0.11b-runtime.jar:. PLXC /home/pablo/Documentos/GitHub/Universidad/PL/Practica/PLX_Obligatoria/PLX_Obligatoria/pruebas/asig1.plx prog.ctd

