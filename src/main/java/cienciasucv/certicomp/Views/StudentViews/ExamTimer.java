package cienciasucv.certicomp.Views.StudentViews;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExamTimer {

    private int counter;
    private JLabel timerLabel;
    private Timer timer;
    private int minutes;
    private int seconds;

    public ExamTimer(int duration) {

        System.out.println("Duration value: " + duration);
        counter  = duration * 60;;
        timerLabel = new JLabel();
        timerLabel.setFont(new Font("ROBOTO", Font.BOLD, 45));
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter--;
                minutes = counter / 60;
                int seconds = counter % 60;
                timerLabel.setText(String.format("%02d:%02d", minutes, seconds));

                if (counter == 0) {
                    ((Timer)e.getSource()).stop();
                }
            }
        });
    }

    public void start(){
        timer.start();
    }

    public JLabel getTimerLabel(){
        return timerLabel;
    }
}
