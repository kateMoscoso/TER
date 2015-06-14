package ticTacToe.controllers;

import ticTacToe.models.Tablero;
import ticTacToe.views.TableroView;

public class ContinuarController extends TicTacToeController {
	public boolean nuevaPartida;

	public ContinuarController(Tablero tablero, TableroView tableroView) {
		super(tablero, tableroView);
		// TODO Auto-generated constructor stub
	}
	public void controlar(){
		nuevaPartida = tableroView.nuevaPartida();
		
		if(nuevaPartida){
			tablero = new Tablero();
			System.out.println(nuevaPartida);
		}

	}
	public boolean continuarConOtraPartida(){
		return nuevaPartida;
	}

}
