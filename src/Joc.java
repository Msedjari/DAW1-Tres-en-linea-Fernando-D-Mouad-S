import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Joc {
    private  short torn;

    private char [][] taullel;

    public char[][] getTaullel() {
        return taullel;
    }

    public short getTorn() {
        return torn;
    }

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
