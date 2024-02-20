package cienciasucv.certicomp.Views.AdminViews;
import cienciasucv.certicomp.Controllers.CreateExamController;
import cienciasucv.certicomp.Views.ButtonSize;
import cienciasucv.certicomp.Views.Buttons;
import cienciasucv.certicomp.Views.LogoSize;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CreateExamPanel extends PanelContent{
    public LimitedTextField NameBox;
    public static JTextField DurationBox;
    private JComboBox Levels;
    private JComboBox AsociatedCourses;
    public static JTextArea DominiumArea;
    public static JTextArea InstructionsArea;
    public AddDominiumView dominiumWindow;
    public AddInstructionView instrucWindow;
    private JButton botonCrear;
    private JButton addEdit1;
    private JButton addEdit2; 

    public CreateExamPanel(){
        addLogo(LogoSize.SMALL, 25, 20);
        this.setLayout(null);
        this.setBackground(Fondo); 
        addTitulo(" Introduzca los datos del examen",40,90, 210, 30,14); 
        addButtons();
        NameBox= new LimitedTextField(20);
        addNameBox();
        DurationBox= addTextBox(160, 232, 70, 22);
        addDurationBox(DurationBox);
        String [] Prueba ={"Nivel 1", "Nivel 2", "Nivel 3"};
        addLevelBox(Prueba);
        String [] CursosP={"Java","CISCO","Front-End Web Developer"};
        addCourseBox(CursosP);
        DominiumArea =addTextArea(160, 265, 220,50);
        DominiumArea.setEditable(false);
        addDominumArea(DominiumArea);
        Rectangle dimensiones=DominiumArea.getBounds();
        JScrollPane Dominium = new JScrollPane(DominiumArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        Dominium.setBounds(dimensiones);
        this.add(Dominium);
        InstructionsArea=addTextArea(160, 385, 220, 90);
        InstructionsArea.setEditable(false);
        addInstructionsArea(InstructionsArea);
        JScrollPane Instrucciones=new JScrollPane(InstructionsArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        dimensiones=InstructionsArea.getBounds();
        Instrucciones.setBounds(dimensiones);
        this.add(Instrucciones);
       
        botonCrear.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                if(camposLlenos()==true){
                    if(Integer.parseInt(DurationBox.getText())<30){

                        JOptionPane.showMessageDialog(null, "LA DURACION DEBE SER MAYOR A 30 MINUTOS");
                    }else{
                    CreateExamController controller = new CreateExamController();//añade esta instruccion aqui
                   if( controller.collectExamData(CreateExamPanel.this)==true){
                   }else{
                    //Domain nuevoDomain=new Domain(1,getDominumArea());
                    JFrame frame=(JFrame)SwingUtilities.getWindowAncestor(CreateExamPanel.this);
                    restartAll();
                    frame.dispose();}}
                }else{
                JOptionPane.showMessageDialog(null, "DEBE LLENAR TODOS LOS CAMPOS");
                }
            }
        });
      
        addEdit1.addActionListener((ActionListener) new ActionListener() {
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
        });
       
        addEdit2.addActionListener((ActionListener) new ActionListener() {
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
        });
    
    }

    private void addButtons(){
       botonCrear=Buttons.getButton("CREAR", ButtonSize.LARGE);
       botonCrear.setBounds(400, 650,botonCrear.getPreferredSize().width,botonCrear.getPreferredSize().height);
       addEdit1=Buttons.getButton("Añadir/Editar",ButtonSize.WIDER);
       addEdit1.setBounds(160, 325,addEdit1.getPreferredSize().width,addEdit1.getPreferredSize().height);
       addEdit2=Buttons.getButton("Añadir/Editar",ButtonSize.WIDER);
       addEdit2.setBounds(160, 490,addEdit2.getPreferredSize().width,addEdit2.getPreferredSize().height);
       this.add(botonCrear);
       this.add(addEdit1);
       this.add(addEdit2);
    }

    private void addNameBox(){
        addSideText("Nombre:", 100, 140, 80, 30);
        NameBox= new LimitedTextField(20);
        NameBox.setBounds(160, 145, 220, 22);
        this.add(NameBox);
    }
   
    private void addLevelBox(String[] prueba){
        addSideText("Nivel:", 120, 197, 80, 30);
        Levels=PanelContent.addComboBox(prueba, 160,202 , 130, 22);
        this.add(Levels);
    }
    
    private void addCourseBox(String[] lista){
        addSideText("Curso Asociado:", 54, 168, 120, 30);
        AsociatedCourses=addComboBox(lista, 160,173 , 220, 22);
        this.add(AsociatedCourses);
    }
    
    private void addDurationBox(JTextField cont) {
        AbstractDocument document = (AbstractDocument) cont.getDocument();
        document.setDocumentFilter(new IntegerDocumentFilter());
    
        final JTextField[] contArr = { cont }; // Crear un array de longitud 1
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
                String text = contArr[0].getText(); // Acceder a la variable a través del array
                try {
                    int value = Integer.parseInt(text);
                  if (value < 0 || value > 180) {
                    if (value < 0) {
                        contArr[0].setText("0");
                    } else {
                        contArr[0].setText("180");
                    }
                }
                } catch (NumberFormatException ex) {
                }
            }
        });
        addSideText("Duracion:", 95, 227, 80, 30);
        this.add(cont);
    }

    
    private void addDominumArea(JTextArea cont){
        cont.setLineWrap(true);
        cont.setWrapStyleWord(true);
        cont.setAutoscrolls(true);
        addSideText("Dominio(S):", 83, 260, 80, 30);
        this.add(cont);
    }
   
    private void addInstructionsArea (JTextArea cont){
        cont.setLineWrap(true);
        cont.setWrapStyleWord(true);
        cont.setAutoscrolls(true);
        addSideText("Instrucciones:", 71, 385, 90, 20);
        this.add(cont);
    }
   
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect(25, 104, 575, 500);
    }
    
    private boolean camposLlenos (){

        if(NameBox.getText().trim().isEmpty()||DurationBox.getText().trim().isEmpty()||Levels.getSelectedIndex()==-1||AsociatedCourses.getSelectedIndex()==-1 ||
        DominiumArea.getText().trim().isEmpty()||InstructionsArea.getText().trim().isEmpty()){
            return false;
        }
        
        return true;
    }

    public String getNameBox(){
        return NameBox.getText();
    }
    
    public String getCourseBox(){
        return AsociatedCourses.getSelectedItem().toString();
    }

    public String getLevelBox(){  
        return String.valueOf(Levels.getSelectedItem());
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
    
    public void setName(String Name){
        NameBox.setText(Name);
    }
    
    public void setCourse(int index){
        AsociatedCourses.setSelectedIndex(index);
    }

    public void setLevel(int index){
        Levels.setSelectedIndex(index);
    }
   
    public static void setDuration(String duration){
        DurationBox.setText(duration);
    }

    public static void setInstructionsArea(String instrucciones){
        InstructionsArea.setText(instrucciones);
    }
    
    public static void setDominumArea(String dominios){
        DominiumArea.setText(dominios);
    }

    public void restartAll(){
        setDominumArea("");
        setInstructionsArea("");
        setName("");
        setDuration("");
        setLevel(0);
        setCourse(0);
    }


}