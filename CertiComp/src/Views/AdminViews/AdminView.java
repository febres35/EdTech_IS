import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AdminView extends JFrame{

    public AdminView(){

        UIManager.put("TabbedPane.selected", Color.decode("#231F20"));
        UIManager.put("TabbedPane.contentAreaColor", Color.LIGHT_GRAY);
        HomeView homePanelContent = new HomeView();
        MyProfileView profilePanelContent = new MyProfileView();
        ExamsManagementView examsPanelContent = new ExamsManagementView();
        CourseManagementView coursesPanelContent = new CourseManagementView();
        UsersManagementView usersPanelContent = new UsersManagementView();
        
        JTabbedPane adminTabbedPane = new JTabbedPane();

        adminTabbedPane.addTab("", homePanelContent.geHomeContent());
        adminTabbedPane.addTab("", examsPanelContent.getExamsPanelContent());
        adminTabbedPane.addTab("", coursesPanelContent.getCoursesPanelContent());
        adminTabbedPane.addTab("", usersPanelContent.getUsersPanelContent());
        adminTabbedPane.addTab("", profilePanelContent.getMyProfileContent());

        JLabel home = new JLabel("Inicio");
        JLabel examsManagement = new JLabel("Gestión de Exámenes");
        JLabel coursesManagement = new JLabel("Gestión de Cursos");
        JLabel usersManagement = new JLabel("Gestión de Usuarios");
        JLabel myProfile = new JLabel("Mi Perfil");

        home.setPreferredSize(new Dimension(210, 60));
        home.setForeground(Color.WHITE);
        home.setHorizontalAlignment(JLabel.CENTER);
        adminTabbedPane.setTabComponentAt(0, home);

        examsManagement.setPreferredSize(new Dimension(210, 60));
        examsManagement.setHorizontalAlignment(JLabel.CENTER);
        adminTabbedPane.setTabComponentAt(1, examsManagement);

        coursesManagement.setPreferredSize(new Dimension(210, 60));
        coursesManagement.setHorizontalAlignment(JLabel.CENTER);
        adminTabbedPane.setTabComponentAt(2, coursesManagement);

        usersManagement.setPreferredSize(new Dimension(210, 60));
        usersManagement.setHorizontalAlignment(JLabel.CENTER);
        adminTabbedPane.setTabComponentAt(3, usersManagement);

        myProfile.setPreferredSize(new Dimension(210, 60));
        myProfile.setHorizontalAlignment(JLabel.CENTER);
        adminTabbedPane.setTabComponentAt(4, myProfile);

        adminTabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                home.setForeground(Color.decode("#231F20"));
                examsManagement.setForeground(Color.decode("#231F20"));
                coursesManagement.setForeground(Color.decode("#231F20"));
                usersManagement.setForeground(Color.decode("#231F20"));
                myProfile.setForeground(Color.decode("#231F20"));
                JLabel selectedLabel = (JLabel) adminTabbedPane.getTabComponentAt(adminTabbedPane.getSelectedIndex());
                selectedLabel.setForeground(Color.WHITE);
            }
        });

        JPanel mainContenedor = new JPanel();
        mainContenedor.setLayout(new BorderLayout());

        this.getContentPane().add(adminTabbedPane);
        this.setSize(1200, 640);
        this.setTitle("Administrador | Gestión Usuarios");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}