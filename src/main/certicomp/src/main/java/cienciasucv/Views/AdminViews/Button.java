package cienciasucv.Views.AdminViews;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

import cienciasucv.Views.SizeType;

class Button extends JButton {
    Button(SizeType size ,String text, int x, int y){
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
