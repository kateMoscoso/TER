package ticTacToe.models;

import utils.Intervalo;
import utils.Coordenada;

public class Tablero {

    public static final int DIMENSION = 3;
    public static final Intervalo RANGO =
            new Intervalo(0, Tablero.DIMENSION - 1);
    private static final char VACIA = '-';
    private char[][] fichas =
            new char[Tablero.DIMENSION][Tablero.DIMENSION];
//    private Coordenada[][] coordenadas = new Coordenada[2][Tablero.DIMENSION];

    public Tablero() {
        for (int i = 0; i < Tablero.DIMENSION; i++) {
            for (int j = 0; j < Tablero.DIMENSION; j++) {
                fichas[i][j] = Tablero.VACIA;
            }
        }
    }
    
    public boolean completo(){
        int contadorFichas = 0;
        for (int i = 0; i < Tablero.DIMENSION; i++) {
            for (int j = 0; j < Tablero.DIMENSION; j++) {
                if (fichas[i][j] != Tablero.VACIA) {
                    contadorFichas++;
                }
            }
        }
        return contadorFichas == Tablero.DIMENSION*2;
    }

    public char getFicha(Coordenada coordenada) {
        return fichas[coordenada.getFila()][coordenada.getColumna()];
    }

    public boolean vacio(Coordenada coordenada) {
        return this.ocupado(coordenada,Tablero.VACIA);
    }

    public boolean ocupado(Coordenada coordenada, int ficha) {
    	char ficha2 = '-';
    	if(ficha == 0){
    		ficha2 = 'X';
    	}
    	if(ficha == 1){
    		ficha2 = 'O';
    	}
        return this.getFicha(coordenada) == ficha2;
    }

    public void poner(Coordenada coordenada, int ficha) {
    	if(ficha ==0)
        fichas[coordenada.getFila()][coordenada.getColumna()] = 'X';
    	if(ficha ==1)
            fichas[coordenada.getFila()][coordenada.getColumna()] = 'O';
    	if(ficha ==2)
            fichas[coordenada.getFila()][coordenada.getColumna()] = '-';
    }

    public void quitar(Coordenada coordenada) {
        this.poner(coordenada, 2);
    }

    public boolean hayTER(int ficha) {
        boolean hayTER = false;
        // TODO: Codificar algoritmo
        return hayTER;
    }

}

