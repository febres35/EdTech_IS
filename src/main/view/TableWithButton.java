package main.view;

import java.awt.Button;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

//public class TableWithButton extends JPanel implements MouseListener {
public class TableWithButton {

    /*private JTable table;
    private TableModel examList;
    private JScrollPane tableExams;
    private JButton btnExam;*/

    public void tableView(JTable exams){
        
        exams.setDefaultRenderer(Object.class, new RenderTableExams());
        JButton btnPresentExam = new JButton("Present Exam");

        DefaultTableModel data = new DefaultTableModel(

        new Object[][] {{"1", "Examen 1", "25", "15min", btnPresentExam }, {"2", "Examen 2", "35", "25min", btnPresentExam }, {"3", "Examen 3", "45", "35min", btnPresentExam }, {"4", "Examen 4", "55", "55min", btnPresentExam }, {"4", "Examen 4", "55", "55min", btnPresentExam }, {"4", "Examen 4", "55", "55min", btnPresentExam }, {"4", "Examen 4", "55", "55min", btnPresentExam }, {"4", "Examen 4", "55", "55min", btnPresentExam }, {"4", "Examen 4", "55", "55min", btnPresentExam }, {"4", "Examen 4", "55", "55min", btnPresentExam }},    
        new Object[] {"id", "title", "N Questions", "Duration", "Action" }
            
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        exams.setModel(data);
        exams.setRowHeight(25);
       
    }


    
    /*
    class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value != null) {
            setText("");
        } else {
            setText("Present Exam");
        }

        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }

        return this;
    }
}


    public void setTable(Object[] header, Object[][] date){
        examList = new BtnInTable(header, date);
        table = new JTable(examList);
        table.addMouseListener(this);
        btnExam = new JButton("Present Exam");

        TableColumn column = table.getColumnModel().getColumn(4);
        column.setCellRenderer(new ButtonRenderer());

        tableExams = new JScrollPane(table);
        
        add(tableExams);
        

    }
    
    @Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
        
	}

    private void validateSelect(int row){
        String id = table.getValueAt(row, 0).toString();
        String message = "Usted selecciono el examen con id = " + id;
        JOptionPane.showMessageDialog(null, message);
    }

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
        int row = table.rowAtPoint(e.getPoint());
        int column = table.columnAtPoint(e.getPoint());

        if (column == 4){
            validateSelect(row);
        }

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
	}
*/

   
}
