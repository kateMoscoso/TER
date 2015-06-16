package ticTacToe.controllers;

import ticTacToe.models.Jugador;
import ticTacToe.models.Tablero;
import ticTacToe.models.Turno;
import utils.AceptarDialog;
import utils.Coordenada;
import utils.CoordenadaView;
import ticTacToe.views.TableroView;
import ticTacToe.views.TurnoView;

public class MoverController extends JugadorController {
	public String accion="MOVER";
	public Jugador jugador;

	public int VACIO = 2;
    public MoverController(Tablero tablero, TableroView tableroView, Turno turno, TurnoView turnoView, Jugador jugador) {
        super(tablero,  turno, jugador);
       
        
    }

    public void controlar() {
        turnoView.mostrar(accion, super.jugador.nombre);
        Coordenada coordenadaOrigen =  escogerCoordenadaOcupadaPor(turno.toca());

        boolean correcto;
        
//        do {
//        	if(!super.jugador.automatico){
//            coordenadaOrigenView.recoger();
//           
//        	} else {
//        		coordenadaOrigen = obtenerCoordenadaNoOcupadaPor(turno.toca());
//        	}
//        	 correcto = coordenadaOrigen.valida(Tablero.RANGO);
//            if (!correcto) {
//                coordenadaOrigenView.mostrar();
//                AceptarDialog dialogo = new AceptarDialog(" No es una coordenada válida!!!");
//                dialogo.ejecutar();
//                tableroView.mostrar();
//            } else {
//                correcto = tablero.ocupado(coordenadaOrigen, turno.toca());
//                if (!correcto) {
//                    coordenadaOrigenView.mostrar();
//                    AceptarDialog dialogo = new AceptarDialog(
//                            " En esta coordenada no existe una de sus fichas!!!");
//                    dialogo.ejecutar();
//                    tableroView.mostrar();
//                }
//            }
//        } while (!correcto);
        
        Coordenada coordenadaDestino = new Coordenada();
        System.out.println("Coordenada a mover: " + coordenadaOrigen.toString());
        
        CoordenadaView coordenadaDestinoView = new CoordenadaView(coordenadaDestino,
                "Introduzca el destino de la ficha a mover");
        do {
        	if(!super.jugador.automatico){
            coordenadaDestinoView.recoger();
        	}
        	else {
        		coordenadaDestino = obtenerCoordenadaNoOcupadaPor(VACIO);
        	}
        	System.out.println("Coordenada destino: " + coordenadaDestino.toString());
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
                	if(!super.jugador.automatico){
                    coordenadaDestinoView.mostrar();
                    AceptarDialog dialogo = new AceptarDialog(
                            " El origen y destino no pueden ser iguales!!!");
                    dialogo.ejecutar();
                    tableroView.mostrar();
                	}
                } else {
                    correcto = tablero.vacio(coordenadaDestino);
                    if (!correcto) {
                        coordenadaDestinoView.mostrar();
                        AceptarDialog dialogo = new AceptarDialog(
                                " Esta coordsenada no está vacía!!!");
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
