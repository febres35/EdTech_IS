package cienciasucv.certicomp.Models;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Course {

    private String id;
    private String name;
    private String category;
    private String teachers;
    private String prerequisites;
    private String description;
    private ArrayList<String> examsID;
    private Map<String, Object> attributes;

    @SuppressWarnings("unchecked")
    public Course(String id, Map<String, Object> attributes) {
        this.id = id;
        this.name = (String) attributes.get("name");
        this.category = (String) attributes.get("category");
        this.teachers = (String) attributes.get("teachers");
        this.prerequisites = (String) attributes.get("prerequisites");
        this.description = (String) attributes.get("prerequisites");
        this.examsID = (ArrayList<String>) attributes.get("exams");
        this.attributes = attributes;
    }

    public Course(){

    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getTeachers() {
        return teachers;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public String getDescription() {
        return description;
    }

    public static String[][] getExams(String courseID) {
        try {
            
            String coursesContent = new String(Files.readAllBytes(Paths.get("src/main/resources/data/courses.json")));
            
            String examsContent = new String(Files.readAllBytes(Paths.get("src/main/resources/data/exams.json")));
    
            JSONObject coursesJson = new JSONObject(coursesContent);
            JSONObject examsJson = new JSONObject(examsContent);
    
            JSONObject courseJson = coursesJson.getJSONObject(courseID);
            Course course = new Course(courseID, courseJson.toMap());
            ArrayList<String> examIDs = course.examsID;
    
            String[][] exams = null;
    
            if (examIDs != null) {
                exams = new String[examIDs.size()][4];
    
                for (int i = 0; i < examIDs.size(); i++) {
                    String examID = examIDs.get(i);
                    JSONObject examJson = examsJson.getJSONObject(examID);
                    Map<String, Object> examAttributes = examJson.toMap();
    
                    exams[i][0] = examID;
                    exams[i][1] = (String) examAttributes.get("examtitle");
                    ArrayList<?> questions = (ArrayList<?>) examAttributes.get("questions");
                    exams[i][2] = questions != null ? String.valueOf(questions.size()) : "0";
                    exams[i][3] = String.valueOf(examAttributes.get("duration") + " minutos");
                }
            } else {
                exams = new String[0][0];
            }
    
            return exams;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Map<String, Object> getAttributes(){
        return attributes;

    }

    public static Map<String, String> getCoursesInfo() {

        
        Gson gson = new Gson();
        java.lang.reflect.Type type = new TypeToken<Map<String, Course>>(){}.getType();
        Map<String, String> coursesInfo  = new HashMap<>();

        InputStream inputStream = Course.class.getResourceAsStream("/data/courses.json");
        Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        Map<String, Course> courses = gson.fromJson(reader, type);
        try {
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        

        for (Map.Entry<String, Course> entry : courses.entrySet()) {
            coursesInfo.put(entry.getKey(), entry.getValue().getName());
        }
        return coursesInfo;
    }


    public void registerNewCourse(Course course) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject courses = new JsonObject();
        File file = new File("src/main/resources/data/courses.json");

        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                courses = new Gson().fromJson(reader, JsonObject.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        courses.add(course.getID(), gson.toJsonTree(course.getAttributes()));
        
        try (FileWriter writer = new FileWriter("src/main/resources/data/courses.json")) {
            gson.toJson(courses, writer);
            System.out.println("Curso registrado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error, curso no registrado." + e.getMessage());
        }
    }
    
    public String generateCourseId(String path) {

        int nextId = 1;
        File file = new File(path);
    
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
}