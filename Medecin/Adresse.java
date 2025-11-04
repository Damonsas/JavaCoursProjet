package Medecin;

public class Adresse {
    String ville;
    int cp;
    String rue;
    int numero;
    String cnumero;
    String mentioncomp;

    public Adresse(String ville, int cp, String rue, int numero, String cnumero, String mentioncomp){
        this.ville = ville;
        this.cp = cp;
        this.rue = rue;
        this.numero = numero;
        this.cnumero = cnumero;
        this.mentioncomp = mentioncomp;
    }

    public void afficher() {
    }
}
