package view;

import model.TableReceiptModel;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private final JPanel mainPanel = new JPanel();
    private final TableReceiptModel tableReceiptModel;
    private TableReceipt tableReceipt;
    private final AddReceipt addReceipt = new AddReceipt();


    public MainView(TableReceiptModel tableReceiptModel) {
        this.tableReceiptModel = tableReceiptModel;
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
        this.tableReceipt = new TableReceipt(tableReceiptModel);
        this.mainPanel.add(new JScrollPane(tableReceipt.getTableReceipt()), BorderLayout.CENTER);

        JPanel subPanelBottom = new JPanel();
        subPanelBottom.add(tableReceipt.getBtnAddReceipt());
        subPanelBottom.add(tableReceipt.getBtnRemove());
        subPanelBottom.add(tableReceipt.getBtnEdit());

        this.mainPanel.add(subPanelBottom, BorderLayout.SOUTH);
    }

    public TableReceipt getTableReceipt() {
        return this.tableReceipt;
    }

    public AddReceipt getAddReceipt() {
        return addReceipt;
    }
}
