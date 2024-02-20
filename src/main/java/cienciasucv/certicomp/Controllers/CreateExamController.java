package cienciasucv.certicomp.Controllers;
import cienciasucv.certicomp.Models.*;
import cienciasucv.certicomp.Views.AdminViews.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class CreateExamController {

    private String generateExamId(String path) {
        int nextId = 1;
        File file = new File(path);
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

    public boolean collectExamData(CreateExamPanel view){
        String path = "src/main/resources/data/exams.json";
        String name= view.getNameBox();
        String id = generateExamId(path);
        String instructions= view.getInstructionsArea();
        String duration=String.valueOf(view.getDurationBox());
        ArrayList<String> questions = new ArrayList<>();
        
        Exam exam = new Exam(name,id,duration,instructions);
         
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
    JsonObject exams = new JsonObject();
    File file = new File("src/main/resources/data/exams.json");

    if (file.exists()) {
        try (FileReader reader = new FileReader(file)) {
            exams = gson.fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    boolean examExists = false;

for (Map.Entry<String, JsonElement> entry : exams.entrySet()) {
    JsonObject jsonExam = entry.getValue().getAsJsonObject();
    String examName = jsonExam.get("name").getAsString();
    
    if (examName.equals(exam.getName())) {
        JOptionPane.showMessageDialog(null,"YA EXISTE UN EXAMEN CON ESTE NOMBRE");
        examExists = true;
        return examExists;
    }
}
        Exam.createNewExam(exam);
        return false;

  
}
}
