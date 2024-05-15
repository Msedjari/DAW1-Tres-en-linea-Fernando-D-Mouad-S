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
                if (jugada[0] == -2 && jugada[1] == -2){ //-2 por como lee el metodo la entrada de datos.
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
    private static void carregarPartida(){
        throw new NotImplementedException();
    }
    private static void configuracio() throws IOException {
        TUI tui = new TUI();
        boolean select = true;
        do{
            int opcion = tui.mostrarMenuConfiguracion();
            switch (opcion) {
                case 1:
                    tui.modificarMidaTaulell();
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