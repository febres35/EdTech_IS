package cienciasucv.certicomp.Views;

import javax.swing.JTable;

interface TableBuilder {

    void reset();
    void setColumns(String[] ColumnNames);
    void setRows(String[][] rowData);
    void setTableModel();
    void renderButtons(JTable table, String columnIdentifier);
    void setCellRenderer();
    void setButtonClickListener(ButtonListener listener);
    JTable getResult();
    
}
