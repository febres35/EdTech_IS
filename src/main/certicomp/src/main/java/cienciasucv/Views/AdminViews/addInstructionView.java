package cienciasucv.Views.AdminViews;

import javax.swing.*;

public class AddInstructionView extends JFrame{
    private static AddInstructionView instance = null; 
    private AddInstructionView(){
        AddInstructionPanel panelInstrucciones;
        panelInstrucciones = new AddInstructionPanel();
        this.setBounds(500, 40, 530, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Añadir/Editar Instrucciones");
        this.add(panelInstrucciones);
    } 

    public static AddInstructionView getInstructionView(){
        if(instance==null){
            instance = new AddInstructionView();
        }
        instance.setVisible(true);
        return instance; 
        }
    
    public static void destroyInstance(){
            if (instance !=null){
                instance.dispose();
                instance=null;
            }
    }
}
    

