package model;

import controller.ItemController;
import view.ItemsView;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;import java.util.Arrays;
import java.util.stream.IntStream;

public class TableReceiptModel extends AbstractTableModel{
    @Serial
    private static final long serialVersionUID = 8720445364835231767L;

    private final String[] columns = new String[] { "Name", "Itin", "Total", "items",};
    private Object[][] values = new Object[][]{

    };

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public int getRowCount() {
        return values.length;
    }

    @Override
    public Object getValueAt(int r, int c) {
        return values[r][c];
    }
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        values[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void processRow(String name, String itin, String total, int rowIndex) {
        if(rowIndex < 0) {addRow(name, itin, total); return;}

        this.setValueAt(name, rowIndex, 0);
        this.setValueAt(itin, rowIndex, 1);
        this.setValueAt(total, rowIndex, 2);
    }

    public void addRow(String name, String itin, String total) {
        JButton jButton = new JButton("polozky");
        values = Arrays.copyOf(values, values.length + 1);
        values[values.length - 1] = new Object[] { name, itin, total, jButton};
        fireTableDataChanged();


        TableItemModel tableItemModel = new TableItemModel();
        ItemsView itemsView = new ItemsView(tableItemModel);
        new ItemController(tableItemModel, itemsView);
        itemsView.setVisible(false);
        jButton.addActionListener(e -> itemsView.setVisible(true));
    }

    public void removeRow(int[] selectedRows) {
        int idx = 0;
        Object[][] newValues = Arrays.copyOf(values, values.length - selectedRows.length);
        for(int i = 0; i < values.length; i++) {
            int finalI = i;
            if(IntStream.of(selectedRows).anyMatch(x -> x == finalI)) {
                idx++;
                continue;
            }
            newValues[i - idx] = values[i];
        }
        values = newValues;
        IntStream.of(selectedRows).forEach(x -> fireTableRowsDeleted(x, x));

    }
}

