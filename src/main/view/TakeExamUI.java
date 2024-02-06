package main.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.*;
import java.beans.Statement;



/**
 * takeExamUI
 */
public class TakeExamUI extends JPanel implements ActionListener {

    private JButton btnPresentarExamen, btnSelectCourse;
    private JLabel lbIcon, lbSelectCourse, lbCourseDetail;
    private ImageIcon imgIcon;
    private JPanel plExam;
    private JTable tbExams;
    private JComboBox courseList;
    private Statement sentencia;
    private TableModel examList;
    private TableWithButton tbWBtn;

    public TakeExamUI(){
   
        // Datos de tabla y boton select
        String[] courses = { "Java", "Pytho", "Node Js", "JavaScript"};
        String[] headers = {"id", "title", "N Questions", "Duration", "Action" };
        String [][] data= {{"1", "Examen 1", "25", "15min", " " }, {"2", "Examen 2", "35", "25min", " " }, {"3", "Examen 3", "45", "35min", " " }, {"4", "Examen 4", "55", "55min", "" }, {"4", "Examen 4", "55", "55min", "" }, {"4", "Examen 4", "55", "55min", "" }, {"4", "Examen 4", "55", "55min", "" }, {"4", "Examen 4", "55", "55min", "" }, {"4", "Examen 4", "55", "55min", "" }, {"4", "Examen 4", "55", "55min", "" }};
        
        imgIcon = new ImageIcon("src\\main\\view\\staticFile\\img\\logo_CertiComp250px.png");
        lbIcon = new JLabel(imgIcon);
        add(lbIcon);  
        
        courseList = new JComboBox(courses);
        
        courseList.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){
                String courseSelection = (String) courseList.getSelectedItem();
                if (courseSelection == "Java"){
                    System.out.print(courseSelection);
             
                }
            }
            
        }); 
        tbWBtn = new TableWithButton();

        tbWBtn.setTable(headers, data);

        //examList = new BtnInTable(headers, data);            
        plExam = new JPanel();
        
        JTable tbExams = new JTable(examList);
        //JScrollPane scrollPaneTable= new JScrollPane(tbExams);
        //Border borde = BorderFactory.createLineBorder( Color.BLACK, 2);
        //Border borderTitle = BorderFactory.createTitledBorder(borde, "Exam List");
        //scrollPaneTable.setBorder(borderTitle);

          
        //plExam.add(scrollPaneTable);
        add(tbExams);
        add(courseList);
        plExam.setVisible(true);
        add(plExam);
        setVisible(true);
    }
    public  void actionPerformed(ActionEvent e ){

    }
      
}
