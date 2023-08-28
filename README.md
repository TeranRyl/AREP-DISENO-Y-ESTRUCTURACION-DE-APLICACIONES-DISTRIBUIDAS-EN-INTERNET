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

NOTA: Para abortar el shell con el servidor encendido, podemos presionar "CTRL" + "C".
```

Puede enviar cuantas cadenas de texto quiera.

Una vez haya terminado, puede cerrar el servidor introduciendo, desde el cliente, la URL "localhost:35001/web/salir.exe" (SIN LAS COMILLAS) y el servidor se apagara enseguida.



## Evaluacion

Pruebas realizadas:

Pagina html:

![image](https://github.com/TeranRyl/ARQUITECTURAS-EMPRESARIALES-TALLER-2/assets/81679109/6b1a1a69-8311-4a3a-8654-b79308d9b7e3)

Archivo css:

![image](https://github.com/TeranRyl/ARQUITECTURAS-EMPRESARIALES-TALLER-2/assets/81679109/d34736bb-5466-4c1a-a25b-07e66c504aca)

Archivo js:

![image](https://github.com/TeranRyl/ARQUITECTURAS-EMPRESARIALES-TALLER-2/assets/81679109/a3375cbe-5fa5-4f72-91b8-bd058b15f50d)

Imagen jpg:

![image](https://github.com/TeranRyl/ARQUITECTURAS-EMPRESARIALES-TALLER-2/assets/81679109/3707c7ce-7e54-44cc-b36f-3d4cf5253f5c)

Aplicacion web:

![image](https://github.com/TeranRyl/ARQUITECTURAS-EMPRESARIALES-TALLER-2/assets/81679109/db1946ba-c6d6-4200-9ce9-3b7ed8ebd924)
![image](https://github.com/TeranRyl/ARQUITECTURAS-EMPRESARIALES-TALLER-2/assets/81679109/3334d16c-9cfc-4428-b5f4-d297a9c0b8c4)

Pagina erronea:

![image](https://github.com/TeranRyl/ARQUITECTURAS-EMPRESARIALES-TALLER-2/assets/81679109/a3080618-9267-4967-bb52-1fa9dcf81ba5)



## Implementacion

NOTA1

En el backend se utilizo codigo fuente puro Java (sin ningun tipo de framework). Se utilizo JavaScript asincrono como cliente web ejecutado como explorador web.
Tambien se utilizaron sockets, los cuales tienen la funcion de comunicar dos programas: un cliente y un servidor. El proposito de esto es poder conectarse al servidor web, por lo que el cliente y servidor se conectaron entre si a traves de sus sockets "cliente" (el servidor abre otro socket adicional). Para esto, el cliente debe buscar comunicarse con el servidor especificando la IP destino a la que pretende conectarse, y por cual puerto, mientras que el servidor abre su respectivo puerto.
Para implementar el servidor web se utilizo HTTP.
El explorador web se conecto al servidor web por medio de sockets (los cuales utilizan el protocolo TCP -> Orientado a Conexion).
El flujo es el siguiente: Se abre la conexion TCP -> El explorador web envia solicitud HTTP al servidor -> El servidor responder al explorador web -> Cierre de conexion.


NOTA 2

El explorador pide y ejecuta lo que el servidor web le envie, y luego el servidor devuelve el resultado (paginas html, archivos css y js e imagenes jpg).
Para esta conversion, se tiene en cuenta el encabezado del archivo y se devuelve en bytes. Este proceso varia segun el tipo de contenido.

## Construido con

* [Java](https://www.oracle.com/co/java/) - Backend
* [Maven](https://maven.apache.org/) - Gestion de ciclo de vida y dependencias
* [Git/Github](https://git-scm.com/) - Almacenar el codigo fuente
* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - IDE para desarrollo

## Autores

* **Juan Francisco Teran** - *Trabajo total* - [TeranRyl](https://github.com/TeranRyl)

## Licencia

Este proyecto tiene la licencia GNU General Public License v3.0; consulte el archivo [LICENSE](LICENSE.txt) para obtener más información.

## Reconocimientos

* PurpleBooth - Plantilla para hacer un buen README
* Luis Daniel Benavides - Preparacion para el taller e introduccion al diseño de sistemas de informacion

