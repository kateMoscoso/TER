package ticTacToe.views;

import ticTacToe.models.Jugador;
import utils.GestorIOFactory;
import utils.GestorIOMock;

public class JugadorViewTester {
	 private GestorIOMock gestorIOMock;
	    private Jugador jugador;
	    private JugadorView jugadorView;

	    private void init() {
	        gestorIOMock = new GestorIOMock();
	        GestorIOFactory.setGestorIO(gestorIOMock);
	        jugador = new Jugador();
	        jugadorView = new JugadorView(jugador);
	    }
//
//	    private void mostrarTest() {
//	        this.init();
//	        String titulo = "XXXXX";
//	        jugadorView.mostrar("1");
//	        String salida = TurnoView.TITULO_MOSTRAR.replaceAll("#titulo#", titulo).replaceAll(
//	                "#ficha#", ""+turno.toca()+"\n");
//	        assert salida.equals(gestorIOMock.getSalida()) : "No corresponde la salida de mostrar";
//	    }
//
//	    private void victoriaTest() {
//	        this.init();
//	        turnoView.victoria();
//	        String salida = TurnoView.TITULO_VICTORIA.replaceAll("#ficha#", ""+turno.toca()+"\n");
//	        assert salida.equals(gestorIOMock.getSalida()) : "No corresponde la salida de victoria";
//	    }
//
//	    private void test() {
//	        this.mostrarTest();
//	        this.victoriaTest();
//	    }
//
//	    public static void main(String[] arg) {
//	        new TurnoViewTester().test();
//	    }
}
