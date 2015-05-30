package ticTacToe.controllers;

import ticTacToe.models.Tablero;
import ticTacToe.views.TableroView;

public class TicTacToeController {

    protected Tablero tablero;
    protected TableroView tableroView;
    
    protected TicTacToeController(Tablero tablero, TableroView tableroView) {
        this.tablero = tablero;
        this.tableroView = tableroView;
    }
}
