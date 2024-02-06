package cienciasucv.Views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cienciasucv.Views.AdminViews.AdminView;
import cienciasucv.Views.StudentViews.StudentView;

public class LoginView {

    JButton adminButton;
    JButton studentButton;
    JFrame frame;

    public LoginView(){
 
        frame = new JFrame("Login Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 340);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JLabel logoLabel2 = LogoFactory.getLogo(SizeType.SMALL);
        
        adminButton =  Buttons.getButton("Admin", SizeType.LARGE);
        studentButton = Buttons.getButton("Student", SizeType.LARGE);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 1;

        panel.add(logoLabel2, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
     
        panel.add(adminButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(15, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
          
        panel.add(studentButton, gbc);

        frame.add(panel);
        

 studentButton.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentView studentView = new StudentView("Jhon Smith");
                
                frame.dispose();
            }
        });

        adminButton.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminView adminView = new AdminView("María Paula Herrero");
                
                frame.dispose();
            }
        });

    }

    public void startLoginView(Boolean visible){
        frame.setVisible(visible);

    }
}
