package TPZoofinal.fr.eni.zoo.dal.impl;

import java.util.ArrayList;
import java.util.List;

import TPZoofinal.fr.eni.zoo.bo.Salarie;
import TPZoofinal.fr.eni.zoo.dal.SalarieDao;
import TPZoofinal.fr.eni.zoo.dal.exception.SalarieDaoException;

public class SalarieDaoMock implements SalarieDao {

    // Liste statique pour stocker les objets Salarie
    private static List<Salarie> salaries = new ArrayList<>();
    
    // Indice pour attribuer des IDs uniques aux salariés ajoutés
    private static int idIndex = 1;

    /**
     * Ajoute un nouveau salarié à la liste.
     * @param salarie L'objet Salarie à ajouter.
     * @throws SalarieDaoException Si l'ajout du salarié échoue.
     */
    @Override
    public void insert(Salarie salarie) throws SalarieDaoException {
        // Assigne un ID unique au salarié et l'incrémente pour le prochain ajout
        salarie.setId(idIndex);
        idIndex++;
        
        // Ajoute le salarié à la liste des salariés
        salaries.add(salarie);
    }

    /**
     * Supprime un salarié de la liste par son ID.
     * @param id L'ID du salarié à supprimer.
     * @throws SalarieDaoException Si le salarié n'existe pas dans la liste.
     */
    @Override
    public void delete(int id) throws SalarieDaoException {
        // Recherche du salarié dans la liste par son ID
        Salarie salarie = selectById(id);
        
        // Vérifie si le salarié existe dans la liste
        if (salarie == null) {
            // Le salarié n'est pas trouvé, lancer une exception
            throw new SalarieDaoException("Le salarié n'existe pas, il ne peut être supprimé.");
        }
        
        // Supprime le salarié de la liste
        salaries.remove(salarie);
    }

    /**
     * Met à jour un salarié existant dans la liste.
     * @param salarie L'objet Salarie avec les mises à jour à appliquer.
     * @throws SalarieDaoException Si le salarié n'existe pas dans la liste.
     */
    @Override
    public void update(Salarie salarie) throws SalarieDaoException {
        // Recherche du salarié existant dans la liste par son ID
        Salarie sal = selectById(salarie.getId());
        
        // Vérifie si le salarié existe dans la liste
        if (sal == null) {
            // Le salarié n'est pas trouvé, lancer une exception
            throw new SalarieDaoException("Le salarié n'existe pas, il ne peut être mis à jour.");
        }
        
        // Met à jour les attributs du salarié existant avec les valeurs du nouveau salarié
        sal.setPrenom(salarie.getPrenom());
        sal.setNom(salarie.getNom());
        sal.setSalaire(salarie.getSalaire());
    }

    /**
     * Récupère un salarié de la liste par son ID.
     * @param id L'ID du salarié à rechercher.
     * @return Le salarié avec l'ID correspondant, ou null s'il n'est pas trouvé.
     * @throws SalarieDaoException Si une erreur se produit pendant la recherche.
     */
    @Override
    public Salarie selectById(int id) throws SalarieDaoException {
        // Utilise un stream pour filtrer les salariés par ID et retourne le premier résultat trouvé
        return salaries.stream()
                       .filter(a -> id == a.getId())
                       .findAny()
                       .orElse(null);
    }

    /**
     * Récupère tous les salariés de la liste.
     * @return La liste des salariés.
     * @throws SalarieDaoException Si une erreur se produit pendant la récupération.
     */
    @Override
    public List<Salarie> selectAll() throws SalarieDaoException {
        // Retourne la liste complète des salariés
        return salaries;
    }
}
