:: agregamos la ruta del proyecto
cd .\build\install\mp01

:: establecemos los puertos donde se ejecutaran las intancias

start java -Dserver.port=7002 -classpath lib/* com.distribuida.Servidor

start java -Dserver.port=7003 -classpath lib/* com.distribuida.Servidor

start java -Dserver.port=7004 -classpath lib/* com.distribuida.Servidor

start java -Dserver.port=7005 -classpath lib/* com.distribuida.Servidor

