package Inventory;

public class Main {
    public static void main(String[]args){
        Inventory inventory = new Inventory();

        GameInventory inventory1 = new GameInventory();
        Item sword = new Item("épée", 2);
        Item axe = new Item("hache", 1);

        inventory1.addItem(sword);
        inventory1.addItem(axe);

        inventory.displayInventory();

        inventory1.displayIventory();

    }

}
