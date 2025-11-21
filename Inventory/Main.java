package Inventory;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CustomFrame frame = new CustomFrame("Inventaire du jeu");
        frame.setSize(500, 500);
        GameInventory inventory1 = new GameInventory();
        Item sword = new Item("épée", 2);
        Item axe = new Item("hache", 1);
        BoutonTest btn = new BoutonTest("add");
        btn.addActionListener();

        frame.setDefaultClose(true);
        frame.setVisibility(true);
    }
}

