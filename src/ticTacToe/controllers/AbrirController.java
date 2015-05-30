package ticTacToe.controllers;

import ticTacToe.models.Tablero;
import ticTacToe.views.TableroView;

public class AbrirController extends TicTacToeController {

    public AbrirController(Tablero tablero, TableroView tableroView){
       super(tablero, tableroView);
    }
    
    public void controlar(){
        tableroView.mostrar();
    }
}