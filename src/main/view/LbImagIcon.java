package main.view;


import javax.swing.ImageIcon;
/**
 * LbImagIcon
 */
public class LbImagIcon{
    

    private static ImageIcon icon = new ImageIcon("C:\\Users\\Leonardo\\Universidad\\Ing Software\\repositorios\\EdTech_IS\\src\\main\\view\\staticFile\\img.logo_CertiComp250px.png");
    private LbImagIcon(){
    }

    public static ImageIcon getIcon() {
        return icon;
    }

}