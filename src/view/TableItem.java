package view;

import model.TableItemModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.Serial;

public class TableItem extends Component {

    @Serial
    private static final long serialVersionUID = 1541752522315393245L;

    private final JTable tableItem;

    private final JButton btnAddItem = new JButton("Přidat položku");
    private final JButton btnRemoveItem = new JButton("Odebrat");
    private final JButton btnBack = new JButton("Zpět");
    private final JButton btnEdit = new JButton("Editovat");

    public TableItem(TableItemModel tableItemModel) {
        tableItem = new JTable(tableItemModel);
        tableItem.setShowGrid(true);
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JTable getTableItem() {
        return tableItem;
    }

    public JButton getBtnAddItem() {
        return btnAddItem;
    }

    public JButton getBtnRemoveItem() {
        return btnRemoveItem;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public void addBtnRemoveListener(ActionListener act) {
        btnRemoveItem.addActionListener(act);
    }

    public void addBtnBackListener(ActionListener act) {
        btnBack.addActionListener(act);
    }

    public void addBtnAddItemListener(ActionListener act) {
        btnAddItem.addActionListener(act);
    }

    public void addBtnEditListener(ActionListener act) {
        btnEdit.addActionListener(act);
    }
}

