@REM #!/bin/bash.
@REM # se mettre dans la repertoire des classes
cd "C:\Program Files\Apache Software Foundation\Tomcat 10.1\webapps\Sprint4\WEB-INF\classes"
@REM # construire le fichier jar
jar -cvf ../etu1888.jar .
@REM # copie du jar dans le projet de test
cd "../"
copy etu1888.jar 
