import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CourseManagementView extends JPanel {

    private JPanel coursePanel; 

    CourseManagementView() {
        
        coursePanel = new JPanel();
        coursePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        ImageIcon certiCompLogo = new ImageIcon("images/CertiComp250.png");
        JLabel logo = new JLabel(certiCompLogo);

        ButtonFactory BigFactory = new BigButtonsFactory();
        JButton registerCourse = BigFactory.createButton("Registrar Curso");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        // gbc.insets = new Insets(-350, 5, 50, 0);
        coursePanel.add(logo, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHEAST; 
        //gbc.insets = new Insets(0, 500, 400, -200);
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