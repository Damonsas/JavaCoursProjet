package TpEntreprise;

public class Adresse {
    public String ville;
    public String codePostal;

    public Adresse(String ville, String codePostal){
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public void dissplayAdresse(){
        System.out.println(ville + codePostal);
    }

}
