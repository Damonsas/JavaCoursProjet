package TPZoofinal.test.fr.eni.zoo.dal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import TPZoofinal.fr.eni.zoo.dal.SalarieDao;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import TPZoofinal.fr.eni.zoo.bo.*;
import TPZoofinal.fr.eni.zoo.dal.exception.SalarieDaoException;
import TPZoofinal.fr.eni.zoo.dal.impl.SalarieDaoJson;

//utilisé pour lancer les tests dans l'ordre donné par les annotation @order
//et s'assuré que la sortie sur la console est identique à l'énoncé
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCoucheSalarieDaoJsonInterface {

	SalarieDao dao = new SalarieDaoJson();

	@Test
	@Order(1)
	public void testinsert() throws SalarieDaoException {
		System.out.println("\n-------------- test ajout salarie ---------------");
		// Arrange
		// création adresse
		Adresse address = new Adresse(1, 9, "chemin des bois", "Nantes", "44000");
		
		// création de gardien
		Gardien gardien = new Gardien("Dubois", "Sophie", 1600, address, true);
		
		int size = this.dao.selectAll().size();
		// Act
		this.dao.insert(gardien);

		// Assert
		System.out.println("il y a une différence de taille de la liste de " + (this.dao.selectAll().size() - size));
	}

	@Test
	@Order(2)
	public void testGetSalarie() throws SalarieDaoException {
		System.out.println("\n-------------- test getSalarie ---------------");
		// Arrange
		Adresse address = new Adresse(2, 2, "rue de la forêt", "Rennes", "35000");

		Gardien gardien = new Gardien("Leclerc", "Jacques", 1700, address, false);

		this.dao.insert(gardien);

		// Act
		Salarie salarie = this.dao.selectById(gardien.getId());

		// Assert
		assertEquals(salarie.getNom(), "Leclerc");
		assertEquals(salarie.getPrenom(), "Jacques");
		assertEquals(salarie.getSalaire(), 1700);
		assertEquals(salarie.getAdresse(), address);
		System.out.println("détail du salarié Leclerc " + salarie);
	}

	@Test
	@Order(3)
	public void testUpdateSalaries() throws SalarieDaoException {
		System.out.println("\n-------------- test mise à jour salarie ---------------");
		// Arrange
		// création de soignant
		Adresse address = new Adresse(3, 3, "rue Faraday", "Saint Herblain", "44800");
		Soignant soignant = new Soignant("Dupont", "Daniel", 1800, address, TypeAnimal.LION);
		String nouveauNom = "Martin";
		// ajout d'un salarie dans le manager
		this.dao.insert(soignant);
		System.out.println("détail du soignant " + soignant);
		// changement du nom
		soignant.setNom(nouveauNom);

		// Act
		// mis à jour du salarie
		this.dao.update(soignant);

		// Assert
		// récupération du nouveau salarie
		Salarie Salarie = this.dao.selectById(soignant.getId());
		assertEquals(nouveauNom, Salarie.getNom());
		System.out.println("changement du nom du soignant " + soignant);
	}
	@Test
	@Order(4)
	public void testDeleteSalarie() throws SalarieDaoException {
	    System.out.println("\n-------------- test suppression salarie ---------------");
	    // Arrange
	    Adresse address = new Adresse(4, 4, "avenue de la République", "Paris", "75000");
	    Gardien gardien = new Gardien("Blanc", "Luc", 1900, address, false);
	    this.dao.insert(gardien);
	    int size = this.dao.selectAll().size();
	    int salarieId = gardien.getId();
	    System.out.println("Salarié ajouté pour suppression : " + gardien);

	    // Act
	    this.dao.delete(salarieId);

	    // Assert
	    assertEquals(size - 1, this.dao.selectAll().size());
	    assertNull(this.dao.selectById(gardien.getId()));
	    System.out.println("L'animal avec l'ID " + gardien.getId() + " a été supprimé.");
	}
}
