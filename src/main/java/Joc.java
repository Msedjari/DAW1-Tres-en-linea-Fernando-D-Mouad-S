import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                    lleno = true;
                    break;
                }
            }
        }
        return lleno;
    }
    public void guardarPartida() throws IOException {
        LocalDate fecha = LocalDate.now();
        LocalTime hora = LocalTime.now().withNano(0); //elimina nanosegundos
        DateTimeFormatter horaFormateada = DateTimeFormatter.ofPattern("HHmmss");
        //crea el directorio si no existe
        String nombredirectorio = "savedgame";
        File directorio = new File(nombredirectorio);
        if (!directorio.exists()){
            directorio.mkdir();
        }
        //crea el archivo de guarado
        String archivoNombre = String.format(nombredirectorio + "/%s_%s.txt", fecha, hora.format(horaFormateada));
        FileWriter saved = new FileWriter(archivoNombre); //Crea el archivo
        saved.write(torn + System.lineSeparator()); //Guarda el turno y añade una nueva linea
        for (char[] fila : taulell) { //Guarda el tablero (contenido de la matriz)
            saved.write(new String(fila) + System.lineSeparator());
        }
        saved.close();
    }

    public String[] verPartidasGuardadas(){
        String nombredirectorio = "savedgame";
        File directorio = new File(nombredirectorio);
        if (!directorio.exists() || !directorio.isDirectory() || !directorio.canRead()) { //Comprueba que el directorio exista y se puede leer
            return new String[0]; // Retorna un array vacío si el directorio no existe o no es legible
        }
        File[] partidasGuardadas = directorio.listFiles();
        if(partidasGuardadas != null){ //Comprueba que el array no este vacio
            String[] nombresArchivos = new String[partidasGuardadas.length];
            for (int i = 0; i < partidasGuardadas.length; i++){ //Recorre el array
                nombresArchivos[i] = partidasGuardadas[i].getName(); //Guarda los nombres en el array
            }
            return nombresArchivos;
        }else{
            return new String[0]; //Retorna un array vacío si no existen archivos
        }
    }

    public int cargarTurnoPartidaGuardada(int archivo) throws FileNotFoundException {
        String nombredirectorio = "savedgame";
        File directorio = new File(nombredirectorio);
        File[] partidasGuardadas = directorio.listFiles(); //Crea un array con todos los archivos
        if (partidasGuardadas != null) { //Mira que el array no este vacia
            File partidasGuardada = partidasGuardadas[archivo-1];
            Scanner leerPartida = new Scanner(partidasGuardada);
            torn = leerPartida.nextInt();
        }
        return torn;
    }

    public char[][] cargarTaulellPartidaGuardada(int archivo) throws FileNotFoundException {
        String nombredirectorio = "savedgame";
        File directorio = new File(nombredirectorio);
        File[] partidasGuardadas = directorio.listFiles(); //Crea un array con todos los archivos
        if (partidasGuardadas != null) { //Mira que el array no este vacia
            File partidasGuardada = partidasGuardadas[archivo-1];
            Scanner leerPartida = new Scanner(partidasGuardada);
            leerPartida.nextLine(); //La la primera linea y la ignora
            List<char[]> tableroList = new ArrayList<>(); // Lee el tablero línea por línea y lo convierte en char[][]
            while (leerPartida.hasNextLine()){
            String linea = leerPartida.nextLine();
                tableroList.add(linea.toCharArray());
            }
            char[][] taulellGuardado = new char[tableroList.size()][]; // Convierte la lista de char[] en un char[][]
            for (int i = 0; i < tableroList.size(); i++) {
                taulellGuardado[i] = tableroList.get(i);
            }
            taulell = taulellGuardado;
            return taulell;
        }else {
            return null;
        }
    }
}
