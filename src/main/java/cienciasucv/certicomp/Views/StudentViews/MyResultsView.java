package cienciasucv.certicomp.Views.StudentViews;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyResultsView {

    JPanel resultsPanel;
    JTable resultsTable;
    JTable myCoursesTable;
    DefaultTableModel resultsTableModel; 
    DefaultTableModel myCoursesTableModel;           

    MyResultsView(){

        

        resultsPanel = new JPanel();
        resultsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        resultsTableModel = new DefaultTableModel(new Object[]{"Mis Exámenes", "Nivel", "Curso", "Fecha", "Total Preguntas\nAprobadas", "Total Preguntas\nReprobadas", "Acción"}, 0);
        resultsTable = new JTable(resultsTableModel);

        myCoursesTableModel = new DefaultTableModel(new Object[]{"Curso", "Acción"}, 0);
        myCoursesTable = new JTable(myCoursesTableModel);

        JScrollPane scrollPane = new JScrollPane(resultsTable);
        JScrollPane scrollPane2 = new JScrollPane(myCoursesTable);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5; 
        gbc.weighty = 0.5; 
        gbc.insets = new Insets(25, 25, 25, 25);
        resultsPanel.add(scrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0; 
        gbc.weighty = 1.0; 
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
     
        resultsPanel.add(scrollPane2, gbc);
    }
    

    public JPanel getResultsPanelContent() {
        return resultsPanel;
    }
}
