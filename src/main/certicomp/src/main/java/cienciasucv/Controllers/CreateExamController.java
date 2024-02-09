package cienciasucv.Controllers;
import cienciasucv.Models.*;
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

    private String generateExamId() {
        int nextId = 1;
        File file = new File("exams.json");
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                JsonObject exams = new Gson().fromJson(reader, JsonObject.class);
                for (String examID : exams.keySet()) {
                    int currentIdNumber = Integer.parseInt(examID.substring(1));
                    nextId = Math.max(nextId, currentIdNumber + 1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "E" + String.format("%03d", nextId);
    }

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

    public void collectExamData(CreateExamPanel view){

        String id = generateExamId();

        Map<String, Object> examAttributes = new HashMap<>();

        examAttributes.put("duration", view.getDurationBox());
        examAttributes.put("instructions", view.getInstructionsArea());
        examAttributes.put("title", view.getNameBox());
        examAttributes.put("course", view.getCourseBox());
        
        Exam exam = new Exam(id, examAttributes);

        createNewExam(exam);

    }
  
}
