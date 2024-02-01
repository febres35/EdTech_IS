import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class SmallButtonsFactory implements ButtonFactory {
    @Override
    public JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.decode("#231F20"));
        button.setForeground(Color.decode("#ffffff"));
        button.setPreferredSize(new Dimension(100, 25));
        button.setFont(new Font("Roboto", Font.BOLD, 16));
        return button;
    }
}
