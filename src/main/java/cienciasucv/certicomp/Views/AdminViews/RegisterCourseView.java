package cienciasucv.certicomp.Views.AdminViews;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cienciasucv.certicomp.Controllers.RegisterCourseController;
import cienciasucv.certicomp.Views.ButtonSize;
import cienciasucv.certicomp.Views.Buttons;
import cienciasucv.certicomp.Views.LogoFactory;
import cienciasucv.certicomp.Views.LogoSize;

public class RegisterCourseView extends JFrame{

    RegisterCourseController controller;

    private JTextField courseField;
    private JComboBox<String> courseCategories;
    private JTextArea teachersArea;
    private JTextArea prerequisitesArea;
    private JTextArea descriptionArea;

    public RegisterCourseView(){

        controller = new RegisterCourseController(this);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

         JPanel logoPanel = new JPanel();
         logoPanel.add(LogoFactory.getLogo(LogoSize.SMALL));

         JLabel title = new JLabel("Registrar Curso");
         JPanel centralPanel = new JPanel();
         title.setFont(new Font("Roboto", Font.BOLD, 25));
         title.setHorizontalAlignment(JLabel.CENTER);
         centralPanel.setLayout(new GridBagLayout());
         
         JLabel courseLabel = new JLabel("Nombre:");
         courseField = new JTextField(35);
         
         JLabel categoryLabel = new JLabel("Categoría: ");
         courseCategories = new JComboBox<>();
         courseCategories.setPreferredSize(new Dimension(300, 25));

         courseCategories.addItem("--- Seleccionar Categoría ---");
         courseCategories.addItem("Lenguajes de Programación");
         courseCategories.addItem("Bases de Datos");
         courseCategories.addItem("Sistemas Operativos");

         JLabel teachersLabel = new JLabel("Profesor(es):");
         teachersArea = new JTextArea(3, 35);
         JScrollPane teachersscrollPane = new JScrollPane(teachersArea);

         JLabel prerequsitesLabel = new JLabel("Pre-requisitos:");
         prerequisitesArea = new JTextArea(3, 35);
         prerequisitesArea.setLineWrap(true);
         prerequisitesArea.setWrapStyleWord(true);
         JScrollPane prerequisitesScrollPane = new JScrollPane(prerequisitesArea);

         JLabel descriptionLabel = new JLabel("Descripción:");
         descriptionArea = new JTextArea(3, 35);
         descriptionArea.setLineWrap(true);
         descriptionArea.setWrapStyleWord(true);
         JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);

         GridBagConstraints gbc = new GridBagConstraints();

         gbc.gridx = 0;
         gbc.gridy = 0;
         gbc.anchor = GridBagConstraints.WEST;
         centralPanel.add(title, gbc);

         gbc.gridx = 0;
         gbc.gridy = 1;
         gbc.anchor = GridBagConstraints.WEST;
         gbc.insets = new Insets(0, 0, 10, 0);
         centralPanel.add(courseLabel, gbc);

         gbc.gridx = 0;
         gbc.gridy = 2;
         gbc.anchor = GridBagConstraints.WEST;
         centralPanel.add(courseField, gbc);


         gbc.gridx = 0;
         gbc.gridy = 3;
         gbc.anchor = GridBagConstraints.WEST;
         gbc.insets = new Insets(0, 0, 10, 0);
         centralPanel.add(categoryLabel, gbc);

         gbc.gridx = 0;
         gbc.gridy = 4;
         gbc.anchor = GridBagConstraints.WEST;
         centralPanel.add(courseCategories, gbc);

         gbc.gridx = 0;
         gbc.gridy = 5;
         gbc.anchor = GridBagConstraints.WEST;
         gbc.insets = new Insets(0, 0, 10, 0);
         centralPanel.add(teachersLabel, gbc);

         gbc.gridx = 0;
         gbc.gridy = 6;
         gbc.anchor = GridBagConstraints.WEST;
         centralPanel.add(teachersscrollPane, gbc);

         gbc.gridx = 0;
         gbc.gridy = 7;
         gbc.anchor = GridBagConstraints.WEST;
         gbc.insets = new Insets(0, 0, 10, 0);
         centralPanel.add(prerequsitesLabel, gbc);

         gbc.gridx = 0;
         gbc.gridy = 8;
         gbc.anchor = GridBagConstraints.WEST;
         centralPanel.add(prerequisitesScrollPane, gbc);

         gbc.gridx = 0;
         gbc.gridy = 9;
         gbc.anchor = GridBagConstraints.WEST;
         gbc.insets = new Insets(0, 0, 10, 0);
         centralPanel.add(descriptionLabel, gbc);

         gbc.gridx = 0;
         gbc.gridy = 10;
         gbc.anchor = GridBagConstraints.WEST;
         centralPanel.add(descriptionScrollPane, gbc);

         JButton registerButton  = Buttons.getButton("Registrar", ButtonSize.MEDIUM);
         JPanel buttonPanel = new JPanel();
         buttonPanel.setLayout(new GridBagLayout());

         gbc.gridx = 0;
         gbc.gridy = 11;
         gbc.anchor = GridBagConstraints.EAST;
         centralPanel.add(registerButton, gbc);

         mainPanel.add(logoPanel, BorderLayout.NORTH);
         mainPanel.add(centralPanel, BorderLayout.CENTER);
        // mainPanel.add(buttonPanel, BorderLayout.SOUTH);


         registerButton.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.collectCourseData();
            }
        });



        this.getContentPane().add(mainPanel);
        this.setSize(480, 600);
        this.setTitle("Administrador | Registrar Curso");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public String getCourseName() {
        return courseField.getText();
    }

    public String getCourseCategories() {
        return courseCategories.getSelectedItem().toString();
    }

    public String getCourseTeachers() {
        return teachersArea.getText();
    }

    public String getCoursePrerequisites() {
        return prerequisitesArea.getText();
    }

    public String getCourseDescription() {
        return descriptionArea.getText();
    }



    
}