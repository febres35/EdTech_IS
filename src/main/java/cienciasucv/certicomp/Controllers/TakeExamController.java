package cienciasucv.certicomp.Controllers;

import java.util.ArrayList;

import cienciasucv.certicomp.Models.Exam;
import cienciasucv.certicomp.Views.StudentViews.InstructionsView;
import cienciasucv.certicomp.Views.StudentViews.TakeExamView;

public class TakeExamController {

    private InstructionsView view;
    private TakeExamView examView;
    private Exam exam;

    public TakeExamController(){

    }

    public void setInstructionsView(InstructionsView view) {
      this.view = view;
    }

    public void setExamView(TakeExamView examView) {
      this.examView = examView;
    }

    public String getExamInstructions(String examID){
        
      String instructions = Exam.getInstructions(examID);
      return instructions;
    }

    public String getExamDuration(String examID){
      exam = Exam.getExam(examID);
      return exam.getDuration();
    }

    public ArrayList<String> getExamQuestions(String examID){

      exam = Exam.getExam(examID);
      return exam.fetchQuestions();

    }


    
    
}
