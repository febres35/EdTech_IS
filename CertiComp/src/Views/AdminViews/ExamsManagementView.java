import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class ExamsManagementView extends JPanel {

    private JPanel examsPanel; 

    ExamsManagementView() {

        examsPanel = new JPanel(); 
        examsPanel.setLayout(new BorderLayout());
        JLabel profileLabel = new JLabel("This is Exam Management View - Coming soon");
        profileLabel.setHorizontalAlignment(JLabel.CENTER);
        examsPanel.add(profileLabel);
    }

    public JPanel getExamsPanelContent() {
        return examsPanel;
    }
}