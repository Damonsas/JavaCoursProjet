package TPZoofinal.test.fr.eni.zoo.dal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import TPZoofinal.fr.eni.zoo.dal.AnimalDao;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import TPZoofinal.fr.eni.zoo.bo.Animal;
import TPZoofinal.fr.eni.zoo.bo.TypeAnimal;
import TPZoofinal.fr.eni.zoo.dal.exception.AnimalDaoException;
import TPZoofinal.fr.eni.zoo.dal.impl.AnimalDaoJson;

//utilisé pour lancer les tests dans l'ordre donné par les annotation @order
//et s'assuré que la sortie sur la console est identique à l'énoncé
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCoucheAnimalDaoJsonInterface {
	AnimalDao animalDao = new AnimalDaoJson();

	@Test
	@Order(1)
	public void testAjoutAnimal() throws AnimalDaoException {
		System.out.println("\n-------------- test ajout animal ---------------");
		// Arrange
		Animal elephantFemelle = new Animal("dumbo", true, 14, TypeAnimal.ELEPHANT);
		int size = this.animalDao.selectAll().size();
		// Act
		this.animalDao.insert(elephantFemelle);

		// Assert
		assertEquals(size + 1, this.animalDao.selectAll().size());

		System.out
				.println("il y a une différence de taille dans liste de " + (this.animalDao.selectAll().size() - size));

	}

	@Test
	@Order(2)
	public void testGetAnimal() throws AnimalDaoException {
		System.out.println("\n-------------- test getAnimal---------------");
		Animal singeFemelle = new Animal("Coco", true, 6, TypeAnimal.SINGE);
		// Arrange
		this.animalDao.insert(singeFemelle);

		// Act
		Animal animal = this.animalDao.selectById(singeFemelle.getId());

		// Assert
		assertEquals(animal.getNom(), "Coco");
		assertEquals(animal.getSexe(), true);
		assertEquals(animal.getType(), TypeAnimal.SINGE);
		assertEquals(animal.getAge(), 6);

		System.out.println("détail du singe Coco : " + animal);

	}

	@Test
	@Order(3)
	public void testUpdateAnimaux() throws AnimalDaoException {
		System.out.println("\n-------------- test mise à jour animal ---------------");
		// Arrange
		Animal girafeMale = new Animal("Gerald", false, 12, TypeAnimal.GIRAFE);
		String nouveauNom = "Gaston";
		// ajout d'un animal dans le manager
		this.animalDao.insert(girafeMale);
		System.out.println("détail de la girafe : " + girafeMale);
		// changement du nom
		girafeMale.setNom(nouveauNom);

		// Act
		// mis à jjour de l'animal
		this.animalDao.update(girafeMale);

		// Assert
		// récupération du nouvel animal
		Animal animal = this.animalDao.selectById(girafeMale.getId());
		assertEquals(nouveauNom, animal.getNom());
		System.out.println("changement du nom de la girafe " + girafeMale);

	}

	@Test
	@Order(4)
	public void testDeleteAnimalMock() throws AnimalDaoException {
	    System.out.println("\n-------------- test suppression animal Mock ---------------");
		Animal lionFemelle = new Animal("nala", true, 5, TypeAnimal.LION);
	    // Arrange
	    this.animalDao.insert(lionFemelle);
	    int size = this.animalDao.selectAll().size();

	    // Act
	    this.animalDao.delete(lionFemelle.getId());
	    // Assert
	    assertEquals(size - 1, this.animalDao.selectAll().size());
	    assertNull(this.animalDao.selectById(lionFemelle.getId()));
	    System.out.println("L'animal avec l'ID " + lionFemelle.getId() + " a été supprimé.");
	}
}
