import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

// PARA PRUEBAS CON PARAMETROS
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sun.rmi.runtime.NewThreadAction;

class JocTest {

    @org.junit.jupiter.api.Test
    void novaPartida_jugador() {
        Joc joc = new Joc();
        joc.novaPartida();

        Assertions.assertEquals(1, joc.getTorn());
    }

    @org.junit.jupiter.api.Test
    void novaPartida_taulell() {
        Joc joc = new Joc();
        joc.novaPartida();

        //obtener el tamaño del nuevo tablero
        int novaMida = joc.getNovaMida();

        //crear un tablero de prueba con el mismo tamaño y llenarlocon '_'
        char[][] taulellTest = new char[novaMida][novaMida];
        for(int i = 0; i < novaMida; i++) {
            for (int j = 0; j < novaMida; j++) {
                taulellTest[i][j] = '_';
            }
        }
        char [][] taulell = joc.getTaulell();

        String taulellTestS = Arrays.deepToString(taulellTest);
        String taulellS = Arrays.deepToString(joc.getTaulell());

        Assertions.assertEquals(taulellTestS, taulellS,"El tablero se inicializó correctamente");

    }

    @ParameterizedTest
    @CsvSource({"0,0" , "0,1" , "0,2" ,"1,0" , "1,1" , "1,2" ,"2,0" , "2,1" , "2,2"  })
    void jugar1_3(short fila,int columna) {

        Joc joc = new Joc();
        joc.novaPartida();

   //verificar que la casilla esta vacia antes de jugar
        Assertions.assertEquals('_',joc.getTaulell()[fila][columna]);

    //realizar la jugada
        joc.jugar(fila,columna);

   //verificar que la ficha se ha colocado en la primera casilla
        Assertions.assertEquals('X',joc.getTaulell()[fila][columna]);

    }
    @ParameterizedTest
    @CsvSource({"0,0" , "0,1" , "0,2" ,"1,0" , "1,1" , "1,2" ,"2,0" , "2,1" , "2,2"  })
    void jugar_2(short fila,int columna) {

        Joc joc = new Joc();
        joc.novaPartida();

        //verificar que la casilla esta vacia antes de jugar
        Assertions.assertEquals('_',joc.getTaulell()[fila][columna]);

        //realizar la jugada del J1
        joc.jugar(fila,columna);

        //realizar la jugada del J2
        joc.jugar(fila,columna);

   //verificar que la ficha se ha colocado en la primera casilla
        Assertions.assertEquals('O',joc.getTaulell()[fila][columna]);

    }
    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "0,3", "1,0", "1,1", "1,2", "1,3", "2,0", "2,1", "2,2", "2,3", "3,0", "3,1", "3,2", "3,3"})
    void jugar1_4(short fila,int columna) {

        Joc joc = new Joc();
        joc.novaPartida();

        //verificar que la casilla esta vacia antes de jugar
        // Assertions.assertEquals('_',joc.getTaulell()[fila][columna]);

        //realizar la jugada del J1
        joc.jugar(fila,columna);



        //verificar que la ficha se ha colocado en la primera casilla
        Assertions.assertEquals('X',joc.getTaulell()[fila][columna]);

    }
    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2", "0,3", "1,0", "1,1", "1,2", "1,3", "2,0", "2,1", "2,2", "2,3", "3,0", "3,1", "3,2", "3,3" })
    void jugar2_4(short fila,int columna) {

        Joc joc = new Joc();
        joc.novaPartida();

        //verificar que la casilla esta vacia antes de jugar
        Assertions.assertEquals('_',joc.getTaulell()[fila][columna]);

        //realizar la jugada del J1
        joc.jugar(fila,columna);

        //verificar que la ficha se ha colocado en la primera casilla
        Assertions.assertEquals('X',joc.getTaulell()[fila][columna]);

        //realizar la jugada del J1
        joc.jugar(fila,columna);

        //verificar que la ficha se ha colocado en la primera casilla
        Assertions.assertEquals('O',joc.getTaulell()[fila][columna]);

    }
    @ParameterizedTest
    @CsvSource({
            "0,0", "0,1", "0,2", "0,3", "0,4", "0,5", "0,6", "0,7", "0,8", "0,9",
            "1,0", "1,1", "1,2", "1,3", "1,4", "1,5", "1,6", "1,7", "1,8", "1,9",
            "2,0", "2,1", "2,2", "2,3", "2,4", "2,5", "2,6", "2,7", "2,8", "2,9",
            "3,0", "3,1", "3,2", "3,3", "3,4", "3,5", "3,6", "3,7", "3,8", "3,9",
            "4,0", "4,1", "4,2", "4,3", "4,4", "4,5", "4,6", "4,7", "4,8", "4,9",
            "5,0", "5,1", "5,2", "5,3", "5,4", "5,5", "5,6", "5,7", "5,8", "5,9",
            "6,0", "6,1", "6,2", "6,3", "6,4", "6,5", "6,6", "6,7", "6,8", "6,9",
            "7,0", "7,1", "7,2", "7,3", "7,4", "7,5", "7,6", "7,7", "7,8", "7,9",
            "8,0", "8,1", "8,2", "8,3", "8,4", "8,5", "8,6", "8,7", "8,8", "8,9",
            "9,0", "9,1", "9,2", "9,3", "9,4", "9,5", "9,6", "9,7", "9,8", "9,9"
    })
    void jugar1_10(short fila, int columna) {
        Joc joc = new Joc();
        //joc.setNovaMida(10);
        joc.novaPartida();

        // Verificar que la casilla está vacía antes de jugar
        Assertions.assertEquals('_', joc.getTaulell()[fila][columna]);

        // Realizar la jugada del J1
        joc.jugar(fila, columna);

        // Verificar que la ficha se ha colocado en la primera casilla
        Assertions.assertEquals('X', joc.getTaulell()[fila][columna]);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0", "0,1", "0,2", "0,3", "0,4", "0,5", "0,6", "0,7", "0,8", "0,9",
            "1,0", "1,1", "1,2", "1,3", "1,4", "1,5", "1,6", "1,7", "1,8", "1,9",
            "2,0", "2,1", "2,2", "2,3", "2,4", "2,5", "2,6", "2,7", "2,8", "2,9",
            "3,0", "3,1", "3,2", "3,3", "3,4", "3,5", "3,6", "3,7", "3,8", "3,9",
            "4,0", "4,1", "4,2", "4,3", "4,4", "4,5", "4,6", "4,7", "4,8", "4,9",
            "5,0", "5,1", "5,2", "5,3", "5,4", "5,5", "5,6", "5,7", "5,8", "5,9",
            "6,0", "6,1", "6,2", "6,3", "6,4", "6,5", "6,6", "6,7", "6,8", "6,9",
            "7,0", "7,1", "7,2", "7,3", "7,4", "7,5", "7,6", "7,7", "7,8", "7,9",
            "8,0", "8,1", "8,2", "8,3", "8,4", "8,5", "8,6", "8,7", "8,8", "8,9",
            "9,0", "9,1", "9,2", "9,3", "9,4", "9,5", "9,6", "9,7", "9,8", "9,9"
    })
    void jugar2_10(short fila, int columna) {
        Joc joc = new Joc();
        //joc.setNovaMida(10);
        joc.novaPartida();

        //verificar que la casilla está vacía antes de jugar
        Assertions.assertEquals('_', joc.getTaulell()[fila][columna]);

        //realizar la jugada del J1
        joc.jugar(fila, columna);

        //verificar que la ficha del J1 se ha colocado en la casilla
        Assertions.assertEquals('X', joc.getTaulell()[fila][columna]);

        //realizar la jugada del J2 en otra casilla
        joc.jugar(fila, columna);

        //verificar que la ficha del J2 se ha colocado en la primera casilla
        Assertions.assertEquals('O', joc.getTaulell()[fila][columna]);
    }
    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2" , "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugadaGuanyador_tableroEnBlanco(int n1, int n2){
        Joc joc = new Joc();
        joc.novaPartida();
        assertFalse(joc.jugadaGuanyador(n1, n2)); //verifica que devuelva un false
    }
    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "0,2" , "1,0", "1,1", "1,2", "2,0", "2,1", "2,2"})
    void jugadaGuanyador_tableroUnaCasilla(int n1, int n2){
        Joc joc = new Joc();

        Random r = new Random();
        int j1 = r.nextInt(3);
        int j2 = r.nextInt(3);
        joc.novaPartida();
        //realizar la jugada
        joc.jugar(j1, j2);
        //Comprueba
        assertFalse(joc.jugadaGuanyador(n1, n2));
        //verificar que la ficha se ha colocado en la primera casilla
        assertFalse(joc.jugadaGuanyador(n1,n2));
    }
    @org.junit.jupiter.api.Test
    void jugadaGuanyador_tableroJugadaGuanyadoraJ1(){
        Joc joc = new Joc();
        joc.novaPartida();
        //realizar la jugada de J1
        joc.jugar(0, 0);
        //realizar la jugada de J2
        joc.jugar(2, 0);
        //realizar la jugada de J1
        joc.jugar(0, 1);
        //realizar la jugada de J2
        joc.jugar(2, 1);
        //realizar la jugada de J1
        joc.jugar(0, 2);
        //Comprueba
        assertTrue(joc.jugadaGuanyador(0, 2));
    }
    @org.junit.jupiter.api.Test
    void jugadaGuanyador_tableroJugadaGuanyadoraJ2(){
        Joc joc = new Joc();
        joc.novaPartida();
        //realizar la jugada de J1
        joc.jugar(0, 1);
        //realizar la jugada de J2
        joc.jugar(0, 0);
        //realizar la jugada de J1
        joc.jugar(0, 2);
        //realizar la jugada de J2
        joc.jugar(1, 1);
        //realizar la jugada de J1
        joc.jugar(1, 0);
        //realizar la jugada de J2
        joc.jugar(2, 2);
        //Comprueba
        assertTrue(joc.jugadaGuanyador(2, 2));
    }
    @Test
    public void guardarPartida() throws IOException {
        Joc joc = new Joc(); //Instancia la clase
        String nombredirectorio = "savedgame"; //Variable del nombre del directorio
        File directorio = new File(nombredirectorio); //Instancia la clase
        if(directorio.isDirectory()) { //Mira si el directorio existe
        File[] archivos = directorio.listFiles(); //Crea un array de archivos
            if(archivos != null){ //Si el array no esta vacio
                for(File archivo : archivos){ //recorre el array 1 por 1
                    archivo.delete(); //elimina el archivo
                }
            }
        }
        directorio.delete(); //elimina el directorio
        joc.guardarPartida(); //Llama al metodo para crear el guardado (direcorio y archivo.txt)
        assertTrue(directorio.exists()); //comprueba que el directorio existe, no comprueba que exista el archvio ya que este se genera con un nombre diferente cada vez.
    }
    @Test
    void archivoGenerado() {
        Joc joc = new Joc();
        joc.guardarConfiguracion(5); // Guardar una configuración con un tamaño de 5x5
        // Verificar que el archivo de configuración se ha generado en el directorio correcto
        File archivo = new File(Joc.config_directorio, Joc.config_file);
        Assertions.assertTrue(archivo.exists());
        // Eliminar el archivo después de la prueba para mantener limpio el entorno de pruebas
        archivo.delete();
    }

    @Test
    void archivoNoGenerado() {
        // Probar el caso en que el directorio de configuración no existe
        Joc joc = new Joc();
        File directorio = new File(Joc.config_directorio);
        directorio.delete(); // Eliminar el directorio de configuración antes de guardar la configuración
        joc.guardarConfiguracion(5); // Guardar una configuración con un tamaño de 5x5
        // Verificar que el archivo de configuración no se ha generado
        File archivo = new File(Joc.config_directorio, Joc.config_file);
        Assertions.assertTrue(archivo.exists());
    }

    @Test
    void contenidoCorrecto() {
        Joc joc = new Joc();
        int novaMida = 7;
        joc.guardarConfiguracion(novaMida); // Guardar una configuración con un tamaño de 7x7
        // Verificar que el contenido del archivo de configuración es correcto
        int tamanoLeido = 0;
        try (Scanner scanner = new Scanner(new File(Joc.config_directorio, Joc.config_file))) {
            tamanoLeido = scanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(novaMida, tamanoLeido);
        // Eliminar el archivo después de la prueba para mantener limpio el entorno de pruebas
        File archivo = new File(Joc.config_directorio, Joc.config_file);
        archivo.delete();
    }

}