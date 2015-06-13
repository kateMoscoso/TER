package ticTacToe.models;

import java.util.Random;

public class Turno {

    public static final int CRUZ = 1;
    public static final int NO_CRUZ = 0;
    private  int jugador  = 1;

    public Turno (){
    	Random rnd = new Random();
    	int randomTurn = rnd.nextInt(10); 
    	if(randomTurn < 50){
    		jugador =Turno.NO_CRUZ;
    	}else {
    		jugador = Turno.CRUZ;
    	}
    }
    public void cambiar() {
        jugador = this.noToca();
    }

    public int toca() {
        return jugador;
    }

    public int noToca() {
        if (jugador == Turno.CRUZ) {
            return Turno.NO_CRUZ;
        } else {
            return Turno.CRUZ;
        }
    }
}