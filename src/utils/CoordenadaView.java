package utils;


public class CoordenadaView {

    private Coordenada coordenada;
    private String titulo;

    public CoordenadaView(Coordenada mCoordenada, String titulo) {
        this.coordenada = mCoordenada;
        this.titulo = titulo;
    }

    public void recoger() {
        GestorIOFactory.getGestorIO().escribirLinea(titulo);
        coordenada.setFila(GestorIOFactory.getGestorIO().leerInt("Dame fila [1,3]: ") - 1);
        coordenada.setColumna(GestorIOFactory.getGestorIO().leerInt("Dame columna [1,3]: ") - 1);
    }

    public void mostrar() {
        GestorIOFactory.getGestorIO().escribir("(" + (coordenada.getFila() + 1) + "," +
                (coordenada.getColumna() + 1) + ")");
    }
}
