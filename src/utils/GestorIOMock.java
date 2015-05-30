package utils;

import java.util.ArrayList;

public class GestorIOMock extends GestorIO {

    private ArrayList<Object> entrada = new ArrayList<Object>();
    private StringBuffer salida = new StringBuffer();
    
    public GestorIOMock(){
        super();
    }
    
    public String getSalida(){
        return salida.toString();
    }
    
    public void setString(String mensaje){
        entrada.add(mensaje);
    }
    
    public void setInt(int mensaje){
        entrada.add(mensaje);
    }
    
    public String leerString(String mensaje){
        return (String) entrada.remove(0);
    }

    public int leerInt(String mensaje){
        return (int) entrada.remove(0);
    }

    public float leerFloat(String mensaje){
        return (float) entrada.remove(0);
    }

    public double leerDouble(String mensaje){
        return (double) entrada.remove(0);
    }
    
    public long leerLong(String mensaje){
        return (long) entrada.remove(0);
    }

    public byte leerByte(String mensaje){
        return (byte) entrada.remove(0);
    }

    public short leerShort(String mensaje){
        return (short) entrada.remove(0);
    }

    public char leerChar(String mensaje){
        return (char) entrada.remove(0);
    }

    public boolean leerBoolean(String mensaje){
        return (boolean) entrada.remove(0);
    }

    public void escribir(String salida){
        this.salida.append(salida);
    }

    public void escribirLinea(String salida){
        this.escribir(salida+"\n");
    }

    public void escribir(int salida){
        this.salida.append(""+salida);
    }
    
    public void escribirLinea(int salida){
        this.escribir(salida+"\n");
    }

    public void escribir(float salida){
        this.salida.append(""+salida);
    }

    public void escribirLinea(float salida){
        this.escribir(salida+"\n");
    }

    public void escribir(double salida){
        this.salida.append(""+salida);
    }

    public void escribirLinea(double salida){
        this.escribir(salida+"\n");
    }

    public void escribir(long salida){
        this.salida.append(""+salida);
    }

    public void escribirLinea(long salida){
        this.escribir(salida+"\n");
    }

    public void escribir(byte salida){
        this.salida.append(""+salida);
    }

    public void escribirLinea(byte salida){
        this.escribir(salida+"\n");
    }

    public void escribir(short salida){
        this.salida.append(""+salida);
    }

    public void escribirLinea(short salida){
        this.escribir(salida+"\n");
    }

    public void escribir(char salida){
        this.salida.append(""+salida);
    }

    public void escribirLinea(char salida){
        this.escribir(salida+"\n");
    }

    public void escribir(boolean salida){
        this.salida.append(""+salida);
    }

    public void escribirLinea(boolean salida){
        this.escribir(salida+"\n");
    }

    public void escribirLinea(){
        this.escribir("\n");
    }
}
