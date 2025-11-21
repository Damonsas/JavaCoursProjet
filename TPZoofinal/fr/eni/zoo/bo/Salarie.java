package TPZoofinal.fr.eni.zoo.bo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Gardien.class, name = "Gardien"),
        @JsonSubTypes.Type(value = Soignant.class, name = "Soignant")
})
public abstract class Salarie {
	private int id;
	private String nom;
	private String prenom;
	private double salaire;
	private Adresse adresse;

	public Salarie() {
		super();
	}
	
	public Salarie(String nom, String prenom, double salaire, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
		this.adresse = adresse;
	}
	
	public Salarie(int id, String nom, String prenom, double salaire, Adresse adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
		this.adresse = adresse;
	}
	
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
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Salarie [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", salaire=" + salaire + ", adresse="
				+ adresse + "]";
	}
}
