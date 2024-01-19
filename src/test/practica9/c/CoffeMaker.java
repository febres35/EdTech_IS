package test.practica9.c;

public class CoffeMaker {
    private  boolean state;
    
    public CoffeMaker(){
        this.state = false;
    }
    public void On(){
        state = true;
        System.out.println("Encendido");
    }
    public void Off(){
        state = false;
        System.out.println("Apagado");

    }
    public boolean isOff(){
        if (!state){
            return true;
        }
        return false;    
    }
}