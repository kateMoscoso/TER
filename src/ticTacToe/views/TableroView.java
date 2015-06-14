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

	public boolean nuevaPartida() {
		boolean valido = false;
		String resultado ="";
		do {
		GestorIOFactory.getGestorIO().escribirLinea("Desea Jugar nueva partida SI o NO");
		resultado = GestorIOFactory.getGestorIO().leerString("");
		if(resultado.equals("SI") || resultado.equals("NO"))
			valido= true;
		}while(!valido);
		if(resultado.equals("SI"))
			return true;
		if(resultado.equals("NO")) 
			return false;
		return false;
	}
}
