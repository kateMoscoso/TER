package ticTacToe.models;

public class TurnoTester {

    private Turno turno;
    
    private void constructorTest(){
        turno = new Turno();
        assert turno.toca()==Turno.CRUZ : "No incializa bien";
    }
    
    private void cambiarTest(){
        turno = new Turno();
        turno.cambiar();
        assert turno.toca()==Turno.NO_CRUZ : "No cambia bien"; 
        turno.cambiar();
        assert turno.toca()==Turno.CRUZ : "No cambia bien"; 
    }
    
    private void tocaTest(){
        turno = new Turno();
        assert turno.toca()==Turno.CRUZ : "No toca bien";  
    }
    
    public void test(){
        this.constructorTest();
        this.cambiarTest();
        this.tocaTest();
    }
    
    public static void main (String[] arg){
        new TurnoTester().test();
    }
}
