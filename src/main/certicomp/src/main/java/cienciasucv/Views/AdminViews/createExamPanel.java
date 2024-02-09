package cienciasucv.Views.AdminViews;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;

import cienciasucv.Controllers.*;
import cienciasucv.Models.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CreateExamPanel extends CreatePanel{
    private JLabel newLabel;
    public LimitedTextField NameBox;
    public JTextField DurationBox;
    private JComboBox Levels;
    private JComboBox AsociatedCourses;
    public static JTextArea DominiumArea;
    public static JTextArea InstructionsArea;
    public AddDominiumView dominiumWindow;
    public AddInstructionView instrucWindow;
    private Button addEdit1;
    private Button addEdit2; 

    public CreateExamPanel(){
        this.setLayout(null);
        this.setBackground(Fondo); 
        addTitulo(" Introduzca los datos del examen",40,90, 210, 30,14); 
        Button botonCrear= new Button();
        addEdit1 = new Button();
        addEdit2 = new Button();
        aggButtons(botonCrear,addEdit1,addEdit2);
        NameBox= new LimitedTextField(20);
        addNameBox(NameBox);
        DurationBox= new JTextField();
        setDurationBox(DurationBox);
        String [] Prueba ={"Nivel 1", "Nivel 2", "Nivel 3"};
        Levels = new JComboBox(Prueba);
        setLevelBox(Levels);
        String [] CursosP={"Java","CISCO","Front-End Web Developer"};
        AsociatedCourses = new JComboBox(CursosP);
        setCourseBox(AsociatedCourses);
        DominiumArea = new JTextArea();
        setDominumArea(DominiumArea);
        Rectangle dimensiones=DominiumArea.getBounds();
        JScrollPane Dominium = new JScrollPane(DominiumArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        Dominium.setBounds(dimensiones);
        this.add(Dominium);
        InstructionsArea= new JTextArea();
        addInstructionsArea(InstructionsArea);
        JScrollPane Instrucciones=new JScrollPane(InstructionsArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        dimensiones=InstructionsArea.getBounds();
        Instrucciones.setBounds(dimensiones);
        this.add(Instrucciones);
        ActionListener crearExamen = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                if(camposLlenos()){
                    CreateExamController controller = new CreateExamController();//añade esta instruccion aqui
                    //Exam nuevoExam= new Exam(1,getDurationBox(),getInstructionsArea(),getNameBox());
                    controller.collectExamData(CreateExamPanel.this);
                    Domain nuevoDomain=new Domain(1,getDominumArea());
                    JOptionPane.showMessageDialog(null, "EXAMEN CREADO");
                    JFrame frame=(JFrame)SwingUtilities.getWindowAncestor(CreateExamPanel.this);
                    frame.dispose();
                }else{
                JOptionPane.showMessageDialog(null, "DEBE LLENAR TODOS LOS CAMPOS");
                }
            }
        };
      
        ActionListener openDominium = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                addEdit1.setEnabled(false);
                addEdit2.setEnabled(false);
                NameBox.setEnabled(false);
                AsociatedCourses.setEnabled(false);
                DurationBox.setEnabled(false);
                Levels.setEnabled(false);
                dominiumWindow = new AddDominiumView();
                dominiumWindow.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e){
                        NameBox.setEnabled(true);
                        AsociatedCourses.setEnabled(true);
                        DurationBox.setEnabled(true);
                        Levels.setEnabled(true);
                        addEdit1.setEnabled(true);
                        addEdit2.setEnabled(true);
    
                    }
                });
            }
        };
       
        ActionListener openInstructions = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                addEdit1.setEnabled(false);
                addEdit2.setEnabled(false);
                instrucWindow = new AddInstructionView();
                NameBox.setEnabled(false);
                AsociatedCourses.setEnabled(false);
                DurationBox.setEnabled(false);
                Levels.setEnabled(false);
                instrucWindow.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e){
                        NameBox.setEnabled(true);
                        AsociatedCourses.setEnabled(true);
                        DurationBox.setEnabled(true);
                        Levels.setEnabled(true);
                        addEdit1.setEnabled(true);
                        addEdit2.setEnabled(true);
                    }
                });
            }
        };

        botonCrear.addActionListener(crearExamen);
        addEdit1.addActionListener(openDominium);
        addEdit2.addActionListener(openInstructions);
    
    }

    protected void addLogo(JLabel label){
        this.newLabel = label;
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/CertiCompSmall.png"));
        Icon nuevaIcon = new ImageIcon(icon.getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH));
        newLabel.setBounds(15, 20, 200, 50);
        newLabel.setIcon(nuevaIcon); 
    }

    private void aggButtons(Button C, Button E1, Button E2 ){
       C.addButton("CREAR", 450, 700, 150, 40);
       C.setFont(new Font("Roboto", Font.BOLD, 16));
       E1.addButton("Añadir/Editar", 160, 325, 110, 30);
       E1.setFont(new Font("Myriad Pro", Font.BOLD, 11));
       this.add(E1);
       E2.addButton("Añadir/Editar", 160, 490, 110, 30);
       E2.setFont(new Font("Myriad Pro", Font.BOLD, 11));
       this.add(E2);
       this.add(C);
    }

    private void addNameBox(JTextField campo){
        addSideText("Nombre:", 100, 140, 80, 30);
        addTextBox(campo,160, 145, 220, 22);
        this.add(campo);
    }
   
    private void setLevelBox(JComboBox lista){
        addSideText("Nivel:", 120, 197, 80, 30);
        addComboBox(lista, 160,202 , 130, 22);
        this.add(lista);
    }
    
    private void setCourseBox(JComboBox lista){
        addSideText("Curso Asociado:", 54, 168, 120, 30);
        addComboBox(lista, 160,173 , 220, 22);
        this.add(lista);
    }
    
    private void setDurationBox(JTextField cont){
        AbstractDocument document = (AbstractDocument) cont.getDocument();
        document.setDocumentFilter(new IntegerDocumentFilter());

        cont.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void insertUpdate(DocumentEvent e) {
        validateValue();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        validateValue();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        validateValue();
    }

    private void validateValue() {
        String text = cont.getText();
        try {
            int value = Integer.parseInt(text);
            if (value < 0 || value > 180) {
                if (value < 0) {
                    cont.setText("0");
                } else {
                    cont.setText("180");
                }
            }
        } catch (NumberFormatException ex) {
        }
    }
});
        addSideText("Duracion:", 95, 227, 80, 30);
        addTextBox(cont,160, 232, 70, 22);
        this.add(cont);
    }
    
    private void setDominumArea(JTextArea cont){
        cont.setLineWrap(true);
        cont.setWrapStyleWord(true);
        cont.setAutoscrolls(true);
        addSideText("Dominio(S):", 83, 260, 80, 30);
        addTextArea(cont, 160, 265, 220,50,false);
        this.add(cont);
    }
   
    private void addInstructionsArea (JTextArea cont){
        cont.setLineWrap(true);
        cont.setWrapStyleWord(true);
        cont.setAutoscrolls(true);
        addSideText("Instrucciones:", 71, 385, 90, 20);
        addTextArea(cont, 160, 385, 220, 90, false);
        this.add(cont);
    }
   
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect(25, 104, 575, 500);
    }
   
    public static void setInstructionsArea(String instrucciones){
        InstructionsArea.setText(instrucciones);
    }
    
    public static void setDominumArea(String dominios){
        DominiumArea.setText(dominios);
    }

    private boolean camposLlenos (){

        if(NameBox.getText().isEmpty()||DurationBox.getText().isEmpty()||Levels.getSelectedIndex()==-1||AsociatedCourses.getSelectedIndex()==-1 || DominiumArea.getText().isEmpty()||
        InstructionsArea.getText().isEmpty()){
            return false;

        }
        return true;
    }

    public String getNameBox(){
        return NameBox.getText();
    }
    public String getLevelBox(){  
        return String.valueOf(Levels.getSelectedItem());
    }
    public String getCourseBox(){
        return AsociatedCourses.getSelectedItem().toString();
    }
    public int getDurationBox(){
            String durationText=DurationBox.getText();
        if (durationText.isEmpty()){
            throw new NumberFormatException("El campo esta vacio");
        }

        return Integer.parseInt(durationText);
    }

    public String getDominumArea(){
        return DominiumArea.getText();
    }
    public String getInstructionsArea (){
        return InstructionsArea.getText();
    }

}