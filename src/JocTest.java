import org.junit.jupiter.api.Assertions;

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
    }

    @org.junit.jupiter.api.Test
    void jugar() {

        Joc joc = new Joc();
        joc.novaPartida();

   //verificar que la casilla esta vacia antes de jugar
        assertEquals(' ',joc.getTaullel()[0][0]);


    //realizar la jugada
        joc.jugar((short) 0, "X");


   //verificar que la ficha se ha colocado en la primera casilla
        assertEquals(' ',joc.getTaullel()[0][0]);

    }
}