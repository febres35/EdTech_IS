package cienciasucv.certicomp.Models;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class Exam {

    private String id;
    private String name;
    private String duration; 
    private String instructions;
    private String level;
    private String creationDate;
    private ArrayList<String> dominios;
    private ArrayList<String> questions;
    public static Map<String, Exam> exams;

    
    private final static String path = "src/main/resources/data/exams.json";
    
    static {
        exams = loadExamsFromFile();
    }

    public Exam(String name,String id, String duration, String instructions,ArrayList<String> domains,String level){
        this.name= name;
        this.id = id;
        this.duration= duration;
        this.instructions=instructions;
        this.questions= new ArrayList<String>();
        this.dominios=domains;
        this.level=level;
        this.creationDate = LocalDate.now().toString();

    }
    
    public Exam() {
     
    }

    private static Map<String, Exam> loadExamsFromFile() {
        Gson gson = new Gson();
        java.lang.reflect.Type type = new TypeToken<Map<String, Exam>>(){}.getType();
        try (Reader reader = new FileReader(path)) {
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

    public ArrayList<String> getDomainList(){
        return this.dominios;
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
     
    public static boolean examExists(String name){
     
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    JsonObject exams = new JsonObject();
    File file = new File(path);

    if (file.exists()) {
        try (FileReader reader = new FileReader(file)) {
            exams = gson.fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        for (Map.Entry<String, JsonElement> entry : exams.entrySet()) {
            JsonObject jsonExam = entry.getValue().getAsJsonObject();
            String examName = jsonExam.get("name").getAsString();
            
            if (examName.equals(name)) {
                JOptionPane.showMessageDialog(null,"YA EXISTE UN EXAMEN CON ESTE NOMBRE");
                return true;
            }
        }
        return false;
    }

    public static String getInstructions(String examID) {
        Exam examen= exams.get(examID);
        if(examen!=null){
            return examen.fetchInstructions();
        }else{
            return null;
        }
    }

    public static Map<String, String> getQuestions(String examID){
    System.out.println("Testing get Questions in EXAM!");
    Map<String, String> questionsCollection =  new HashMap<>();
    Exam exam = getExam(examID);
    if(exam.questions== null){
        System.out.println("Yes, questions attribute is null!");
    } else{
        System.out.println(exam.questions);
    }
    questionsCollection = Question.fetchQuestions(exam.questions);
    System.out.println("Printing from getQuestions!");

    return questionsCollection;

   }

    public static void createNewExam(Exam exam) {
    Exam.exams.put(exam.getID(), exam);
    Exam.organizarPorID();
    saveExamsToJson();
}
   
    public static void saveExamsToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(path)) {
            gson.toJson(exams, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteExam(String examToDeleteID) {
        exams.remove(examToDeleteID);
        saveExamsToJson();
    }

    public static void editExam(String originalExamID, Exam editedExam) {
       exams.put(originalExamID, editedExam);
       JOptionPane.showMessageDialog(null,"EXAMEN EDITADO EXITOSAMENTE");
       saveExamsToJson();
    }

    public void addDomain(String domainID){
        this.dominios.add(domainID);
   }
   
    public static void organizarPorID(){ 
    Map<String, Exam> sortedExamMap = new TreeMap<>(Exam.exams);
    Exam.exams.clear();
    Exam.exams.putAll(sortedExamMap);
   }

   public String getDate(){
    return this.creationDate;
   }
}
