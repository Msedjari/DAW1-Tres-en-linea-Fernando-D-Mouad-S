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
        char ficha = (torn == 1) ? 'X' : 'O' ; // Selecciona la ficha segun el turno 1 = X, 2 = O
        taulell[fila][columna] =  ficha; //indicar la fila y la columna donde se colocara la fitcha
        torn = ((torn == 1) ? 2 : 1); //pasar al siguente turno
    }
    public boolean jugadaGuanyador(int fila,int columna){

        char ficha = (torn == 1) ? 'X' : 'O' ;
        // Verificar si hay una línea ganadora en la fila actual
        if (taulell[fila][0] == ficha && taulell[fila][1] == ficha && taulell[fila][2] == ficha) {
            return true; // Línea horizontal
        }
        // Verificar si hay una línea ganadora en la columna actual
        if (taulell[0][columna] == ficha && taulell[1][columna] == ficha && taulell[2][columna] == ficha) {
            return true; // Línea vertical
        }
        // Verificar si hay una línea ganadora en la diagonal
        if (fila == columna && taulell[0][0] == ficha && taulell[1][1] == ficha && taulell[2][2] == ficha) {
            return true; // Diagonal principal
        }
        // Verificar si hay una línea ganadora en la diagonal inversa
        return fila + columna == 2 && taulell[0][2] == ficha && taulell[1][1] == ficha && taulell[2][0] == ficha; // Diagonal secundaria

    }

}
