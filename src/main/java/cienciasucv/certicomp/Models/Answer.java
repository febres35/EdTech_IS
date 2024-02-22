package cienciasucv.certicomp.Models;


import java.util.ArrayList;

public class Answer {

    private String id;
    private String explanation;
    private ArrayList<String> correctAnswers;

    public Answer(String id, String explanation, ArrayList<String> correctAnswers){

        this.id = id;
        this.explanation = explanation;
        this.correctAnswers = correctAnswers;
        
    }

    public String getID(){
        return this.id;
    }

    public String getExplanation(){
        return this.explanation;
    }

    public ArrayList<String> getCorrectAnswers(){
        return this.correctAnswers;
    }
    
}
