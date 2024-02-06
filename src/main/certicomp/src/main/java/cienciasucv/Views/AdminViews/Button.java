package cienciasucv.Views.AdminViews;

import java.awt.Color;
import javax.swing.JButton;

class Button extends JButton {
    Button(){
    }
    public void addButton(String text, int x, int y, int width,int heigth){
        this.setText(text);
        this.setBounds(x,y,width,heigth);
        this.setForeground(Color.WHITE);
        this.setBackground(Color.BLACK);
    }
}
