package JavaProjet.Inventory;

public class Item {
     public String name;
     public int  quantity;

    public Item (String name, int quantity ){
        this.name = name;
        this.quantity = quantity;
    }



    public void displayInfo(){
        System.out.println("nom: " +name + ",quantité: " + quantity);
    }
}



