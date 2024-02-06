package cienciasucv.Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class Buttons {

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
    
}
