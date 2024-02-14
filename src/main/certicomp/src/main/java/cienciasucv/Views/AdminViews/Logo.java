package cienciasucv.Views.AdminViews;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import cienciasucv.Views.SizeType;

public class Logo extends JLabel {
    Logo(SizeType type, int x , int y){
    int ancho=0;
    int alto=0;
        switch (type) {
            case MEDIUM:
            ancho=300;
            alto=70;
                break;
            case SMALL:
            ancho=250;
            alto=60;
                break;
            default:
            break;
        }
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/CertiCompSmall.png"));
        Icon nuevaIcon = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
        this.setBounds(x, y, ancho, alto);
        this.setIcon(nuevaIcon); 
    }
}
