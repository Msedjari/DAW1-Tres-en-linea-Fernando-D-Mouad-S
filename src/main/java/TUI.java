import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.FileWriter;
import java.util.Scanner;
public class TUI {
    private Scanner sc = new Scanner(System.in);

    public int validacionCaracter() {
        int caracterValido = 0;
        if (sc.hasNextInt()){ //comporueba que el valor sea un numero
           caracterValido = sc.nextInt(); //Le el numero del usuario
        }else{
            String entradaInvalida = sc.next(); //Le el valor no valido
            System.out.println("Caracter: " + entradaInvalida + " no valido, introduce un numero");
            caracterValido = validacionCaracter(); //hace que vuelva a llamar al metodo !RECURSIVIDAD!
        }
        return caracterValido;
    }

    public int mostrarMenuPrincipal() {
        System.out.println("Elige una opcion:");
        System.out.println("1.Nueva partida");
        System.out.println("2.Cargar partida");
        System.out.println("3.Configuracion");
        System.out.println("4.Salir");

        return validacionCaracter();
    }
    public int mostrarMenuConfiguracion(){
        System.out.println("Elige una opcion:");
        System.out.println("1.Mida tablero");
        System.out.println("2.Volver atras");

        return validacionCaracter();
    }
    public void modificarMidaTaulell() {
        System.out.println("Introdueix la nova mida del taulell entre 3 i 10:");
        int novaMida = validacionCaracter();
        // verificar si no se ha introducido un numero entre 3 y 10 se vuelve a imprimir
        while (novaMida < 3 || novaMida > 10) {
            System.out.println("Entre 3 y 10.");
            novaMida = validacionCaracter();
        }

        try {
            //crear un  File que representa el nuevo archivo llamado configuracion.txt
            FileWriter myWriter = new FileWriter("configuracion.txt");
            // guardar la variable  dentro del fichero
            myWriter.write(String.valueOf(novaMida));
            // cerrar el writer
            myWriter.close();
            System.out.println("Configuración guardada correctamente");
        } catch (Exception e) {
            System.out.println("se ha ocurrido un error al guardar la jugada ");
            //excepcion
        }
    }

    //en joc

    public void mostrarTaulell(char[][] taulell){

        //poner taulell.length para que imprima  el tablero
        for(int i = 0; i < taulell.length; i++) {
            for (int j = 0; j < taulell.length; j++) {
                System.out.print(taulell[i][j] + " ");
            }
            System.out.println(" ");
        }

    }
    public int[] recollirJugada(int torn){
        //almacenar las cordenadas de la jugada
        int[] jugada = new int[2];
        //verificar si la jugada es valida
        boolean jugadaValida = false;

        while (!jugadaValida) {
            System.out.println("Jugador " + torn + ", introduce tu jugada:");
            //leer la limitefila ingresada por el jugador
            System.out.println("Introduce la fila:");

            int fila = validacionCaracter(); //Lee el numero
            jugada[0] = fila - 1; //elimina 1 al caracter para que ser amigable con el usaurio: 0 = 1.
            System.out.println("Introduce la columna:");

            int columna = validacionCaracter(); //Lee el numero
            jugada[1] = columna - 1; //elimina 1 al caracter para que ser amigable con el usaurio: 0 = 1.

            // Verificar si la jugada es válida
            if (jugada[0] >= 0 && jugada[0] < 3 && jugada[1] >= 0 && jugada[1] < 3) {
                jugadaValida = true;
            } else if (jugada[0] == -2 && jugada[1] == -2) { // -2 por el factor -1 implementado arriba
                jugadaValida = true; //Opcion para guardar partida

            } else {
                System.out.println("Jugada inválida. Inténtalo de nuevo.");
            }
        }
        return jugada;
    }
    public void fiDePartidaEmpate(){
        System.out.println(" ");
        System.out.println("Fin! Empate");
        System.out.println(" ");
    }
    public void fiDePartida(int guanyador){
        //Como creo que deveria ser, muestra quien gana:
        // System.out.println("Fin! Ha ganado el Jugador: " + guanyador);

        //Trampeando TUI
        if(guanyador == 1) {
            System.out.println(" ");
            System.out.println("Fin! Ha ganado el Jugador: 2");
            System.out.println(" ");
        }else {
            System.out.println(" ");
            System.out.println("Fin! Ha ganado el Jugador: 1");
            System.out.println(" ");
        }
    }
    public void seGuarda(){
            System.out.println("Guardando...");
            System.out.println("Se ha guardado el archivo");
            System.out.println(" ");
    }

    public void mostrarSeCarga(){
        System.out.println("Cargando...");
        System.out.println("Se ha cargado el archivo");
        System.out.println(" ");
    }
}


