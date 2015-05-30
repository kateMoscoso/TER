package ticTacToe.models;

import utils.Coordenada;

public class TableroTester {
    
    private Tablero tablero;
    
    private void construtorTablero(){
        tablero = new Tablero();
        for (int i = 0; i < Tablero.DIMENSION; i++) {
            for (int j = 0; j < Tablero.DIMENSION; j++) {
                assert tablero.vacio(new Coordenada(i,j)) : "Casilla no vacía inicialmente";
            }
        }
    }
    
    private void tresEnRayaTest(){
        Coordenada coordenadas[][] = {
                {new Coordenada(0,0), new Coordenada(1,1), new Coordenada(2,2)},
                {new Coordenada(0,1), new Coordenada(0,2), new Coordenada(0,0)},
                {new Coordenada(0,2), new Coordenada(1,1), new Coordenada(2,0)}               
        };
        for (Coordenada[] fila : coordenadas){
            tablero = new Tablero();
            for (Coordenada coordenada : fila)
            tablero.poner(coordenada, 'X');
            assert tablero.hayTER('X') : "No va bien las TER";
        }
    }
    
    public void test(){
        this.construtorTablero();
        this.tresEnRayaTest();
    }
    
    public static void main (String[] arg){
        new TurnoTester().test();
    }

}
