package utils;

public abstract class GestorIO {

    protected GestorIO(){
    }
    
    public abstract String leerString(String mensaje) ;

    public abstract int leerInt(String mensaje) ;

    public abstract float leerFloat(String mensaje);

    public abstract double leerDouble(String mensaje);

    public abstract long leerLong(String mensaje);

    public abstract byte leerByte(String mensaje);

    public abstract short leerShort(String mensaje);

    public abstract char leerChar(String mensaje);

    public abstract boolean leerBoolean(String mensaje);

    public abstract void escribir(String salida);

    public abstract void escribirLinea(String salida);

    public abstract void escribir(int salida);
    
    public abstract void escribirLinea(int salida);

    public abstract void escribir(float salida);

    public abstract void escribirLinea(float salida) ;

    public abstract void escribir(double salida);

    public abstract void escribirLinea(double salida);

    public abstract void escribir(long salida);

    public abstract void escribirLinea(long salida);

    public abstract void escribir(byte salida);

    public abstract void escribirLinea(byte salida);

    public abstract void escribir(short salida);

    public abstract void escribirLinea(short salida);

    public abstract void escribir(char salida);

    public abstract void escribirLinea(char salida);

    public abstract void escribir(boolean salida);

    public abstract void escribirLinea(boolean salida);

    public abstract void escribirLinea() ;
}

