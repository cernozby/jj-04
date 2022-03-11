package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddItem {
    private final JFrame itemWindow = new JFrame();
    private Container container;
    private final JLabel name = new JLabel("Name: ");
    private final JLabel amount = new JLabel("amount: ");
    private final JLabel unitPrice = new JLabel("unitPrice: ");
    private final JButton saveBtn = new JButton ("Uložit");
    private final JTextField tname = new JTextField();
    private final JTextField tamount = new JTextField();
    private final JTextField tunitprice = new JTextField();

    private int rowIndex = -1;

    public AddItem() {this.makeDialog();}

    private void addNameToForm() {
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(50, 50);
        container.add(name);

        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(150, 50);
        container.add(tname);
    }


    private void addItinToForm() {
        amount.setFont(new Font("Arial", Font.PLAIN, 20));
        amount.setSize(100, 20);
        amount.setLocation(50, 100);
        container.add(amount);

        tamount.setFont(new Font("Arial", Font.PLAIN, 15));
        tamount.setSize(190, 20);
        tamount.setLocation(150, 100);
        container.add(tamount);
    }

    private void addTotalToForm() {
        unitPrice.setFont(new Font("Arial", Font.PLAIN, 20));
        unitPrice.setSize(100, 20);
        unitPrice.setLocation(50, 150);
        container.add(unitPrice);

        tunitprice.setFont(new Font("Arial", Font.PLAIN, 15));
        tunitprice.setSize(190, 20);
        tunitprice.setLocation(150, 150);
        container.add(tunitprice);
    }

    private void addSaveBtn() {
        saveBtn.setSize(290, 20);
        saveBtn.setLocation(50, 200);
        container.add(saveBtn);
    }



    private void makeDialog() {
        itemWindow.setTitle("Přidání položky účtenky");
        itemWindow.setBounds(150, 90, 400, 400);
        itemWindow.setDefaultCloseOperation(itemWindow.EXIT_ON_CLOSE);
        itemWindow.setResizable(false);
        container = itemWindow.getContentPane();
        container.setLayout(null);

        addNameToForm();
        addItinToForm();
        addTotalToForm();
        addSaveBtn();

        itemWindow.setVisible(false);
    }

    public String getName() {
        return this.tname.getText();
    }

    public String getAmount() {
        return this.tamount.getText();
    }

    public String getUnitPrice() {
        return this.tunitprice.getText();
    }

    public void clearInputs() {
        this.tname.setText("");
        this.tamount.setText("");
        this.tunitprice.setText("");
    }

    public void setInputs(String name, String itin, String total) {
        this.tname.setText(name);
        this.tamount.setText(itin);
        this.tunitprice.setText(total);
    }

    public void saveBtnAddListener(ActionListener act) {
        saveBtn.addActionListener(act);
    }

    public JFrame getReceiptWindow() {
        return itemWindow;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }
}
