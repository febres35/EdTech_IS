package cienciasucv.Views.AdminViews;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cienciasucv.Views.SizeType;

class AddInstructionPanel extends CreatePanel {
    private static AddInstructionPanel instance=null;

    private AddInstructionPanel(){
        addLogo();
        this.setLayout(null);
        this.setBackground(Fondo); 
        addTitulo(" Instrucciones", 35  , 75, 102, 20, 16);
        addButtons();
        Inst = new JTextArea();
        addTextArea(Inst, 40, 150, 432,420,true);
        Rectangle dimensiones=Inst.getBounds();
        JScrollPane Instructions = new JScrollPane(Inst,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        Instructions.setBounds(dimensiones);
        Inst.setText(CreateExamPanel.InstructionsArea.getText());
        Inst.setLineWrap(true);
        Inst.setWrapStyleWord(true);
        Inst.setAutoscrolls(true);
        this.add(Instructions);
        instruccionesFrame();
        Guardar.addActionListener ((ActionListener) new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                JFrame parentFrame=(JFrame)getRootPane().getParent();
                String instrucciones=Inst.getText();
                CreateExamPanel.setInstructionsArea(instrucciones);
                JOptionPane.showMessageDialog(null, "Instruccion Editada");
                parentFrame.dispose();
            }
            
        });
    }
    
    private Button Guardar;
    private JTextArea Inst;

    protected void addLogo(){
        Logo labelLogo= new Logo(SizeType.MEDIUM, 15, 10);
        add(labelLogo);
    }
    
    private void addButtons(){
           Guardar=new Button(SizeType.MEDIUM, "GUARDAR", 362, 600);
           this.add(Guardar);
        }      
    
    public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawRect(25, 85, 462, 500);
        }
    
    public void instruccionesFrame(){
        addFrameInfo("<html><body>Ingrese las instrucciones a seguir por los estudiantes a la hora de<br>presentar el examen:</body></html>", 40, 90, 600, 50);
    }
    
    public static AddInstructionPanel getInstructionsPanel(){
        if(instance==null){
            instance = new AddInstructionPanel();
        }
        instance.setVisible(true);
        return instance; 
    }

}