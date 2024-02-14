package cienciasucv.Views.AdminViews;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import cienciasucv.Views.SizeType;
import cienciasucv.Views.Buttons;
import cienciasucv.Views.LogoFactory.Logo;

public class AddDominiumPanel extends CreatePanel {
    public AddDominiumPanel(){
        addLogo();
        this.setLayout(null);
        this.setBackground(Fondo); 
        addTitulo(" Dominios", 35  , 75, 80, 20, 16);
        addButton();
        Doms = new JTextArea();
        addTextArea(Doms, 40, 150, 432,420,true);
        Rectangle dimensiones=Doms.getBounds();
        JScrollPane dominiums = new JScrollPane(Doms,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        dominiums.setBounds(dimensiones);
        Doms.setText(CreateExamPanel.DominiumArea.getText());
        Doms.setLineWrap(true);
        Doms.setWrapStyleWord(true);
        Doms.setAutoscrolls(true);
        this.add(dominiums);
        instruccionesFrame();
        Guardar.addActionListener((ActionListener)new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                JFrame parentFrame=(JFrame)SwingUtilities.getWindowAncestor(AddDominiumPanel.this);
                CreateExamPanel.setDominumArea(Doms.getText());
                JOptionPane.showMessageDialog(null, "Dominios Editados");
                parentFrame.dispose();
            }
            
        });
    }

    private Buttons Guardar;

    public JTextArea Doms;
    
    private void addLogo(){
        Logo labelLogo= new Logo(SizeType.MEDIUM, 15, 10);
        add(labelLogo);
    }

    private void addButton(){
        Guardar=new Buttons(SizeType.MEDIUM, "GUARDAR", 362, 600);
        this.add(Guardar);
    }      

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect(25, 85, 462, 500);
    }
    
    public void instruccionesFrame(){
        addFrameInfo("<html><body>Ingrese o edite los dominios de las preguntas que compondrán el<br>examen. Un dominio por línea:</body></html>", 40, 90, 600, 50);
    }
}
