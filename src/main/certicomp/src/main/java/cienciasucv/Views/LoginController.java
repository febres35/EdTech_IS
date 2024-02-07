package cienciasucv.Views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoginController{
    public boolean checkLoginData(String correo, String contrasenia) {
        File fichero = new File("fichero.txt");
        System.out.println(fichero.getAbsolutePath());
        try (BufferedReader reader = new BufferedReader(new FileReader("datos_sesion.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split("/");
                if (datos.length == 2 && datos[0].equals(correo) && datos[1].equals(contrasenia)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}