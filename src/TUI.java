import java.util.Scanner;

public class TUI {
    private static Scanner sc;

    public TUI() {
        sc = new Scanner(System.in);
    }

    public TUI(Scanner sc) {
        this.sc = sc;
    }

    public void start() {
       lanzarMenu();
    }
    private static void salir() {
        System.out.println("Saliendo del programa. ¡Hasta luego!");
        System.exit(0);
    }
    private static void nuevaPartida(){
        System.out.println("Iniciando nueva partida...");
    }

    private static void cargarPartida(){
        System.out.println("Cargando partida...");

    }
    private static void configuracion(){
        System.out.println("Accediendo a la configuración...");
    }
    private static void lanzarMenu() {
        System.out.println("Elige una opcion:");
        System.out.println("1.Nueva partida");
        System.out.println("2.Cargar partida");
        System.out.println("3.Configuracion");
        System.out.println("4.Salir");

        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                System.out.println("Ha seleccionado: Nueva partida");
                nuevaPartida();
                break;
            case 2:
                System.out.println("Ha seleccionado: Cargar partida");
                cargarPartida();
                break;
            case 3:
                System.out.println("Ha seleccionado :Configuracion");
                configuracion();
                break;
            case 4:
                System.out.println("Ha seleccionado: Salir");
                salir();
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
                break;
        }
    }


}


