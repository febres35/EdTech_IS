package cienciasucv.Views.AdminViews;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.Toolkit;

public class CreateExamView extends JFrame{
    public CreateExamPanel panel;
    public CreateExamView(){
        JLabel labelLogo = new JLabel();
        panel = new CreateExamPanel();
        panel.addLogo(labelLogo);
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension sizePantalla=miPantalla.getScreenSize();

        this.setBounds(80, 20, 640, 800);
   
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Administrador|Crear Examen");
        this.add(labelLogo);
        this.add(panel);
    }
}