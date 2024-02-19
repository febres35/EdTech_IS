package cienciasucv.certicomp.Views.AdminViews;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import cienciasucv.certicomp.Controllers.RegisterUserController;
import cienciasucv.certicomp.Views.ButtonSize;
import cienciasucv.certicomp.Views.Buttons;
import cienciasucv.certicomp.Views.LogoFactory;
import cienciasucv.certicomp.Views.LogoSize;

public class RegisterUserView {

    private JFrame frame;
    private GridBagConstraints gbc; 
    private JPanel container;
    private JRadioButton adminRoleRadioButton;
    private JRadioButton studentRoleRadioButton;
    private ButtonGroup rolesGroup;
    private JTextField userNameField;
    private JTextField userLastnameField;
    private JLabel userName;
    private JLabel userLastName;
    private JLabel userNationalID;
    private JLabel title;
    private JLabel subtitle;
    private JLabel userEmail;
    private JLabel userPassword;
    private JLabel usersRole;
    private JTextField userEmailField;
    private JPasswordField userPasswordField;
    private JTextField userNationalIDField;
    private JPanel logoPanel;
    private JButton registerButton;
    private RegisterUserController control = new RegisterUserController();

    public RegisterUserView(){
  
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Administrador | Registrar Usuario");
        frame.setSize(480, 600);

        container = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 0, 0,0);

        title = new JLabel("Registrar Usuario");
        subtitle = new JLabel("Introduzca los datos del nuevo usuario:");
        title.setFont(new Font("Roboto", Font.BOLD, 25));
        subtitle.setFont(new Font("Roboto", Font.BOLD, 12));
        title.setHorizontalAlignment(JLabel.CENTER);
        subtitle.setHorizontalAlignment(JLabel.CENTER);

        logoPanel = new JPanel();
        logoPanel.add(LogoFactory.getLogo(LogoSize.SMALL));

        userName = new JLabel("Nombre: ");
        userNameField = new JTextField(30);

        userLastName = new JLabel("Apellido: ");
        userLastnameField = new JTextField(30);

        userNationalID = new JLabel("N\u00BA de Cédula: ");
        userNationalIDField = new JTextField(30);

        userEmail = new JLabel("Email: ");
        userEmailField = new JTextField(30);

        userPassword = new JLabel("Contraseña: ");
        userPasswordField = new JPasswordField(25);

        usersRole = new JLabel("Rol Usuario: ");
        adminRoleRadioButton = new JRadioButton("Administrador");
        studentRoleRadioButton = new JRadioButton("Estudiante");

        rolesGroup = new ButtonGroup();
        rolesGroup.add(adminRoleRadioButton);
        rolesGroup.add(studentRoleRadioButton);

        registerButton  = Buttons.getButton("Registrar", ButtonSize.MEDIUM);

        addComponent(container, logoPanel,  gbc, 0, 0);
        addComponent(container, title,  gbc, 0, 1);
        addComponent(container, subtitle,  gbc, 0, 2);
        addComponent(container, userName,  gbc, 0, 3);
        addComponent(container, userNameField, gbc, 0, 4);
        addComponent(container, userLastName, gbc, 0, 5);
        addComponent(container, userLastnameField, gbc, 0, 6);
        addComponent(container, userNationalID, gbc, 0, 7);
        addComponent(container, userNationalIDField, gbc, 0, 8);
        addComponent(container, userEmail, gbc, 0, 9);
        addComponent(container, userEmailField, gbc, 0, 10);
        addComponent(container, userPassword, gbc, 0, 11);
        addComponent(container, userPasswordField, gbc, 0, 12);
        addComponent(container, usersRole, gbc, 0, 13);
        addComponent(container, adminRoleRadioButton, gbc, 0, 14);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 150, 0, 0);
        addComponent(container, studentRoleRadioButton, gbc, 0, 14);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(20, 0, 0,0);
        addComponent(container, registerButton, gbc, 0, 15);

        frame.add(container);

        
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 ArrayList<String> data = new ArrayList<String>();
                 data.add(userNameField.getText());
                 data.add(userLastnameField.getText());
                 control.collectUserDataInput(data);
            }
        });
 }

   

    private void addComponent(Container container, Component component, GridBagConstraints gbc, int gridx, int gridy) {

        gbc.gridx = gridx;
        gbc.gridy = gridy;
        container.add(component, gbc); 

}

    public void start(){

        

        frame.setVisible(true);

    }
}
