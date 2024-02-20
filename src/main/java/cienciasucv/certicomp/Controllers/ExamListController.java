package cienciasucv.certicomp.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import cienciasucv.certicomp.Models.Course;
import cienciasucv.certicomp.Views.StudentViews.ExamsListView;

public class ExamListController implements ActionListener{

    private ExamsListView view;

    public ExamListController() {

    }

    public void setView(ExamsListView view) {
        this.view = view;
    }

    public String[][] updateExamstable(String courseID){

        String[][] exams = Course.getExams(courseID);
        return exams;

    }

    public Map<String, String> loadCourses(){

        Map<String, String> courses = new HashMap<>();
         courses = Course.getCoursesInfo();

        return courses;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}