package main.view;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class test {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de posicionamiento de JPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(1200, 680);
        JPanel principal = new ExamListVIew();
        /*TakeExamUI takeExam = new TakeExamUI();
        takeExam.setBounds(10, 10, 680, 580 );
        takeExam.setVisible(true);
        frame.add(takeExam);*/
        //frame.pack();
        //frame.getContentPane().add(principal);
        frame.add(principal);
        
        frame.setVisible(true);
        


    }
}
