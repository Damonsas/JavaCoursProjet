package Inventory;

import java.util.ArrayList;

public class Inventory {
     ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {

        items.add(item);
    }


    public void displayInventory(){
        System.out.println("contenue de l'inventaire");
            for ( Item item : items) {
                item.displayInfo();
            }
    }
}
