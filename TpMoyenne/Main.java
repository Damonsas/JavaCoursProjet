package JavaProjet.TpMoyenne;


import java.util.ArrayList;
import java.util.List;

public class Main {
    // Point d'entrée d'une application
    public static void main(String[] args) {

        // Je prépare une liste de matière
        ArrayList<Matiere> subjects = new ArrayList<Matiere>();

        // - Francais
        ArrayList<Double> notesFrancais = new ArrayList<Double>(List.of(12.0, 8.0, 6.0));
        Matiere francais = new Matiere("Français", notesFrancais);

        // Ajouter le francais dans la liste de matière
        subjects.add(francais);

        // - MATH
        ArrayList<Double> notesMath = new ArrayList<Double>(List.of(8.0, 16.0, 3.0, 6.0, 8.0));
        Matiere math = new Matiere("Math", notesMath);

        // Ajouter le francais dans la liste de matière
        subjects.add(math);

        // - SPORT
        ArrayList<Double> notesSport = new ArrayList<Double>(List.of(2.0, 4.0, 20.0, 3.0));
        Matiere sport = new Matiere("Sport", notesSport);

        // Ajouter le francais dans la liste de matière
        subjects.add(sport);

        // CALCULER LA MOYENNE GENERALE
        // -- Je prépare la somme des moyennes de chaque matière
        double sumAverage = 0;

        // Je vais parcourir toute les matières
        for (Matiere subject : subjects){

            // Additionner la moyenne de chaque matière dans sumAverage
            sumAverage += subject.calculAverage();
        }

        // somme des moyennes divisée par nombre de matière
        double generalAverage = sumAverage / subjects.size();

        System.out.println("La moyenne est générale est de : " + generalAverage);
    }
}
