import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Main {
    public static void main(String[] args) {
        TUI tui = new TUI();
        int opcion = tui.mostrarMenu();

        switch (opcion) {
            case 1:
                novaPartida();
                break;
            case 2:
                carregarPartida();
                break;
            case 3:
                configuracio();
                break;
            case 4:
                sortir();
                break;
            default:
                tui.mostrarMenu();
                break;
        }
    }
    private static void novaPartida(){
        Joc joc = new Joc();
        TUI tui = new TUI();
        joc.novaPartida();
        tui.mostrarTaulell(joc.getTaulell(), joc.getTorn());
    }
    private static void carregarPartida(){
        throw new NotImplementedException();
    }
    private static void configuracio(){
        throw new NotImplementedException();
    }
    private static void sortir(){
        System.exit(0);
        throw new NotImplementedException();
    }
}