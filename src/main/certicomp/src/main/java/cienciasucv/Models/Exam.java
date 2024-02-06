package cienciasucv.Models;
import cienciasucv.Views.*;

import java.util.Map;

public class Exam {

    private String examID;
    private int duration;
    private String instructions;
    private String title;
    private Map<String, Object>attributes;

    // public Exam(int examID,int duration, String instructions,String title){
    //     setExamID(examID);
    //     setDuration(duration);
    //     setInstructions(instructions);
    //     setTitle(title);
    // }

    public Exam(String id, Map<String, Object> attributes) {
        this.examID = id;
        this.duration = (int) attributes.get("duration");
        this.instructions = (String) attributes.get("instructions");
        this.title = (String) attributes.get("name");
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
    public void setExamID(String examID) {
        this.examID = examID;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Object> getAttributes(){
        return attributes;
    }

}
