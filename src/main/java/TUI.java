import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Scanner;
public class TUI {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenuPrincipal() {
        System.out.println("Elige una opcion:");
        System.out.println("1.Nueva partida");
        System.out.println("2.Cargar partida");
        System.out.println("3.Configuracion");
        System.out.println("4.Salir");

        return sc.nextInt();
    }
    public int mostrarMenuConfiguracion(){
        System.out.println("Elige una opcion:");
        System.out.println("1.Mida tablero");
        System.out.println("2.Volver atras");

        return sc.nextInt();
    }
    public void sinImplementar(){
        System.out.println("Opcion pendiente de programar");
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
    public int[] recollirJugada(int torn){ //No Valido
        //almacenar las cordenadas de la jugada
        int[] jugada = new int[2];
        //verificar si la jugada es valida
        boolean jugadaValida = false;

        while (!jugadaValida) {
            System.out.println("Jugador " + torn + ", introduce la limitefila y limitecolumna de tu jugada:");
            //leer la limitefila ingresada por el jugador
            jugada[0] = sc.nextInt();
            //leer la limitecolumna ingresada por  el jugador
            jugada[1] = sc.nextInt();

            // Verificar si la jugada es válida
            if (jugada[0] >= 0 && jugada[0] < 3 && jugada[1] >= 0 && jugada[1] < 3) {
                jugadaValida = true;
            } else {
                System.out.println("Jugada inválida. Inténtalo de nuevo.");
            }
        }
        return jugada;
    }
    public void fiDePartida(int guanyador){
        throw new NotImplementedException();
    }
}


