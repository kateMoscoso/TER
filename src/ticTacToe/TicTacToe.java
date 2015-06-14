package ticTacToe;

// turno aleatorio incial
// nombre de jugadores y referirse a ellos por nombre
// jugador automático (aleatorio)
// jugar más partidas con ContinuarController
// refactorizar PonerController y MoverController
// Tablero basado en Coordenadas, no en caracteres
// Desacoplar Coordenada de TresEnRaya con clase hija
// X y O no pueden ser parte del modelo, sería vista, y no es operativo!

import ticTacToe.models.Jugador;
import ticTacToe.models.Tablero;
import ticTacToe.models.Turno;
import ticTacToe.views.TableroView;
import ticTacToe.views.TurnoView;
import ticTacToe.controllers.AbrirController;
import ticTacToe.controllers.ContinuarController;
import ticTacToe.controllers.JugadorController;
import ticTacToe.controllers.MoverController;
import ticTacToe.controllers.PonerController;

class TicTacToe {

    private Tablero tablero = new Tablero();
    private Turno turno = new Turno();
    private TableroView tableroView = new TableroView(tablero);
    private TurnoView turnoView = new TurnoView(turno);
  //  private Jugador[] jugador  = new Jugador[2]; 
  //private AbrirController abrirController = new AbrirController(tablero,ponerControllers);
    private AbrirController abrirController = new AbrirController(tablero,tableroView);
    private ContinuarController nuevaPartidaController = new ContinuarController(tablero, tableroView);
    private JugadorController [] jugadores = new JugadorController[2];
    private PonerController ponerController[] = new PonerController[2];
    //private MoverController moverController = new MoverController(tablero, tableroView, turno, turnoView);
    private MoverController moverController[] = new MoverController[2];
    public void jugar() {
    	 boolean victoria;
    	jugadores[0] = new JugadorController(tablero, turno);
    	jugadores[0].inicializar();
    	jugadores[1] = new JugadorController(tablero, turno);
    	jugadores[1].inicializarJugadorAutomatico();
    	 do {
    		 tablero.vaciar();
    	ponerController[0] = new PonerController(tablero, tableroView, turno, turnoView, jugadores[0].getJugador() );
    	ponerController[1] = new PonerController(tablero, tableroView, turno, turnoView, jugadores[1].getJugador() );
    	moverController[0] = new MoverController(tablero, tableroView, turno, turnoView, jugadores[0].getJugador() );
    	moverController[1] = new MoverController(tablero, tableroView, turno, turnoView, jugadores[1].getJugador() );
    	abrirController.controlar(ponerController,moverController);
     //   abrirController.controlar();
        
       
       
        do {
            if (!tablero.completo()) {
                ponerController[turno.toca()].controlar();
            } else {
                moverController[turno.toca()].controlar();
            }
            victoria = tablero.hayTER(turno.toca());
            System.out.println(victoria + " " + turno.noToca());
            if (!victoria) {
                turno.cambiar();
                System.out.println("cambiar turno");
            }
        } while (!victoria);
        System.out.println(victoria + " " + turno.noToca() + "");
        turnoView.victoria();
        nuevaPartidaController.controlar();
        } while (nuevaPartidaController.continuarConOtraPartida());
        
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.jugar();
    }
}
