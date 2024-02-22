package cienciasucv.certicomp.Views.AdminViews;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cienciasucv.certicomp.Models.Course;
import cienciasucv.certicomp.Models.Exam;
import cienciasucv.certicomp.Views.ButtonSize;
import cienciasucv.certicomp.Views.Buttons;
import cienciasucv.certicomp.Views.LogoFactory;
import cienciasucv.certicomp.Views.LogoSize;
import cienciasucv.certicomp.Views.ButtonRenderer;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class ExamsManagementView extends JPanel {

    static DefaultTableModel examsTableModel;
    private JPanel examsPanel; 
    private java.lang.reflect.Type type;
    private JComboBox<String> comboBox;

    ExamsManagementView() {

        examsPanel = new JPanel();
        examsPanel.setLayout(new GridBagLayout());

        examsPanel = new JPanel();
        JLabel selectCourse = new JLabel("Seleccionar Curso: ");
    
        JTable examsTable;
    
       examsTableModel = new DefaultTableModel(new Object[]{"ID", "Exámenes", "N Preguntas", "Duración", "Fecha Creación" }, 0);
        for (final Exam exam : Exam.exams.values()) {
            Object[] rowData = {
                exam.getID(),
                exam.getName(),
                String.valueOf(exam.fetchQuestions().size()),
                exam.getDuration(),
                exam.getDate(),
            };
            examsTableModel.addRow(rowData);
        }
        examsTable = new JTable(examsTableModel){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        examsTable.setDefaultEditor(Object.class, null);

        
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
            examsPanel.add(comboBox);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JPanel getExamsPanelContent() {
        return examsPanel;
    }

    public static void refreshTableData() {
        examsTableModel.setRowCount(0); // Borra todas las filas existentes en la tabla
    
        for (Exam exam : Exam.exams.values()) {
            Object[] rowData = {
                exam.getID(),
                exam.getName(),
                 "x",
                exam.getDuration(),
                "x",
                "Editar"
            };
            examsTableModel.addRow(rowData); // Agrega una nueva fila con los datos del examen
        }
    
        examsTableModel.fireTableDataChanged(); // Notifica a la JTable que se han realizado cambios en el modelo de datos
    }
    
}