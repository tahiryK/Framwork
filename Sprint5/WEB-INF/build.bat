
@REM # se mettre dans la repertoire des classes
cd "C:\Program Files\Apache Software Foundation\Tomcat 10.1\webapps\Sprint5\WEB-INF\classes"
@REM # construire le fichier jar
jar -cvf ../Framework_etu1888.jar .
@REM # copie du jar dans le projet de test
cd ../
copy Framework_etu1888.jar "C:\Program Files\Apache Software Foundation\Tomcat 10.1\webapps\Sprint5\WEB-INF\lib"
