package ticTacToe.models;

import java.util.List;
import java.util.ArrayList;

import utils.CoordenadaTablero;
import utils.Intervalo;
import utils.Coordenada;

public class Tablero {

	public static final int DIMENSION = 3;
	public static final Intervalo RANGO =
			new Intervalo(0, Tablero.DIMENSION - 1);
	private static final char VACIA = '-';
	private CoordenadaTablero[][] fichas =
			new CoordenadaTablero[Tablero.DIMENSION][Tablero.DIMENSION];
	List<CoordenadaTablero> listaCoordenadas = new ArrayList<CoordenadaTablero>();
	//    private Coordenada[][] coordenadas = new Coordenada[2][Tablero.DIMENSION];

	public Tablero() {
		for (int i = 0; i < Tablero.DIMENSION; i++) {
			for (int j = 0; j < Tablero.DIMENSION; j++) {
				//Coordenada c =new Coordenada(i,j);
				//listaCoordenadas.add(c);
				fichas[i][j] = new CoordenadaTablero(i,j);
			}
		}
	}

	public boolean completo(){
		int contadorFichas = 0;
		for (int i = 0; i < Tablero.DIMENSION; i++) {
			for (int j = 0; j < Tablero.DIMENSION; j++) {
				// if (fichas[i][j] != Tablero.VACIA) {
				if (!fichas[i][j].estaVacia()) {
					contadorFichas++;
				}
			}
		}
		System.out.println("contador "+contadorFichas);
		return contadorFichas == Tablero.DIMENSION*2;
	}

	public char getFicha(Coordenada coordenada) {
		return fichas[coordenada.getFila()][coordenada.getColumna()].getFicha();
	}

	public boolean vacio(Coordenada coordenada) {
		return this.ocupado(coordenada,2);
	}

	public boolean ocupado(Coordenada coordenada, int ficha) {
		char ficha2 = '-';

		if(ficha == 1){
			ficha2 = 'X';
		}
		if(ficha == 0){
			ficha2 = 'O';
		}
		return this.getFicha(coordenada) == ficha2;
	}

	public void poner(Coordenada coordenada, int ficha) {
		if(ficha == 0){
			fichas[coordenada.getFila()][coordenada.getColumna()].setFicha('O');
		}
		if(ficha ==1){
			fichas[coordenada.getFila()][coordenada.getColumna()].setFicha('X');
		}
		if(ficha ==2){
			fichas[coordenada.getFila()][coordenada.getColumna()].setFicha('-');
		}
	}

	public void quitar(Coordenada coordenada) {
		this.poner(coordenada, 2);
	}

	public boolean hayTER(int fichaNum) {
		char ficha='X';
		if(fichaNum == 0)
			ficha ='O';

		if(fichas[0][0].getFicha()== ficha && fichas[0][1].getFicha()== ficha  && fichas[0][2].getFicha()== ficha)
			return true;
		if(fichas[1][0].getFicha()== ficha && fichas[1][1].getFicha()== ficha  && fichas[1][2].getFicha()== ficha)
			return true;
		if(fichas[2][0].getFicha()== ficha && fichas[2][1].getFicha()== ficha  && fichas[2][2].getFicha()== ficha)
			return true;
		if(fichas[0][0].getFicha()== ficha && fichas[1][0].getFicha()== ficha  && fichas[2][0].getFicha()== ficha)
			return true;
		if(fichas[0][1].getFicha()== ficha && fichas[1][1].getFicha()== ficha  && fichas[2][1].getFicha()== ficha)
			return true;
		if(fichas[0][2].getFicha()== ficha && fichas[1][2].getFicha()== ficha  && fichas[2][2].getFicha()== ficha)
			return true;
		if(fichas[0][0].getFicha()== ficha && fichas[1][1].getFicha()== ficha  && fichas[2][2].getFicha()== ficha)
			return true;
		if(fichas[2][0].getFicha()== ficha && fichas[1][1].getFicha()== ficha  && fichas[0][2].getFicha()== ficha)
			return true;
		return false;
	}

	public void vaciar() {
		for (int i = 0; i < Tablero.DIMENSION; i++) {
			for (int j = 0; j < Tablero.DIMENSION; j++) {
				fichas[i][j].setFicha('-');
			}
		}

	}

}

