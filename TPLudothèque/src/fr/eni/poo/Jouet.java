package TPLudothèque.src.fr.eni.poo;

public class Jouet extends Jeu{
	
    // Constructeur
    public Jouet() {
    	super();
    }

	public Jouet(int id, String titre, Etat etat, int age, String description) {
		super(id, titre, etat, age, description);
	}

}
