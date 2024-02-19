package cienciasucv.certicomp.Views.StudentViews;


import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import cienciasucv.certicomp.Controllers.TakeExamController;
import cienciasucv.certicomp.Views.LogoFactory;
import cienciasucv.certicomp.Views.LogoSize;

public class InstructionsView {

    private TakeExamController controller;

    private String examID;

    public InstructionsView(){

        controller = new TakeExamController();

        JFrame  frame = new JFrame();
        frame.setSize(400, 300);
        frame.setVisible(false);
        
    }

    void loadInstructions(String examInstructions){

        JLabel logo = LogoFactory.getLogo(LogoSize.SMALL);
        Object[] options = {"Aceptar", "Rechazar"};

        JLabel title = new JLabel("INSTRUCCIONES");
        title.setFont(new Font("Roboto", Font.BOLD, 30));


        //JLabel instructionsLabel= new JLabel("<html><body style='width: 200px'>" + examInstructions + "</body></html>");
        JLabel instructions = new JLabel("<html><body style='width: 200px'><p style='text-align: justify;'>" + examInstructions + "</p></body></html>");
     
        Object[] array = {logo, title, instructions};

        

        int confirmation = JOptionPane.showOptionDialog(null, array, "Instrucciones | Instrucciones ",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (confirmation == JOptionPane.NO_OPTION) {
            System.out.println("No button clicked");
        } else if (confirmation == JOptionPane.YES_OPTION) {
            
            confirmInstructions(examID, true);

        } else if (confirmation == JOptionPane.CLOSED_OPTION) {
            System.out.println("JOptionPane closed");
        }
    }


    void confirmInstructions(String examID, Boolean isConfirmed){

        System.out.println("Previous to Start exam from view! - executed!");
        TakeExamView view = new TakeExamView();
        view.startExam(examID);
        System.out.println("Start exam from view! - executed!");

    }

    void displayInstructions(String examID){
        this.examID = examID;
        String examInstructions = controller.getExamInstructions(examID);
        System.out.println(examInstructions);
        loadInstructions(examInstructions);
    }
}

    
    

