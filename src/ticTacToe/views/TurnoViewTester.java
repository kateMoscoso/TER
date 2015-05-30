package ticTacToe.views;

import ticTacToe.models.Turno;
import utils.GestorIOFactory;
import utils.GestorIOMock;

public class TurnoViewTester {

    private GestorIOMock gestorIOMock;
    private Turno turno;
    private TurnoView turnoView;

    private void init() {
        gestorIOMock = new GestorIOMock();
        GestorIOFactory.setGestorIO(gestorIOMock);
        turno = new Turno();
        turnoView = new TurnoView(turno);
    }

    private void mostrarTest() {
        this.init();
        String titulo = "XXXXX";
        turnoView.mostrar(titulo);
        String salida = TurnoView.TITULO_MOSTRAR.replaceAll("#titulo#", titulo).replaceAll(
                "#ficha#", ""+turno.toca()+"\n");
        assert salida.equals(gestorIOMock.getSalida()) : "No corresponde la salida de mostrar";
    }

    private void victoriaTest() {
        this.init();
        turnoView.victoria();
        String salida = TurnoView.TITULO_VICTORIA.replaceAll("#ficha#", ""+turno.toca()+"\n");
        assert salida.equals(gestorIOMock.getSalida()) : "No corresponde la salida de victoria";
    }

    private void test() {
        this.mostrarTest();
        this.victoriaTest();
    }

    public static void main(String[] arg) {
        new TurnoViewTester().test();
    }
}
