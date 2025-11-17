package TPLudothèque.src.fr.eni.poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Membre {
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private LocalDate dateAdhesion;
    ArrayList<Emprunt> emprunts = new ArrayList<>();


    public Membre() {
		super();
	}

    public Membre(int id, String nom, String prenom, String telephone, LocalDate dateAdhesion) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.dateAdhesion = dateAdhesion;

    }

    public void addEmprunt(Emprunt emprunt){
        emprunts.add(emprunt);
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(LocalDate dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = (ArrayList<Emprunt>) emprunts;
    }

    public  void ajouterEmprunt(Emprunt emprunt) {
        this.emprunts.add(emprunt);
    }

}
