package TPLudothèque.src.fr.eni.poo;

public class JeuSociete extends Jeu {
    private double difficulte;
    private double interet;
    
    // Constructeur
    public JeuSociete() {
    	super();
    }
    
    public JeuSociete(int id, String titre, Etat etat, int age, String description, double difficulte, double interet) {
        super(id, titre, etat, age, description);
        this.difficulte = difficulte;
        this.interet = interet;
    }

    // Getters et setters spécifiques
    public double getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(double difficulte) {
        this.difficulte = difficulte;
    }

    public double getInteret() {
        return interet;
    }

    public void setInteret(double interet) {
        this.interet = interet;
    }

}
