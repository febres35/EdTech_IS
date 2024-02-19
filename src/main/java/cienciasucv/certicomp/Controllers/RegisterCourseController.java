package cienciasucv.certicomp.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cienciasucv.certicomp.Models.Course;
import cienciasucv.certicomp.Views.AdminViews.RegisterCourseView;


public class RegisterCourseController {
    
    Course course = new Course();
    private RegisterCourseView view; 
    
    public RegisterCourseController(RegisterCourseView view) {
        this.view = view;
    }
    
    public void collectCourseData(){
        
        String path = "src/main/resources/data/courses.json";
        String id = course.generateCourseId(path);
        Map<String, Object> courseAttributes = new HashMap<>();
        ArrayList<String> exams = new ArrayList<>();


        courseAttributes.put("name", view.getCourseName());
        courseAttributes.put("category", view.getCourseCategories());
        courseAttributes.put("teachers", view.getCourseTeachers());
        courseAttributes.put("prerequisites", view.getCoursePrerequisites());
        courseAttributes.put("description", view.getCourseDescription());
        courseAttributes.put("exams", exams);
        
        Course newCourse = new Course(id, courseAttributes);
        course.registerNewCourse(newCourse);
    }   
}
