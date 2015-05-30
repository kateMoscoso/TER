package utils;

public class Intervalo {

    private int minimo;
    private int maximo;

    public Intervalo(int minimo, int maximo) {
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public Intervalo(Intervalo intervalo) {
        this(intervalo.getMinimo(), intervalo.getMaximo());
    }

    public int getMinimo() {
        return minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public int longitud() {
        return maximo - minimo;
    }

    public int puntoMedio() {
        return (maximo + minimo) / 2;
    }

    public Intervalo copia() {
        return new Intervalo(minimo, maximo);
    }

    public Intervalo simetrico() {
        return new Intervalo(-maximo, -minimo);
    }

    public void desplazar(int cantidad) {
        minimo += cantidad;
        maximo += cantidad;
    }

    public Intervalo desplazado(int cantidad) {
        Intervalo intervalo = this.copia();
        intervalo.desplazar(cantidad);
        return intervalo;
    }

    public boolean incluye(int punto) {
        return minimo <= punto && punto <= maximo;
    }

    public boolean incluye(Intervalo intervalo) {
        return this.incluye(intervalo.getMinimo()) &&
                this.incluye(intervalo.getMaximo());
    }
}

