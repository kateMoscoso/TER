package utils;

import ticTacToe.models.Tablero;

public class Coordenada {

    private int fila;
    private int columna;

    public Coordenada() {
    }

    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean iguales(Coordenada coordenada) {
        return fila == coordenada.fila && columna == coordenada.columna;
    }

    public boolean valida(Intervalo intervalo) {
        return intervalo.incluye(fila) && intervalo.incluye(columna);
    }
    
    private boolean enDiagonaPrincipal(){
        return this.fila - this.columna == 0;
    }
    
    private boolean enDiagonaSecundaria(){
        return this.fila + this.columna == Tablero.DIMENSION-1;
    }
    
    public Direccion enDireccion(Coordenada coordenada){
        if (this.fila == coordenada.fila){
            return Direccion.EN_FILA;
        } else if (this.columna == coordenada.columna) {
            return Direccion.EN_COLUMNA;
        } else if (this.enDiagonaPrincipal() && coordenada.enDiagonaPrincipal()) {
            return Direccion.EN_DIAGONAL_PRINCIPAL;
        } else if (this.enDiagonaSecundaria() && coordenada.enDiagonaSecundaria()){
            return Direccion.EN_DIAGONAL_SECUNDARIA;
        } else {
            return Direccion.SIN_DIRECION;
        }
    }
}
