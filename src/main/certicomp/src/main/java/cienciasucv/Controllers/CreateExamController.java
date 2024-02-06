package cienciasucv.Controllers;
import cienciasucv.Models.*;
import cienciasucv.Views.*;
import cienciasucv.Views.AdminViews.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateExamController {

    public void createNewExam(Exam exam) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject exams = new JsonObject();
        File file = new File("exams.json");
        if (file.exists()) {

            try (FileReader reader = new FileReader(file)) {
                exams = new Gson().fromJson(reader, JsonObject.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        exams.add(exam.getExamID(), gson.toJsonTree(exam.getAttributes()));
    
        try (FileWriter writer = new FileWriter("exams.json")) {
            gson.toJson(exams, writer);
            System.out.println("Examen creado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error, examen no creado." + e.getMessage());
        }
    }
    

  private String generateExamId() {
        int nextId = 1;
        File file = new File("exams.json");
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
        return "E" + String.format("%03d", nextId);
    }

    public void collectExamData(createExamPanel view){

        String id = generateExamId();

        Map<String, Object> examAttributes = new HashMap<>();
        //String[] exams = new String[0];

        examAttributes.put("name", view.getNameBox());
        //examAttributes.put("level", view.getLevelBox());
        examAttributes.put("course", view.getCourseBox());
        examAttributes.put("duration", view.getDurationBox());
        examAttributes.put("instructions", view.getInstructionsArea());
        //examAttributes.put("exams", exams );
        Exam exam = new Exam(id, examAttributes);

        createNewExam(exam);

    }
  
}
