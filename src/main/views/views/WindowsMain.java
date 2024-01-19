package views;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Color;
//import java.awt.Color;



public class WindowsMain extends JFrame{
    

    public WindowsMain(){
        this.setLayout(null);
        this.setSize(1024, 720);
        this.setTitle("EDTech");
        this.setLocationRelativeTo(null);
        setMinimumSize(new Dimension(400, 300));
        this.getContentPane().setBackground(Color.decode("#0a8c5a"));
        this.setVisible(true);
    }

    public static void main(String[] args) {
        WindowsMain ventana = new WindowsMain();
        LoginPanel login = new LoginPanel();
        login.setVisible(true);
        login.setBounds(512, 0, 496, 680);
        //login.setBackground(Color.decode("#333"));
        ventana.add(login);
    }
}
