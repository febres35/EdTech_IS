package cienciasucv.certicomp.Views;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class ExamsTableBuilder implements TableBuilder{

    private JTable table;
    private String[] topColumnNames;
    private Object[][] data;
    private ButtonListener listener;
    private ButtonEditor buttonEditor;

    

    @Override
    public void reset() {
       table = new JTable(); 
    }

    @Override
    public void setColumns(String[] columnNames) {

        topColumnNames = columnNames;
     
    } 
    @Override
    public void setRows(String[][] rowdata) {

        data = rowdata;
        
    }

    public void setButtonEditor(ButtonEditor buttonEditor) {
        this.buttonEditor = buttonEditor;
    }

    @Override
    public void setTableModel() {
        DefaultTableModel model = new DefaultTableModel(data, topColumnNames);
        table.setModel(model);
    } 
    
    
    public void setButtonClickListener(ButtonListener listener) {
        System.out.println("Debugging - Printed from setButtonClickListener");
        this.listener = listener;
    }

    @Override 
    public void renderButtons(JTable table, String columnIdentifier){

        //table.getColumn(columnIdentifier).setCellRenderer(new ButtonRenderer());
        table.getColumn(columnIdentifier).setCellEditor(new ButtonEditor(new JCheckBox(), table));

        ButtonEditor buttonEditor = new ButtonEditor(new JCheckBox(), table);
        buttonEditor.setButtonClickListener(listener); 

        table.getColumn(columnIdentifier).setCellEditor(buttonEditor);

        //TableColumn tc = table.getColumn(columnIdentifier);
        //tc.setCellEditor(buttonEditor);
    }

    @Override
public void setCellRenderer() {
    table = new JTable(table.getModel()) {
        @Override
        public TableCellRenderer getCellRenderer(int row, int column) {
            if (column == getColumnCount() - 1) {
                return getDefaultRenderer(getColumnClass(column));
            } else {
                return super.getCellRenderer(row, column);
            }
        }
    };
}

    @Override
    public JTable getResult() {
        return table;        
    }

    public void setData(Object[][] data) {
        this.data = data;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Object[] row : data) {
            model.addRow(row);
        }
    }

   

    
}
