package ticTacToe.views;

import ticTacToe.models.Turno;
import utils.GestorIOFactory;

public class TurnoView {

    private Turno turno;
    static final String TITULO_MOSTRAR = "\n..........................................." +
                                         "\nLe toca  #titulo# al jugador con fichas #ficha#";
    static final String TITULO_VICTORIA = "\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +
                                          "\nVictoria para las fichas #ficha#";
    
    public TurnoView(Turno turno) {
        this.turno = turno;
    }
    
    private String tituloConFicha(String titulo){
        return titulo.replaceAll("#ficha#", ""+turno.toca());
    }

    public void mostrar(String titulo) {
        String conTitulo = TurnoView.TITULO_MOSTRAR.replaceAll("#titulo#", titulo);
        GestorIOFactory.getGestorIO().escribirLinea(this.tituloConFicha(conTitulo));
    }

    public void victoria() {
        GestorIOFactory.getGestorIO().escribirLinea(this.tituloConFicha(TurnoView.TITULO_VICTORIA));
    }
}
