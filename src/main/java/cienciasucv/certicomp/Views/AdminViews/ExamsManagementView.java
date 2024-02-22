package cienciasucv.certicomp.Views.AdminViews;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cienciasucv.certicomp.Controllers.ExamListController;
import cienciasucv.certicomp.Models.Course;
import cienciasucv.certicomp.Models.Exam;
import cienciasucv.certicomp.Views.ButtonSize;
import cienciasucv.certicomp.Views.Buttons;
import cienciasucv.certicomp.Views.LogoFactory;
import cienciasucv.certicomp.Views.LogoSize;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class ExamsManagementView extends JPanel {

    static DefaultTableModel examsTableModel;
    private JPanel examsPanel; 
    private java.lang.reflect.Type type;
    private static JComboBox<String> comboBox;
    private ExamListController controller;
    private String examSelectedID;

    ExamsManagementView() {

        controller= new ExamListController();

        examsPanel = new JPanel();
        examsPanel.setLayout(new GridBagLayout());

        examsPanel = new JPanel();
        JLabel selectCourse = new JLabel("Seleccionar Curso: ");
    
        final JTable examsTable;
    
       examsTableModel = new DefaultTableModel(new Object[]{"ID", "Exámenes", "N Preguntas", "Duración", "Fecha Creación" }, 0);
        examsTable = new JTable(examsTableModel){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        examsTable.setDefaultEditor(Object.class, null);

        examsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                   
                    int selectedRow = examsTable.getSelectedRow();
                    if (selectedRow != -1) { 
                        examSelectedID = examsTable.getValueAt(selectedRow, 0).toString(); 
                        System.out.println(examSelectedID);
                    }
                }
            }
        });
        
        
        JScrollPane scrollPane = new JScrollPane(examsTable);

        examsPanel.add(selectCourse);
        loadCourses();
        examsPanel.add(scrollPane);

        JButton editExamButton = Buttons.getButton("Editar", ButtonSize.SMALL);
        JButton deleteExamButton = Buttons.getButton("Borrar", ButtonSize.SMALL);
        JButton createExam =  Buttons.getButton("Crear Examen", ButtonSize.SMALL);
        JButton addQuestions =  Buttons.getButton("Cargar Preguntas", ButtonSize.SMALL);

        
        
        JPanel logoPanel = new JPanel();
        logoPanel.add(LogoFactory.getLogo(LogoSize.MEDIUM));

        examsPanel.add(editExamButton);
        examsPanel.add(deleteExamButton);
        examsPanel.add(createExam);
        examsPanel.add(addQuestions);
        examsPanel.add(logoPanel);

        createExam.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CreateExamView();
            }
        });

        addQuestions.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddQuestionsView();
            }
        });

        editExamButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e){
                if(examSelectedID != ""){
                    new EditExamView(Exam.getExam(examSelectedID));
                }else{
                    JOptionPane.showMessageDialog(null, "Por Favor seleccione un mensaje");
                }
             }
        });

        deleteExamButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               if(examSelectedID != ""){
                   Exam.deleteExam(examSelectedID);
               }else{
                   JOptionPane.showMessageDialog(null, "Por Favor seleccione un mensaje");
               }
            }
       });

    
    }private void loadCourses() {

        Gson gson = new Gson();
        type = new TypeToken<Map<String, Course>>(){}.getType();

        try {
            Map<String, Course> courses = gson.fromJson(new FileReader("src/main/resources/data/courses.json"), type);
            DefaultComboBoxModel<String> coursesModel = new DefaultComboBoxModel<>();
            coursesModel.addElement("--- Seleccionar curso ---");

            for (Map.Entry<String, Course> entry : courses.entrySet()) {
                coursesModel.addElement(entry.getKey() + " - " + entry.getValue().getName());
            }

            comboBox = new JComboBox<>(coursesModel);
            comboBox.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                       refreshTableData();
                    }
                }
            });
            examsPanel.add(comboBox);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JPanel getExamsPanelContent() {
        return examsPanel;
    }

    public static void refreshTableData() {

        String selectedCourse = comboBox.getSelectedItem().toString(); 
         if(!selectedCourse.equals("--- Seleccionar curso ---")) {
        String selectedCourseID = selectedCourse.substring(0, selectedCourse.indexOf(" - "));
        Course selectedCourseObject = Course.getCourse(selectedCourseID);
            
         examsTableModel.setRowCount(0); 
            
        for (String examID : selectedCourseObject.getExamsID()) { 
            Exam exam = Exam.exams.get(examID); 
            Object[] rowData = {
            exam.getID(),
            exam.getName(),
            String.valueOf(exam.fetchQuestions().size()),
            exam.getDuration(),
            exam.getDate()
            };
             examsTableModel.addRow(rowData); 
        }
        }
    
        examsTableModel.fireTableDataChanged();
    }
    
}