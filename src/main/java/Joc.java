import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Joc {
    private  int torn;

    private char [][] taulell;

    public char[][] getTaulell() {
        return taulell;
    }

    public int getTorn() {
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
    public void jugar(int fila,int columna){
        char ficha = (torn == 1) ? 'X' : 'O' ;
        taulell[fila][columna] =  ficha; //indicar la fila y la columna donde se colocara la fitcha
        torn = (short) ((torn == 1) ? 2 : 1); //pasar al siguente turno
    }
    public boolean jugadaGuanyador(int fila,int columna){

        throw new NotImplementedException();
    }

}
