package utils;

public class CoordenadaTablero extends Coordenada {
	private char ficha;
	public CoordenadaTablero(int fila, int columna) {
		super(fila,columna);
		this.ficha = '-';
	}

	public boolean estaVacia() {
		return ficha == '-';
	}

	public char getFicha() {
		return ficha;
	}

	public void setFicha(char ficha) {
		this.ficha = ficha;
	}


}
