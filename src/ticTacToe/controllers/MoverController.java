package ticTacToe.controllers;

import ticTacToe.models.Tablero;
import ticTacToe.models.Turno;
import utils.AceptarDialog;
import utils.Coordenada;
import utils.CoordenadaView;
import ticTacToe.views.TableroView;
import ticTacToe.views.TurnoView;

public class MoverController extends JugadorController {
	public String accion="MOVER";

    public MoverController(Tablero tablero, TableroView tableroView, Turno turno, TurnoView turnoView) {
        super(tablero, tableroView, turno, turnoView);
    }

    public void controlar() {
        turnoView.mostrar(accion);
        Coordenada coordenadaOrigen = new Coordenada();
        CoordenadaView coordenadaOrigenView = new CoordenadaView(coordenadaOrigen,
                "Introduzca el origen de la ficha a mover");
        boolean correcto;
        do {
            coordenadaOrigenView.recoger();
            correcto = coordenadaOrigen.valida(Tablero.RANGO);
            if (!correcto) {
                coordenadaOrigenView.mostrar();
                AceptarDialog dialogo = new AceptarDialog(" No es una coordenada válida!!!");
                dialogo.ejecutar();
                tableroView.mostrar();
            } else {
                correcto = tablero.ocupado(coordenadaOrigen, turno.toca());
                if (!correcto) {
                    coordenadaOrigenView.mostrar();
                    AceptarDialog dialogo = new AceptarDialog(
                            " En esta coordenada no existe una de sus fichas!!!");
                    dialogo.ejecutar();
                    tableroView.mostrar();
                }
            }
        } while (!correcto);
        Coordenada coordenadaDestino = new Coordenada();
        CoordenadaView coordenadaDestinoView = new CoordenadaView(coordenadaDestino,
                "Introduzca el destino de la ficha a mover");
        do {
            coordenadaDestinoView.recoger();
            correcto = coordenadaDestino.valida(Tablero.RANGO);
            if (!correcto) {
                coordenadaDestinoView.mostrar();
                AceptarDialog dialogo = new AceptarDialog(
                        " No es una coordenada válida!!!");
                dialogo.ejecutar();
                tableroView.mostrar();
            } else {
                correcto = !coordenadaOrigen.iguales(coordenadaDestino);
                if (!correcto) {
                    coordenadaDestinoView.mostrar();
                    AceptarDialog dialogo = new AceptarDialog(
                            " El origen y destino no pueden ser iguales!!!");
                    dialogo.ejecutar();
                    tableroView.mostrar();
                } else {
                    correcto = tablero.vacio(coordenadaDestino);
                    if (!correcto) {
                        coordenadaDestinoView.mostrar();
                        AceptarDialog dialogo = new AceptarDialog(
                                " Esta coordenada no está vacía!!!");
                        dialogo.ejecutar();
                        tableroView.mostrar();
                    }
                }
            }
        } while (!correcto);
        tablero.quitar(coordenadaOrigen);
        tablero.poner(coordenadaDestino, turno.toca());
        tableroView.mostrar();
    }
}
