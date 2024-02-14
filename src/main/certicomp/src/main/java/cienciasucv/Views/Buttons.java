package cienciasucv.Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class Buttons extends JButton {

    public static JButton getButton(String text, SizeType size){

        JButton button = new JButton(text);

        button.setBackground(Color.decode("#231F20"));
        button.setForeground(Color.decode("#ffffff"));
        button.setPreferredSize(new Dimension(100, 25));
        button.setFont(new Font("Roboto", Font.BOLD, 16));

        switch(size){
            case LARGE:
            button.setPreferredSize(new Dimension(200, 50));
            break;

            case MEDIUM:
            button.setPreferredSize(new Dimension(125, 40));
            break;

            case SMALL:
            button.setPreferredSize(new Dimension(100, 25));
            break;

            default:
            break;
        }

        return button;
    }
    
    public Buttons(SizeType size ,String text, int x, int y){
    int ancho;
    int alto;
    int fontS;
    ancho=0;alto=0;fontS=0;
    this.setBackground(Color.decode("#231F20"));
    this.setForeground(Color.decode("#ffffff"));
            
    switch (size) {
    case LARGE:
        ancho=175;
        alto=50;
        fontS=18;
           break;
        case MEDIUM:
        ancho=125;
        alto=40;
        fontS=14;
           break;
    case SMALL:
        ancho=100;
        alto=25;
        fontS=11;
        break;        
    default:
        break;
    }
    this.setFont(new Font("Roboto", Font.BOLD, fontS));
    this.setBounds(x, y, ancho, alto);
    this.setText(text);
    }
}
