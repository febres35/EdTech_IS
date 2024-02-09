package cienciasucv.Views.AdminViews;

import javax.swing.*;

public class AddDominiumView extends JFrame{

    public AddDominiumView(){
        JLabel logoDominium = new JLabel();
        AddDominiumPanel panelDominio = new AddDominiumPanel();
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