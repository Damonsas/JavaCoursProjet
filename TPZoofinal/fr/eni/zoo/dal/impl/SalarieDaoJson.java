package TPZoofinal.fr.eni.zoo.dal.impl;

import java.util.ArrayList;
import java.util.List;

import TPZoofinal.fr.eni.zoo.bo.Salarie;
import TPZoofinal.fr.eni.zoo.dal.SalarieDao;
import TPZoofinal.fr.eni.zoo.dal.exception.SalarieDaoException;
import TPZoofinal.fr.eni.zoo.util.SerialiseurJson;

public class SalarieDaoJson implements SalarieDao {
	public final static String SOURCE = "storage/Salaries.json";

    @Override
	public List<Salarie> selectAll() throws SalarieDaoException {
		List<Salarie> salaries = SerialiseurJson.importerFromJson(SOURCE, Salarie.class);
		return salaries;
	}

    @Override
	public Salarie selectById(int id) throws SalarieDaoException {
		Salarie salarie = null;

		List<Salarie> salaries = SerialiseurJson.importerFromJson(SOURCE, Salarie.class);
		if (salaries != null)
			salarie = salaries.stream().filter(c-> c.getId() == id).findFirst().orElse(null);
		return salarie;
	}

    @Override
	public void insert(Salarie newElement) throws SalarieDaoException {
		
		List<Salarie> salaries = SerialiseurJson.importerFromJson(SOURCE, Salarie.class);
		
		if (newElement != null) {
			//création de l'id à la volée cela simule le comportement du base de donnée
			newElement.setId(getNouvelId());
			if (salaries == null)
				salaries = new ArrayList<Salarie>();
			salaries.add(newElement);
			SerialiseurJson.exporterToJson(SOURCE, salaries);
		}
	}

    @Override
	public void update(Salarie element) throws SalarieDaoException {
		if (element != null) {
			this.delete(element.getId());
			this.insert(element);
		}
	}

    @Override
	public void delete(int id) throws SalarieDaoException {
		List<Salarie> salaries = SerialiseurJson.importerFromJson(SOURCE, Salarie.class);
		salaries.removeIf(c-> c.getId() == id);
		SerialiseurJson.exporterToJson(SOURCE, salaries);
	}

    /**
     * Détermine le dernier id entré dans le fichier pour déterminer l'id du nouvel élément
     * @return l'id à utiliser pour le nouvel élément
     */
    private int getNouvelId() {
    	//récupération de la liste
		List<Salarie> salaries = SerialiseurJson.importerFromJson(SOURCE, Salarie.class);
		//détermine l'id maximum de la liste
		int maximum = salaries.stream().map(Salarie::getId).max(Integer::compareTo).orElse(0);
    	
		return maximum+1;
    }
}
