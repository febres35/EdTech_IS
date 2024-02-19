package cienciasucv.certicomp.Views;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isButtonPressed;
    private JTable table;
    private ButtonListener listener; 
    public static String capturedID;

    public ButtonEditor(JCheckBox checkBox, JTable table) {
        super(checkBox);
        this.table = table;
        this.button = Buttons.getButton("Presentar Examen", ButtonSize.SMALL);
        this.button.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    public void setButtonClickListener(ButtonListener buttonClickListener) { 

        this.listener = buttonClickListener;
        System.out.println(listener);
        System.out.println("I am listening!");
    }

    public Component getTableCellEditorComponent(JTable table, Object value, 
    boolean isSelected, int row, int column) {
        System.out.println("Component called!");
        label = (value == null) ? "" : value.toString();
        isButtonPressed = true;
        return button;
    }

    public Object getCellEditorValue() {
        if (isButtonPressed) {
            int selectedRow = table.getSelectedRow();
            String id = table.getModel().getValueAt(selectedRow, 0).toString();
            System.out.println("Pressed! id= " + id);
            System.out.println(listener);
            if (listener != null) {
                listener.onButtonClick(id);
            }
        }
        isButtonPressed = false;
        return label;
    }

    public boolean stopCellEditing() {
        isButtonPressed = false;
        return super.stopCellEditing();
    }

    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}