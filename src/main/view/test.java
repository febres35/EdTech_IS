package main.view;

import java.awt.Rectangle;

import javax.swing.JFrame;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        Rectangle area = new Rectangle(680, 820);
        frame.setBounds(area);


        TakeExamUI takeExam = new TakeExamUI();
        takeExam.setBounds(10, 10, 640, 720);
        takeExam.setVisible(true);
        
        frame.add(takeExam);
        frame.pack();
        frame.setVisible(true);
        


    }
}
