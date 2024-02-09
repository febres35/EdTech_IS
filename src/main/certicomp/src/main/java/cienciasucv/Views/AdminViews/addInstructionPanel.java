package cienciasucv.Views.AdminViews;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class addInstruccionPanel extends CreatePanel {

    
    public addInstruccionPanel(){
        JLabel labelLogo= new JLabel();
        addLogo(labelLogo);
        add(labelLogo);
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
                parentFrame.setVisible(false);
                parentFrame.dispose();
            }
            
        });
    }
    
    private Button Guardar;
    private JTextArea Inst;

    protected void addLogo(JLabel label){
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/CertiCompSmall.png"));
        Icon nuevaIcon = new ImageIcon(icon.getImage().getScaledInstance(250, 60, Image.SCALE_SMOOTH));
        label.setBounds(15, 10, 250, 60);
        label.setIcon(nuevaIcon); 
    }
    private void aggButtons(Button G){
           G.addButton("GUARDAR", 340, 605, 110, 40);
           G.setFont(new Font("Roboto", Font.BOLD, 16));
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