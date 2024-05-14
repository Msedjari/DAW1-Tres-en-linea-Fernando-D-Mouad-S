
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CrearArchivo {
    public CrearArchivo() {
    }

    public static void main() {
        try {
            //crear un nuevo objeto File que representa el nuevo archivo llamado configuracion.txt en el derictorio actual
            File myObj = new File("configuracion.txt");
            //verificar si elarchivo  no existia previamente y crea un nuevo archivo si es asi
            if (myObj.createNewFile()) {
                System.out.println("Archivo creado:" + myObj.getName());
            }
            //Si el archivo ya existía, imprime un mensaje indicando que el archivo ya existe
            else {
                System.out.println("Ya existe el archivo");
            }
        }
        //excepcion
        catch (IOException var2) {
            throw new RuntimeException(var2);
        }
       /*
        try {
            new FileWriter("configuracion.txt");
        } catch (IOException var1) {
            throw new RuntimeException(var1);
        }

        */
    }
}
