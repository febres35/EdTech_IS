package cienciasucv.Controllers;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import cienciasucv.Models.*;
import cienciasucv.Views.AdminViews.RegisterCourseView;

public class RegisterCourseController {

    private RegisterCourseView view; 

    public RegisterCourseController(RegisterCourseView view) {
        this.view = view;
    }

    private String generateCourseId() {
        int nextId = 1;
        File file = new File("courses.json");
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                JsonObject courses = new Gson().fromJson(reader, JsonObject.class);
                for (String courseId : courses.keySet()) {
                    int currentIdNumber = Integer.parseInt(courseId.substring(1));
                    nextId = Math.max(nextId, currentIdNumber + 1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "C" + String.format("%03d", nextId);
    }
    
    public void registerNewCourse(Course course) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject courses = new JsonObject();
        File file = new File("courses.json");
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
            courses = new Gson().fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    courses.add(course.getID(), gson.toJsonTree(course.getAttributes()));
    
    try (FileWriter writer = new FileWriter("courses.json")) {
        gson.toJson(courses, writer);
        System.out.println("Curso registrado exitosamente.");
    } catch (IOException e) {
        System.out.println("Error, curso no registrado." + e.getMessage());
    }
}
    


public void collectCourseData(){

    String id = generateCourseId();

    Map<String, Object> courseAttributes = new HashMap<>();
    String[] exams = new String[0];

    courseAttributes.put("name", view.getCourseName());
    courseAttributes.put("category", view.getCourseCategories());
    courseAttributes.put("teachers", view.getCourseTeachers());
    courseAttributes.put("prerequisites", view.getCoursePrerequisites());
    courseAttributes.put("description", view.getCourseDescription());
    
    courseAttributes.put("exams", exams );
    Course course = new Course(id, courseAttributes);

    registerNewCourse(course);

}

    
}
