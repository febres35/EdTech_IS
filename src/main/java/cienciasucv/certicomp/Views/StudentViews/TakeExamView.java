package cienciasucv.certicomp.Views.StudentViews;

import net.miginfocom.swing.MigLayout;

import cienciasucv.certicomp.Controllers.TakeExamController;
import cienciasucv.certicomp.Views.ButtonSize;
import cienciasucv.certicomp.Views.Buttons;
import cienciasucv.certicomp.Views.LogoFactory;
import cienciasucv.certicomp.Views.LogoSize;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import org.json.JSONArray;

import com.google.gson.Gson;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class TakeExamView {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel questionsPanel;
    private int currentQuestion;
    private int answeredQuestions;
    private int correctAnswers;
    private int totalQuestions;
    private TakeExamController controller;
    private String duration;
    private JPanel leftPanel;
    private Map<String, String> questionsCollection;
    private JPanel answersPanel;
    private JProgressBar questionsProgressBar;
    private String questionID;
    private ExamTimer examTimer;
    private JButton okButton;
    private JButton seeResultsButton;
    private JLabel timerLabel;
    private String currentExamID;
    private int questionNumber;

    TakeExamView(){

        controller = new TakeExamController();

        LocalDate date = LocalDate.now();
        String pattern = "EEEE, d 'de' MMMM 'de' yyyy";
        Locale locale = Locale.forLanguageTag("es");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
        String formattedDate = date.format(formatter);
        JLabel dateLabel = new JLabel(formattedDate);
        dateLabel.setFont(new Font("Roboto", Font.BOLD, 16));
        dateLabel.setHorizontalAlignment(JLabel.CENTER);

        frame = new JFrame("Presentando examen | ");
        frame.setLayout(new BorderLayout());

        totalQuestions = 0; 
        questionNumber = 0;
        currentQuestion = 0;
        answeredQuestions = 0;
        correctAnswers = 0;

        leftPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        JPanel rightPanel = new JPanel();

        JLabel leftTitle = new JLabel("Presentando");
        leftTitle.setSize(new Dimension(400,200));
        leftTitle.setFont(new Font("Roboto", Font.BOLD, 36));
        leftTitle.setHorizontalAlignment(JLabel.CENTER);

        JPanel infoPanel = new JPanel();

        JLabel courseName = new JLabel("Curso: ");
        JLabel examTaker = new JLabel("Practicante: ");
        JLabel examName = new JLabel("Examen: " + currentExamID);

        infoPanel.add(courseName);
        infoPanel.add(examTaker);
        infoPanel.add(examName);

        
        gbc1.gridx = 0;
        gbc1.gridy = 1;
        leftPanel.add(dateLabel, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 2;
        leftPanel.add(LogoFactory.getLogo(LogoSize.SMALL), gbc1);


        gbc1.gridx = 0;
        gbc1.gridy = 3;
        leftPanel.add(leftTitle, gbc1);

        leftPanel.setPreferredSize(new Dimension(400, 640));
        Border border = new MatteBorder(0, 0, 0, 3, Color.BLACK);
        leftPanel.setBorder(border);


        gbc1.gridx = 0;
        gbc1.gridy = 4;
        leftPanel.add(infoPanel, gbc1);
        
        JButton finishExam = Buttons.getButton("Finalizar Examen", ButtonSize.WIDER);

        gbc1.gridx = 0;
        gbc1.gridy = 5;
        leftPanel.add(finishExam, gbc1);

        finishExam.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                setExamTimer(duration, "stop");

                okButton = Buttons.getButton("OK", ButtonSize.SMALL);
                seeResultsButton = Buttons.getButton("Ver Resultados", ButtonSize.WIDER);
                seeResultsButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Window win = SwingUtilities.getWindowAncestor(seeResultsButton);
                        if (win != null) {
                            win.dispose();
                            frame.dispose();
                        }
                        viewResults();
                    }
                });

                ImageIcon icon = new ImageIcon("OK_ICON.png");
                Object[] options = {okButton, seeResultsButton};
                int n = JOptionPane.showOptionDialog(frame,"EXAMEN FINALIZADO. \n" + correctAnswers + " / " + totalQuestions + " preguntas correctas","Usuario ha finalizado",
                JOptionPane.OK_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                icon,     
                options,  
                options[0]); 
                
            }
        });
        
        rightPanel.setPreferredSize(new Dimension(540, 640));
        rightPanel.setLayout(new BorderLayout());

        JPanel topRightPanel = new JPanel();
        topRightPanel.setBounds(100, 100, 100, 100);


        JPanel progressBarPanel = new JPanel();
        progressBarPanel.setPreferredSize(new Dimension(550, 40));
        questionsProgressBar = new JProgressBar(0, totalQuestions);
        questionsProgressBar.setForeground(Color.BLACK);
        questionsProgressBar.setPreferredSize(new Dimension(550, 25));

        progressBarPanel.add(questionsProgressBar);

        topRightPanel.add(progressBarPanel);
        rightPanel.add(topRightPanel, BorderLayout.NORTH);

        JPanel bottomRightPanel = new JPanel();
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
        
        centerRightPanel.setLayout(new BoxLayout(centerRightPanel, BoxLayout.Y_AXIS));
        centerRightPanel.setPreferredSize(new Dimension(200, 200));

        cardLayout = new CardLayout();
        questionsPanel = new JPanel(cardLayout);
       
        
        Border borderTitle = BorderFactory.createTitledBorder("Pregunta " + questionNumber);
 
        questionsPanel.setBorder(borderTitle);

        answersPanel = new JPanel();
  
        centerRightPanel.add(questionsPanel);
        centerRightPanel.add(answersPanel);
        JPanel eastEmpty = new JPanel();
        JPanel westEmpty = new JPanel();
        eastEmpty.setPreferredSize(new Dimension(50, 50));
        westEmpty.setPreferredSize(new Dimension(50, 50));
        rightPanel.add(centerRightPanel, BorderLayout.CENTER);
        rightPanel.add(eastEmpty, BorderLayout.EAST);
        rightPanel.add(westEmpty, BorderLayout.WEST);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentQuestion < totalQuestions - 1) {
                    currentQuestion++;
                    cardLayout.next(questionsPanel);
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

        currentExamID = examID;

        final HashMap<String, Boolean> isAnswered = new HashMap<>();
        questionsCollection = controller.getExamQuestions(examID);

        totalQuestions = questionsCollection.size();
        questionsProgressBar.setMaximum(totalQuestions);
        questionsProgressBar.setString(answeredQuestions + " / " + totalQuestions);
        questionsProgressBar.setStringPainted(true);

        String text = (String) questionsCollection.get("text");

        if(questionsCollection.isEmpty()){
            System.out.println("The collection is empty");
        } else{

            questionNumber = 1;

            Gson gson = new Gson();
            for (Map.Entry<String, String> entry : questionsCollection.entrySet()) {

                System.out.println(entry);

                @SuppressWarnings("unchecked")
                Map<String, Object> questionObj = gson.fromJson(entry.getValue(), Map.class);
                text = (String) questionObj.get("text");
                questionID = entry.getKey();
                System.out.println("ID question: " + questionID);

                @SuppressWarnings("unchecked")
                Map<String, String> answerOptions = (Map<String, String>) questionObj.get("answerOptions");
              
                @SuppressWarnings("unchecked")
                ArrayList<String> domains = (ArrayList<String>) questionObj.get("domains");
                

                JPanel domainsGroup = new JPanel(){
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(525, super.getPreferredSize().height);
                    }
                };
         
                domainsGroup.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 2));
                

              
                for (String domain : domains){
                    
                   
                    JLabel domainText = new JLabel(domain);
                    domainText.setHorizontalAlignment(JLabel.LEFT);
                    domainsGroup.add(domainText);
                    System.out.println("Domain :" + domain);

                }
                
                JPanel questionCard = new JPanel(new BorderLayout()){
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(500, super.getPreferredSize().height);
                    }
                };

                

                JPanel domainPanel = new JPanel();
      
                domainPanel.setLayout(new BorderLayout());
                JLabel domainLabel = new JLabel("<html><body style='padding: 10px;'>DOMINIO</body></html>");
                domainPanel.add(domainLabel, BorderLayout.WEST);
                domainPanel.add(domainsGroup, BorderLayout.CENTER);
                domainLabel.setFont(new Font("ROBOTO", Font.BOLD, 20));
                Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
                Border border2 = BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK);
             
                domainLabel.setBorder(border2);

                JPanel questionTextPanel = new JPanel(){
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(525, super.getPreferredSize().height);
                    }
                };
                JPanel questionPanel = new JPanel();
                JLabel questionText = new JLabel(
                "<html><body style='width: 300px'><p style='text-align: justify;'>"+text +"</p></body></html>");
                
                questionTextPanel.add(questionText);
                
                questionPanel.add(domainPanel);
                questionText.setFont(new Font("ROBOTO", Font.BOLD, 14));
                questionPanel.add(questionTextPanel);
                
                ButtonGroup group = new ButtonGroup();
                JPanel answersPanel = new JPanel(){
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(525, super.getPreferredSize().height);
                    }
                };
                
                Border topBorder = BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK);
                answersPanel.setBorder(topBorder);
                questionTextPanel.setBorder(topBorder);
           

                
                answersPanel.setLayout(new BoxLayout(answersPanel, BoxLayout.Y_AXIS));
           
                
                for (Map.Entry<String, String> option : answerOptions.entrySet()) {
                    final String currentQuestionID = questionID;

                    String optionText = option.getKey() + ". " + option.getValue();
                    JRadioButton radioButton = new JRadioButton("<html>"+optionText +"</html>");

                    radioButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (!isAnswered.getOrDefault(currentQuestionID, false)) {
                                answeredQuestions++;
                                isAnswered.put(currentQuestionID, true); 
                                updateProgressBar();
                                System.out.println("Answered questions: " + answeredQuestions);
                                System.out.println(isAnswered);
                            }
                        }
                    });

                    questionCard.setBorder(border);

                    questionCard.add(answersPanel, BorderLayout.SOUTH);
                    questionCard.add(domainPanel, BorderLayout.NORTH);
                    questionCard.add(questionTextPanel, BorderLayout.CENTER);
                    
                    answersPanel.add(radioButton);
                    group.add(radioButton);
                    questionPanel.add(questionCard);
                }

                questionsPanel.add(questionPanel, "Question " + questionNumber);
                
                questionNumber++;
        }

        questionsPanel.revalidate();
        questionsPanel.repaint();
    }
        duration = controller.getExamDuration(examID);
        setExamTimer(duration, "start");
        
        frame.setTitle("Presentar Examen | " + examID);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private void setExamTimer(String duration, String command){

        int duration2 = Integer.parseInt(duration);

         

        if(examTimer == null){
            examTimer = new ExamTimer(duration2); 
        }
        timerLabel = new JLabel();

        if(command.equals("start")){

            JPanel timerPanel = new JPanel();
            Border titled = BorderFactory.createTitledBorder("Tiempo Restante");
            ((TitledBorder) titled).setTitleJustification(TitledBorder.CENTER);
            timerPanel.setBorder(titled); 
            examTimer.start();
            
            timerLabel = examTimer.getTimerLabel();
            timerPanel.add(timerLabel);
            leftPanel.add(timerPanel); 
            
        } else{
            examTimer.stop();
        }
    }

    private void updateProgressBar() {

        questionsProgressBar.setValue(answeredQuestions);
        questionsProgressBar.setString(answeredQuestions + " / " + totalQuestions);

    }

    private void viewResults() {

        ViewResultsView view = new ViewResultsView();
    }
}
