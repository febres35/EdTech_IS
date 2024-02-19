package cienciasucv.certicomp.Views.AdminViews;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cienciasucv.certicomp.Models.Course;
import cienciasucv.certicomp.Views.ButtonSize;
import cienciasucv.certicomp.Views.Buttons;
import cienciasucv.certicomp.Views.LogoFactory;
import cienciasucv.certicomp.Views.LogoSize;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class ExamsManagementView extends JPanel {

    private JPanel examsPanel; 
    private java.lang.reflect.Type type;
    private JComboBox<String> comboBox;

    ExamsManagementView() {

        examsPanel = new JPanel();
        examsPanel.setLayout(new GridBagLayout());

        examsPanel = new JPanel();
        JLabel selectCourse = new JLabel("Seleccionar Curso: ");
    
        JTable examsTable;
        DefaultTableModel examsTableModel;

        examsTableModel = new DefaultTableModel(new Object[]{"ID", "Exámenes", "N Preguntas", "Duración", "Fecha Creación", "Acciones" }, 0);
        examsTable = new JTable(examsTableModel);

        JScrollPane scrollPane = new JScrollPane(examsTable);

        examsPanel.add(selectCourse);
        loadCourses();
        examsPanel.add(scrollPane);

        JButton createExam =  Buttons.getButton("Crear Examen", ButtonSize.SMALL);
        JButton addQuestions =  Buttons.getButton("Cargar Preguntas", ButtonSize.SMALL);
        
        JPanel logoPanel = new JPanel();
        logoPanel.add(LogoFactory.getLogo(LogoSize.MEDIUM));

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
            Map<String, Course> courses = gson.fromJson(new FileReader("cienciasucv/certicomp/src/main/resources/data/courses.json"), type);
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
}