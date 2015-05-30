package utils;

public class CoordenadaViewTester {

    private GestorIOMock gestorIOMock;
    private Coordenada coordenada;
    private CoordenadaView coordenadaView;

    private static final Coordenada[] coordenadas = {
            new Coordenada(3, 4), 
            new Coordenada(33, -34),
            new Coordenada(100, -4), 
            new Coordenada(100, -41)
            };

    private void init(Coordenada coordenada) {
        gestorIOMock = new GestorIOMock();
        GestorIOFactory.setGestorIO(gestorIOMock);
        this.coordenada = coordenada;
        coordenadaView = new CoordenadaView(coordenada, "Titulo");
    }

    private void mostrarTest() {
        for (Coordenada coordenada : coordenadas) {
            this.init(coordenada);
            coordenadaView.mostrar();
            String salida = "(" + (1+coordenada.getFila()) + "," + 
                                (1+coordenada.getColumna()) + ")";
            System.out.println(salida);
            System.out.println(gestorIOMock.getSalida());
            assert gestorIOMock.getSalida().equals(salida) : "No muestra bien las coordenada";
        }
    }

    private void recogerTest() {
        for (Coordenada coordenada : coordenadas) {
            this.init(new Coordenada());
            gestorIOMock.setInt(coordenada.getFila()+1);
            gestorIOMock.setInt(coordenada.getColumna()+1);
            coordenadaView.recoger();
            assert this.coordenada.iguales(coordenada) : "No recoge bien las coordenadas";
        }
    }
    
    private void recogerTest2() {
            this.init(new Coordenada());
            gestorIOMock.setInt(5+1);
            gestorIOMock.setInt(100+1);
            coordenadaView.recoger();
            assert new Coordenada(5,100).iguales(coordenada) : "No recoge bien las coordenadas";
    }

    private void test() {
        this.mostrarTest();
        this.recogerTest();
    }

    public static void main(String[] arg) {
        CoordenadaViewTester coordenadaViewTester = new CoordenadaViewTester();
        coordenadaViewTester.test();
    }
}
