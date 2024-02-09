package cienciasucv.Views.AdminViews;
import cienciasucv.Views.AdminViews.CreatePanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class AddDominiumPanel extends CreatePanel {

    JLabel newLabelDominium;
    
    public AddDominiumPanel(){
        this.setLayout(null);
        this.setBackground(Fondo); 
        addTitulo(" Dominios", 35  , 75, 80, 20, 16);
        Guardar= new Button();
        aggButtons(Guardar);
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
        ActionListener oyente =new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                JFrame parentFrame=(JFrame)getRootPane().getParent();
                String Dominios=Doms.getText();
                CreateExamPanel.setDominumArea(Dominios);
                JOptionPane.showMessageDialog(null, "Dominios Editados");
                parentFrame.setVisible(false);
                parentFrame.dispose();
            }
            
        };
        Guardar.addActionListener(oyente);
        };
    
    private Button Guardar;
    public JTextArea Doms;

    protected void addLogo(JLabel label2){
        this.newLabelDominium = label2;
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/CertiCompSmall.png"));
        Icon nuevaIcon = new ImageIcon(icon.getImage().getScaledInstance(280, 50, Image.SCALE_SMOOTH));
        newLabelDominium.setBounds(125, 20, 280, 50);
        newLabelDominium.setIcon(nuevaIcon); 
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
        addFrameInfo("<html><body>Ingrese o edite los dominios de las preguntas que compondrán el<br>examen. Un dominio por línea:</body></html>", 40, 90, 600, 50);

    }
}