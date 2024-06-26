import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        start();

    }
    private static void start() throws IOException {
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
    private static void novaPartida() throws IOException {
        Joc joc = new Joc();
        TUI tui = new TUI();
        while (true) {
            boolean ganador;
            boolean empate;
            joc.novaPartida();
            while (true){
                tui.mostrarTaulell(joc.getTaulell());
                int[] jugada = tui.recollirJugada(joc.getTorn());
                if (jugada[0] == -2 && jugada[1] == -2){ ////Para guardar partida, -2 por como lee el metodo la entrada de datos.
                    joc.guardarPartida();
                    tui.seGuarda();
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
    private static void carregarPartida() throws IOException {
        Joc joc = new Joc();
        TUI tui = new TUI();
        tui.mostrarPartidasGuardadas(joc.verPartidasGuardadas());
        tui.seleccionaUnaPartida();
        int partidaSeleccionada = tui.partidaParaCargar();
        if (partidaSeleccionada == -1){ // Para volver atras si no quieres cargar ninguna partida
            start();
        }
        joc.cargarTurnoPartidaGuardada(partidaSeleccionada);
        joc.cargarTaulellPartidaGuardada(partidaSeleccionada);
        tui.mostrarSeCarga();
        while (true) {
            boolean ganador;
            boolean empate;
            while (true){
                tui.mostrarTaulell(joc.getTaulell());
                int[] jugada = tui.recollirJugada(joc.getTorn());
                if (jugada[0] == -2 && jugada[1] == -2){ //Para guardar partida, -2 por como lee el metodo la entrada de datos.
                    joc.guardarPartida();
                    tui.seGuarda();
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
    private static void configuracio() throws IOException {
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