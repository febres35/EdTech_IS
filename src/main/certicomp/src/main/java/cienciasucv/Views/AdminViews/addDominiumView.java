package cienciasucv.Views.AdminViews;

import javax.swing.*;

public class AddDominiumView extends JFrame{

    public AddDominiumView(){
        AddDominiumPanel panelDominio = new AddDominiumPanel();

        this.setBounds(900, 40, 530, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Añadir/Editar Dominios");
        this.add(panelDominio);
    }

}