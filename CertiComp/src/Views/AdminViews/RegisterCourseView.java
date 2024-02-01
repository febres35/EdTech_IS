import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class RegisterCourseView extends JFrame{

    RegisterCourseView(){

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

         ImageIcon certiCompLogo = new ImageIcon("CertiComp/images/SmallCertiCompLogo.png");
         JLabel logo = new JLabel(certiCompLogo);

         JPanel logoPanel = new JPanel();
         logoPanel.add(logo);

         JLabel title = new JLabel("Registrar Curso");
         JPanel centralPanel = new JPanel();
         title.setFont(new Font("Roboto", Font.BOLD, 25));
         centralPanel.setLayout(new GridBagLayout());

         GridBagConstraints gbc = new GridBagConstraints();

         gbc.gridx = 0;
         gbc.gridy = 0;
         //gbc.fill = GridBagConstraints.BOTH;
         gbc.anchor = GridBagConstraints.EAST;
         centralPanel.add(title, gbc);
         


         mainPanel.add(logoPanel, BorderLayout.NORTH);
         mainPanel.add(centralPanel, BorderLayout.CENTER);

         

         

        this.getContentPane().add(mainPanel);
        this.setSize(480, 600);
        this.setTitle("Administrador | Registrar Curso");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
    
}
