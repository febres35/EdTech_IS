package cienciasucv.Views;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LogoFactory {
    public static JLabel getLogo(SizeType size) {
       
        String imagePath = "";

        switch (size) {
            case SMALL:
                imagePath = "/images/CertiCompSmall.png";
                break;
            case MEDIUM:
                imagePath = "/images/CertiCompMedium.png";
                break;
            case LARGE:
                imagePath = "/images/CertiCompLarge.png";
                break;
            default:
            break;
        }

        try {

            InputStream stream = LogoFactory.class.getResourceAsStream(imagePath);
            BufferedImage image = ImageIO.read(stream);
            ImageIcon logoIcon = new ImageIcon(image);
            return new JLabel(logoIcon);

        } catch (IOException e) {
            throw new RuntimeException("Ha ocurrido un error al cargar el logo", e);
        }
    }

    public static JLabel getLogo(SizeType type, int x , int y){
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
        ImageIcon icon = new ImageIcon(LogoFactory.class.getResource("/images/CertiCompSmall.png"));
        Icon nuevaIcon = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
        JLabel logo= new JLabel();
        logo.setBounds(x, y, ancho, alto);
        logo.setIcon(nuevaIcon); 
        return logo;
    }
}
