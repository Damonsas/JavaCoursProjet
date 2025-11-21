package TPZoofinal.test.fr.eni.zoo.bll;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import TPZoofinal.fr.eni.zoo.bll.exception.SalarieManagerException;
import TPZoofinal.fr.eni.zoo.bll.impl.SalarieManagerImpl;
import TPZoofinal.fr.eni.zoo.bo.Adresse;
import TPZoofinal.fr.eni.zoo.bo.Salarie;
import TPZoofinal.fr.eni.zoo.bo.Gardien;
import TPZoofinal.fr.eni.zoo.bo.Soignant;
import TPZoofinal.fr.eni.zoo.bo.TypeAnimal;

//utilisé pour lancer les tests dans l'ordre donné par les annotation @order
//et s'assuré que la sortie sur la console est identique à l'énoncé
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCoucheSalarieManagerInterface {

	//l'erreur provient du fait que l'on a rendu le constructeur private
	//il est impossible d'instancier un objet de type SalarieManagerImpl dorénavant
	SalarieManager salarieManager = new SalarieManagerImpl();

	@Test
	@Order(1)
	/**
	 * Teste l'ajout d'un salarié au gestionnaire de salariés. Vérifie si un salarié
	 * est correctement ajouté à la liste des salariés et si la taille de la liste
	 * augmente de 1.
	 *
	 * @throws SalarieManagerException si une erreur se produit lors de l'ajout du
	 *                                 salarié.
	 */
	public void testAjoutSalarie() throws SalarieManagerException {
		System.out.println("\n-------------- test ajout salarie ---------------");
		// Arrange

		Adresse address = new Adresse(3, "2b rue Faraday", "Saint Herblain", "44800");
		Gardien gardien = new Gardien("Dubois", "Sophie", 1600, address, true);
		
		int size = this.salarieManager.getSalaries().size();

		// Act
		this.salarieManager.ajoutSalarie(gardien);

		// Assert
		assertEquals(1, this.salarieManager.getSalaries().size() - size);
		System.out.println("La taille de la liste a augmenté de " + (this.salarieManager.getSalaries().size() - size));

		// Nettoyage après test: supprimer le salarié ajouté
		this.salarieManager.supprimerSalarie(gardien.getId());
	}

	@Test
	@Order(2)
	/**
	 * Teste la récupération d'un salarié par son identifiant. Vérifie que les
	 * attributs du salarié récupéré correspondent à ceux attendus.
	 *
	 * @throws SalarieManagerException si une erreur se produit lors de la
	 *                                 récupération du salarié.
	 */
	public void testGetSalarie() throws SalarieManagerException {
		System.out.println("\n-------------- test getSalarie ---------------");
		// Arrange
		Adresse address = new Adresse(4, "1 rue de la soie", "Quimper", "29000");
		Gardien gardien = new Gardien("Leclerc", "Jacques", 1700, address, false);

		
		this.salarieManager.ajoutSalarie(gardien);

		// Act
		Salarie salarie = this.salarieManager.getSalarie(gardien.getId());

		// Assert
		assertEquals(salarie.getNom(), "Leclerc");
		assertEquals(salarie.getPrenom(), "Jacques");
		assertEquals(salarie.getSalaire(), 1700);
		assertEquals(salarie.getAdresse(), address);
		System.out.println("Détail du salarié Leclerc : " + salarie);

		// Nettoyage après test: supprimer le salarié ajouté
		this.salarieManager.supprimerSalarie(gardien.getId());
	}

	@Test
	@Order(3)
	/**
	 * Teste la mise à jour d'un salarié. Vérifie que les modifications effectuées
	 * sur le salarié sont correctement mises à jour.
	 *
	 * @throws SalarieManagerException si une erreur se produit lors de la mise à
	 *                                 jour du salarié.
	 */
	public void testUpdateSalaries() throws SalarieManagerException {
		System.out.println("\n-------------- test mise à jour du salarié ---------------");
		// Arrange

		Adresse address = new Adresse(9, " chemin des bois", "Nantes", "44000");

		Soignant soignant = new Soignant("Dupont", "Daniel", 1800, address, TypeAnimal.LION);
		
		String nouveauNom = "Martin";
		// Ajouter un salarié pour effectuer le test
		this.salarieManager.ajoutSalarie(soignant);

		System.out.println("Détail du soignant : " + soignant);

		// Changer le nom du salarié
		soignant.setNom(nouveauNom);

		// Act: mettre à jour le salarié
		this.salarieManager.majSalarie(soignant);

		// Assert: vérifier que le nom du salarié a été mis à jour
		Salarie salarie = this.salarieManager.getSalarie(soignant.getId());
		assertEquals(nouveauNom, salarie.getNom());
		System.out.println("Changement du nom du soignant : " + soignant);

		// Nettoyage après test: supprimer le salarié mis à jour
		this.salarieManager.supprimerSalarie(soignant.getId());
	}
	 
	@Test
    @Order(4)
    public void testDeleteSalarie() throws SalarieManagerException {
        System.out.println("\n-------------- test delete salarie ---------------");
        // Arrange
		Adresse address = new Adresse(3, "2b rue Faraday", "Saint Herblain", "44800");

		Gardien gardien1 = new Gardien("Dubois", "Sophie", 1600, address, true);
		
        this.salarieManager.ajoutSalarie(gardien1);
        int size = this.salarieManager.getSalaries().size();

        // Act
        this.salarieManager.supprimerSalarie(gardien1.getId());

        // Assert: vérifier si la taille de la liste a diminué de 1
        assertEquals(size - 1, this.salarieManager.getSalaries().size());
        // Vérifier que le salarié n'existe plus
        Salarie salarie = this.salarieManager.getSalarie(gardien1.getId());
        assertNull(salarie);
        System.out.println("Le salarié a été supprimé avec succès");
    }

	@Test
	@Order(5)
	/**
	 * Teste le calcul de la masse salariale totale. Vérifie que la masse salariale
	 * calculée correspond à celle attendue.
	 *
	 * @throws SalarieManagerException si une erreur se produit lors du calcul de la
	 *                                 masse salariale.
	 */
	public void testMasseSalariale() throws SalarieManagerException {
		System.out.println("\n-------------- test masse salariale ---------------");
		// Arrange
		Gardien gardien1 = new Gardien("Dubois", "Sophie", 1600, null, true);
		Gardien gardien2 = new Gardien("Leclerc", "Jacques", 1700, null, false);

		Soignant soignant1 = new Soignant("Dupont", "Daniel", 1800, null, TypeAnimal.LION);
		Soignant soignant2 = new Soignant("Martin", "Julie", 1750, null, TypeAnimal.SINGE);
		
		//on vide la liste pour s'assurer de le total
		List<Integer> list = this.salarieManager.getSalaries().stream().map(Salarie::getId).collect(Collectors.toList());
		for (int id : list) {
			salarieManager.supprimerSalarie(id);
	    }
		
		this.salarieManager.ajoutSalarie(gardien1);
		this.salarieManager.ajoutSalarie(gardien2);
		this.salarieManager.ajoutSalarie(soignant1);
		this.salarieManager.ajoutSalarie(soignant2);

		// Act: calculer la masse salariale totale
		double masse = this.salarieManager.getMasseSalariale();

		// Assert: vérifier que la masse salariale calculée est correcte
		assertEquals(6850.0, masse);
		System.out.println("La masse salariale totale est de " + masse + " euros");

		// Nettoyage après test: supprimer les salariés ajoutés
		this.salarieManager.supprimerSalarie(gardien1.getId());
		this.salarieManager.supprimerSalarie(gardien2.getId());
		this.salarieManager.supprimerSalarie(soignant1.getId());
		this.salarieManager.supprimerSalarie(soignant2.getId());
	}

	@Test
	@Order(6)
	/**
	 * Teste le calcul de la moyenne salariale. Vérifie que la moyenne salariale
	 * calculée correspond à celle attendue.
	 *
	 * @throws SalarieManagerException si une erreur se produit lors du calcul de la
	 *                                 moyenne salariale.
	 */
	public void testMoyenneSalariale() throws SalarieManagerException {
		System.out.println("\n-------------- test moyenne salariale ---------------");
		// Arrange
		Gardien gardien1 = new Gardien("Dubois", "Sophie", 1600, null, true);
		Gardien gardien2 = new Gardien("Leclerc", "Jacques", 1700, null, false);

		Soignant soignant1 = new Soignant("Dupont", "Daniel", 1800, null, TypeAnimal.LION);
		Soignant soignant2 = new Soignant("Martin", "Julie", 1750, null, TypeAnimal.SINGE);
		
		//on vide la liste pour s'assurer de la moyenne
		List<Integer> list = this.salarieManager.getSalaries().stream().map(Salarie::getId).collect(Collectors.toList());
		for (int id : list) {
			salarieManager.supprimerSalarie(id);
	    }
		
		this.salarieManager.ajoutSalarie(gardien1);
		this.salarieManager.ajoutSalarie(gardien2);
		this.salarieManager.ajoutSalarie(soignant1);
		this.salarieManager.ajoutSalarie(soignant2);

		// Act
		double moyenne = this.salarieManager.getMoyenneSalariale();

		// Assert
		assertEquals(1712.5, moyenne);
		System.out.println("La moyenne des salaires est de " + moyenne + " euros");

		// Nettoyage après test: supprimer les salariés ajoutés
		this.salarieManager.supprimerSalarie(gardien1.getId());
		this.salarieManager.supprimerSalarie(gardien2.getId());
		this.salarieManager.supprimerSalarie(soignant1.getId());
		this.salarieManager.supprimerSalarie(soignant2.getId());
	}
}
