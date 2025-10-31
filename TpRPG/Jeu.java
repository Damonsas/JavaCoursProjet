package JavaProjet.TpRPG;

public class Jeu {

    public static void play(Attaquant a1, Attaquant a2) {

        // Tirage pair/impair pour savoir qui commence
        boolean hordeStart = Attaquant.attaque();
        Attaquant attacker = hordeStart ? a1 : a2;
        Attaquant defender = hordeStart ? a2 : a1;

        // Boucle du combat
        while (!a1.isDead() && !a2.isDead()) {

            // Si l'attaque réussit
            if (attacker.attack()) {
                int dmg = (int)(Math.random() * attacker.power) + 1;
                defender.looseHP(dmg);
            }

            // Si le défenseur meurt → fin
            if (defender.isDead()) {
                break;
            }

            // On échange les rôles
            Attaquant temp = attacker;
            attacker = defender;
            defender = temp;
        }

        // Afficher le gagnant
        System.out.println("Gagnant : " + (a1.isDead() ? a2.name : a1.name));
    }
}

