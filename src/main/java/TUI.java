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
    public int[] recollirJugada(){
        throw new NotImplementedException();
    }
    public void fiDePartida(int guanyador){
        throw new NotImplementedException();
    }
}


