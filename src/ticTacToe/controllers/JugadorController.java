package ticTacToe.controllers;

import ticTacToe.models.Tablero;
import ticTacToe.models.Turno;
import ticTacToe.views.TableroView;
import ticTacToe.views.TurnoView;

public class JugadorController extends TicTacToeController{
    
    protected Turno turno;
    protected TurnoView turnoView;
    
    public JugadorController(Tablero tablero, TableroView tableroView, Turno turno, TurnoView turnoView){
        super(tablero, tableroView);
        this.turno = turno;
        this.turnoView = turnoView;
    }

}
