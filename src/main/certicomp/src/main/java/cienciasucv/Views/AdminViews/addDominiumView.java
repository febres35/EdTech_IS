package cienciasucv.Views.AdminViews;

import javax.swing.*;

public class addDominiumView extends JFrame{

    public addDominiumView(){
        JLabel logoDominium = new JLabel();
        addDominiumPanel panelDominio = new addDominiumPanel();
        panelDominio.addLogo(logoDominium);

        this.setBounds(900, 40, 530, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Añadir/Editar Dominios");
        this.add(logoDominium);
        this.add(panelDominio);
    }

}