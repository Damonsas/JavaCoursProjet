package Inventory;

import javax.swing.JFrame;  // Importer la vraie classe JFrame

public class CustomFrame {  // Renommer la classe pour éviter le conflit avec JFrame
    private JFrame frame;  // Utiliser un objet JFrame de Swing

    public CustomFrame(String title) {
        frame = new JFrame(title); // Créer un objet JFrame avec un titre
    }

    // Méthode pour définir la visibilité
    public void setVisibility(boolean visible) {
        frame.setVisible(visible);
    }

    // Méthode pour définir la taille de la fenêtre
    public void setSize(int width, int height) {
        frame.setSize(width, height);
    }

    // Méthode pour définir la fermeture de la fenêtre
    public void setDefaultClose(boolean exitOnClose) {
        if (exitOnClose) {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }
}


