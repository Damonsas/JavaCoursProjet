package TPZoofinal.fr.eni.zoo.bo;

public class Soignant extends Salarie {

    private TypeAnimal specialite;

    public Soignant() {}

    public Soignant(String nom, String prenom, double salaire, Adresse adresse, TypeAnimal specialite) {
		super(nom, prenom, salaire, adresse);
		this.specialite = specialite;
	}

    public Soignant(int id, String nom, String prenom, double salaire, Adresse adresse, TypeAnimal specialite) {
		super(id, nom, prenom, salaire, adresse);
		this.specialite = specialite;
	}

	public TypeAnimal getSpecialite() {
        return specialite;
    }

    public void setSpecialite(TypeAnimal specialite) {
        this.specialite = specialite;
    }

	@Override
	public String toString() {
		return "Soignant [specialite=" + specialite + ", getId()=" + getId() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getSalaire()=" + getSalaire() + ", getAdresse()=" + getAdresse()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
