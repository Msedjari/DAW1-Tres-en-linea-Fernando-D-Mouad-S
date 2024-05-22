import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Main {
    public static void main(String[] args) {
        start(); //inicia el programa

    }
    private static void start(){
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
                    start();
                    break;
            }
        }while(select);
    }
    private static void novaPartida(){
        Joc joc = new Joc();
        TUI tui = new TUI();
        while (true) {

            boolean ganador;
            boolean empate;
            joc.novaPartida();
            while (true){
                tui.mostrarTaulell(joc.getTaulell());
                int[] jugada = tui.recollirJugada(joc.getTorn());
                if (jugada[0] == -2 && jugada[1] == -2){ //-2 por como lee el metodo la entrada de datos.
                    start();
                }
                joc.jugar(jugada[0], jugada[1]);
                ganador = joc.jugadaGuanyador(jugada[0], jugada[1]);
                empate = joc.jugadaEmpate(jugada[0], jugada[1]);
                if (ganador || !empate){
                    break;
                }
            }
            tui.mostrarTaulell(joc.getTaulell());
            if (ganador) {
                tui.fiDePartida(joc.getTorn());
            } else {
                tui.fiDePartidaEmpate();
            };
            start();
        }
    }
    private static void carregarPartida(){
        throw new NotImplementedException();
    }
    private static void configuracio(){
        TUI tui = new TUI();
        Joc joc = new Joc();
        int opcionC = tui.mostrarMenuConfiguracion();

        switch (opcionC) {
            case 1:

                tui.modificarMidaTaulell();
                break;
            case 2:
                tui.mostrarMenuPrincipal();
                break;
            default:
                tui.mostrarMenuConfiguracion();
                break;
        }
        boolean select = true;
        do{
            int opcion = tui.mostrarMenuConfiguracion();
            switch (opcion) {
                case 1:
                    tui.modificarMidaTaulell();
                    joc.guardarConfiguracion(joc.novaMida);
                    select = false;
                    break;
                case 2:
                    start();
                    select = false;
                    break;
                default:
                    configuracio();
                    break;
            }
        }while(select);
    }
    private static void sortir(){
        System.exit(0);
        throw new NotImplementedException();
    }
}