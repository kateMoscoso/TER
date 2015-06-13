package ticTacToe.views;

import ticTacToe.models.Jugador;
import utils.GestorIOFactory;


public class JugadorView {

	 private Jugador jugador;
	 static final String TITULO_MOSTRAR = "\n..........................................." +
				"\nIntroduzca el nommbre del jugador #numeroJugador#";
	    public JugadorView(Jugador jugador) {
	        this.jugador = jugador;
	    }
	    public void recoger() {
	        GestorIOFactory.getGestorIO().escribirLinea("Escriba el nombre del jugador");
			jugador.setNombre(GestorIOFactory.getGestorIO().leerString("Nombre:"));
//	        coordenada.setFila(GestorIOFactory.getGestorIO().leerInt("Dame fila [1,3]: ") - 1);
//	        coordenada.setColumna(GestorIOFactory.getGestorIO().leerInt("Dame columna [1,3]: ") - 1);
	    }
	    public void mostrar(String numeroJugador) {
			String conTitulo = TurnoView.TITULO_MOSTRAR.replaceAll("#numeroJugador#", numeroJugador);
			GestorIOFactory.getGestorIO().escribirLinea(conTitulo);
		}
}
