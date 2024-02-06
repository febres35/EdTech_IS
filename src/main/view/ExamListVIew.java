package main.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ExamListVIew extends JPanel{

    private JPanel jpHeader, jpLeft, jpRight;
    JTable tbExams ;
    public  ExamListVIew() {
        setLayout(new BorderLayout());

        jpHeader = new JPanel();
        jpLeft = new JPanel();
        jpRight = new JPanel();
       
        ImageIcon imgIcon = new ImageIcon("src\\main\\view\\staticFile\\img\\logo_CertiComp250px.png");
        JLabel lbIcon = new JLabel(imgIcon);

        jpHeader.setBackground(Color.RED);
        jpHeader.add(lbIcon);
        add(jpHeader, BorderLayout.NORTH );
        



        
        jpLeft.setBackground(Color.BLUE);

        jpLeft.add(new JLabel("Left"));

        tbExams = new JTable();
        TableWithButton tableWithButton = new TableWithButton();
        tableWithButton.tableView(tbExams);
        jpLeft.add(tbExams);
        add(jpLeft, BorderLayout.WEST);

        jpRight.setBackground(Color.GREEN);
        jpRight.add(new JLabel("Right"));
        add(jpRight, BorderLayout.EAST);
   
    }

    @SuppressWarnings("unchecked")
    private void  tableMouseClicked(MouseEvent e){
    int column = tbExams.getColumnModel().getColumnIndexAtX(e.getX());
    int row = e.getY()/tbExams.getRowHeight();

        if (row < tbExams.getRowCount() && row >= 0 && column < tbExams.getColumnCount() && column >= 0){
            Object value = tbExams.getValueAt(row,column);
            if (value instanceof JButton){
                JButton btn = (JButton) value;
                System.out.println("Se ha hecho clik");
            }
        }
    }

}
