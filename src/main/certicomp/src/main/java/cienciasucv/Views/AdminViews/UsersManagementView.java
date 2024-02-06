package cienciasucv.Views.AdminViews;

import javax.swing.JButton;
import javax.swing.JPanel;

import cienciasucv.Views.Buttons;
import cienciasucv.Views.LogoFactory;
import cienciasucv.Views.SizeType;

public class UsersManagementView extends JPanel {

    private JPanel usersPanel; 

    UsersManagementView() {

        usersPanel = new JPanel(); 


        JPanel logoPanel = new JPanel();
        logoPanel.add(LogoFactory.getLogo(SizeType.MEDIUM));

        JButton registerUser = Buttons.getButton("Registrar Usuario", SizeType.LARGE);

        usersPanel.add(logoPanel);
        usersPanel.add(registerUser);

    }

    public JPanel getUsersPanelContent() {
        return usersPanel;
    }
}