package TPZoofinal.fr.eni.zoo.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class SerialiseurJson {

    /**
     * Importe une liste d'objets d'un fichier JSON.
     *
     * @param <T>          Le type d'objet à importer.
     * @param fileName     Le chemin du fichier JSON à partir duquel importer.
     * @param elementClass La classe des objets à importer.
     * @return Une liste d'objets de type `T` importés à partir du fichier JSON.
     */
    public static <T> List<T> importerFromJson(String fileName, Class<T> elementClass) {
        List<T> elements = new ArrayList<>();
	    try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
	        String line;
	        ObjectMapper objectMapper = new ObjectMapper();
	        while ((line = reader.readLine()) != null) {
	            // Désérialiser l'objet JSON individuel problème de conflit avec l'héritage si gé
	            T element = objectMapper.readValue(line, elementClass);
	            elements.add(element);
	        }
	    } catch (IOException e) {
		    //problème à la lecture du fichier une liste vide est retournée
	    }
        return elements;
    }
    
    /**
     * Exporte une liste d'éléments en format JSON dans un fichier spécifié.
     * 
     * @param <T>       le type des éléments de la liste
     * @param fileName  le nom du fichier dans lequel les éléments JSON seront écrits
     * @param elements  la liste des éléments à exporter en JSON
     */
    public static <T> void exporterToJson(String fileName, List<T> elements) {
        // Créer un ObjectMapper et enregistrer le module JavaTime pour gérer les types date et heure.
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
	    	for (T elem : elements) {
	    		String json = mapper.writeValueAsString(elem);
	            writer.write(json);
	            writer.newLine(); 
	         }
		} catch (IOException e) {		 
			//problème lors de l'ouverture du fichier
			e.printStackTrace();
		}
    }

}
