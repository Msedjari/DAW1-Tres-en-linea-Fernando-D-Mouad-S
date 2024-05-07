import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

// PARA PRUEBAS CON PARAMETROS
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;

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
        Assertions.assertEquals('_',joc.getTaulell()[0][0]);

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

        //realizar la jugada
        joc.jugar(fila,columna);

        //verificar que la ficha se ha colocado en la primera casilla
        Assertions.assertEquals('O',joc.getTaulell()[fila][columna]);
    }
    @org.junit.jupiter.api.Test
    void jugadaGuanyador(){
        Joc joc = new Joc();

        Assertions.assertEquals(false, joc.jugadaGuanyador( 0,0));
    }


}