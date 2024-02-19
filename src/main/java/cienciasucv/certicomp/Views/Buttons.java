package cienciasucv.certicomp.Views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class Buttons {
    public static JButton getButton(String text, ButtonSize size) {
        JButton button = new JButton(text);

        button.setBackground(Color.decode("#231F20"));
        button.setForeground(Color.decode("#ffffff"));
        button.setFont(new Font("Roboto", Font.BOLD, size.getFontSize()));
        button.setPreferredSize(size.getDimension());

        return button;
    }
}