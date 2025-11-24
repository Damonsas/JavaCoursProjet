/**package TPZoofinal.test.fr.eni.zoo.bll;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import TPZoofinal.fr.eni.zoo.bll.AnimalManager;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import TPZoofinal.fr.eni.zoo.bll.exception.AnimalManagerException;
import TPZoofinal.fr.eni.zoo.bll.impl.AnimalManagerImpl;
import TPZoofinal.fr.eni.zoo.bo.Animal;
import TPZoofinal.fr.eni.zoo.bo.TypeAnimal;

//utilisé pour lancer les tests dans l'ordre donné par les annotation @order
//et s'assuré que la sortie sur la console est identique à l'énoncé
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCoucheAnimalManagerInterface {

	//l'erreur provient du fait que l'on a rendu le constructeur private
	//il est impossible d'instancier un objet de type AnimalManagerImpl dorénavant
	AnimalManager animalManager = new AnimalManagerImpl();

	@Test
	@Order(1)
	/**
	 * Teste l'ajout d'un animal au gestionnaire d'animaux. Vérifie si un animal est
	 * correctement ajouté à la liste des animaux et si la taille de la liste
	 * augmente de 1.
	 *
	 * @throws AnimalManagerException si une erreur se produit lors de l'ajout de
	 *                                l'animal.
	 */
	/**public void testAjoutAnimal() throws AnimalManagerException {
		System.out.println("\n-------------- test ajout animal ---------------");
		// Arrange
		Animal lionMale = new Animal("Simba", false, 5, TypeAnimal.LION);
		int size = this.animalManager.getAnimaux().size();

		// Act
		this.animalManager.ajoutAnimal(lionMale);

		// Assert
		assertEquals(1, this.animalManager.getAnimaux().size() - size);
		System.out.println("La taille de la liste a augmenté de " + (this.animalManager.getAnimaux().size() - size));
	}

	@Test
	@Order(2)
	/**
	 * Teste la récupération d'un animal par son identifiant. Vérifie que les
	 * attributs de l'animal récupéré correspondent à ceux attendus.
	 *
	 * @throws AnimalManagerException si une erreur se produit lors de la
	 *                                récupération de l'animal.
	 */
	/**public void testGetAnimal() throws AnimalManagerException {
		System.out.println("\n-------------- test getAnimal ---------------");
		// Arrange
		Animal singeFemelle = new Animal("Coco", true, 6, TypeAnimal.SINGE);
		this.animalManager.ajoutAnimal(singeFemelle);

		// Act
		Animal animal = this.animalManager.getAnimal(singeFemelle.getId());

		// Assert
		assertEquals(animal.getNom(), "Coco");
		assertEquals(animal.getSexe(), true);
		assertEquals(animal.getType(), TypeAnimal.SINGE);
		assertEquals(animal.getAge(), 6);
		System.out.println("Détail de l'animal récupéré : " + animal);
	}

	@Test
	@Order(3)
	/**
	 * Teste la mise à jour d'un animal. Vérifie que les modifications effectuées
	 * sur l'animal sont correctement mises à jour.
	 *
	 * @throws AnimalManagerException si une erreur se produit lors de la mise à
	 *                                jour de l'animal.
	 */
	/**public void testUpdateAnimaux() throws AnimalManagerException {
		System.out.println("\n-------------- test mise à jour animal ---------------");
		// Arrange
		Animal girafeMale = new Animal("Gerald", false, 12, TypeAnimal.GIRAFE);
		
		String nouveauNom = "Moufassa";
		// Ajouter un animal pour effectuer le test
		this.animalManager.ajoutAnimal(girafeMale);
		System.out.println("Changement du nom de la girafe : " + girafeMale);
		// Changer le nom de l'animal
		girafeMale.setNom(nouveauNom);

		// Act
		this.animalManager.majAnimal(girafeMale);

		// Assert
		Animal animal = this.animalManager.getAnimal(girafeMale.getId());
		assertEquals(nouveauNom, animal.getNom());
		System.out.println("Le nom de la girafe a été changé en : " + animal.getNom());
	}
	
    @Test
    @Order(4)
    /**
     * Teste la suppression d'un animal. Vérifie si un animal est correctement
     * supprimé de la liste des animaux et si la taille de la liste diminue de 1.
     *
     * @throws AnimalManagerException si une erreur se produit lors de la suppression
     *                                de l'animal.
     */
   /** public void testDeleteAnimal() throws AnimalManagerException {
        System.out.println("\n-------------- test delete animal ---------------");
        // Arrange
		Animal elephantFemelle = new Animal("dumbo", true, 14, TypeAnimal.ELEPHANT);
		
        this.animalManager.ajoutAnimal(elephantFemelle);
        int size = this.animalManager.getAnimaux().size();

        // Act
        this.animalManager.supprimerAnimal(elephantFemelle.getId());

        // Assert
        assertEquals(size - 1, this.animalManager.getAnimaux().size());
        // Vérifier que l'animal n'existe plus
        Animal animal = this.animalManager.getAnimal(elephantFemelle.getId());
        assertNull(animal);
        System.out.println("L'animal a été supprimé avec succès");
    }
    
	@Test
	@Order(5)
	/**
	 * Teste le calcul de la moyenne d'âge des animaux. Vérifie que la moyenne
	 * calculée correspond à celle attendue.
	 *
	 * @throws AnimalManagerException si une erreur se produit lors du calcul de la
	 *                                moyenne d'âge.
	 */
	/**public void testMoyenneAge() throws AnimalManagerException {
		System.out.println("\n-------------- test moyenne âge ---------------");
		// Arrange
		Animal lionMale = new Animal("Simba", false, 5, TypeAnimal.LION);
		Animal singeFemelle = new Animal("Coco", true, 6, TypeAnimal.SINGE);
		Animal girafeMale = new Animal("Gerald", false, 12, TypeAnimal.GIRAFE);
		Animal elephantFemelle = new Animal("dumbo", true, 14, TypeAnimal.ELEPHANT);
		
		//on vide la liste pour s'assurer de le total
		List<Integer> list = this.animalManager.getAnimaux().stream().map(Animal::getId).collect(Collectors.toList());
		for (int id : list) {
			animalManager.supprimerAnimal(id);
	    }

		// Ajouter des animaux pour effectuer le test
		this.animalManager.ajoutAnimal(lionMale);
		this.animalManager.ajoutAnimal(singeFemelle);
		this.animalManager.ajoutAnimal(girafeMale);
		this.animalManager.ajoutAnimal(elephantFemelle);

		// Act: calculer la moyenne d'âge des animaux
		double moyenne = this.animalManager.getMoyenneAge();

		// Assert: vérifier que la moyenne calculée est correcte
		assertEquals(9.25, moyenne);
		System.out.println("La moyenne d'âge est de " + moyenne + " ans");

		// Nettoyage après test: supprimer les animaux ajoutés
		this.animalManager.supprimerAnimal(lionMale.getId());
		this.animalManager.supprimerAnimal(singeFemelle.getId());
		this.animalManager.supprimerAnimal(girafeMale.getId());
		this.animalManager.supprimerAnimal(elephantFemelle.getId());
	}

	@Test
	@Order(6)
	/**
	 * Teste le calcul de la proportion d'animaux femelles. Vérifie que la
	 * proportion calculée correspond à celle attendue.
	 *
	 * @throws AnimalManagerException si une erreur se produit lors du calcul de la
	 *                                proportion.
	 */
/**	public void testProportionFemelle() throws AnimalManagerException {
		System.out.println("\n-------------- test proportion femelle ---------------");
		// Arrange
		Animal lionMale = new Animal("Simba", false, 5, TypeAnimal.LION);
		Animal singeFemelle = new Animal("Coco", true, 6, TypeAnimal.SINGE);
		Animal girafeMale = new Animal("Gerald", false, 12, TypeAnimal.GIRAFE);
		Animal elephantFemelle = new Animal("dumbo", true, 14, TypeAnimal.ELEPHANT);
		
		//on vide la liste pour s'assurer de la moyenne
		List<Integer> list = this.animalManager.getAnimaux().stream().map(Animal::getId).collect(Collectors.toList());
		for (int id : list) {
			animalManager.supprimerAnimal(id);
	    }

		// Ajouter des animaux pour effectuer le test
		this.animalManager.ajoutAnimal(lionMale);
		this.animalManager.ajoutAnimal(singeFemelle);
		this.animalManager.ajoutAnimal(girafeMale);
		this.animalManager.ajoutAnimal(elephantFemelle);

		// Act
		double proportion = this.animalManager.getProportionFemelle();

		// Assert
		assertEquals(50.0, proportion);
		System.out.println("La proportion de femelle est de " + proportion + "%");

		// Nettoyage après test: supprimer les animaux ajoutés
		this.animalManager.supprimerAnimal(lionMale.getId());
		this.animalManager.supprimerAnimal(singeFemelle.getId());
		this.animalManager.supprimerAnimal(girafeMale.getId());
		this.animalManager.supprimerAnimal(elephantFemelle.getId());
	}
}
*/