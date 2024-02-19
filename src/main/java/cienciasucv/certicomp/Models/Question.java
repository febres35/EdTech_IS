package cienciasucv.certicomp.Models;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Question {

    private String id;
    private String text;
    private ArrayList<String> domains;
    private Map<String, String> answerOptions;
    private ArrayList<String> correctAnswers;
    private String explanation;
    private Question question;

    private static Map<String, Question> questions;

    static {

        questions = loadQuestionsFromFile();
    }

    private static Map<String, Question> loadQuestionsFromFile() {

        Gson gson = new Gson();
        java.lang.reflect.Type type = new TypeToken<Map<String, Exam>>(){}.getType();
        try (Reader reader = new FileReader("certicomp/src/main/resources/data/questions.json")) {
            questions = gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

    Question(String id, String text, ArrayList<String> domains, 
    Map<String,String> answers, ArrayList<String> correctAnswers, String explanation){

        this.id = id;
        this.text = text;
        this.domains = domains;
        this.answerOptions = answers;
        this.correctAnswers = correctAnswers;
        this.explanation = explanation;

    }

    public String getID(){
        return this.id;
    }

    public static Question getQuestion(String questionID){
        return questions.get(questionID);
    }

    public String getText(){
        return this.text;
    }

    public ArrayList<String> getDomains(){
        return this.domains;
    }

    public Map<String,String> getAnswerOptions(){

        return this.answerOptions;

    }

    public ArrayList<String> getCorrectAnswer(){

        return this.correctAnswers;
        
    }

    public String getExplanation(){
        return this.explanation;

    }

   
}
