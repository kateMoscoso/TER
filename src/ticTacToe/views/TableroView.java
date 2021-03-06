package ticTacToe.views;

import ticTacToe.models.Tablero;
import utils.Coordenada;
import utils.GestorIOFactory;

public class TableroView {

	private Tablero tablero;

	public TableroView(Tablero tablero) {
		this.tablero = tablero;
	}

	public void mostrar() {
		GestorIOFactory.getGestorIO().escribirLinea("Tablero:");
		for (int i = 0; i < Tablero.DIMENSION; i++) {
			for (int j = 0; j < Tablero.DIMENSION; j++) {
				GestorIOFactory.getGestorIO().escribir(tablero.getFicha(new Coordenada(i, j)));
			}
			GestorIOFactory.getGestorIO().escribirLinea();
		}
	}   
	public int recoger() {
		int numeroJugadores = 0; 
		boolean condicion = false;
		do{
			numeroJugadores = GestorIOFactory.getGestorIO().leerInt("Cuantos Jugadores van a jugar? 1 - 2: ");
			if(numeroJugadores ==1 || numeroJugadores==2){
				condicion =true;
			}
		}while(!condicion);
		System.out.println(numeroJugadores);
		return numeroJugadores;
	}

	public boolean nuevaPartida() {
		boolean valido = false;
		String resultado ="";
		do {
			GestorIOFactory.getGestorIO().escribirLinea("Desea Jugar nueva partida SI o NO");
			resultado = GestorIOFactory.getGestorIO().leerString("");
			if(resultado.toUpperCase().equals("SI") || resultado.toUpperCase().equals("NO"))
				valido= true;
		}while(!valido);
		if(resultado.equals("SI"))
			return true;
		if(resultado.equals("NO")) 
			return false;
		return false;
	}
}
