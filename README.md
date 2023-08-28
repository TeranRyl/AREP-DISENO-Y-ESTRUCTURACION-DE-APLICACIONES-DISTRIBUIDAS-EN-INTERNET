# DISEÑO Y ESTRUCTURACIÓN DE APLICACIONES DISTRIBUIDAS EN INTERNET

Un servidor web que lee los archivos del disco local y retorna todos los archivos solicitados, incluyendo páginas html, archivos java script, css e imágenes. Se construyo una aplicación web con javascript, css, e imágenes para probar el servidor.

## Instrucciones para ejecutar

A continuacion, dejo respectivas instrucciones para correr el proyecto adecuadamente tras obtener la direccion a este repositorio GitHub. Igualmente, mas abajo dejare evidencia detallada para garantizar que se entienda su implementacion. La aplicacion debe usarse para fines de prueba y desarrollo.

### Requisitos previos

Para descargar la aplicacion, ya estando aqui, se necesita un equipo de computo con las siguientes caracteristicas:

```
- Java instalado

- Maven instalado

- JavaScript instalado

- Conexion a internet

- Explorador web

- 

- (RECOMENDACION) Tener todo actualizado
```
Esta guia no incluye tutoria para la descarga e instalacion de los anteriores mencionados. Si no cuenta con algo, o no sabe, le recomiendo ver algun video en Youtube.

### Instalando

Paso a paso

```
1. Descargar el codigo: Bajar el .ZIP correspondiente al repositorio.

2. Extraer el contenido del archivo comprimido.

3. Abrir el Shell de su preferencia.

4. Desde el Shell, muevase a la ubicacion donde extrajo el archivo .ZIP (Deberia estar dentro de la carpeta llamada  "ARQUITECTURAS-EMPRESARIALES-TALLER-2-master").

5. Desde el Shell, escriba "mvn package" (este comando compila, construye y empaqueta el proyecto en un .JAR).

6. Desde el Shell, escriba "java -cp target/Taller2-1.0-SNAPSHOT.jar edu.escuelaing.app.App" para ejecutar la aplicacion.
   Deberia ver un mensaje diciendo "Listo para recibir... ".

7. Abra su explorador web de preferencia y busque en una pestaña incognita lo siguiente:
   
   - "localhost:35001/web/terminos.html" (SIN LAS COMILLAS) - Pagina html con ruta "src/main/resources/terminos.html"
   - "localhost:35001/web/style.css" (SIN LAS COMILLAS) - Archivo css con ruta "src/main/resources/style.css"
   - "localhost:35001/web/app.js" (SIN LAS COMILLAS) - Archivo javascript con ruta "src/main/resources/app.js"
   - "localhost:35001/web/risas.jpg" (SIN LAS COMILLAS) - Imagen jpg con ruta "src/main/resources/risas.jpg"

8. Buscando "localhost:35001/web/index.html" (SIN LAS COMILLAS) o "localhost:35001/web/*CUALQUIERTEXTO_O_VACIO*" (SIN LAS COMILLAS Y ASTERISCOS) tendra acceso a una aplicacion que incluye archivos html, css, js y jpg.

9. Esta aplicacion web incluye comunicacion asincrona con servicios REST. Para probar esto, debe introducir cualquier cadena en el campo de texto y posteriormente debe pulsar sobre el boton "Submit" para enviar la 
   solicitud HTTP y traer el contenido de "terminos.html". En pantalla podra ver, adicional al "index.html", la pagina "terminos.html" cargada.
```

Puede enviar cuantas cadenas de texto quiera.

```
Una vez haya terminado, puede cerrar el servidor introduciendo, desde el cliente, la URL "localhost:35001/web/salir.exe" (SIN LAS COMILLAS) y el servidor se apagara enseguida.

```

## Ejecucion de las pruebas

La aplicacion cuenta con pruebas automatizadas, tanto unitarias como concurrentes. Para demostrar las pruebas de concurrencia, es necesario que el servidor web este en pleno funcionamiento mientras se corren las pruebas. Para ello, tendremos que abrir 2 Shells al mismo tiempo: en uno ejecutaremos primero "java -cp target/Taller1-1.0-SNAPSHOT.jar edu.escuelaing.app.App", una vez aparezca en pantalla el mensaje "Listo para recibir...", en el otro pondremos el comando "mvn test".

NOTA: Para abortar el shell con el servidor encendido, podemos presionar "CTRL" + "C".

## Implementacion

NOTA 1
Una forma adicional de ejecutar el programa, permitiendo realizar busquedas manuales desde el cliente Java (sin necesidad de un explorador web), es, desde un IDLE de Java, ejecutar la clase App (servidor) seguida de la clase HttpClient (cliente). Una vez hecho esto, podremos ver informacion de peliculas desde la pantalla de resultado de el cliente Http, y podremos peliculas tal y como si fuese desde el browser (omitiendo la agradable interfaz). Al igual que desde el browser, podemos apagar el Sever introduciendo " _" en el campo de busqueda y luego enviando la solicitud.

NOTA 2
En el backend se utilizo codigo fuente puro Java (sin ningun tipo de framework). Se utilizo JavaScript asincrono como cliente web ejecutado en el explorador web, asi como formato JSON para los mensajes de respuesta. 
Tambien se utilizaron sockets, los cuales tienen la funcion de comunicar dos programas: un cliente y un servidor. El proposito de esto es poder conectarse al servidor web, por lo que el cliente y servidor se conectaron entre si a traves de sus sockets "cliente" (el servidor abre otro socket adicional). Para esto, el cliente debe buscar comunicarse con el servidor especificando la IP destino a la que pretende conectarse, y por cual puerto, mientras que el servidor abre su respectivo puerto.
Para implementar el servidor web se utilizo HTTP.
El explorador web se conecto al servidor web por medio de sockets (los cuales utilizan el protocolo TCP -> Orientado a Coenxion).
El flujo es el siguiente: Se abre la conexion TCP -> El explorador wb envia solicitud HTTP al servidor -> El servidor responder al explorador web -> Cierre de conexion.
Ademas, para la conexion desde el servidor http al servidor externo se utilizaron servicios GET desde Java.

NOTA 3
El diseño es sumamente extensible. Se puede extender para que, cuando se introduzca un titulo de pelicula "comun" (es decir, que hay mas de una pelicula que se llama exactamente asi) se pueda aplicar otra clase de filtros o criterios sobre la busqueda que la misma API ofrece por su cuenta, tales como: año de estreno y tipo de resultado (cine, serie o episodio). De esta manera, cuando haya mas de una pelicula con el mismo nombre, se puede estar casi seguro de encontrar la que uno busca si se aplican los parametros antes mencinados. En este caso, se podria crear alguna estructura de datos que guarde los resultados con el mismo nombre, de tal manera que, una vez se encuentren, no sea necesario volver a consultar con el API externo sino que los siguientes filtros se apliquen sobre la propia estructura que los contiene.
Personalmente, creo que negocios como Cine Colombia deberian tener mas enfoque con el cine que el que tienen ahorita. Pues en su pagina web solo aparecen peliculas que estan EN CARTELERA, pero opino que una empresa tan famosa y con una pagina tan visitada podrian implementar que se pueda consultar informacion de cualquier pelicula. Ademas, tambien podria serviles para expandirse mas alla del cine, inmersionandose en las series.

## Construido con

* [Java](https://www.oracle.com/co/java/) - Backend
* [Maven](https://maven.apache.org/) - Gestion de ciclo de vida y dependencias
* [Git/Github](https://git-scm.com/) - Almacenar el codigo fuente
* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - IDE para desarrollo

## Autores

* **Juan Francisco Teran** - *Trabajo total* - [TeranRyl](https://github.com/TeranRyl)

## Licencia

Este proyecto tiene la licencia GNU General Public License v3.0; consulte el archivo [LICENSE.txt](LICENSE.txt) para obtener más información.

## Reconocimientos

* PurpleBooth - Plantilla para hacer un buen README
* Luis Daniel Benavides - Preparacion e introduccion al diseño de sistemas de informacion. Preparacion para el taller.

