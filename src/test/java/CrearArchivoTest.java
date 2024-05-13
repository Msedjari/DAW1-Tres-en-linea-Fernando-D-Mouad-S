
import java.io.File;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearArchivoTest {

    @Test
    void archivoGenerado() {
        //declara el nombre del archivo que se espera que se genere
        String nombreArchivo = "configuracion.txt";
        //llama al metodo main de la clase crearArchivo para ejecutar la logica de creacion del archivo
        CrearArchivo.main();
        //Crea el archivo file que representa  el archivo generado
        File archivo = new File(nombreArchivo);
        //Verificar que el archivo existe en el sistema de archivos
        Assertions.assertTrue(archivo.exists());
    }
}
