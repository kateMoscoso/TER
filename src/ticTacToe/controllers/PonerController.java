package ticTacToe.controllers;

import ticTacToe.models.Tablero;
import ticTacToe.models.Turno;
import utils.AceptarDialog;
import utils.Coordenada;
import utils.CoordenadaView;
import ticTacToe.views.TableroView;
import ticTacToe.views.TurnoView;

public class PonerController extends JugadorController {
	public String accion="PONER";

    public PonerController(Tablero tablero, TableroView tableroView, Turno turno, TurnoView turnoView) {
        super(tablero, tableroView, turno, turnoView);
    }

    public void controlar() {
        turnoView.mostrar(accion);
        Coordenada coordenada = new Coordenada();
        CoordenadaView coordenadaView = new CoordenadaView(coordenada, "Introduzca el destino de la ficha a poner");
        boolean correcto;
        do {
            coordenadaView.recoger();
            correcto = coordenada.valida(Tablero.RANGO);
            if (!correcto) {
                coordenadaView.mostrar();
                AceptarDialog dialogo = new AceptarDialog(
                        " No es una coordenada válida!!!");
                dialogo.ejecutar();
                tableroView.mostrar();
            } else {
                correcto = tablero.vacio(coordenada);
                if (!correcto) {
                    coordenadaView.mostrar();
                    AceptarDialog dialogo = new AceptarDialog(
                            " Esa coordenada está ocupada por otra ficha!!!");
                    dialogo.ejecutar();
                    tableroView.mostrar();
                }
            }
        } while (!correcto);
        tablero.poner(coordenada, turno.toca());
        tableroView.mostrar();
    }
}
