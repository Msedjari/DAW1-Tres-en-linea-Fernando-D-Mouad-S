import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Joc {

    private char [][] taullel;

    public char[][] getTablero() {
        return taullel;
    }

    public short getTorn() {
        return torn;
    }

    private short torn;

    public void novaPartida(){
        throw new NotImplementedException();
    }
    public void jugar(short fila,String columna){
        throw new NotImplementedException();
    }
    public boolean jugadaGuanyador(short fila,String columna){
        throw new NotImplementedException();

    }

}
