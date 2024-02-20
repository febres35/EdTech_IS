package cienciasucv.certicomp.Controllers;
import cienciasucv.certicomp.Models.*;
import cienciasucv.certicomp.Views.AdminViews.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

    public void collectExamData(CreateExamPanel view){
        String name= view.getNameBox();
        String id = generateExamId();
        String instructions= view.getInstructionsArea();
        String duration=String.valueOf(view.getDurationBox());
        ArrayList<String> questions = new ArrayList<>();
        
        Exam exam = new Exam(name,id,duration,instructions);

        Exam.createNewExam(exam);

    }
  
}
