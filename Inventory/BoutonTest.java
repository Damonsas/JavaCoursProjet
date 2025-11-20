package Inventory;

import javax.swing.*;

public class BoutonTest {
    BoutonTest bouton = new BoutonTest();


    BoutonTest() {
        Icon icon = new ImageIcon("");
        JButton btn = new JButton(icon);
        btn.setBounds(40, 80, 200, 50);
        add(btn);
    }

    private void add(JButton btn) {
    }

    public void addItem(Item item) {
        bouton.addItem(item);

    }
}



