package Inventory;

import javax.swing.*;

public class BoutonTest {
    BoutonTest() {
        JFrame f = new JFrame("Exemple JButton avec image");
        Icon icon = new ImageIcon("");
        JButton btn = new JButton(icon);
        btn.setBounds(40,80,200,50);
        f.add(btn);
        f.setSize(300,250);
        f.setLayout(null);
        f.setVisible(true);
    }


    }



