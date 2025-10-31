package Inventory;

public class Main {
    public static void main(String[] args) {
        // Créer une instance de la fenêtre personnalisée
        CustomFrame frame = new CustomFrame("Hello World");
        frame.setSize(250, 250);
        frame.setDefaultClose(true);  // La fenêtre ferme l'application à la fermeture
        frame.setVisibility(true);  // Afficher la fenêtre

        GameInventory inventory1 = new GameInventory();
        Item sword = new Item("épée", 2);
        Item axe = new Item("hache", 1);

        inventory1.addItem(sword);
        inventory1.addItem(axe);
    }
}

