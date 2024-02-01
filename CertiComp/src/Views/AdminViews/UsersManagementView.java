import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class UsersManagementView extends JPanel {

    private JPanel usersPanel; 

    UsersManagementView() {

        usersPanel = new JPanel(); 
        usersPanel.setLayout(new BorderLayout());
        JLabel examsLabel = new JLabel("This is User Management View - Coming Soon");
        examsLabel.setHorizontalAlignment(JLabel.CENTER);
        usersPanel.add(examsLabel);
        add(usersPanel);
    }

    public JPanel getUsersPanelContent() {
        return usersPanel;
    }
}