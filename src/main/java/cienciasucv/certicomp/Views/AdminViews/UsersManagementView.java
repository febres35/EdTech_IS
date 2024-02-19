package cienciasucv.certicomp.Views.AdminViews;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

import cienciasucv.certicomp.Views.ButtonSize;
import cienciasucv.certicomp.Views.Buttons;
import cienciasucv.certicomp.Views.LogoFactory;
import cienciasucv.certicomp.Views.LogoSize;

public class UsersManagementView {

    private JPanel usersPanel; 
    RegisterUserView view;

    UsersManagementView() {

        usersPanel = new JPanel(); 
        JPanel logoPanel = new JPanel();
        logoPanel.add(LogoFactory.getLogo(LogoSize.MEDIUM));
        JButton registerUser = Buttons.getButton("Registrar Usuario", ButtonSize.LARGE);

        usersPanel.add(logoPanel);
        usersPanel.add(registerUser);

        registerUser.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view =  new RegisterUserView();
                view.start();

            }
        });
        

    }

    public JPanel getUsersPanelContent() {
        return usersPanel;
    }
}