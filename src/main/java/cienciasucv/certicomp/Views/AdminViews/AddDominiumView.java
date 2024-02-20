package cienciasucv.certicomp.Views.AdminViews;
import cienciasucv.certicomp.Views.ButtonSize;
import cienciasucv.certicomp.Views.Buttons;
import cienciasucv.certicomp.Views.LogoSize;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class AddDominiumView extends JFrame{
    public DominiumPanel panelDominio;
    AddDominiumView(){
        panelDominio = new DominiumPanel();
        this.setBounds(900, 40, 530, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Añadir/Editar Dominios");
        this.add(panelDominio);
    }

    private class DominiumPanel extends PanelContent{
        private JButton Guardar;
        public JTextArea Doms;

    public DominiumPanel(){
        addLogo(LogoSize.SMALL,15,10);
        this.setLayout(null);
        this.setBackground(Fondo); 
        JLabel titulo=addTitulo(" Dominios", 35  , 75, 80, 20, 16);
        this.add(titulo);
        addButton();
        Doms = PanelContent.addTextArea(40, 150, 432,420);
        Doms.setEditable(true);
        Rectangle dimensiones=Doms.getBounds();
        JScrollPane dominiums = new JScrollPane(Doms,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        dominiums.setBounds(dimensiones);
        this.setDoms(CreateExamPanel.DominiumArea.getText());
        Doms.setLineWrap(true);
        Doms.setWrapStyleWord(true);
        Doms.setAutoscrolls(true);
        this.add(dominiums);
        instruccionesFrame();
        Guardar.addActionListener((ActionListener)new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                JFrame parentFrame=(JFrame)SwingUtilities.getWindowAncestor(DominiumPanel.this);
                CreateExamPanel.setDominumArea(getDoms());
                JOptionPane.showMessageDialog(null, "Dominios Editados");
                parentFrame.dispose();
            }
            
        });
    } 

    private void addButton(){
        Guardar=Buttons.getButton("GUARDAR", ButtonSize.MEDIUM);
        Guardar.setBounds(362, 600,(int)Guardar.getPreferredSize().width,(int)Guardar.getPreferredSize().height);
        this.add(Guardar);
    }      

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect(25, 85, 462, 500);
    }
    
    public void instruccionesFrame(){
        addFrameInfo("<html><body>Ingrese o edite los dominios de las preguntas que compondrán el<br>examen. Un dominio por línea:</body></html>", 40, 90, 600, 50);
    }
    
    public void setDoms(String Cont){
        this.Doms.setText(Cont);
    }
    
    public String getDoms(){
        return this.Doms.getText().trim();
    }
    
    }
}

