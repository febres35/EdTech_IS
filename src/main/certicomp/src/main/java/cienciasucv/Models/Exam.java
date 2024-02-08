package cienciasucv.Models;

import java.util.Map;

public class Exam {

    private String examID;
    private int duration;
    private String instructions;
    private String title;
    private String course;
    private Map<String, Object>attributes;

    public Exam(String id, Map<String, Object> attributes) {
        this.examID = id;
        this.duration = (int) attributes.get("duration");
        this.instructions = (String) attributes.get("instructions");
        this.title = (String) attributes.get("title");
        this.course = (String) attributes.get("course");
        this.attributes = attributes;
    }

    public int getDuration() {
        return duration;
    }
    public String getExamID() {
        return examID;
    }
    public String getInstructions() {
        return instructions;
    }
    public String getTitle() {
        return title;
    }
    public String getCourse(){
        return course;
    }
    
    public Map<String, Object> getAttributes(){
        return attributes;
    }

}
