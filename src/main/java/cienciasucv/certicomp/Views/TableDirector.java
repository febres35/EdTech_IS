package cienciasucv.certicomp.Views;

public class TableDirector {
    public static void buildTable(TableBuilder builder, String[][] data, String[] columnNames) {

        String lastColumn = columnNames[columnNames.length - 1];

        builder.reset();
        builder.setColumns(columnNames);
        builder.setRows(data);
        builder.setTableModel();
        builder.renderButtons(builder.getResult(), lastColumn);
        builder.getResult();
    }
    
}