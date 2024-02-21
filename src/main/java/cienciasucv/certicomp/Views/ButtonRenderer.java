package cienciasucv.certicomp.Views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JButton implements TableCellRenderer{
    public ButtonRenderer() {
        setOpaque(true);
        setPreferredSize(new Dimension(100, 20)); 
        
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
                setText((value == null) ? "" : value.toString());
        return this;
    }
}