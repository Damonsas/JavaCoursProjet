package TPZoo.fr.eni.zoo.manager;

import TPZoo.fr.eni.zoo.bo.Animal;
import TPZoo.fr.eni.zoo.dao.AnimalDaoMock;


import java.util.Collection;
import java.util.List;

public class AnimalManager {
    AnimalDaoMock dao = new AnimalDaoMock();


    public List<Animal> getAnimaux() {
        return getAnimaux();
    }

    public void ajoutAnimal(Animal animal) {
        dao.ajoutAnimal(animal);
    }

    public Animal getAnimal(int id) {
        return getAnimal(id);
    }

    public void majAnimal(Animal animal) {
        dao.majAnimal(animal);
    }

    public void supprimerAnimal(int id) {
        dao.supprimerAnimal(id);
    }

    public double getMoyenneAge() {
        List<Animal> animaux = getAnimaux();

        double moyenne = animaux.stream()
                .mapToInt( a -> a.getAge())
                //.mapToInt(Animal::getAge) solution alternative
                .average()
                .orElse(0.0);

        return moyenne;
    }

    public double getProportionFemelle() {
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
