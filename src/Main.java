import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1.Nueva partida");
            System.out.println("2.Cargar partida");
            System.out.println("3.Configuracion");
            System.out.println("4.Salir");


            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ha seleccionado: Nueva partida");
                    break;
                case 2:
                    System.out.println("Ha seleccionado: Cargar partida");
                    break;
                case 3:
                    System.out.println("Ha seleccionado :Configuracion");
                    break;
                case 4:
                    System.out.println("Ha seleccionado: Salir");
                    salir();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
                    break;
            }
            System.out.println();
        } while (true);
    }

    private static void salir() {
        System.exit(0);
    }
    private static void nuevaPartida(){
    }
    private static void cargarPartida(){

    }
    private static void configuracion(){

    }
    private static void opcionEscogida(){

    }
}