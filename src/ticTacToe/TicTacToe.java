package ticTacToe;

// turno aleatorio incial
// nombre de jugadores y referirse a ellos por nombre
// jugador automático (aleatorio)
// jugar más partidas con ContinuarController
// refactorizar PonerController y MoverController
// Tablero basado en Coordenadas, no en caracteres
// Desacoplar Coordenada de TresEnRaya con clase hija
// X y O no pueden ser parte del modelo, sería vista, y no es operativo!

import ticTacToe.models.Tablero;
import ticTacToe.models.Turno;
import ticTacToe.views.TableroView;
import ticTacToe.views.TurnoView;
import ticTacToe.controllers.AbrirController;
import ticTacToe.controllers.MoverController;
import ticTacToe.controllers.PonerController;

class TicTacToe {

    private Tablero tablero = new Tablero();
    private Turno turno = new Turno();
    private TableroView tableroView = new TableroView(tablero);
    private TurnoView turnoView = new TurnoView(turno);
    private AbrirController abrirController = new AbrirController(tablero, tableroView);
    private PonerController ponerController = new PonerController(tablero, tableroView, turno, turnoView);
    private MoverController moverController = new MoverController(tablero, tableroView, turno, turnoView);

    public void jugar() {
        abrirController.controlar();
        boolean victoria;
        do {
            if (!tablero.completo()) {
                ponerController.controlar();
            } else {
                moverController.controlar();
            }
            victoria = tablero.hayTER(turno.noToca());
            if (!victoria) {
                turno.cambiar();
            }
        } while (!victoria);
        turnoView.victoria();
        
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.jugar();
    }
}
