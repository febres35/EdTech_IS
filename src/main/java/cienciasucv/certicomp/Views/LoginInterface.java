package cienciasucv.certicomp.Views;

import javax.swing.*;

import cienciasucv.certicomp.Controllers.LoginController;
import cienciasucv.certicomp.Models.User;
import cienciasucv.certicomp.Views.AdminViews.AdminView;
import cienciasucv.certicomp.Views.StudentViews.StudentView;

import java.awt.*;
import java.awt.event.*;

public class LoginInterface extends javax.swing.JFrame {

    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private JTextField txtCorreo;
    private JPasswordField txtContrasenia;

    public LoginInterface() {
        initComponents();
    }

        private void initComponents() {

            setTitle("Inicio de Sesion");
            setLocation(263, 100);
            
            jSeparator1 = new JSeparator();
            jLabel1 = new JLabel();
            jLabel2 = new JLabel();
            jLabel3 = new JLabel();
            jPanel1 = new JPanel();
            jLabel4 = new JLabel();
            txtCorreo = new JTextField();
            jLabel5 = new JLabel();
            txtContrasenia = new JPasswordField();
            btnIniciarSesion = Buttons.getButton("INGRESAR", ButtonSize.LARGE);
    
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    
            jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
            jSeparator1.setBackground(Color.DARK_GRAY);
    
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CertiCompMedium.png"))); 
    
            jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); 
            jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel2.setText("ESCUELA DE COMPUTACIÓN UCV");
    
            jLabel3.setFont(new java.awt.Font("Arial", 1, 48));
            jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel3.setText("Inicio de Sesión");
    
            jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Ingresa tus credenciales", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 16))); 
    
            jLabel4.setFont(new java.awt.Font("Arial Black", 1, 18));
            jLabel4.setText("Correo:");
    
            jLabel5.setFont(new java.awt.Font("Arial Black", 1, 18)); 
            jLabel5.setText("Contraseña:");
    
            btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnIniciarSesionActionPerformed(evt);
                }
            });
    
            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtContrasenia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnIniciarSesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(15, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)
                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(30, Short.MAX_VALUE))
            );
    
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(85, 85, 85)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(43, 43, 43)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(38, 38, 38)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(52, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(111, 111, 111)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(69, 69, 69)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
    
            pack();
        }                      
    
        
            public void btnIniciarSesionActionPerformed(ActionEvent e) {
                LoginController controller = new LoginController();
                String correo = txtCorreo.getText();
                String contrasenia = String.valueOf(txtContrasenia.getPassword());
                User userLogged = new User(controller.checkCredentials(correo, contrasenia));
                
                if (!userLogged.getNationalID().equals("")) {

                    JOptionPane.showMessageDialog(LoginInterface.this, "Inicio de sesión exitoso");

                    if((userLogged.getRole().toLowerCase().equals("student"))||(userLogged.getRole().toLowerCase().equals("estudiante"))){
                        StudentView studentView = new StudentView(new String(userLogged.getName()+" "+userLogged.getLastname()));
                    }else if((userLogged.getRole().toLowerCase().equals("admin"))||(userLogged.getRole().toLowerCase().equals("administrador"))){
                        AdminView adminView = new AdminView(new String(userLogged.getName()+" "+userLogged.getLastname()));
                    }
                       
                    
                } else {
                    JOptionPane.showMessageDialog(LoginInterface.this, "Error: correo o contraseña incorrectos");
                }
                
            }
              
                                      
            public static void main(String args[]) {
        
                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new LoginInterface().setVisible(true);
                    }
                });
            }
        
    }