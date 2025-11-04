package Medecin;

public class MedecinGénéral extends InfoPerso{

    static int tarif = 25;

    public MedecinGénéral(String nom, String prenom, String tel, int tarif){
        super(nom, prenom, tel);
        this.tarif = tarif;

    }

    public static void setTarif(int i) {
        tarif = i;
    }

    public void afficher(){
        StringBuilder medecin = new StringBuilder();
        medecin.append(nom).append(prenom).append(tel).append(tarif);
        System.out.println(medecin);
    }
}
