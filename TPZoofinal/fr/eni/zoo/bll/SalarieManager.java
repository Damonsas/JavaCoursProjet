package TPZoofinal.fr.eni.zoo.bll;

import java.util.List;

import TPZoofinal.fr.eni.zoo.bll.exception.SalarieManagerException;
import TPZoofinal.fr.eni.zoo.bo.Salarie;
import TPZoofinal.fr.eni.zoo.dal.SalarieDaoMock;
import TPZoofinal.fr.eni.zoo.dal.exception.SalarieDaoException;

/**
 * Classe de gestion des salariés.
 * Elle fournit des méthodes pour ajouter, supprimer, mettre à jour et obtenir des salariés.
 */
public class SalarieManager {

    // Instance de la couche d'accès aux données
    private SalarieDaoMock dao = new SalarieDaoMock();

    /**
     * Ajoute un salarié dans le système.
     *
     * @param salarie L'objet Salarie à ajouter.
     * @throws SalarieManagerException si une erreur se produit lors de l'ajout du salarié.
     */
    public void ajoutSalarie(Salarie salarie) throws SalarieManagerException {
        try {
            dao.ajoutSalarie(salarie);
        } catch (SalarieDaoException e) {
            // Conversion de l'exception de la couche DAL en exception de la couche BLL
            throw new SalarieManagerException("Erreur lors de l'ajout du salarié " + e);
        }
    }

    /**
     * Supprime un salarié par son identifiant.
     *
     * @param id L'identifiant du salarié à supprimer.
     * @throws SalarieManagerException si une erreur se produit lors de la suppression du salarié.
     */
    public void supprimerSalarie(int id) throws SalarieManagerException {
        try {
            dao.supprimerSalarie(id);
        } catch (SalarieDaoException e) {
            // Conversion de l'exception de la couche DAL en exception de la couche BLL
            throw new SalarieManagerException("Erreur lors de la suppression du salarié " + e);
        }
    }

    /**
     * Met à jour les informations d'un salarié.
     *
     * @param salarie L'objet Salarie à mettre à jour.
     * @throws SalarieManagerException si une erreur se produit lors de la mise à jour du salarié.
     */
    public void majSalarie(Salarie salarie) throws SalarieManagerException {
        try {
            dao.majSalarie(salarie);
        } catch (SalarieDaoException e) {
            // Conversion de l'exception de la couche DAL en exception de la couche BLL
            throw new SalarieManagerException("Erreur lors de la mise à jour du salarié " + e);
        }
    }

    /**
     * Récupère un salarié par son identifiant.
     *
     * @param id L'identifiant du salarié à récupérer.
     * @return L'objet Salarie correspondant à l'identifiant donné.
     * @throws SalarieManagerException si une erreur se produit lors de la récupération du salarié.
     */
    public Salarie getSalarie(int id) throws SalarieManagerException {
        try {
            return dao.getSalarie(id);
        } catch (SalarieDaoException e) {
            // Conversion de l'exception de la couche DAL en exception de la couche BLL
            throw new SalarieManagerException("Erreur lors de la récupération du salarié " + e);
        }
    }

    /**
     * Récupère la liste de tous les salariés.
     *
     * @return La liste de tous les salariés.
     * @throws SalarieManagerException si une erreur se produit lors de la récupération de la liste des salariés.
     */
    public List<Salarie> getSalaries() throws SalarieManagerException {
        try {
            return dao.getSalaries();
        } catch (SalarieDaoException e) {
            // Conversion de l'exception de la couche DAL en exception de la couche BLL
            throw new SalarieManagerException("Erreur lors de la récupération de la liste des salariés " + e);
        }
    }

	public double getMasseSalariale() throws SalarieManagerException {
		List<Salarie> salaries = getSalaries();
		return salaries.stream().mapToDouble(s -> s.getSalaire()).sum();
	}

	public double getMoyenneSalariale() throws SalarieManagerException {
		List<Salarie> salaries = getSalaries();
		return salaries.stream().mapToDouble(s -> s.getSalaire()).average().orElse(0.0);
	}
}
