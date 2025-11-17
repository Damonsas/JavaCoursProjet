package TPLudothèque.src.fr.eni.poo;

import java.util.ArrayList;
import java.util.List;

public abstract class Jeu {
	private int id;
	private String titre;
	private Etat etat;
	private int age;
    private String description;

    private List<Emprunt> emprunts = new ArrayList<>();


    // Constructeur

    public Jeu() {
		super();
	}
	
    public Jeu(int id, String titre, Etat etat, int age, String description) {
		super();
        this.titre = titre;
        this.id = id;
        this.etat = etat;
        this.age = age;
        this.description = description;
    }



    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

    public Etat getEtat() {
        return etat;
    }

	public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    public  void ajouterEmprunt(Emprunt emprunt) {
        this.emprunts.add(emprunt);
    }

}


