package view;

import model.TableItemModel;

import javax.swing.*;
import java.awt.*;

public class ItemsView extends JFrame {
    private final JPanel mainPanel = new JPanel();
    private final TableItemModel tableItemModel;
    private TableItem tableItem;
    private final AddItem addItem = new AddItem();


    public ItemsView(TableItemModel tableItemModel) {
        this.tableItemModel = tableItemModel;
        this.pageSetting();

    }

    void pageSetting() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700, 700));
        mainPanel.setLayout(new BorderLayout());
        this.addComponents();
        getContentPane().add(mainPanel);
        pack();
    }

    void addComponents() {
        this.tableItem = new TableItem(tableItemModel);
        this.mainPanel.add(new JScrollPane(tableItem.getTableItem()), BorderLayout.CENTER);

        JPanel subPanelBottom = new JPanel();
        subPanelBottom.add(tableItem.getBtnAddItem());
        subPanelBottom.add(tableItem.getBtnRemoveItem());
        subPanelBottom.add(tableItem.getBtnBack());
        subPanelBottom.add(tableItem.getBtnBack());
        subPanelBottom.add(tableItem.getBtnEdit());
        this.mainPanel.add(subPanelBottom, BorderLayout.SOUTH);
    }


    public TableItem getTableItem() {
        return tableItem;
    }

    public AddItem getAddItem() {
        return addItem;
    }
}