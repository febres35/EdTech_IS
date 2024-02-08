package cienciasucv.Views.StudentViews;
import cienciasucv.Controllers.*;
import cienciasucv.Views.Buttons;
import cienciasucv.Views.SizeType;

import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.*;

public class TakeExamView extends JFrame {

  String pBarString = "0/100 respondidas";
  int valor = 0;
  TakeExamController controlador = new TakeExamController();
  
  // Variables declaration                     
  private ButtonGroup buttonGroup1;
  private Box.Filler filler1;
  private JButton finishExamButton;
  private JButton previousButton;
  private JButton nextButton;
  private JLabel jLabel1;
  private JLabel todayDate;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLabel jLabel5;
  private JLabel jLabel6;
  private JLabel jLabel7;
  private JLabel jLabel8;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private TimeCronometer timePanel;
  private JPanel questionPanel;
  private JProgressBar pBarQuestions;
  private JRadioButton jRadioButton1;
  private JRadioButton jRadioButton2;
  private JRadioButton jRadioButton3;
  private JRadioButton jRadioButton4;
  private JScrollPane jScrollPane1;
  private JSeparator jSeparator1;
  private JSeparator jSeparator2;
  private JSeparator jSeparator3;
  private JTextArea questionsTextArea;
  // End of variables declaration 

    public TakeExamView() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(150, 40, 1247, 1000);
        initComponents();
    }   
    public void weekDays(){

        Calendar calendar = Calendar.getInstance();
        String dayOfWeek = "";

        switch(calendar.get(Calendar.DAY_OF_WEEK)){
            case 1:
                dayOfWeek = "Domingo"; 
            break; 
            case 2:
                dayOfWeek = "Lunes"; 
            break; 
            case 3:
                dayOfWeek = "Martes"; 
            break; 
            case 4:
                dayOfWeek = "Miercoles"; 
            break; 
            case 5:
                dayOfWeek = "Jueves"; 
            break; 
            case 6:
                dayOfWeek = "Viernes"; 
            break; 
            case 7:
                dayOfWeek = "Sabado"; 
            break; 
        }
        //return dayOfWeek;
        todayDate.setText(dayOfWeek);
    }

    public void actualDate(){
        Date actual = new Date();
        DateFormat dateFormatter;
        Locale currentLocale = new Locale("es");
        dateFormatter = DateFormat.getDateInstance(DateFormat.LONG, currentLocale);
        String fecha = dateFormatter.format(actual);
        weekDays();
        String day = todayDate.getText();
        todayDate.setText(day+", "+fecha);
    }

    private void initComponents() {
       
        buttonGroup1 = new ButtonGroup();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        todayDate = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        timePanel = new TimeCronometer(3600*3);;
        finishExamButton = Buttons.getButton("Finalizar Examen", SizeType.MEDIUM);
        jPanel2 = new JPanel();
        previousButton = Buttons.getButton("Anterior", SizeType.SMALL);
        nextButton = Buttons.getButton("Siguiente", SizeType.SMALL);
        pBarQuestions = new JProgressBar();
        questionPanel = new JPanel();
        jScrollPane1 = new JScrollPane();
        questionsTextArea = new JTextArea();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jRadioButton3 = new JRadioButton();
        jSeparator1 = new JSeparator();
        jRadioButton4 = new JRadioButton();
        jSeparator3 = new JSeparator();
        jSeparator2 = new JSeparator();
        filler1 = new Box.Filler(new java.awt.Dimension(0, 3), new java.awt.Dimension(0, 3), new java.awt.Dimension(32767, 3));
        jLabel8 = new JLabel();
        jLabel7 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estudiante | Presentando Examen");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/CertiCompSmall.png"));
        Icon nuevaIcon = new ImageIcon(icon.getImage().getScaledInstance(462, 104, Image.SCALE_SMOOTH));
        jLabel1.setBounds(0, 0, 462, 104);
        jLabel1.setIcon(nuevaIcon); // NOI18N
    

        todayDate.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        actualDate();

      jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); 
      jLabel3.setText("Presentando");

      jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 12)); 
      jLabel4.setText("Curso: Java SE- Java Associate programmer 1");

      jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 12));
      jLabel5.setText("Practicante: John Smith");

      jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 12)); 
      jLabel6.setText("Examen: Examen Práctico 2");

      timePanel.setBackground(new java.awt.Color(255, 255, 255));
      timePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true), "TIEMPO RESTANTE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Candara", 1, 24)));

      finishExamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finisExam(evt);
            }
        });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
          jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanel1Layout.createSequentialGroup()
                      .addGap(30, 30, 30)
                      .addComponent(todayDate, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel1Layout.createSequentialGroup()
                      .addGap(21, 21, 21)
                      .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel1Layout.createSequentialGroup()
                      .addGap(120, 120, 120)
                      .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                          .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                          .addComponent(jLabel3)))
                  .addGroup(jPanel1Layout.createSequentialGroup()
                      .addGap(137, 137, 137)
                      .addComponent(timePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel1Layout.createSequentialGroup()
                      .addGap(169, 169, 169)
                      .addComponent(finishExamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
              .addContainerGap(120, Short.MAX_VALUE))
      );
      jPanel1Layout.setVerticalGroup(
          jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
              .addGap(35, 35, 35)
              .addComponent(todayDate)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(jLabel1)
              .addGap(71, 71, 71)
              .addComponent(jLabel3)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(jLabel4)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(jLabel5)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(jLabel6)
              .addGap(48, 48, 48)
              .addComponent(timePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGap(36, 36, 36)
              .addComponent(finishExamButton, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
              .addGap(76, 76, 76))
      );

      jPanel2.setBackground(new java.awt.Color(255, 255, 255));

    //   previousButton.setUI(new MetalButtonUI());
    //   previousButton.setFont(new java.awt.Font("Arial Black", 1, 14)); 
    //   previousButton.setText("Anterior");
    //   previousButton.setForeground(new java.awt.Color(255, 255, 255));
    //   previousButton.setBackground(new java.awt.Color(0, 0, 0));
    //   previousButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
      previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousQuestion(evt);
            }
        });

      nextButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            nextQuestion(evt);
        }
    });
      
      pBarQuestions.setBackground(new java.awt.Color(255, 255, 255));
      pBarQuestions.setFont(new java.awt.Font("sansserif", 0, 14));
      pBarQuestions.setForeground(new java.awt.Color(0, 0, 0));
      pBarQuestions.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
      pBarQuestions.setName(""); // NOI18N
      pBarQuestions.setStringPainted(true);
      pBarQuestions.setString(pBarString);
      if(valor == pBarQuestions.getMinimum()){previousButton.setEnabled(false);}

      questionPanel.setBackground(new java.awt.Color(255, 255, 255));
      questionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Pregunta: "/*+questionName*/, javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Candara", 1, 18))); 

      questionsTextArea.setColumns(20);
      questionsTextArea.setRows(5);
      questionsTextArea.setEditable(false);
      jScrollPane1.setViewportView(questionsTextArea);

      File fichero = new File ("preguntas.txt");
        
        List<String> data;
        try {
            for (String str : controlador.extractDataFromFile(fichero)) {
                questionsTextArea.append(str+"\n");
            }

        } catch (IOException e) {
          e.printStackTrace();
        }
    
        

      buttonGroup1.add(jRadioButton1);
      jRadioButton1.setText("jRadioButton1");

      buttonGroup1.add(jRadioButton2);
      jRadioButton2.setText("jRadioButton2");

      buttonGroup1.add(jRadioButton3);
      jRadioButton3.setText("jRadioButton3");

      jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

      buttonGroup1.add(jRadioButton4);
      jRadioButton4.setText("jRadioButton4");

      jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
      jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

      jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

      jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
      jLabel8.setText("DOMINIO");

      jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
      jLabel7.setText("Trabajando con tipos de datos Java");

      javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(questionPanel);
      questionPanel.setLayout(jPanel4Layout);
      jPanel4Layout.setHorizontalGroup(
          jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jSeparator1)
          .addComponent(jSeparator2)
          .addComponent(jScrollPane1)
          .addGroup(jPanel4Layout.createSequentialGroup()
              .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanel4Layout.createSequentialGroup()
                      .addContainerGap()
                      .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel4Layout.createSequentialGroup()
                      .addContainerGap()
                      .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel4Layout.createSequentialGroup()
                      .addContainerGap()
                      .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel4Layout.createSequentialGroup()
                      .addContainerGap()
                      .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(jPanel4Layout.createSequentialGroup()
              .addGap(18, 18, 18)
              .addComponent(jLabel8)
              .addGap(45, 45, 45)
              .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanel4Layout.createSequentialGroup()
                      .addGap(52, 52, 52)
                      .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                      .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addGap(14, 14, 14))))
      );
      jPanel4Layout.setVerticalGroup(
          jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel4Layout.createSequentialGroup()
              .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanel4Layout.createSequentialGroup()
                      .addContainerGap()
                      .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                          .addGroup(jPanel4Layout.createSequentialGroup()
                              .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                          .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                  .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(jScrollPane1)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGap(17, 17, 17)
              .addComponent(jRadioButton1)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(jRadioButton2)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(jRadioButton3)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(jRadioButton4)
              .addGap(69, 69, 69))
      );

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
          jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
              .addContainerGap(43, Short.MAX_VALUE)
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                      .addComponent(pBarQuestions, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addGap(91, 91, 91))
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                      .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                          .addGroup(jPanel2Layout.createSequentialGroup()
                              .addComponent(previousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                          .addComponent(questionPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addGap(41, 41, 41))))
      );
      jPanel2Layout.setVerticalGroup(
          jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
              .addGap(17, 17, 17)
              .addComponent(pBarQuestions, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGap(18, 18, 18)
              .addComponent(questionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(previousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGap(24, 24, 24))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
              .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      );
      layout.setVerticalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );

      pack();
  }                      

    private void finisExam(java.awt.event.ActionEvent evt) {                                         
      timePanel.stopCountdown();
    }                  
    
    private void nextQuestion(java.awt.event.ActionEvent evt) {                                         
       if(valor < 100){ valor += 10;}
       if(valor == pBarQuestions.getMaximum()){nextButton.setEnabled(false);}
       if(valor > pBarQuestions.getMinimum()){previousButton.setEnabled(true);}
       pBarQuestions.setValue(valor);
       pBarString = String.valueOf(valor);
       pBarQuestions.setString(pBarString+" de 100 respondidas");
    }              

    private void previousQuestion(java.awt.event.ActionEvent evt) {                                         
        if(valor > 0){ valor -=10;}
        if(valor == pBarQuestions.getMinimum()){previousButton.setEnabled(false);}
        if(valor == pBarQuestions.getMaximum()-10){nextButton.setEnabled(true);}
        pBarQuestions.setValue(valor);
        pBarString = String.valueOf(valor);
        pBarQuestions.setString(pBarString+" de 100 respondidas");
    }             

        public static void main(String[] args) {

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                
                    TakeExamView ventana = new TakeExamView();   
                
                }
            });
        
        }
      
}                      