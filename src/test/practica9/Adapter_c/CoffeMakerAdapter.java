package test.practica9.c;

public class CoffeMakerAdapter extends Connectable {
    private CoffeMaker coffiMaker;

    public CoffeMakerAdapter(){
        coffiMaker = new CoffeMaker();
    }
    @Override
    public void turnOff() {

        coffiMaker.Off();
    }

    public void turnOn(){
        coffiMaker.On();
    }

    public boolean IsOn(){
        return !coffiMaker.isOff();
    }
    
}
