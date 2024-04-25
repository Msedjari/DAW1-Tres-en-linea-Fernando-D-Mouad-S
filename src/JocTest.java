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
    }
}