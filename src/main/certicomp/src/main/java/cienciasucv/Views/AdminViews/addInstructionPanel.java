package cienciasucv.Views.AdminViews;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class addInstruccionPanel extends createPanel {

    JLabel newLabelInstructions;
    
    public addInstruccionPanel(){
        this.setLayout(null);
        this.setBackground(Fondo); 
        addTitulo(" Instrucciones", 35  , 75, 102, 20, 16);
        Guardar= new Button();
        aggButtons(Guardar);
        Inst = new JTextArea();
        addTextArea(Inst, 40, 150, 432,420,true);
        Rectangle dimensiones=Inst.getBounds();
        JScrollPane Instructions = new JScrollPane(Inst,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        Instructions.setBounds(dimensiones);
        Inst.setText(createExamPanel.InstructionsArea.getText());
        Inst.setLineWrap(true);
        Inst.setWrapStyleWord(true);
        Inst.setAutoscrolls(true);
        this.add(Instructions);
        instruccionesFrame();
        ActionListener oyente =new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                JFrame parentFrame=(JFrame)getRootPane().getParent();
                String instrucciones=Inst.getText();
                createExamPanel.setInstructionsArea(instrucciones);
                JOptionPane.showMessageDialog(null, "Instruccion Editada");
                parentFrame.setVisible(false);
                parentFrame.dispose();
            }
            
        };
        Guardar.addActionListener(oyente);


       
    }
    
    private Button Guardar;
    private JTextArea Inst;

    protected void addLogo(JLabel label1){
        
        this.newLabelInstructions = label1;
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/CertiCompSmall.png"));
        //****Se añadieron nuevas dimensiones width y height***
        Icon nuevaIcon = new ImageIcon(icon.getImage().getScaledInstance(280, 50, Image.SCALE_SMOOTH));
        
        //****Bloque de codigo agregado para setear la ubicacion de la label****
        newLabelInstructions.setBounds(125, 20, 280, 50);
        newLabelInstructions.setIcon(nuevaIcon); 
    }
    private void aggButtons(Button G){
           G.addButton("GUARDAR", 328, 605, 110, 40);
           G.setFont(new Font("Roboto", Font.BOLD, 14));
           this.add(G);
        }      
    public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawRect(25, 85, 462, 500);
        }
    public void instruccionesFrame(){
        addFrameInfo("<html><body>Ingrese las instrucciones a seguir por los estudiantes a la hora de<br>presentar el examen:</body></html>", 40, 90, 600, 50);
    }
}