package Medecin.eni.quelmedecin.bo;

public class MedecinSpecialiste extends Medecin{

    //ATTRIBUTS DE CLASSE
    private static int tarif = 52;
    String spe;
    private Creneau[] creneaux;


    //CONSTANTES DE CLASSE
    public static final int MAX_CRENEAUX = 15;


    //CONSTRUCTEURS

    /**
     * Constructeur : crée une instance de type MedecinGeneraliste
     *
     * @param nom               - nom du médecin
     * @param prenom            - prénom du médecin
     * @param numeroDeTelephone - numéro de téléphone
     * @param adresse           - adresse postale du medecin
     */
    public MedecinSpecialiste(String nom, String prenom, String numeroDeTelephone, Adresse adresse, String spe, int tarif) {
        super(nom, prenom, numeroDeTelephone, adresse);
        this.tarif = tarif;
        this.spe = spe;
    }

    //AUTRES METHODES

    /**
     * Affiche sur la console sous la forme :
     * NOM Prénom
     * Téléphone : XXXXXXXXXX
     * Tarif : XX€
     * Adresse : Complément
     * XXbis rue XXXXXXXXX
     * 00000 XXXXXXXXXXXXX
     * Créneaux :
     * 00:00 - 00:00 (XX minutes)
     */
    public void afficher() {
        System.out.printf("%s %s%nTéléphone : %s%nTarif : %d€%nAdresse :%n", this.getNom(), this.getPrenom(),
                this.getNumeroDeTelephone(), MedecinSpecialiste.tarif);
        if (getAdresse() != null) {
            this.getAdresse().afficher();
        }
        System.out.println("Créneaux :");
        for (int i = 0; i < this.creneaux.length; i++)
            if (this.creneaux[i] != null)
                this.creneaux[i].afficher();
    }

    /**
     * @param creneauAAjouter
     */



    //ACCESSEURS ET MUTATEURS


    /**
     * Getter pour tarif.
     *
     * @return le tarif de la consultation
     * @see MedecinGeneraliste#setTarif(int)
     */
    public static int getTarif() {
        return MedecinSpecialiste.tarif;
    }

    /**
     * Setter pour tarif.
     *
     * @param tarif - le tarif de la consultation
     * @see MedecinSpecialiste#getTarif()
     */
    public static void setTarif(int tarif) {
        MedecinSpecialiste.tarif = tarif;
    }
}
