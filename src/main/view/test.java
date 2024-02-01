package main.view;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setBackground(Color.white);
        Rectangle area = new Rectangle(1360, 760);
        frame.setBounds(area);


        TakeExamUI takeExam = new TakeExamUI();
        takeExam.setBounds(10, 10, 680, 580 );
        takeExam.setVisible(true);
        frame.add(takeExam);
        //frame.pack();
        frame.setVisible(true);
        


    }
}
