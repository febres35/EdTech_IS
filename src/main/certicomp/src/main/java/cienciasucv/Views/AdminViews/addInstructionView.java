package cienciasucv.Views.AdminViews;

import javax.swing.*;
public class AddInstructionView extends JFrame{

    public AddInstructionView(){
    JLabel logoInstructions = new JLabel();
    panelInstrucciones = new addInstruccionPanel();
    panelInstrucciones.addLogo(logoInstructions);

    this.setBounds(500, 40, 530, 700);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("Añadir/Editar Instrucciones");
    this.add(logoInstructions);
    this.add(panelInstrucciones);
    }
    private addInstruccionPanel panelInstrucciones; 
    
}
