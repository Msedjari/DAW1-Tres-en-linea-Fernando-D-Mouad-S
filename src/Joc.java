import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Joc {
    private  short torn;

    private char [][] taulell;

    public char[][] getTaulell() {
        return taulell;
    }

    public short getTorn() {
        return torn;
    }

    public void novaPartida(){
        torn = 1;
        char[][] taulellGenerat = new char[3][3];
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                taulellGenerat[i][j] = '_';
            }
        }
        taulell = taulellGenerat;
    }
    public void jugar(short fila,String columna){
        char ficha = (torn == 1) ? 'X' : 'O' ;
        taulell[fila][Integer.parseInt(columna)] =  ficha; //indicar la fila y la columna donde se colocara la fitcha
        torn = (short) ((torn == 1) ? 2 : 1); //pasar al siguente turno
    }
    public boolean jugadaGuanyador(short fila,String columna){
        throw new NotImplementedException();
    }

}
