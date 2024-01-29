package main.view;

import javax.swing.*;
import java.awt.event.*;


public class btnSelect extends JFrame implements ActionListener {
    JButton boton1;
    
    public btnSelect() {
        setLayout(null);
        
        JFrame frame = new JFrame("Ejemplo Select");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un arreglo de opciones para el select
        String[] opciones = {"Opción 1", "Opción 2", "Opción 3"};

        // Crear un JComboBox con las opciones
        JComboBox<String> select = new JComboBox<>(opciones);

        // Agregar el JComboBox al JFrame
        frame.add(select);

        frame.pack();
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        btnSelect formulario1 = new btnSelect();
        formulario1.setBounds(0, 0, 450, 350);
        formulario1.setVisible(true);
        //formulario1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}