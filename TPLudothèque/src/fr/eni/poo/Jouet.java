package TPLudothèque.src.fr.eni.poo;

public class Jouet extends Jeu{
    private TypeJouet typeJouet;
	
    // Constructeur
    public Jouet() {
    	super();
    }

	public Jouet(int id, String titre, Etat etat, int age, String description, TypeJouet typeJouet) {
		super(id, titre, etat, age, description);
        this.typeJouet = typeJouet;
	}

}
