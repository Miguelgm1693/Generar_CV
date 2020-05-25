package genera_cv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Genera_CV {

    public static void main(String[] args) {

        String todo = "";

        try {

            BufferedReader br = new BufferedReader(new FileReader("cv.txt"));

            String linea = " ";

            while (linea != null) {
                linea = br.readLine();

                todo += linea + "\n";

            }
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("El archivo cv.txt no se ha podido encontrar");

        } catch (IOException e) {
            System.out.println("Se ha producido un error en la lectura");
        }

        
        String nombre = todo.substring(todo.indexOf(">>>nombre") + 9, todo.indexOf(">>>telefono"));
        String telefono = todo.substring(todo.indexOf(">>>telefono") + 11, todo.indexOf(">>>correo"));
        String correo = todo.substring(todo.indexOf(">>>correo") + 9, todo.indexOf(">>>formacion"));
        String[] formacion = todo.substring(todo.indexOf(">>>formacion") + 12, todo.indexOf(">>>experiencialaboral")).split("\n");
        String[] experienciaLaboral = todo.substring(todo.indexOf(">>>experiencialaboral") + 21).split("\n");

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("Mi_Curriculum_Vitae.html"));

            bw.write("<!DOCTYPE html>\r\n"
                    + "<html>\r\n"
                    + "<head>\r\n"
                    + "    <title>Currículum</title>\r\n"
                    + "    <meta charset=\"utf-8\" />\r\n"
                    + "</head>"
                    + "<body>\r\n"
                    + "	\r\n"
                    + "	<h1>Currículum Vitae</h1>\r\n"
                    + "	<h3>Datos personales</h3>\r\n"
                    + "	<p>" + nombre + "</p>\r\n"
                    + "	<p>" + telefono + "</p>\r\n"
                    + "	<p>" + correo + "</p>\n"
                    + "	<h3>Formación profesional</h3\n");

            for (String estudio : formacion) {
                bw.write("<p>" + estudio + "</p>\n");
            }

            bw.write("<h3>Experiencia Laboral</h3>\n");

            for (String trabajo : experienciaLaboral) {
                if(!trabajo.equals("null")){
                bw.write("<p>" + trabajo + "</p>\n");
                }
            }

            bw.close();

        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }

}
