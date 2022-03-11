package view;

import controller.TableController;
import model.TableReceiptModel;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.Serial;

public class TableReceipt extends Component {

    @Serial
    private static final long serialVersionUID = 1541752522315393245L;

    private final JTable tableReceipt;
    private final JButton btnAddReceipt;
    private final JButton btnRemove;
    private final JButton btnEdit = new JButton("Editovat");

    public TableReceipt(TableReceiptModel tableReceiptModel) {
        tableReceipt = new JTable(tableReceiptModel);
        tableReceipt.setShowGrid(true);
        tableReceipt.addMouseListener(new TableController.JTableButtonMouseListener(tableReceipt));

        btnAddReceipt = new JButton("Přidat účtenku");
        btnRemove = new JButton("Odebrat");


        TableCellRenderer cellRenderer = tableReceipt.getDefaultRenderer(JButton.class);
        tableReceipt.getColumnModel().getColumn(3).setCellRenderer(new JTableButtonRenderer(cellRenderer));


        }

    public void addReceiptBtnAddListener(ActionListener act) {
        btnAddReceipt.addActionListener(act);
    }

    public void btnRemoveListener(ActionListener act) {
            btnRemove.addActionListener(act);
    }

    public void editBtnListener(ActionListener act) {
        btnEdit.addActionListener(act);
    }

    public JTable getTableReceipt() {
        return tableReceipt;
    }

    public JButton getBtnAddReceipt() {
        return btnAddReceipt;
    }

    public JButton getBtnRemove() {
            return btnRemove;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    static class JTableButtonRenderer implements TableCellRenderer {
        private final TableCellRenderer defaultRenderer;
        public JTableButtonRenderer(TableCellRenderer renderer) {
            defaultRenderer = renderer;
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if(value instanceof Component)
                return (Component)value;
            return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
}
