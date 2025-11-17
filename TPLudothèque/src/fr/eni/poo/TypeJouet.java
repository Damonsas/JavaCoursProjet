package TPLudothèque.src.fr.eni.poo;

public class TypeJouet {
    private int id;
    private String libelle;

    // Constructeur
    public TypeJouet(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
