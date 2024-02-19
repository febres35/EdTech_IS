package cienciasucv.certicomp.Views;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LogoFactory {
    public static JLabel getLogo(LogoSize size) {
        String imagePath = size.getImagePath();

        try {
            InputStream stream = LogoFactory.class.getResourceAsStream(imagePath);
            BufferedImage image = ImageIO.read(stream);
            ImageIcon logoIcon = new ImageIcon(image);
            return new JLabel(logoIcon);
        } catch (IOException e) {
            throw new RuntimeException("Ha ocurrido un error al cargar el logo", e);
        }
    }
}