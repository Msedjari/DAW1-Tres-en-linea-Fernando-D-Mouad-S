import jdk.jshell.spi.ExecutionControl;

public class Joc {

    private char [][] tablero;

    public char[][] getTablero() {
        return tablero;
    }

    public short getTorn() {
        return torn;
    }

    private short torn;

    public void novaPartida(){
        throw new ExecutionControl.NotImplementedException();
    }
    public void jugar(){


    }
    public boolean jugadaGuanyador(){

    }




}
