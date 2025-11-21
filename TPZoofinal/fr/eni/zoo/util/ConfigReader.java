package TPZoofinal.fr.eni.zoo.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /**
     * Lit la propriété "database.context" à partir du fichier de propriétés "config.properties".
     *
     * @return La valeur de la propriété "database.context" si elle existe, sinon retourne une chaîne vide.
     */
    public static String getContext() {
        String resultat = "";

        // Utiliser un bloc try-with-resources pour garantir la fermeture du flux d'entrée après utilisation
        try (FileInputStream input = new FileInputStream("config.properties")) {
            // Créer un nouvel objet Properties pour charger les propriétés à partir du fichier
            Properties prop = new Properties();

            // Charger les propriétés à partir du flux d'entrée
            prop.load(input);

            // Obtenir la valeur de la propriété "database.context"
            resultat = prop.getProperty("database.context");

        } catch (IOException e) {
            // Imprimer la trace de la pile de l'exception si une IOException est levée
            e.printStackTrace();
            // Une meilleure gestion de l'erreur pourrait inclure l'enregistrement de l'erreur ou la propagation d'une exception spécifique
        }

        // Retourner la valeur de la propriété "database.context"
        // ou une chaîne vide si la propriété n'est pas trouvée
        return resultat;
    }
}
