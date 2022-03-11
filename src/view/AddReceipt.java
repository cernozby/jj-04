package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddReceipt {
    private final JFrame receiptWindow = new JFrame();
    private Container container;
    private final JLabel name = new JLabel("Name: ");
    private final JLabel itin = new JLabel("Itin: ");
    private final JLabel total = new JLabel("Total: ");
    private final JButton saveBtn = new JButton ("Uložit");
    private final JTextField tname = new JTextField();
    private final JTextField titin = new JTextField();
    private final JTextField ttotal = new JTextField();

    private int rowIndex = -1;

    public AddReceipt() {this.makeDialog();}

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
        itin.setFont(new Font("Arial", Font.PLAIN, 20));
        itin.setSize(100, 20);
        itin.setLocation(50, 100);
        container.add(itin);

        titin.setFont(new Font("Arial", Font.PLAIN, 15));
        titin.setSize(190, 20);
        titin.setLocation(150, 100);
        container.add(titin);
    }

    private void addTotalToForm() {
        total.setFont(new Font("Arial", Font.PLAIN, 20));
        total.setSize(100, 20);
        total.setLocation(50, 150);
        container.add(total);

        ttotal.setFont(new Font("Arial", Font.PLAIN, 15));
        ttotal.setSize(190, 20);
        ttotal.setLocation(150, 150);
        container.add(ttotal);
    }

    private void addSaveBtn() {
        saveBtn.setSize(290, 20);
        saveBtn.setLocation(50, 200);
        container.add(saveBtn);
    }



    private void makeDialog() {
        receiptWindow.setTitle("Registration Form");
        receiptWindow.setBounds(150, 90, 400, 400);
        receiptWindow.setDefaultCloseOperation(receiptWindow.EXIT_ON_CLOSE);
        receiptWindow.setResizable(false);
        container = receiptWindow.getContentPane();
        container.setLayout(null);

        addNameToForm();
        addItinToForm();
        addTotalToForm();
        addSaveBtn();

        receiptWindow.setVisible(false);
    }

    public String getName() {
        return this.tname.getText();
    }

    public String getItin() {
        return this.titin.getText();
    }

    public String getTotal() {
        return this.ttotal.getText();
    }

    public void clearInputs() {
        this.tname.setText("");
        this.titin.setText("");
        this.ttotal.setText("");
    }

    public void setInputs(String name, String itin, String total) {
        this.tname.setText(name);
        this.titin.setText(itin);
        this.ttotal.setText(total);
    }

    public void saveBtnAddListener(ActionListener act) {
        saveBtn.addActionListener(act);
    }

    public JFrame getReceiptWindow() {
        return receiptWindow;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }
}
