package ticTacToe.controllers;


import ticTacToe.models.Jugador;
import ticTacToe.models.Tablero;
import ticTacToe.models.Turno;
import utils.Coordenada;
import ticTacToe.views.TableroView;
import ticTacToe.views.TurnoView;

public class PonerController extends JugadorController {
	public String accion="PONER";
	public Jugador jugador;

	public PonerController(Tablero tablero, TableroView tableroView, Turno turno, TurnoView turnoView, Jugador jugador) {
		super(tablero, turno,jugador);
	//	this.jugador = jugador;
	}

	public void controlar() {

		turnoView.mostrar(accion, super.jugador.getNombre());
		Coordenada coordenada = escogerCoordenadaOcupadaPor(2);
		
		tablero.poner(coordenada, turno.toca());
		tableroView.mostrar();
	}


	
}
