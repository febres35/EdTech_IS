package cienciasucv.Views.AdminViews;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import cienciasucv.Views.*;
import cienciasucv.Views.LogoFactory;
import cienciasucv.Views.SizeType;

public class CourseManagementView extends JPanel {

    private JPanel coursePanel; 

    CourseManagementView() {
        
        coursePanel = new JPanel();
        coursePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JButton registerCourse = Buttons.getButton("Registrar Curso", SizeType.LARGE);

        JPanel logoPanel = new JPanel();
         logoPanel.add(LogoFactory.getLogo(SizeType.MEDIUM));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        coursePanel.add(logoPanel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHEAST; 
        coursePanel.add(registerCourse, gbc);


        registerCourse.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegisterCourseView();
            }
        });

    }

    public JPanel getCoursesPanelContent() {
        return coursePanel;
    }
}