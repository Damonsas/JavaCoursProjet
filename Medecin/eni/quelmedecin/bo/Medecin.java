package Medecin.eni.quelmedecin.bo;

import java.util.ArrayList;
import java.util.function.IntFunction;

public class Medecin extends ArrayList<Medecin> {
    private String nom;
    private String prenom;
    private String numeroDeTelephone;
    //association unidirectionnelle
    //navigation vers Adresse 0..1
    private Adresse adresse;
    //association bidirectionnelle
    //navigation vers Creneau 0..15
    private Creneau[] creneaux;


    public Medecin(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
        this.setNom(nom.toUpperCase());
        this.setPrenom(prenom);
        this.setNumeroDeTelephone(numeroDeTelephone);
        this.setAdresse(adresse);
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


    public String getNumeroDeTelephone() {
        return this.numeroDeTelephone;
    }


    public void setNumeroDeTelephone(String numeroDeTelephone) {
        this.numeroDeTelephone = numeroDeTelephone;
    }

    public Adresse getAdresse() {
        return adresse;
    }


    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }


    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }

    public void afficher() {
        System.out.printf("%s %s%nTéléphone : %s%nTarif : %d€%nAdresse :%n", this.getNom(), this.getPrenom(),
                this.getNumeroDeTelephone(), MedecinSpecialiste.getTarif());
        if (getAdresse() != null) {
            this.getAdresse().afficher();
        }
        System.out.println("Créneaux :");
        for (int i = 0; i < this.creneaux.length; i++)
            if (this.creneaux[i] != null)
                this.creneaux[i].afficher();
    }

    void ajouterCreneau(Creneau creneauAAjouter) {
        if (this != creneauAAjouter.getMedecin()) {
            System.err.println("Ce créneau ne peut être associé à ce médecin car il est déjà associé à un autre");
        } else {
            int pos = 0;
            while (pos < this.creneaux.length && this.creneaux[pos] != null)
                pos++;
            if (pos == this.creneaux.length)
                System.err.println("Trop de créneaux sont affectés à ce médecin");
            else
                this.creneaux[pos] = creneauAAjouter;
        }
    }
}





