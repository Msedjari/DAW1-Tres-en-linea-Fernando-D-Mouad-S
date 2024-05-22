import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Joc {
    private  int torn;

    private char [][] taulell;

    public int getNovaMida() {
        return novaMida;
    }

    int novaMida;

    public char[][] getTaulell() {
        return taulell;
    }

    public int getTorn() {
        return torn;
    }

    public static final String CONFIG_DIR = "config";
    public static  final String CONFIG_FILE = "configuracion.txt";

    public void novaPartida(){
        int novaMida =3;
        try {
            //para leer el fichero
            Scanner sc = new Scanner(new File("configuracion.txt"));
            //leer la variable
            novaMida= sc.nextInt();
        }
        //excepcion
        catch (Exception var2) {
        }
        torn = 1;// Inicializa el turno a 1
        char[][] taulellGenerat = new char[novaMida][novaMida];// Inicializa el tablero con el nuevo tamaño
        // Inicializa el tablero con casillas vacías
        for(int i = 0; i < novaMida; i++) {
            for (int j = 0; j < novaMida; j++) {
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

    // Método para guardar la configuración del tamaño del tablero
    public void guardarConfiguracion(int novaMida) {
        this.novaMida = novaMida;
        File file = new File(CONFIG_DIR, CONFIG_FILE);
        // Crea el directorio si no existe
        File dir = new File(CONFIG_DIR);
        if (!dir.exists()) {
            dir.mkdir();
        }
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(String.valueOf(novaMida)); // Escribe el tamaño en el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean jugadaGuanyador(int fila,int columna){

        char ficha = (torn == 2) ? 'X' : 'O' ;
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
        return fila + columna == 2 && taulell[0][2] == ficha && taulell[1][1] == ficha && taulell[2][0] == ficha;// Diagonal secundaria

    }
    public boolean jugadaEmpate(int fila,int columna){
        // Comprueba si todas las casillas estan llenas (Empate)
        boolean lleno = false;
        for(int i = 0; i < taulell.length; i++) {
            for (int j = 0; j < taulell.length; j++) {
                if(taulell[i][j] == '_'){
                    lleno = true;// Si hay al menos una casilla vacía, no hay empate
                    break;
                }
            }
        }
        return lleno;// Si todas las casillas están ocupadas, hay empate
    }

}
