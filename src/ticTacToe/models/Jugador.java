package ticTacToe.models;

public class Jugador {
	
	public String nombre;
	public char ficha;
	public boolean automatico;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getFicha() {
		return ficha;
	}

	public void setFicha(char ficha) {
		this.ficha = ficha;
	}

	public boolean isAutomatico() {
		return automatico;
	}

	public void setAutomatico(boolean automatico) {
		this.automatico = automatico;
	}
	
	

}
