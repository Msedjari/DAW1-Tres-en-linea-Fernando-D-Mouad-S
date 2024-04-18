import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int entradaUsaurio = sc.nextInt();
        switch (entradaUsaurio) {
            case 1:
                System.out.println("1.Nueva Prtida");
                break;
            case 2:
                System.out.println("2.Cargar partida");
                break;
            case 3:
                System.out.println("3.Configuracion");
                break;
            case 4:
                System.out.println("4.Salir");
            default:


        }
    }
}