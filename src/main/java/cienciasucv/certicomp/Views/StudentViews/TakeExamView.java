package cienciasucv.certicomp.Views.StudentViews;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import cienciasucv.certicomp.Controllers.TakeExamController;
import cienciasucv.certicomp.Views.ButtonSize;
import cienciasucv.certicomp.Views.Buttons;
import cienciasucv.certicomp.Views.LogoFactory;
import cienciasucv.certicomp.Views.LogoSize;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class TakeExamView {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel questionsPanel;
    private JPanel answersPanel;
    private int currentQuestion;
    private int answeredQuestions;
    private int correctAnswers;
    private int totalQuestions;
    private TakeExamController controller;
    private int duration;
    private JLabel durationLabel;
    private JPanel leftPanel;


    TakeExamView(){

        controller = new TakeExamController();

        frame = new JFrame("Presentando examen | ");
        frame.setLayout(new BorderLayout());

        totalQuestions = 3; // Testing: This will equal questionsArray length. 
        currentQuestion = 0;
        answeredQuestions = 0;
        correctAnswers = 0;
        String[]answers = new String[]{"Answer 1", "Answer 2", "Answer 3"}; // Testing - We shall need this but not convenient to keep answers in the view.

        leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        JLabel leftTitle = new JLabel("Presentando");
        JLabel progressBarTitle = new JLabel("Progress bar here");
        durationLabel = new JLabel("Duración del examen:" + duration);

        
        leftPanel.add(LogoFactory.getLogo(LogoSize.SMALL));
        leftPanel.add(leftTitle);
        leftPanel.setBackground(Color.GREEN);
        leftPanel.setPreferredSize(new Dimension(400, 640));
        JButton finishExam = Buttons.getButton("Finalizar Examen", ButtonSize.WIDER);
        leftPanel.add(finishExam);


        rightPanel.setBackground(Color.BLUE);
        rightPanel.setPreferredSize(new Dimension(540, 640));
        rightPanel.setLayout(new BorderLayout());

        JPanel topRightPanel = new JPanel();
        topRightPanel.setBackground(Color.YELLOW);
        topRightPanel.setBounds(20, 20, 20, 20);
        JProgressBar questionsProgressBar = new JProgressBar();
        questionsProgressBar.setPreferredSize(new Dimension(440, 50));
        topRightPanel.add(questionsProgressBar);
        topRightPanel.add(progressBarTitle);
        rightPanel.add(topRightPanel, BorderLayout.NORTH);

        JPanel bottomRightPanel = new JPanel();
        bottomRightPanel.setBackground(Color.MAGENTA);
        bottomRightPanel.setLayout(new BoxLayout(bottomRightPanel, BoxLayout.Y_AXIS));
        bottomRightPanel.setPreferredSize(new Dimension(540, 50));

        JButton previousButton = Buttons.getButton("Anterior", ButtonSize.MEDIUM);
        JButton nextButton = Buttons.getButton("Siguiente", ButtonSize.MEDIUM);
       
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 150); 
        buttons.add(previousButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 30, 0, 0); 
        buttons.add(nextButton, gbc);

        bottomRightPanel.add(buttons);
        rightPanel.add(bottomRightPanel, BorderLayout.SOUTH);

        JPanel centerRightPanel = new JPanel();
        centerRightPanel.setBackground(Color.BLACK);
        centerRightPanel.setLayout(new BoxLayout(centerRightPanel, BoxLayout.Y_AXIS));
        centerRightPanel.setPreferredSize(new Dimension(200, 200));
        JPanel domainPanel = new JPanel();
        JLabel domainLabel = new JLabel("This is the domain area of Certicomp!");
        domainPanel.add(domainLabel);
        domainPanel.setPreferredSize(new Dimension(540, 50));

        cardLayout = new CardLayout();
        questionsPanel = new JPanel(cardLayout);

        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);

        Border empty = BorderFactory.createEmptyBorder(20, 100, 0, 100);
        Border titled = BorderFactory.createTitledBorder(lineBorder, "Pregunta");
        Border compound = BorderFactory.createCompoundBorder(empty, titled);
        questionsPanel.setBorder(compound);

        
        answersPanel = new JPanel(cardLayout);
        //answersPanel.setBackground(Color.BLUE);

       // Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border empty2 = BorderFactory.createEmptyBorder(0, 100, 20, 100);
        Border compound2 = BorderFactory.createCompoundBorder(empty2, lineBorder);
        answersPanel.setBorder(compound2);

        Dimension size = new Dimension(answersPanel.getWidth(), answersPanel.getHeight());

        answersPanel.setMaximumSize(size);

        //answersPanel.setBorder(compound);

        // JPanel answersFirstQuestion= new JPanel();
        // JLabel answerLabel = new JLabel("Obviously an Object");
        // answersFirstQuestion.add(answerLabel);
        // answersPanel.add(answersFirstQuestion);

        

        int totalAnswers = 10;

        GridLayout gridLayAnswers = new GridLayout(totalAnswers, 1);
           

        for(int i=0; i< totalQuestions; i++){

            JPanel question = new JPanel();
            if(i==0){
                JLabel questionLabel = new JLabel("Question 1: What is an Object?");
                question.add(questionLabel);
            }else if(i==1){
                JLabel questionLabel = new JLabel("Question 2: What is a Class?");
                question.add(questionLabel);
            }else{
                JLabel questionLabel = new JLabel("Question 3: What is Inheritance?");
                question.add(questionLabel);
            }
            
           
            questionsPanel.add(question, "Question " + (i+1));
            
            JPanel answers3 = new JPanel(gridLayAnswers);
            JScrollPane answersScroll = new JScrollPane();
            

            for(int j=0; j<totalAnswers; j++){

                JCheckBox button = new JCheckBox("Answer "+(j+1));
                answers3.add(button);

            }

            //answersPanel.add(answers3);
            answersScroll.setViewportView(answers3);
            
            answersPanel.add(answersScroll);
           

            //answersScroll.setViewportView(answers3);
            
        }
            

           // Question 1
        //    JPanel question1 = new JPanel();
        //    JLabel question1Label = new JLabel("Question 1: What is an Object?");
        //    question1.add(question1Label);
    
        //    questionsPanel.add(question1, "Question 1");
   
        //    // Question 2
        //    JPanel question2 = new JPanel();
        //    JLabel question2Label = new JLabel("Question 2: What is a Class?");
        //    question2.add(question2Label);
        //    questionsPanel.add(question2, "Question 2");

        //    // Question 3
        //    JPanel question3 = new JPanel();
        //    JLabel question3Label = new JLabel("Question 3: What is Inheritance?");
        //    question3.add(question3Label);
        //    questionsPanel.add(question3, "Question 2");

        //questionsPanel.setBackground(Color.BLACK);
          
          centerRightPanel.add(domainPanel, BorderLayout.NORTH);
          centerRightPanel.add(questionsPanel);
          centerRightPanel.add(answersPanel);
          rightPanel.add(centerRightPanel, BorderLayout.CENTER);


        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentQuestion < totalQuestions - 1) {
                    currentQuestion++;
                    cardLayout.next(questionsPanel);
                    cardLayout.next(answersPanel);
                }
            }
            }
        );

        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentQuestion > 0) {
                    currentQuestion--;
                    cardLayout.previous(questionsPanel);
                    cardLayout.previous(answersPanel);
                }
            }
        });
        
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel);
        frame.pack();
        frame.setSize(1080, 640);
        frame.setResizable(false);
        

    }

    public void startExam(String examID){


        System.out.println("Printing from TakeExamView: " + controller.getExamQuestions(examID));
        duration = Integer.parseInt(controller.getExamDuration(examID));
        ExamTimer examTimer = new ExamTimer(duration); 
        examTimer.start();
        JLabel timerLabel = examTimer.getTimerLabel();
        leftPanel.add(timerLabel);
        
        durationLabel.setText("Duración del examen:" + duration);
        System.out.println("Duration: " + duration);
        frame.setTitle("Presentar Examen | " + examID);
        frame.setVisible(true);

    }

    private void updateProgressBar() {

        // Lógica para la barra de progreso. 

    }

    
}
