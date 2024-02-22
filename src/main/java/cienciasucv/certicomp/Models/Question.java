package cienciasucv.certicomp.Models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Question {

    private String id;
    private String text;
    private ArrayList<String> domainsID;
    private Map<String, String> answerOptions;
    private String type;
    private String answerID;
    private Question question;
    private ArrayList<String> questionImagesPath;

    private static Map<String, Question> questionsMap;

    static {
        try {
            questionsMap = JsonLoader.loadFromFile(Question.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Question(String id, String text, ArrayList<String> domains, 
    Map<String,String> answers, String answerID, String type){

        this.id = id;
        this.text = text;
        this.domainsID = domains;
        this.answerOptions = answers;
        this.answerID = answerID;
        this.type = type;

    }

    Question(String id, String text, ArrayList<String> questionImagesPath, ArrayList<String> domains, 
    Map<String,String> answers, String answerID, String type){

        this.id = id;
        this.text = text;
        this.questionImagesPath = questionImagesPath;
        this.domainsID = domains;
        this.answerOptions = answers;
        this.answerID = answerID;
        this.type = type;

    }

    public String getID(){
        return this.id;
    }

    public static Question getQuestion(String questionID){
        return questionsMap.get(questionID);
    }

    public String getText(){
        return this.text;
    }

    public ArrayList<String> getDomains(){
        return this.domainsID;
    }

    public ArrayList<String> getDomains(ArrayList<String> domainsID){
        return this.domainsID;
    }

    public Map<String,String> getAnswerOptions(){

        return this.answerOptions;

    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);

        
    }

    public static Map<String, String> fetchQuestions(ArrayList<String> questionsID) {
    
    Map<String, String> fetchedQuestions = new HashMap<>();
    for (String questionID : questionsID) {
        Question question = questionsMap.get(questionID);
        if (question != null) {
        
            ArrayList<String> domains = new ArrayList<>();
            for (String domainID : question.getDomains()) {
                String domain = Domain.getDescription(domainID); 
                domains.add(domain);
            }

            JSONObject questionJson = new JSONObject(question.toJson());
            questionJson.remove("domainsID");
            questionJson.put("domains", domains);
            

            fetchedQuestions.put(questionID, questionJson.toString());
        }
    }

    return fetchedQuestions;
}
}