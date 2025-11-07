package Inventory;

public class Main {
    public static void main(String[] args) {
        CustomFrame frame = new CustomFrame("Inventaire du jeu");
        frame.setSize(250, 250);
        frame.setDefaultClose(true);
        frame.setVisibility(true);

        GameInventory inventory1 = new GameInventory();
        Item sword = new Item("épée", 2);
        Item axe = new Item("hache", 1);

        inventory1.addItem(sword);
        inventory1.addItem(axe);
    }
}

