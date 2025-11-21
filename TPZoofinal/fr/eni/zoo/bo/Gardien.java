package TPZoofinal.fr.eni.zoo.bo;

public class Gardien extends Salarie{
    private boolean gardienDeNuit;

    public Gardien() {
    }

	public Gardien(String nom, String prenom, double salaire, Adresse adresse, boolean gardienDeNuit) {
		super(nom, prenom, salaire, adresse);
		this.gardienDeNuit = gardienDeNuit;
	}

	public Gardien(int id, String nom, String prenom, double salaire, Adresse adresse, boolean gardienDeNuit) {
		super(id, nom, prenom, salaire, adresse);
		this.gardienDeNuit = gardienDeNuit;
	}

	public boolean isGardienDeNuit() {
        return gardienDeNuit;
    }

    public void setGardienDeNuit(boolean gardienDeNuit) {
        this.gardienDeNuit = gardienDeNuit;
    }

	@Override
	public String toString() {
		return "Gardien [gardienDeNuit=" + gardienDeNuit + ", getId()=" + getId() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getSalaire()=" + getSalaire() + ", getAdresse()=" + getAdresse()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
}
