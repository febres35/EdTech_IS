package cienciasucv.Models;

import java.util.Map;

public class Course {

    private String id;
    private String name;
    private String category;
    private String teachers;
    private String prerequisites;
    private String description;
    private String[] examsID;
    private Map<String, Object> attributes;

    public Course(String id, Map<String, Object> attributes) {
        this.id = id;
        this.name = (String) attributes.get("name");
        this.category = (String) attributes.get("category");
        this.teachers = (String) attributes.get("teachers");
        this.prerequisites = (String) attributes.get("prerequisites");
        this.description = (String) attributes.get("prerequisites");
        this.examsID = (String[]) attributes.get("exams");
        this.attributes = attributes;
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

    public String[] getExams(){
        return examsID;
    }

    public Map<String, Object> getAttributes(){
        return attributes;
    }

}