import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class MyProfileView extends JPanel {

    private JPanel profilePanel; 

    MyProfileView() {

        profilePanel = new JPanel(); 
        profilePanel.setLayout(new BorderLayout());
        JLabel profileLabel = new JLabel("This is My Profile View - Coming Soon");
        profileLabel.setHorizontalAlignment(JLabel.CENTER);
        profilePanel.add(profileLabel);
    }

    public JPanel getMyProfileContent() {
        return profilePanel;
    }
}