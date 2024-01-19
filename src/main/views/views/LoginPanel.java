package views;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
//import java.awt.GridLayout;
//import java.awt.GridBagConstraints;

//import java.awt.FlexLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;
    public JPanel form;

    public LoginPanel() {
        this.setLayout(new BorderLayout(3, 3));
        form = new JPanel(); 
        form.setLayout(null);
        form.setBounds(40, 240, 320, 240 );


        //form.setLayout(new GridLayout(3, 2));
        //GridBagConstraints  containerForm = new GridBagConstraints(); // objeto permite pasar la columna y la fila donde se posicionara el objeto en el panel
        // Crear campos de texto para el usuario y la contraseña
        userField = new JTextField();
        userField.setBounds(getVisibleRect());
        passwordField = new JPasswordField();

        // Crear botón de inicio de sesión  
        loginButton = new JButton("Iniciar sesión");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passwordField.getPassword());

                // Aquí puedes manejar la lógica de inicio de sesión
                System.out.println("Usuario: " + username + ", Contraseña: " + password);
            }
        });

        
        // Añadir los componentes al panel
        //containerForm.gridx=0;
        //containerForm.gridy=0;
        //form.add(new JLabel("Usuario:"), containerForm);
        JLabel labelUser = new JLabel("Usuario:");
        labelUser.setBounds(getVisibleRect());
        form.add(labelUser);
        
        //containerForm.gridx=1;
        //containerForm.gridy=0;        
        //form.add(userField, containerForm);
        form.add(userField);
        //containerForm.gridx=0;
        //containerForm.gridy=1;        
        //form.add(new JLabel("Contraseña:"), containerForm);
        JLabel labelPass = new JLabel("Usuario:");
        labelPass.setBounds(getVisibleRect());
        form.add(labelPass);
        form.add(passwordField);
        //containerForm.gridx=1; 
        //containerForm.gridy=1;        
        //form.add(passwordField, containerForm);
        //containerForm.gridx=0;
        //containerForm.gridy=2;        
        //containerForm.gridwidth=2;      
        //form.add(loginButton, containerForm);
        form.add(loginButton);
        form.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Login", TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION));
        form.setVisible(true);
        this.add(form, BorderLayout.EAST);
        

    }

    public static void main(String[] args) {
        
    }

}
