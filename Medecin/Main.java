package Medecin;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        System.out.println("__________________________ Médecins ______________________________");
        MedecinGénéral melanie = new MedecinGénéral("Malalaniche", "Mélanie", "02.28.03.17.28", 25);
        MedecinGénéral edmond = new MedecinGénéral("Bosapin", "Edmond", "+33 2 17 18 19 20", 25);
        MedecinGénéral djemila = new MedecinGénéral("Table", "Djémila", "03-04-05-06-07", 25);

        melanie.afficher();
        System.out.println("------------------------------------------------------------------");
        edmond.afficher();
        System.out.println("------------------------------------------------------------------");
        djemila.afficher();

        System.out.println("--------------- Changement du numéro de ce médecin ---------------");
        djemila.settel("07-06-05-04-03");
        System.out.printf("Nouveau numéro du Dr %s : %s%n", djemila.getNom(), djemila.gettel());

        System.out.println("-------------- Changement du prix de la consultation -------------");
        MedecinGénéral.setTarif(23);
        melanie.afficher();
        System.out.println("------------------------------------------------------------------");
        edmond.afficher();
        System.out.println("------------------------------------------------------------------");
        djemila.afficher();


        System.out.println("__________________________ Adresses ______________________________");
        //Adresse sh = new Adresse("ZAC du Moulin Neuf", 44800, "B", 8, "b", "Saint Herblain");
        //Adresse nio = new Adresse("Niort", 79000, "avenue Léo Lagrange", 19, "Niort", "");
        Adresse comp = new Adresse("st Quentin", 2100, "Rue des Glatiniers", 18, "Saint-Quentin", "");

        //sh.afficher();
        System.out.println("------------------------------------------------------------------");
        //nio.afficher();
        System.out.println("------------------------------------------------------------------");
        comp.afficher();


        System.out.println("__________________________ Patient _______________________________");
        Client hillary = new Client("Vambuce", "Hillary", "0123456789", 'F', 287060244010154l,
                LocalDate.of(1987, 6, 2), "Allergie aux arachides");
        Client ines = new Client("Perret", "Inès", "0698745123", 'F', 245021067034521l, LocalDate.of(1945, 2, 10),
                null);
        //Client adhemar = new Client("Pamamobe", "Adhémar", "0753428619", 'M', 192112192020142l,
        //LocalDate.of(1992, 11, 21), null;

        hillary.afficher();
        System.out.println("------------------------------------------------------------------");
        ines.afficher();
        System.out.println("------------------------------------------------------------------");
        //adhemar.afficher();

        Adresse sh = new Adresse("ZAC du Moulin Neuf", 44800, "B", 8, "b", "Saint Herblain");
        //MedecinGénéral melanie = new MedecinGénéral("Malalaniche", "Mélanie", "02.28.03.17.28", sh);
        new Creneau(LocalTime.of(9, 15), 15);
        new Creneau(LocalTime.of(9, 30), 15);
        new Creneau(LocalTime.of(9, 45), 15);
        new Creneau(LocalTime.of(10, 30), 15);
        new Creneau(LocalTime.of(10, 45), 15);
        new Creneau(LocalTime.of(11, 15), 15);
        new Creneau(LocalTime.of(11, 30), 15);
        Creneau c1 = new Creneau(LocalTime.of(11, 45), 15);
        new Creneau(LocalTime.of(14, 0), 30);
        new Creneau(LocalTime.of(14, 30), 30);
        new Creneau(LocalTime.of(15, 0), 30);
        new Creneau(LocalTime.of(15, 30), 30);
        new Creneau(LocalTime.of(16, 0), 30);
        new Creneau(LocalTime.of(16, 30), 30);
        System.out.println("__________________________ Rendez-Vous ___________________________");
        Adresse nio = new Adresse("Niort", 79000, "avenue Léo Lagrange", 19, "Niort", "");
        Client adhemar = new Client("Pamamobe", "Adhémar", "0753428619", 'M', 192112192020142l, LocalDate.of(1992, 11, 21), null);
        //rdv.afficher();
    }}