package Medecin;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        System.out.println("__________________________ Médecins ______________________________");
        MedecinGénéral melanie = new MedecinGénéral("Malalaniche", "Mélanie", "02.28.03.17.28", 25);
        MedecinGénéral edmond = new MedecinGénéral("Bosapin", "Edmond", "+33 2 17 18 19 20",25);
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
        Adresse sh = new Adresse("ZAC du Moulin Neuf", 44800, "B", 8, "b", "Saint Herblain");
        Adresse nio = new Adresse("Niort", 79000, "avenue Léo Lagrange", 19, "Niort", "");
        Adresse comp = new Adresse("st Quentin", 2100, "Rue des Glatiniers", 18, "Saint-Quentin", "");

        sh.afficher();
        System.out.println("------------------------------------------------------------------");
        nio.afficher();
        System.out.println("------------------------------------------------------------------");
        comp.afficher();


        System.out.println("__________________________ Patient _______________________________");
        Client hillary = new Client("Vambuce", "Hillary", "0123456789", 'F', 287060244010154l,
                LocalDate.of(1987, 6, 2), "Allergie aux arachides");
        Client ines = new Client("Perret", "Inès", "0698745123", 'F', 245021067034521l, LocalDate.of(1945, 2, 10),
                null);
        Client adhemar = new Client("Pamamobe", "Adhémar", "0753428619", 'M', 192112192020142l,
                LocalDate.of(1992, 11, 21), null);

        hillary.afficher();
        System.out.println("------------------------------------------------------------------");
        ines.afficher();
        System.out.println("------------------------------------------------------------------");
        adhemar.afficher();

        Methode ctrl = Methode.getMethode();
        System.out.println("___________________________ Test téléphone Patients ________________________");
        Client mac = new Client("Vambuce", "mac'douglas", "0123456789", 'F', 287060244010154l,
                LocalDate.of(1987, 6, 2), "Allergie aux arachides");
        //mettre la 1ere lettre de chaque mot du prénom en majuscule
        //mac.setPrenom(ctrl.premiereEnMajuscule(mac.getPrenom(), "[-' ]"));
        //formattage numero de telephone
        //mac.settel(ctrl.formattel(mac.gettel()));
        mac.afficher();System.out.println();


        //Client ines = new Client("Perret", "inès", "0698745123", 'F', 245021067034521l, LocalDate.of(1945, 2, 10),
                //null);
        //mettre la 1ere lettre de chaque mot du prénom en majuscule
        //ines.setPrenom(ctrl.premiereEnMajuscule(ines.getPrenom(), "[-' ]"));
        //formattage numero de telephone
        //ines.settel(ctrl.formattel(ines.gettel()));
        ines.afficher();System.out.println();


        Client sidney = new Client("Pamamobe", "sidney-scott", "0753428619", 'M', 192112192020142l,
                LocalDate.of(1992, 11, 21), null);
        //mettre la 1ere lettre de chaque mot du prénom en majuscule
        //sidney.setPrenom(ctrl.premiereEnMajuscule(sidney.getPrenom(), "[-' ]"));
        //formattage numero de telephone
        //sidney.settel(ctrl.formattel(sidney.gettel()));
        sidney.afficher();System.out.println();


        Client jessie = new Client("Watson", "jessie james", "01254266788", 'M', 287060244010154l,
                LocalDate.of(1975, 8, 17), "Allergie au lactose");
        //mettre la 1ere lettre de chaque mot du prénom en majuscule
       // jessie.setPrenom(ctrl.premiereEnMajuscule(jessie.getPrenom(), "[-' ]"));
        //formattage numero de telephone
        //jessie.setNumeroDeTelephone(ctrl.formatNumeroTelephone(jessie.gettel()));
        jessie.afficher();System.out.println();

        System.out.println("___________________________ Test téléphone Médecins ________________________");
        //MedecinGénéral melanie = new MedecinGénéral("Malalaniche", "Mélanie", "0228031728");
        //mettre la 1ere lettre de chaque mot du prénom en majuscule
        //melanie.setPrenom(ctrl.premiereEnMajuscule(melanie.getPrenom(), "[-' ]"));
        //formattage numero de telephone
       // melanie.settel(ctrl.formattel(melanie.gettel()));
        melanie.afficher();System.out.println();


      //  MedecinGénéral edmond = new MedecinGénéral("Bosapin", "Edmond", "217181920");
        //mettre la 1ere lettre de chaque mot du prénom en majuscule
      //  edmond.setPrenom(ctrl.premiereEnMajuscule(edmond.getPrenom(), "[-' ]"));
        //formattage numero de telephone
      //  edmond.settel(ctrl.formattel(edmond.gettel()));
        edmond.afficher();System.out.println();


       // MedecinGénéral vikie = new MedecinGénéral("Madge", "vickie", "OO04050607");
        //mettre la 1ere lettre de chaque mot du prénom en majuscule
       // vikie.setPrenom(ctrl.premiereEnMajuscule(vikie.getPrenom(), "[-' ]"));
        //formattage numero de telephone
       // vikie.settel(ctrl.formattel(vikie.gettel()));
       // vikie.afficher();

    }
}