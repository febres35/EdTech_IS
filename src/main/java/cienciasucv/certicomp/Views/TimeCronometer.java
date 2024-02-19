package cienciasucv.certicomp.Views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TimeCronometer extends JPanel {
    private JLabel timerLabel;
    private Timer timer;
    private long endTime;

    public TimeCronometer(int totalSeconds) {
        
        setLayout(new BorderLayout()); 

        endTime = System.currentTimeMillis() + (totalSeconds * 1000L);

        timerLabel = new JLabel();
        timerLabel.setForeground(Color.BLACK);
        timerLabel.setBackground(Color.WHITE);
        timerLabel.setFont(new java.awt.Font("Segoe UI", 1, 60)); 
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    
        javax.swing.GroupLayout timePanelLayout = new javax.swing.GroupLayout(this);
      this.setLayout(timePanelLayout);
      timePanelLayout.setHorizontalGroup(
        timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(timePanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(timerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
            .addContainerGap())
        );
      timePanelLayout.setVerticalGroup(
        timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(timePanelLayout.createSequentialGroup()
            .addComponent(timerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
            .addContainerGap())
        );

        startCountdown();
    }

    public void startCountdown() {
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long currentTime = System.currentTimeMillis();
                long timeRemaining = endTime - currentTime;

                if (timeRemaining <= 0) {
                    
                    timer.stop();
                    JOptionPane.showMessageDialog(TimeCronometer.this, "EXAMEN FINALIZADO", "Sistema ha finalizado", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }

                int seconds = (int) (timeRemaining / 1000) % 60;
                int minutes = (int) ((timeRemaining / 1000) / 60);

                String secondsString = String.format("%02d", seconds);
                String minutesString = String.format("%02d", minutes);

                timerLabel.setText(minutesString + ":" + secondsString);
            }
        });
        timer.start();
    }

    public void stopCountdown(){

        timer.stop();
        JOptionPane.showMessageDialog(TimeCronometer.this, "EXAMEN FINALIZADO", "Usuario ha finalizado", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);

    }
}