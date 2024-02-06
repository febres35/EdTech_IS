package cienciasucv.Views.AdminViews;

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

import cienciasucv.crearexamen;
import cienciasucv.Models.Course;
import cienciasucv.Views.Buttons;
import cienciasucv.Views.LogoFactory;
import cienciasucv.Views.SizeType;
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

        JButton createExam =  Buttons.getButton("Crear Examen", SizeType.SMALL);
        JButton addQuestions =  Buttons.getButton("Cargar Preguntas", SizeType.SMALL);
        
        JPanel logoPanel = new JPanel();
        logoPanel.add(LogoFactory.getLogo(SizeType.MEDIUM));

        examsPanel.add(createExam);
        examsPanel.add(addQuestions);
        examsPanel.add(logoPanel);

        createExam.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new crearexamen();
            }
        });

        addQuestions.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddQuestions();
            }
        });

    
    }private void loadCourses() {

        Gson gson = new Gson();
        type = new TypeToken<Map<String, Course>>(){}.getType();

        try {
            Map<String, Course> courses = gson.fromJson(new FileReader("courses.json"), type);
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