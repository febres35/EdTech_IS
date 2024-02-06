package cienciasucv.Views.StudentViews;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cienciasucv.Models.Course;



public class ExamsListView {

    private JPanel examsListPanel;
    private java.lang.reflect.Type type;
    private JComboBox<String> comboBox;

    ExamsListView(){


        examsListPanel = new JPanel();
        JLabel selectCourse = new JLabel("Seleccionar Curso: ");
    
        JTable examsTable;
        DefaultTableModel examsTableModel;

        examsTableModel = new DefaultTableModel(new Object[]{"ID", "Exámenes", "N Preguntas", "Duración", "Acciones" }, 0);
        examsTable = new JTable(examsTableModel);

        JScrollPane scrollPane = new JScrollPane(examsTable);

        examsListPanel.add(selectCourse);
        loadCourses();
        examsListPanel.add(scrollPane);

    }

    private void loadCourses() {

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
            examsListPanel.add(comboBox);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public JPanel getExamsPanelContent() {
       
        return examsListPanel;
    }
    
}
