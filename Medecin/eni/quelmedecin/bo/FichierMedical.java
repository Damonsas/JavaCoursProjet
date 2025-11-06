package Medecin.eni.quelmedecin.bo;

import java.time.LocalDate;
import java.util.ArrayList;

public class FichierMedical {
    int masse;
    int taille;
    String tension;
    int sat;
    int rcp;
    String problme;
    String prescription;
    LocalDate dateSion;
    ArrayList<Medecin> medecin;
    ArrayList<Patient> patients;

    public FichierMedical(int masse, int taille, String tension, int sat, int rcp, String problme, String prescription, LocalDate dateSion, ArrayList<Medecin> medecin, ArrayList<Patient> patients){
        this.masse = masse;
        this.taille = taille;
        this.tension = tension;
        this.sat = sat;
        this.rcp = rcp;
        this.problme = problme;
        this.prescription = prescription;
        this.dateSion = dateSion;
        this.medecin = medecin;
        this.patients = patients;
    }

}
