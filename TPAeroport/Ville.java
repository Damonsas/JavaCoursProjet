package TPAeroport;

import java.util.Objects;

public class Ville {
    private String nom;

    public String getNom(){
        return this.nom;
    }

    public String setNom(){
        return this.nom;
    }

    public Ville(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Ville{" +
                "nom='" + nom + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ville ville)) return false;
        return Objects.equals(nom, ville.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nom);
    }
}
