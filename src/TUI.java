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
    public void mostrarTaulell(char[] taulell, short torn){
        throw new NotImplementedException();
    }
    public short[] recollirJugada(){
        throw new NotImplementedException();
    }
    public void fiDePartida(short guanyador){
        throw new NotImplementedException();
    }
}


