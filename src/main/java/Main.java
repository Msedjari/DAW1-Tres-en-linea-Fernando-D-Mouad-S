import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Main {
    public static void main(String[] args) {
        TUI tui = new TUI();
        boolean select = true;
        do{
        int opcion = tui.mostrarMenuPrincipal();
            switch (opcion) {
                case 1:
                    novaPartida();
                    select = false;
                    break;
                case 2:
                    carregarPartida();
                    select = false;
                    break;
                case 3:
                    configuracio();
                    select = false;
                    break;
                case 4:
                    sortir();
                    select = false;
                    break;
                default:
                    tui.mostrarMenuPrincipal();
                    break;
            }
        }while(select);
    }
    private static void novaPartida(){
        Joc joc = new Joc();
        TUI tui = new TUI();

        joc.novaPartida();

        tui.mostrarTaulell(joc.getTaulell(), joc.getTorn());
        int [] jugada = tui.recollirJugada(joc.getTorn());
        joc.jugar(jugada[0],jugada[1]);
        joc.jugadaGuanyador(jugada[0],jugada[1]);

    }
    private static void carregarPartida(){
        throw new NotImplementedException();
    }
    private static void configuracio(){
        TUI tui = new TUI();
        int opcionC = tui.mostrarMenuConfiguracion();

        switch (opcionC) {
            case 1:
                tui.sinImplementar();
                break;
            case 2:
                tui.mostrarMenuPrincipal();
                break;
            default:
                tui.mostrarMenuConfiguracion();
                break;
        }
    }
    private static void sortir(){
        System.exit(0);
        throw new NotImplementedException();
    }
}