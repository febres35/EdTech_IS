package cienciasucv.Views.AdminViews;

import javax.swing.*;

class AddDominiumView extends JFrame{
    private static AddDominiumView instance = null;
    private AddDominiumView(){
        AddDominiumPanel panelDominio;
        panelDominio = new AddDominiumPanel();
        this.setBounds(900, 40, 530, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Añadir/Editar Dominios");
        this.add(panelDominio);
    }

    public static AddDominiumView getDominiumView(){
        if(instance==null){
            instance = new AddDominiumView();
        }
        instance.setVisible(true);
        return instance; 
    }
    public static void destroyInstance(){
        if (instance !=null){
            instance.dispose();
            instance=null;
        }
    }
    }