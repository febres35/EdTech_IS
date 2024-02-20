package cienciasucv.certicomp.Models;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class Exam {

    private String id;
    private String name;
    private String duration; 
    private String instructions;
    private ArrayList<String> dominios;
    private ArrayList<String> questions;
    private static Map<String, Exam> exams;
    private Exam exam;
    private Question question;
    
    
    static {

        exams = loadExamsFromFile();
    }

    Exam(String name,String id, String duration, String instructions, ArrayList<String> questions){
        this.id = id;
        this.duration = duration;
        this.instructions = instructions;
        this.questions = questions;
    }

    public Exam(String name,String id, String duration, String instructions){
        this.name= name;
        this.id = id;
        this.duration= duration;
        this.instructions=instructions;
    }
    

    private static Map<String, Exam> loadExamsFromFile() {

        Gson gson = new Gson();
        java.lang.reflect.Type type = new TypeToken<Map<String, Exam>>(){}.getType();
        try (Reader reader = new FileReader("src/main/resources/data/exams.json")) {
            exams = gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exams;
    }

    public static Exam getExam(String examId){

       return exams.get(examId);
    }

    public String getName(){
        return name;
    }

    public String getID(){
        return id;
    }

    public String getDuration(){
        
        return this.duration;
    }

    public String fetchInstructions(){
        return instructions;
    }

    public ArrayList<String> fetchQuestions(){

        return this.questions;
    } 

    public ArrayList<String> getQuestions(){
        return this.questions;
    }
     

   public static String getInstructions(String examID) {
    
    Gson gson = new Gson();

    InputStream inputStream = Exam.class.getResourceAsStream("/data/exams.json");
    Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
    Map<String, Exam> exams = gson.fromJson(reader, new TypeToken<Map<String, Exam>>(){}.getType());

    Exam exam = exams.get(examID);
    if(exam != null ){
        System.out.println("Not null!");
        return exam.fetchInstructions();
    }else{
        return null;
    }
}

public static void createNewExam(Exam exam) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    JsonObject exams = new JsonObject();
    File file = new File("exams.json");

    if (file.exists()) {
        try (FileReader reader = new FileReader(file)) {
            exams = gson.fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    exams.add(exam.getID(), gson.toJsonTree(exam));

    try (FileWriter writer = new FileWriter("exams.json")) {
        gson.toJson(exams, writer);
        System.out.println("Examen creado exitosamente.");
    } catch (IOException e) {
        System.out.println("Error, examen no creado: " + e.getMessage());
    }
}


}
