package controller;

import model.TableReceiptModel;
import view.AddReceipt;
import view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableController {

    private final TableReceiptModel tableReceiptModel;
    private final MainView mainView;

    public TableController(TableReceiptModel tableReceiptModel, MainView mainView) {
        this.mainView = mainView;
        this.tableReceiptModel = tableReceiptModel;
        mainView.getTableReceipt().btnRemoveListener(new RemoveBtnListener());
        mainView.getTableReceipt().addReceiptBtnAddListener(new AddReceiptBtnListener());
        mainView.getTableReceipt().editBtnListener(new editBtnAction());
        mainView.getAddReceipt().saveBtnAddListener(new SaveBtnReceiveActon());

    }

    class editBtnAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int selectedRow = mainView.getTableReceipt().getTableReceipt().getSelectedRow();

            if (selectedRow < 0) {JOptionPane.showMessageDialog(null, "Není vybraná žádná položka!"); return;}
            mainView.getAddReceipt().setRowIndex(selectedRow);
            mainView.getAddReceipt().setInputs(
                    tableReceiptModel.getValueAt(selectedRow, 0).toString(),
                    tableReceiptModel.getValueAt(selectedRow, 1).toString(),
                    tableReceiptModel.getValueAt(selectedRow, 2).toString()
            );
            mainView.getAddReceipt().getReceiptWindow().setVisible(true);

        }
    }


    class SaveBtnReceiveActon implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AddReceipt addReceipt = mainView.getAddReceipt();
            tableReceiptModel.processRow(addReceipt.getName(), addReceipt.getItin(), addReceipt.getTotal(), addReceipt.getRowIndex());
            addReceipt.setRowIndex(-1);
            addReceipt.clearInputs();
            addReceipt.getReceiptWindow().setVisible(false);
        }
    }

    class RemoveBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int[] selectedRows = mainView.getTableReceipt().getTableReceipt().getSelectedRows();
            if(selectedRows.length != 0) {
                tableReceiptModel.removeRow(selectedRows);
                JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
            }
        }
    }

    class AddReceiptBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainView.getAddReceipt().getReceiptWindow().setVisible(true);
        }
    }


    public static class JTableButtonMouseListener extends MouseAdapter {
        private final JTable table;

        public JTableButtonMouseListener(JTable table) {
            this.table = table;
        }

        @Override public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX());
            int row    = e.getY()/table.getRowHeight();
            System.out.println("Col :"+column + "row:"+row);

            if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
                Object value = table.getValueAt(row, column);
                System.out.println("Value :"+value.getClass().getName());
                if (value instanceof JButton) {
                    ((JButton)value).doClick();
                }

            }
        }
    }
}
