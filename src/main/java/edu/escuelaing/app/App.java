package edu.escuelaing.app;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.*;



import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/** ESCUELA COLOMBIANA DE INGENIERIA - ARQUITECTURAS EMPRESARIALES

 Juan Francisco Teran Roman
 26/08/2023

 DISEÑO Y ESTRUCTURACIÓN DE APLICACIONES DISTRIBUIDAS EN INTERNET
 En este taller usted explorará la arquitectura de las aplicaciones distribuidas. Concretamente, exploraremos la
 arquitectura de  los servidores web y el protocolo http sobre el que están soportados.

 https://github.com/TeranRyl/ARQUITECTURAS-EMPRESARIALES-TALLER-2

 */

// TALLER 2


public class App {

    /**
     * Crea un socket de servidor web y escucha las conexiones entrantes.
     * El socket del servidor se crea en el puerto 35001 y el servidor escucha las conexiones entrantes hasta que finaliza.
     * Cuando se acepta una conexión, el servidor crea un PrintWriter y un BufferedReader para comunicarse con el cliente (explorador web).
     * El servidor lee datos del cliente y los procesa de acuerdo con la URL especificada (el servior lee el disco local y retorna los archivos solicitados por el cliente).
     * El programa funciona con archivos como HTML, CSS, JavaScript e imágenes JPG del directorio "src/main/resources".
     * Crea una aplicacion web para probar el servidor y que invoca servicios REST de forma asincrona desde el cliente.
     *
     * @param args argumentos de línea de comando (no utilizados)
     * @throws IOException si se produce un error de Input-Output al crear el socket del servidor o al comunicarse con el cliente
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35001);

        } catch (IOException e) {
            System.err.println("Could not listen on port: 35001.");
            System.exit(1);
        }



        boolean running = true;
        while (running) {


            Socket clientSocket = null;
            try {
                System.out.println("\nListo para recibir... \n");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }


            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()
                    ));

            //Path rutaHtml = Paths.get("src/main/resources/terminos.html");
            //String leerHtml = Files.readString(rutaHtml);

            String pelicula, respuesta;
            boolean firstLine = true;
            String urlString = "";
            while ((pelicula = in.readLine()) != null) {
                System.out.println("Received: " + pelicula);
                if (firstLine) {
                    firstLine = false;
                    urlString = pelicula.split(" ")[1];
                    System.out.println("Data request: " + pelicula);

                    //System.out.println("HOLA" + urlString);
                    // POST

                }

                if (!in.ready()) {
                    break;
                }

            }


            //System.out.println("HOLI");
            //System.out.println("HOLA JAJAJAJAJA" + urlString.startsWith("/web"));

            if (urlString.startsWith("/web")) {

                //System.out.println(urlString.equals("/web/terminos"));


                switch (urlString) {
                    case "/web/terminos.html" -> {
                        Path rutaHtml = Paths.get("src/main/resources/terminos.html");
                        String leerHtml = Files.readString(rutaHtml);
                        respuesta = "HTTP/1.1 200 OK\r\n"
                                + "Content-Type: text/html\r\n"
                                + "\r\n"
                                // +"Hola";*/
                                + leerHtml;
                    }

                    //System.out.println("hehehehe");
                    //clientSocket.getOutputStream().write(respuesta.getBytes("UTF-8"));
                    //break;

                    case "/web/style.css" -> {
                        Path rutaCss = Paths.get("src/main/resources/style.css");
                        String leerCss = Files.readString(rutaCss);
                        respuesta = "HTTP/1.1 200 OK\r\n"
                                + "Content-Type: text/css\r\n"
                                + "\r\n"
                                + leerCss;
                    }
                    case "/web/app.js" -> {
                        Path rutaJs = Paths.get("src/main/resources/app.js");
                        String leerJs = Files.readString(rutaJs);
                        respuesta = "HTTP/1.1 200 OK\r\n"
                                + "Content-Type: application/javascript\r\n"
                                + "\r\n"
                                + leerJs;
                    }
                    case "/web/risas.jpg" -> {
                        Path rutaJpg = Paths.get("src/main/resources/risas.jpg");
                        respuesta = "HTTP/1.1 200 OK\r\n"
                                + "Content-Type: image/jpeg\r\n"
                                + "\r\n";
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        BufferedImage bufferedImage = ImageIO.read(new File(rutaJpg.toUri()));
                        ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
                        clientSocket.getOutputStream().write(respuesta.getBytes());
                        clientSocket.getOutputStream().write(byteArrayOutputStream.toByteArray());
                    }

                    //byte[] bytesJpg = Files.readAllBytes(rutaJpg);
                    /*String encabezados = ("HTTP/1.1 200 OK\r\n".getBytes());
                    String encabezadoss = ("Content-Type: image/jpeg\r\n").getBytes();
                    String encabezadosss = ("Content-Length: " + bytesJpg.length);
                            + "\r\n").getBytes();
                            //+ bytesJpg;
                    respuesta = encabezados.getBytes()*/

                    //respuesta= Arrays.toString(bytesJpg);

                    default -> {
                        Path rutaIndex = Paths.get("src/main/resources/index.html");
                        String leerIndex = Files.readString(rutaIndex);
                        respuesta = "HTTP/1.1 200 OK\r\n"
                                + "Content-Type: text/html\r\n"
                                + "\r\n"
                                // +"Hola";*/
                                + leerIndex;
                    }

                    //respuesta = getIndexResponse();

                }
            } else {
                respuesta = "HTTP/1.1 200 OK\r\n"
                        + "Content-type: text/html\r\n"
                        + "\r\n"
                        + "<!DOCTYPE html>"
                        + "<html>"
                        + "<head>"
                        + "<meta charset=\"UTF-8\">"
                        + "<title>ERROR 404/title>\n"
                        + "</head>"
                        + "<body>"
                        + "ERROR 404: Pagina no encontrada"
                        + "</body>"
                        + "</html>";

                //respuesta = getIndexResponse();
            }
            out.println(respuesta);


            out.close();
            in.close();
            clientSocket.close();

            if (urlString.equals("/web/salir.exe")){
                System.out.println("Cerrando programa...");
                break;
            }

        }
        serverSocket.close();
    }
}

