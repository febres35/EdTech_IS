package main.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.Border;


import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.*;



/**
 * takeExamUI
 */
public class TakeExamUI extends JPanel implements ActionListener {

    JButton btnPresentarExamen, btnSelectCourse;
    JLabel lbIcon, lbSelectCourse, lbCourseDetail;
    ImageIcon imgIcon;
    JPanel plExam;
    JTable tbExams;
    
    public TakeExamUI(){
        //setLayout(null);
        

        //Se utilizo el patron singleton para esta clase.
        //imgIcon = LbImagIcon.getIcon();
        imgIcon = new ImageIcon("src\\main\\view\\staticFile\\img\\logo_CertiComp250px.png");
        lbIcon = new JLabel(imgIcon);
        //lbIcon.setBounds(10, 10, 150, 100);
        
        add(lbIcon);        
        // Variables de prueba
        String[] headers = {"id", "title", "N Questions", "Duration", "                    Action               " };
        String [][] data= {{"1", "Examen 1", "25", "15min" }, {"2", "Examen 2", "35", "25min" }, {"3", "Examen 3", "45", "35min" }, {"4", "Examen 4", "55", "55min" }, {"4", "Examen 4", "55", "55min" }, {"4", "Examen 4", "55", "55min" }, {"4", "Examen 4", "55", "55min" }, {"4", "Examen 4", "55", "55min" }, {"4", "Examen 4", "55", "55min" }, {"4", "Examen 4", "55", "55min" }};

        plExam = new JPanel();
        
        
        
        // FIn de variables de prueba
        BtnInTable btnInTable = new BtnInTable(headers, data);
        btnInTable.uploapBtn("Presentar Examen");
        
        
        JScrollPane scrollPaneTable= new JScrollPane(btnInTable);
        Border borde = BorderFactory.createLineBorder( Color.BLACK, 2);
        Border borderTitle = BorderFactory.createTitledBorder(borde, "Exam List");
        scrollPaneTable.setBorder(borderTitle);

        
        plExam.add(scrollPaneTable);
        plExam.setVisible(true);
        add(plExam);
        setVisible(true);
    }
    public  void actionPerformed(ActionEvent e ){

    }
      
}
