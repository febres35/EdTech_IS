package cienciasucv.Views.StudentViews;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyProfileView {

    JPanel profilePanel;
 
    MyProfileView(){

        // Agregar lógica de esta sección. 
        profilePanel = new JPanel();
        profilePanel.setLayout(new BorderLayout());
        JLabel label = new JLabel("¡Agregar lógica!");
        label.setHorizontalAlignment(JLabel.CENTER);
        profilePanel.add(label);
        
    }

    public JPanel getMyProfileContent() {
        return profilePanel;
    }
    
}
