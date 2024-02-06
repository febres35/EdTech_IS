package main.view;


import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.BorderFactory;
//import javax.swing.table.JTableHeader;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*public class BtnInTable extends AbstractTableModel{

    private Object[] header;
    private Object[][] data;
    

    public BtnInTable( ){
        header = null;
        data = null;
    }

    public BtnInTable(Object[] header, Object[][] data ){
        this.header = header;
        this.data = data;
        
        
    }

    public BtnInTable(Object[] header){
        this.header = header;
        this.data = null;
        
        
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getRowCount'");
        if (data == null){
            return 5;
        }
        return data.length;
      }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getColumnCount'");
        if (header == null){
            return 5;
        }
        return header.length;   

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getValueAt'");
        if (data == null){
            return null;
        }
        return data[rowIndex][columnIndex];
    
    }
    public String getColumnName(int c){
        if (header == null){
            return "column " + c;
        }
        return  (String) this.header[c];
    }
}


 */

public class BtnInTable extends JTable implements ActionListener  {

    public  JButton btnPresentarExamen;
    public BtnInTable(String[] headers, Object[][] data){
        super(new DefaultTableModel(data, headers));
        setEnabled(false);


        //getColumnModel().getColumn(1).setPreferredWidth(200);
        //getColumnModel().getColumn(getColumnCount()-1).setPreferredWidth(200);
        //getTableHeader().setReorderingAllowed(false);
        
        
        //setShowHorizontalLines(false);
        //setShowVerticalLines(false);
        centerCell();
        //applyBorder();
        //applyPadding();
        //raizebleColumn();

    }

    public void uploapBtn(String btnName){
        for (int i = 0; i < getRowCount(); i++){
            int j = 0;
            while(j != getColumnCount()-1){
                j++;
            }
            //btnPresentarExamen = new JButton(btnName + " " +getValueAt(i, 0));
            //setValueAt(btnPresentarExamen, i, j); 
            JButton btnPresentarExam = new JButton(btnName + " " +getValueAt(i, 0));
            TableColumn  columnButton = getColumnModel().getColumn(j);
            columnButton.setCellRenderer(new ButtonRenderer());
            columnButton.setCellEditor(new ButtonEditor(btnPresentarExam));
            /*btnPresentarExamen.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    JButton btnPressed = (JButton) e.getSource();
                    String textButton = btnPressed.getText();
                    JOptionPane.showMessageDialog(null, "se presiono: " + textButton);
                }
            });*/
        }
    }

    private void centerCell(){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < getColumnCount(); i++){

            getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

        }

    }
    /*
    private void applyBorder(){
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        //Border border = BorderFactory.createTitledBorder("Exam List");
        //Border border = BorderFactory.createEmptyBorder();
        JTableHeader headerTable = getTableHeader();
        headerTable.setBorder(border);

        setBorder(border);
        

    } */

    private void applyPadding(){
        setRowHeight(getRowHeight() + 30);
    }


    /*private void raizebleColumn(){
        for (int i = 0; i< getColumnCount()-1; i++) {
            getColumnModel().getColumn(i).setResizable(false);
        }
    }

    public void actionPerformed(ActionEvent e){
        JButton btnPressed = (JButton) e.getSource();
        String textButton = btnPressed.getText();
        JOptionPane.showMessageDialog(null, "se presiono: " + textButton);
    }

    
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }
    
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "Presentar Examt" : value.toString());
            return this;
        }
    }
    
    
*/    
}



