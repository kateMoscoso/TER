package ticTacToe.controllers;

import ticTacToe.models.Jugador;
import ticTacToe.models.Tablero;
import ticTacToe.models.Turno;
import ticTacToe.views.JugadorView;
import ticTacToe.views.TableroView;
import ticTacToe.views.TurnoView;
import utils.Coordenada;

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
    public void inicializarJugadorAutomatico() {
    	this.jugador.setAutomatico(true);
    	this.jugador.setNombre("Maquina");
    	 
    }
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	protected Coordenada generarCoordenadaPoner() {
		//	Random rnd = new Random();
		boolean correcto;
		Coordenada c;
		do{
			int fila = (int) (Math.random()*2 + 1);
			int columna = (int) (Math.random()*2 + 1);
			c = new Coordenada(fila, columna);
	//		correcto = c.valida(Tablero.RANGO);
			
			correcto = tablero.vacio(c);
		}while (!correcto);
		return c;
	}
	
	protected Coordenada generarCoordenadaMover() {
		//	Random rnd = new Random();
		boolean correcto;
		Coordenada c;
		do{
			int fila = (int) (Math.random()*2 + 1);
			int columna = (int) (Math.random()*2 + 1);
			c = new Coordenada(fila, columna);
	//		correcto = c.valida(Tablero.RANGO);
			
			correcto = tablero.ocupado(c, turno.toca());
		}while (!correcto);
		return c;
	}
	
    

}
