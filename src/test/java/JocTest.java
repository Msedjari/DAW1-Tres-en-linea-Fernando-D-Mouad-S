import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

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

        char[][] taulellTest = new char[3][3];
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                taulellTest[i][j] = '_';
            }
        }

        String taulellTestS = Arrays.deepToString(taulellTest);
        String taulellS = Arrays.deepToString(joc.getTaulell());

        Assertions.assertEquals(taulellTestS, taulellS);

    }

    @ParameterizedTest
    @CsvSource({"0,0" , "0,1" , "0,2" ,"1,0" , "1,1" , "1,2" ,"2,0" , "2,1" , "2,2"  })
    void jugar_1(short fila,int columna) {

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
    @org.junit.jupiter.api.Test
    public void guardarPartida() throws IOException {
        Joc joc = new Joc(); //Instancia la clase
        String nombredirectorio = "savedgame"; //Variable del nombre del directorio
        File directorio = new File(nombredirectorio); //Instancia la clase
        if(directorio.isDirectory()) { //Mira si el directorio existe
        File[] archivos = directorio.listFiles(); //Crea un array de archivos
            if(archivos != null){ //Si el array no esta vacio
                for(File archivo : archivos){ //Recorre el array 1 por 1
                    archivo.delete(); //Elimina el archivo
                }
            }
        }
        directorio.delete(); //Elimina el directorio
        joc.novaPartida(); // Lanza la partida
        //realizar la jugada de J1
        joc.jugar(0, 0);
        joc.guardarPartida(); //Llama al metodo para crear el guardado (direcorio y archivo.txt)
        assertTrue(directorio.exists()); //comprueba que el directorio existe
        File[] archivosCreadosAntes = directorio.listFiles(); //Crea un array de archivos.
        joc.guardarPartida(); //Llama al metodo para crear el guardado (direcorio y archivo.txt)
        File[] archivosCreadosDespues = directorio.listFiles(); //Crea un array de archivos.
        assertTrue(archivosCreadosAntes.length < archivosCreadosDespues.length); //Compara el array de antes de llamar a guarado con el de despues de llamar a guardado.
    }
    @org.junit.jupiter.api.Test
    public void cargarPartida() throws IOException {
        Joc joc1 = new Joc(); //Instancia la clase joc1
        joc1.novaPartida(); // Lanza la partida
        joc1.jugar(0, 0);//realizar la jugada de J1
        joc1.guardarPartida(); //Llama al metodo para crear el guardado (direcorio y archivo.txt)
        String nombredirectorio = "savedgame"; //Variable del nombre del directorio
        File directorio = new File(nombredirectorio); //Instancia la clase
        File[] archivos = directorio.listFiles(); //Crea un array de archivos
        assert archivos != null;
        int i = archivos.length -1;
        Joc joc2 = new Joc(); //Instancia la clase joc2
        joc2.cargarTurnoPartidaGuardada(i); //Llama al metodo para cargar el turno
        assertEquals(joc1.getTorn(),joc2.getTorn());//compruba que el torn guardado de joc1 es igual al torn cargado en joc2
        joc2.cargarTaulellPartidaGuardada(i); //Llama al metodo para cargar el tablero
        assertEquals(joc1.getTaulell(), joc2.getTaulell());//compruba que el tablero guardado de joc1 es igual al tablero cargado en joc2
    }


}