package TPZoofinal.fr.eni.zoo.dal.impl;

import java.util.ArrayList;
import java.util.List;

import TPZoofinal.fr.eni.zoo.bo.Animal;
import TPZoofinal.fr.eni.zoo.dal.AnimalDao;
import TPZoofinal.fr.eni.zoo.dal.exception.AnimalDaoException;
import TPZoofinal.fr.eni.zoo.util.SerialiseurJson;

public class AnimalDaoJson implements AnimalDao  {
	public final static String SOURCE = "storage/Animaux.json";

    @Override
	public List<Animal> selectAll() throws AnimalDaoException {
		List<Animal> animaux = SerialiseurJson.importerFromJson(SOURCE, Animal.class);
		return animaux;
	}

    @Override
	public Animal selectById(int id) throws AnimalDaoException {
		Animal animal = null;

		List<Animal> animaux = SerialiseurJson.importerFromJson(SOURCE, Animal.class);
		if (animaux != null)
			animal = animaux.stream().filter(c-> c.getId() == id).findFirst().orElse(null);
		return animal;
	}

    @Override
	public void insert(Animal newElement) throws AnimalDaoException {
		
		List<Animal> animaux = SerialiseurJson.importerFromJson(SOURCE, Animal.class);
		
		if (newElement != null) {
			//création de l'id à la volée cela simule le comportement de la base de donnée
			newElement.setId(getNouvelId());
			if (animaux == null)
				animaux = new ArrayList<Animal>();
			animaux.add(newElement);
			SerialiseurJson.exporterToJson(SOURCE, animaux);
		}
	}

    @Override
	public void update(Animal element) throws AnimalDaoException {
		if (element != null) {
			this.delete(element.getId());
			this.insert(element);
		}
	}

    @Override
	public void delete(int id) throws AnimalDaoException {
		List<Animal> animaux = SerialiseurJson.importerFromJson(SOURCE, Animal.class);
		animaux.removeIf(c-> c.getId() == id);
		SerialiseurJson.exporterToJson(SOURCE, animaux);
	}
    
    /**
     * Détermine le dernier id entré dans le fichier pour déterminer l'id du nouvel élément
     * @return l'id à utiliser pour le nouvel élément
     */
    private int getNouvelId() {
    	//récupération de la liste
		List<Animal> animaux = SerialiseurJson.importerFromJson(SOURCE, Animal.class);
		//détermine l'id maximum de la liste
		int maximum = animaux.stream().map(Animal::getId).max(Integer::compareTo).orElse(0);
    	
		return maximum+1;
    }
}
