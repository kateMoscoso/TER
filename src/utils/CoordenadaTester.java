package utils;

public class CoordenadaTester {

    private void igualesTest(){
        Coordenada laMisma = new Coordenada(1,2);
        Coordenada[][] coordenadas = {
                {laMisma, laMisma},
                {new Coordenada(3,4), new Coordenada(3,4)},
                {new Coordenada(100,-4), new Coordenada(100,-4)},
        };
        for (Coordenada[] fila : coordenadas){
            assert fila[0].iguales(fila[1]) : "No compara bien en igualdad";        
        }
    }
    
    private void noIgualesTest(){
        Coordenada[][] coordenadas = {
                {new Coordenada(4,3), new Coordenada(3,4)},
                {new Coordenada(100,-4), new Coordenada(0,-4)},
        };
        for (Coordenada[] fila : coordenadas){
            assert !fila[0].iguales(fila[1]) : "No compara bien en igualdad";
        }
    }
    
    private void test(){
        this.igualesTest();
        this.noIgualesTest();
    }
    
    public static void main (String[] arg){
        new CoordenadaTester().test();
    }
}
