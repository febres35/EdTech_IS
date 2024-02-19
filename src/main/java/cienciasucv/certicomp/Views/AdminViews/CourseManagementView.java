package cienciasucv.certicomp.Views.AdminViews;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import cienciasucv.certicomp.Views.ButtonSize;
import cienciasucv.certicomp.Views.Buttons;
import cienciasucv.certicomp.Views.LogoFactory;
import cienciasucv.certicomp.Views.LogoSize;

public class CourseManagementView extends JPanel {

    private JPanel coursePanel; 

    CourseManagementView() {
        
        coursePanel = new JPanel();
        coursePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JButton registerCourse = Buttons.getButton("Registrar Curso", ButtonSize.LARGE);

        JPanel logoPanel = new JPanel();
         logoPanel.add(LogoFactory.getLogo(LogoSize.MEDIUM));

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