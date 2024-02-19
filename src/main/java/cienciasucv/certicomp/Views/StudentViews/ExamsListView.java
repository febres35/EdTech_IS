package cienciasucv.certicomp.Views.StudentViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

import cienciasucv.certicomp.Controllers.ExamListController;
import cienciasucv.certicomp.Views.ButtonListener;
import cienciasucv.certicomp.Views.ExamsTableBuilder;
import cienciasucv.certicomp.Views.LogoFactory;
import cienciasucv.certicomp.Views.LogoSize;
import cienciasucv.certicomp.Views.TableDirector;


public class ExamsListView {

    private JPanel examsListPanel;
    private TableDirector director;
    private ExamsTableBuilder builder;
    private JScrollPane scrollPane;
    private JTable examTable;
    private Object[][] data;
    private ExamListController controller;

    public ExamsListView(){

        controller = new ExamListController();

        examsListPanel = new JPanel();
        examsListPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0; 
        gbc.weighty = 0.0;
        gbc.anchor = GridBagConstraints.NORTHWEST;

         JPanel logoPanel = new JPanel();
         logoPanel.setLayout(new GridBagLayout());
         
         logoPanel.add(LogoFactory.getLogo(LogoSize.SMALL));

        JComboBox<String> coursesComboBox = new JComboBox<String>();

        JLabel selectCourse = new JLabel("Seleccionar Curso: ");
        Map<String, String> courses = controller.loadCourses();
        coursesComboBox.addItem("--Seleccionar Curso--");

        for(Map.Entry<String, String> entry : courses.entrySet()){
            coursesComboBox.addItem(entry.getKey() + " - " + entry.getValue());
        }

        JPanel courseDetails = new JPanel();
        Border titled = BorderFactory.createTitledBorder("Detalles curso");

        
        String[] columnNames = {"ID", "Examen", "N Preguntas","Duración", "Acciones"};
        String[][] data = {};
    
        this.director = new TableDirector();
        this.builder = new ExamsTableBuilder();

        ButtonListener buttonListener = new ButtonListener() {
            @Override
            public void onButtonClick(String id) {
                System.out.println("Debugging - Button clicked with ID: " + id);
                InstructionsView instructions = new InstructionsView();
                instructions.displayInstructions(id);
            }
        };
        
        builder.setButtonClickListener(buttonListener);
        TableDirector.buildTable(builder, data, columnNames);
        //builder.setCellRenderer();
        this.examTable = builder.getResult();
        examTable.getColumnModel().getColumn(1).setPreferredWidth(250);
        examTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        scrollPane = new JScrollPane(examTable);
        scrollPane.setPreferredSize(new Dimension(650, 200));

        JPanel table = new JPanel();
        table.add(scrollPane);
        table.setMaximumSize(new Dimension(600, 200));
        JLabel courseName = new JLabel("Curso:");
        courseDetails.setMaximumSize(new Dimension(200, 200));
        courseDetails.add(courseName);

        

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(-30, 20, 100, 0); 

        examsListPanel.add(logoPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(-15, 20, 0, 0); 
        examsListPanel.add(selectCourse, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 20, 15, 0); 
    
        examsListPanel.add(coursesComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 20, 15, 0); 
        examsListPanel.add(table, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
 
        courseDetails.setBorder(BorderFactory.createTitledBorder("Detalles Curso"));

        examsListPanel.add(courseDetails, gbc);


        coursesComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    String selectedCourse = event.getItem().toString();
                    
                    if(selectedCourse != "--Seleccionar Curso--"){
                        String[] nameParts = selectedCourse.split(" - ", 2);
                        String courseID = nameParts[0];
                        System.out.println("Selected course " + courseID);
                        String[][] tableData = controller.updateExamstable(courseID);
                        setTableData(tableData);
                         
                    }else{
                        JOptionPane.showMessageDialog(null, "Debe seleccionar un curso.");
                    }
                }
            }   
        });
    }

    public void setTableData(Object[][] tableData){
        builder.setData(tableData);
    }


    public JPanel getExamsPanelContent() {
       
        return examsListPanel;
    }
}
