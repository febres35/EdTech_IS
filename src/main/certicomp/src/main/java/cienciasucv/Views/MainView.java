package cienciasucv.Views;

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

public abstract class MainView extends JFrame{
    protected JTabbedPane tabbedPane;

    public MainView() {

        UIManager.put("TabbedPane.selected", Color.decode("#231F20"));
        UIManager.put("TabbedPane.contentAreaColor", Color.LIGHT_GRAY);

        this.setSize(1200, 640);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.tabbedPane = new JTabbedPane();
        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }

    protected void createTabs(String[] tabTitles, JPanel[] tabPanels) {

        for (int i = 0; i < tabTitles.length; i++) {
            
            JLabel label = new JLabel(tabTitles[i]);
            label.setPreferredSize(new Dimension(210, 60));
            label.setHorizontalAlignment(JLabel.CENTER);

            tabbedPane.addTab("", tabPanels[i]);
            tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, label);
        }
        
        tabbedPane.getTabComponentAt(0).setForeground(Color.WHITE);

        this.tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {

                for (int i = 0; i < tabbedPane.getTabCount(); i++) {
                    JLabel label = (JLabel) tabbedPane.getTabComponentAt(i);
                    label.setForeground(Color.decode("#231F20"));
                }

                JLabel selectedLabel = (JLabel) tabbedPane.getTabComponentAt(tabbedPane.getSelectedIndex());
                selectedLabel.setForeground(Color.WHITE);
            }
        });
    }

}
