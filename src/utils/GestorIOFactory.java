package utils;

public class GestorIOFactory {

    private static GestorIO gestorIO = new GestorIOImplementation();

    public static GestorIO getGestorIO() {
        return gestorIO;
    }

    public static void setGestorIO(GestorIO gestorIO){
        GestorIOFactory.gestorIO = gestorIO;
    }
}
