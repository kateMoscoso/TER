package utils;


public class AceptarDialog {

    private String mensaje;

    public AceptarDialog(String literal) {
        this.mensaje = literal;
    }

    public void ejecutar() {
        GestorIOFactory.getGestorIO().leerString(mensaje + " <Pulse ENTER>");
    }
}
