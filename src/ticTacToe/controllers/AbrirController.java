package ticTacToe.controllers;

import ticTacToe.models.Jugador;
import ticTacToe.models.Tablero;
import ticTacToe.models.Turno;
import ticTacToe.views.TableroView;
import ticTacToe.views.TurnoView;

public class AbrirController extends TicTacToeController {

	public AbrirController(Tablero tablero, TableroView tableroView){
		super(tablero, tableroView);
	}

	public void controlar(PonerController[] ponerController, MoverController[] moverController, Turno turno, TurnoView turnoView, JugadorController[] jugadores){
		int numeroJugadores = tableroView.recoger();
		jugadores[0] = new JugadorController(tablero, turno, new Jugador());
		jugadores[1] = new JugadorController(tablero, turno, new Jugador());
		if(numeroJugadores == 1){
			jugadores[0].inicializar();
			jugadores[1].inicializarJugadorAutomatico();
		}
		else if(numeroJugadores == 2){
			jugadores[0].inicializar();
			jugadores[1].inicializar();
		}
		ponerController[0] = new PonerController(tablero, tableroView, turno, turnoView, jugadores[0].getJugador() );
		ponerController[1] = new PonerController(tablero, tableroView, turno, turnoView, jugadores[1].getJugador() );
		moverController[0] = new MoverController(tablero, tableroView, turno, turnoView, jugadores[0].getJugador() );
		moverController[1] = new MoverController(tablero, tableroView, turno, turnoView, jugadores[1].getJugador() );
		
		tableroView.mostrar();
	}
	public void definirJugadores(){

	}
}