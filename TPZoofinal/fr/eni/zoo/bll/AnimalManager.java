package TPZoofinal.fr.eni.zoo.bll;

import java.util.List;

import TPZoofinal.fr.eni.zoo.bll.exception.AnimalManagerException;
import TPZoofinal.fr.eni.zoo.bo.Animal;
import TPZoofinal.fr.eni.zoo.dal.AnimalDaoMock;
import TPZoofinal.fr.eni.zoo.dal.exception.AnimalDaoException;

/**
 * Classe de gestion des animaux.
 * Elle fournit des méthodes pour ajouter, supprimer, mettre à jour et obtenir des animaux,
 * ainsi que pour calculer des statistiques liées aux animaux.
 */
public class AnimalManager {

    // Instance de la couche d'accès aux données
    private AnimalDaoMock dao = new AnimalDaoMock();

    /**
     * Ajoute un animal dans le système.
     *
     * @param animal L'objet Animal à ajouter.
     * @throws AnimalManagerException si une erreur se produit lors de l'ajout de l'animal.
     */
    public void ajoutAnimal(Animal animal) throws AnimalManagerException {
        try {
            dao.ajoutAnimal(animal);
        } catch (AnimalDaoException e) {
            // Conversion de l'exception de la couche DAL en exception de la couche BLL
            throw new AnimalManagerException("Erreur lors de l'ajout de l'animal " + e);
        }
    }

    /**
     * Supprime un animal par son identifiant.
     *
     * @param id L'identifiant de l'animal à supprimer.
     * @throws AnimalManagerException si une erreur se produit lors de la suppression de l'animal.
     */
    public void supprimerAnimal(int id) throws AnimalManagerException {
        try {
            dao.supprimerAnimal(id);
        } catch (AnimalDaoException e) {
            // Conversion de l'exception de la couche DAL en exception de la couche BLL
            throw new AnimalManagerException("Erreur lors de la suppression de l'animal " + e);
        }
    }

    /**
     * Met à jour les informations d'un animal.
     *
     * @param animal L'objet Animal à mettre à jour.
     * @throws AnimalManagerException si une erreur se produit lors de la mise à jour de l'animal.
     */
    public void majAnimal(Animal animal) throws AnimalManagerException {
        try {
            dao.majAnimal(animal);
        } catch (AnimalDaoException e) {
            // Conversion de l'exception de la couche DAL en exception de la couche BLL
            throw new AnimalManagerException("Erreur lors de la mise à jour de l'animal " + e);
        }
    }

    /**
     * Récupère un animal par son identifiant.
     *
     * @param id L'identifiant de l'animal à récupérer.
     * @return L'objet Animal correspondant à l'identifiant donné.
     * @throws AnimalManagerException si une erreur se produit lors de la récupération de l'animal.
     */
    public Animal getAnimal(int id) throws AnimalManagerException {
        try {
            return dao.getAnimal(id);
        } catch (AnimalDaoException e) {
            // Conversion de l'exception de la couche DAL en exception de la couche BLL
            throw new AnimalManagerException("Erreur lors de la récupération de l'animal " + e);
        }
    }

    /**
     * Récupère la liste de tous les animaux.
     *
     * @return La liste de tous les animaux.
     * @throws AnimalManagerException si une erreur se produit lors de la récupération de la liste des animaux.
     */
    public List<Animal> getAnimaux() throws AnimalManagerException {
        try {
            return dao.getAnimaux();
        } catch (AnimalDaoException e) {
            // Conversion de l'exception de la couche DAL en exception de la couche BLL
            throw new AnimalManagerException("Erreur lors de la récupération de la liste des animaux " + e);
        }
    }

    /**
     * Calcule la moyenne d'âge des animaux.
     *
     * @return La moyenne d'âge des animaux.
     * @throws AnimalManagerException si une erreur se produit lors du calcul de la moyenne.
     */
	public double getMoyenneAge() throws AnimalManagerException {
		List<Animal> animaux = getAnimaux();

		double moyenne = animaux.stream()
			                .mapToInt( a -> a.getAge())
			                //.mapToInt(Animal::getAge) solution alternative
			                .average()
			                .orElse(0.0);
		
		return moyenne;
	}



    /**
     * Calcule la proportion de femelles parmi les animaux.
     *
     * @return La proportion de femelles en pourcentage.
     * @throws AnimalManagerException si une erreur se produit lors du calcul de la proportion.
     */
	public double getProportionFemelle() throws AnimalManagerException {
		double proportion = 0;
		List<Animal> animaux = getAnimaux();

        if (animaux.size() > 0) {
			long nombreDeFemelles = animaux.stream()
					                .filter(animal -> animal.getSexe())
					                .count();
			proportion = 100 *( nombreDeFemelles / (double) animaux.size());
        }
        
        return proportion;
	}
}
