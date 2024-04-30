import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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

    @org.junit.jupiter.api.Test
    void jugar() {

        Joc joc = new Joc();
        joc.novaPartida();

   //verificar que la casilla esta vacia antes de jugar
        assertEquals('_',joc.getTaulell()[0][0]);

    //realizar la jugada
        joc.jugar((short) 0, "0");

   //verificar que la ficha se ha colocado en la primera casilla
        assertEquals('X',joc.getTaulell()[0][0]);

    }
}