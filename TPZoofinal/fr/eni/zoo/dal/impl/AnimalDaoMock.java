package TPZoofinal.fr.eni.zoo.dal.impl;

import java.util.ArrayList;
import java.util.List;

import TPZoofinal.fr.eni.zoo.bo.Animal;
import TPZoofinal.fr.eni.zoo.dal.AnimalDao;
import TPZoofinal.fr.eni.zoo.dal.exception.AnimalDaoException;

public class AnimalDaoMock implements AnimalDao {

    // Liste statique pour stocker les objets Animal
    private static List<Animal> animaux = new ArrayList<>();
    
    // Indice pour attribuer des IDs uniques aux animaux ajoutés
    private static int idIndex = 1;

    /**
     * Ajoute un nouvel animal à la liste.
     * @param animal L'objet Animal à ajouter.
     * @throws AnimalDaoException Si l'ajout de l'animal échoue.
     */
    @Override
    public void insert(Animal animal) throws AnimalDaoException {     
        // Assigne un ID unique à l'animal et l'incrémente pour le prochain ajout
        animal.setId(idIndex);
        idIndex++;
        
        // Ajoute l'animal à la liste des animaux
        animaux.add(animal);
    }

    /**
     * Supprime un animal de la liste par son ID.
     * @param id L'ID de l'animal à supprimer.
     * @throws AnimalDaoException Si l'animal n'existe pas dans la liste.
     */
    @Override
    public void delete(int id) throws AnimalDaoException {
        // Recherche de l'animal dans la liste par son ID
        Animal animal = selectById(id);
        
        // Vérifie si l'animal existe dans la liste
        if (animal == null) {
            // L'animal n'est pas trouvé, lance une exception
            throw new AnimalDaoException("L'animal n'existe pas, il ne peut être supprimé.");
        }
        
        // Supprime l'animal de la liste
        animaux.remove(animal);
    }

    /**
     * Met à jour un animal existant dans la liste.
     * @param animal L'objet Animal avec les mises à jour à appliquer.
     * @throws AnimalDaoException Si l'animal n'existe pas dans la liste.
     */
    @Override
    public void update(Animal animal) throws AnimalDaoException {
        // Recherche de l'animal existant dans la liste par son ID
        Animal ani = selectById(animal.getId());
        
        // Vérifie si l'animal existe dans la liste
        if (ani == null) {
            // L'animal n'est pas trouvé, lance une exception
            throw new AnimalDaoException("L'animal n'existe pas, il ne peut être mis à jour.");
        }
        
        // Met à jour les attributs de l'animal existant avec les valeurs du nouvel animal
        ani.setNom(animal.getNom());
        ani.setSexe(animal.getSexe());
        ani.setType(animal.getType());
    }

    /**
     * Récupère un animal de la liste par son ID.
     * @param id L'ID de l'animal à rechercher.
     * @return L'animal avec l'ID correspondant, ou null s'il n'est pas trouvé.
     * @throws AnimalDaoException Si une erreur se produit pendant la recherche.
     */
    @Override
    public Animal selectById(int id) throws AnimalDaoException {
        // Utilise un stream pour filtrer les animaux par ID et retourne le premier résultat trouvé
        return animaux.stream()
                      .filter(a -> id == a.getId())
                      .findAny()
                      .orElse(null);
    }

    /**
     * Récupère tous les animaux de la liste.
     * @return La liste des animaux.
     * @throws AnimalDaoException Si une erreur se produit pendant la récupération.
     */
    @Override
    public List<Animal> selectAll() throws AnimalDaoException {
        // Retourne la liste complète des animaux
        return animaux;
    }
}
