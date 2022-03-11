package controller;

import model.TableItemModel;
import view.AddItem;
import view.ItemsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemController {

    private final TableItemModel tableItemModel;
    private final ItemsView itemsView;

    public ItemController(TableItemModel tableItemModel, ItemsView itemsView) {
        itemsView.getTableItem().addBtnRemoveListener(new RemoveBtnListener());
        itemsView.getTableItem().addBtnBackListener(new BackBtnListener());
        itemsView.getTableItem().addBtnAddItemListener(new AddItemBtnListener());
        itemsView.getTableItem().addBtnEditListener(new EditBtnAction());

        itemsView.getAddItem().saveBtnAddListener(new SaveBtnReceiveActon());
        this.itemsView = itemsView;
        this.tableItemModel = tableItemModel;
    }

    class BackBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            itemsView.setVisible(false);
        }
    }

    class RemoveBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int[] selectedRows = itemsView.getTableItem().getTableItem().getSelectedRows();
            if(selectedRows.length != 0) {
                tableItemModel.removeRow(selectedRows);
                JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
            }
        }
    }

    class AddItemBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            itemsView.getAddItem().getReceiptWindow().setVisible(true);
        }
    }

    class SaveBtnReceiveActon implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AddItem addItem = itemsView.getAddItem();
            tableItemModel.processRow(addItem.getName(), addItem.getAmount(), addItem.getUnitPrice(), addItem.getRowIndex());
            addItem.setRowIndex(-1);
            addItem.clearInputs();
            addItem.getReceiptWindow().setVisible(false);

        }
    }

    class EditBtnAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int selectedRow = itemsView.getTableItem().getTableItem().getSelectedRow();

            itemsView.getAddItem().setRowIndex(selectedRow);
            itemsView.getAddItem().setInputs(
                    tableItemModel.getValueAt(selectedRow, 0).toString(),
                    tableItemModel.getValueAt(selectedRow, 1).toString(),
                    tableItemModel.getValueAt(selectedRow, 2).toString()
            );
            itemsView.getAddItem().getReceiptWindow().setVisible(true);

        }
    }

}
