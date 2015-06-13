package ticTacToe.controllers;

import ticTacToe.models.Jugador;
import ticTacToe.models.Tablero;
import ticTacToe.models.Turno;
import ticTacToe.views.JugadorView;
import ticTacToe.views.TableroView;
import ticTacToe.views.TurnoView;

public class JugadorController extends TicTacToeController{
    
    protected Turno turno;
    protected TurnoView turnoView;
    protected Jugador jugador;
    
    public JugadorController(Tablero tablero, Turno turno){
        super(tablero, new TableroView(tablero));
        this.turno = turno;
        this.turnoView = new TurnoView(turno);
        jugador = new Jugador();
    }
    public void inicializar() {
    	JugadorView view = new JugadorView(jugador);
    	view.recoger();
    	 
    }
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
    

}
