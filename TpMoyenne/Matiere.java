package JavaProjet.TpMoyenne;



import java.util.ArrayList;

public class Matiere {
    public String libelle;
    public ArrayList<Double> notes;

    public Matiere(String param1, ArrayList<Double> param2){
        libelle = param1;
        notes = param2;
    }

    public double calculAverage() {
        // Calculer la somme des notes
        double sum = 0;
        for (Double note : notes){
            sum += note;
        }

        // moyenne = somme / nombre de notes
        double average = sum / notes.size();

        // Je retourne la moyennne calculé (la fonction retourne/renvoyer la moyenne)
        return average;
    }
}