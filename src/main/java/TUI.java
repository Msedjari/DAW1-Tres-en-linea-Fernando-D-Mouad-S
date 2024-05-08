import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Scanner;
public class TUI {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("Elige una opcion:");
        System.out.println("1.Nueva partida");
        System.out.println("2.Cargar partida");
        System.out.println("3.Configuracion");
        System.out.println("4.Salir");

        return sc.nextInt();
    }
    public void mostrarTaulell(char[][] taulell, int torn){
        System.out.println("Torn: Jugador " + torn);
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(taulell[i][j] + " ");
            }
            System.out.println(" ");
        }

    }
    public int[] recollirJugada(char[][] taulell,int torn , short fila, int columna){
        //almacenar las cordenadas de la jugada
        int[] jugada = new int[2];
        jugada[0]= fila;
        jugada[1]= columna;
        //verificar si la jugada es valida
        boolean jugadaValida = false;

        while (!jugadaValida) {
            System.out.println("Jugador " + torn + ", introduce la fila y columna de tu jugada:");
            //leer la fila ingresada por el jugador
            jugada[0] = sc.nextInt();
            //leer la columna ingresada por  el jugador
            jugada[1] = sc.nextInt();

            // Verificar si la jugada es válida
            if (jugada[0] >= 0 && jugada[0] < 3 && jugada[1] >= 0 && jugada[1] < 3 && taulell[jugada[0]][jugada[1]] == '_') {
                jugadaValida = true;
            } else {
                System.out.println("Jugada inválida. Inténtalo de nuevo.");
            }
        }

        // Marcar la casilla con el símbolo del jugador
        taulell[jugada[0]][jugada[1]] = (torn == 1) ? 'X' : 'O';

        // Cambiar turno al siguiente jugador
        torn = (torn == 1) ? 2 : 1;

        return jugada;
    }
    public void fiDePartida(int guanyador){
        throw new NotImplementedException();
    }
}


