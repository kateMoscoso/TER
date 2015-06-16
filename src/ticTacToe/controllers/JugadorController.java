package ticTacToe.controllers;

import java.util.Random;

import ticTacToe.models.Jugador;
import ticTacToe.models.Tablero;
import ticTacToe.models.Turno;
import ticTacToe.views.JugadorView;
import ticTacToe.views.TableroView;
import ticTacToe.views.TurnoView;
import utils.AceptarDialog;
import utils.Coordenada;
import utils.CoordenadaView;

public class JugadorController extends TicTacToeController{
    
    protected Turno turno;
    protected TurnoView turnoView;
    protected Jugador jugador;
    
    public JugadorController(Tablero tablero, Turno turno, Jugador jugador){
        super(tablero, new TableroView(tablero));
        this.turno = turno;
        this.turnoView = new TurnoView(turno);
        this.jugador = jugador;
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
	
	protected Coordenada obtenerCoordenadaNoOcupadaPor(int numero) {
		boolean correcto;
		Coordenada c;
		do{
			c = generarCoordenadaAleatoria();
			correcto = tablero.ocupado(c, numero);
		}while (!correcto);
		return c;
	}
	
	public Coordenada escogerCoordenadaOcupadaPor(int numero){
		Coordenada coordenada = new Coordenada();
		CoordenadaView coordenadaView = new CoordenadaView(coordenada, "Introduzca el destino de la ficha a poner");
		boolean correcto;
		do {
			if(!jugador.automatico){
				coordenadaView.recoger();
			}
			else{
				coordenada = obtenerCoordenadaNoOcupadaPor(numero);
			}
			correcto = coordenada.valida(Tablero.RANGO);
			if (!correcto) {
				coordenadaView.mostrar();
				AceptarDialog dialogo = new AceptarDialog(
						" No es una coordenada válida!!!");
				dialogo.ejecutar();
				tableroView.mostrar();
			} else {
				correcto = tablero.ocupado(coordenada, numero);
				if (!correcto) {
					coordenadaView.mostrar();
					AceptarDialog dialogo = new AceptarDialog(
							" Esa coordenada está ocupada por otra ficha!!!");
					dialogo.ejecutar();
					tableroView.mostrar();
				}
			}
		} while (!correcto);
		return coordenada;
	}
	
    /*
     * metodo que genera una Coordenada Aleatoria
     * return nueva Coordenada
     */
	public Coordenada generarCoordenadaAleatoria(){
		Random r = new Random();
		int fila = r.nextInt(3);
		int columna = r.nextInt(3);
		return new Coordenada(fila, columna);
	}
}
