package cienciasucv.certicomp.Views.AdminViews;
import cienciasucv.certicomp.Views.ButtonSize;
import cienciasucv.certicomp.Views.Buttons;
import cienciasucv.certicomp.Views.LogoFactory;
import cienciasucv.certicomp.Views.LogoSize;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddInstructionView extends JFrame{
    AddInstructionView(){
        InstructionsPanel panelInstrucciones = new InstructionsPanel();
        this.setBounds(500, 40, 530, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Añadir/Editar Instrucciones");
        this.add(panelInstrucciones);
    } 

    private class InstructionsPanel extends CreatePanel{
        public InstructionsPanel(){
        addLogo(LogoSize.SMALL,15,10);
        this.setLayout(null);
        this.setBackground(Fondo); 
        addTitulo(" Instrucciones", 35  , 75, 102, 20, 16);
        addButtons();
        Inst = CreatePanel.addTextArea(40, 150, 432,420);
        Inst.setEditable(true);
        Rectangle dimensiones=Inst.getBounds();
        JScrollPane Instructions = new JScrollPane(Inst,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        Instructions.setBounds(dimensiones);
        setInstructions(CreateExamPanel.InstructionsArea.getText());
        Inst.setLineWrap(true);
        Inst.setWrapStyleWord(true);
        Inst.setAutoscrolls(true);
        this.add(Instructions);
        instruccionesFrame();
        Guardar.addActionListener ((ActionListener) new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                JFrame parentFrame=(JFrame)getRootPane().getParent();
                CreateExamPanel.setInstructionsArea(getInstructions());
                JOptionPane.showMessageDialog(null, "Instruccion Editada");
                parentFrame.dispose();
            }
            
        });
    }
    
    private JButton Guardar;
    private JTextArea Inst;
    
    private void addButtons(){
        Guardar=Buttons.getButton("GUARDAR", ButtonSize.MEDIUM);
        Guardar.setBounds(362, 600,(int)Guardar.getPreferredSize().width,(int)Guardar.getPreferredSize().height);
        this.add(Guardar);
        }      
    
    public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawRect(25, 85, 462, 500);
        }
    
    public void instruccionesFrame(){
        addFrameInfo("<html><body>Ingrese las instrucciones a seguir por los estudiantes a la hora de<br>presentar el examen:</body></html>", 40, 90, 600, 50);
    }

    public void setInstructions(String Cont){
        this.Inst.setText(Cont);
    }
    
    public String getInstructions(){
        return this.Inst.getText().trim();
    }
    }
    
}
    

