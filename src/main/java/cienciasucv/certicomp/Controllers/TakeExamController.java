package cienciasucv.certicomp.Controllers;
import java.util.HashMap;
import java.util.Map;

import cienciasucv.certicomp.Models.Exam;


public class TakeExamController {

    private Exam exam = new Exam();

    public TakeExamController(){
    }

    public String getExamInstructions(String examID){

        String instructions = Exam.getInstructions(examID);
        return instructions;
    }

    public Map<String, String> getExamQuestions(String examID){

      Map<String, String> questionsCollection = new HashMap<>();
      questionsCollection = Exam.getQuestions(examID);

      if(questionsCollection.isEmpty()){
        System.out.println("Questions collection is empty in the controller");
      }

      return questionsCollection;

    }

    public String getExamDuration(String examID){
      exam = Exam.getExam(examID);
      return exam.getDuration();
    }
}
